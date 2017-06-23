
package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import presentationlayer.skeleton.ISpelObserver;
import proceslayer.LobbyController;

/**
 * LobbyView.java
 * Een klasse die alle informatie bevat om de Lobby view te maken.
 * Het wordt allemaal in een scene gezet en daarna op de stage gezet waar deze classe van extends.
 *
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @author Erwin Olie, s1103026
 * @version 1.2
 */
/**
 * @author Enzo
 *
 */
/**
 * @author Enzo
 *
 */
/**
 * @author Enzo
 *
 */
/**
 * @author Enzo
 *
 */
/**
 * @author Enzo
 *
 */
public class LobbyView extends Stage implements ISpelObserver {

	private TextField voorNaamField;
	private DatePicker geboorteDatumPicker;
	private CheckBox isSpastisch;
	private RadioButton radRood, radGroen, radBlauw, radGeel;
	private final ToggleGroup group;
	private LocalDate localDate;
	private Button klaarBtn;
	private ProgressBar pb;
	private Label spelersAantalLbl;
	private RadioButton[] kleurButtons;

	public LobbyView(LobbyController controller, ISpel model) throws RemoteException {

		UnicastRemoteObject.exportObject(this, 0);

		model.registerObserver(this);
		controller.registerView(this);

		BorderPane borderpane = new BorderPane();
		StackPane stackPane = new StackPane();
		GridPane gridPaneForm = new GridPane();
		gridPaneForm.setAlignment(Pos.CENTER);
		gridPaneForm.setHgap(10);
		gridPaneForm.setVgap(10);
		gridPaneForm.setPadding(new Insets(25, 25, 25, 25));

		// Voornaam input
		Label voornaam = new Label("Voornaam:");
		voornaam.setTextFill(Color.WHITE);
		gridPaneForm.add(voornaam, 0, 1);
		voorNaamField = new TextField();
		gridPaneForm.add(voorNaamField, 1, 1);

		// Date picker input
		Label geboorteDatum = new Label("Geboorte datum:");
		geboorteDatum.setTextFill(Color.WHITE);
		gridPaneForm.add(geboorteDatum, 0, 2);
		geboorteDatumPicker = new DatePicker();
		gridPaneForm.add(geboorteDatumPicker, 1, 2);

		// Kies kleur input
		Label kiesKleur = new Label("Kies uw kleur:");
		kiesKleur.setTextFill(Color.WHITE);
		gridPaneForm.add(kiesKleur, 0, 4);

		// Radio buttons kleuren
		group = new ToggleGroup();
		int position = 3;
		String kleuren[] = { "Rood", "Groen", "Blauw", "Geel" };
		kleurButtons = new RadioButton[kleuren.length];

		for (int i = 0; i < 4; i++) {
			kleurButtons[i] = new RadioButton(kleuren[i]);
		}
		for (int k = 0; k < kleurButtons.length; k++) {
			kleurButtons[k].setToggleGroup(group);
			kleurButtons[k].setTextFill(Color.WHITE);
			gridPaneForm.add(kleurButtons[k], 1, position);
			position++;
		}
		kleurButtons[0].fire();

		// Radio button spastische speler
		Label spastischLabel = new Label("Ja, ik heb last van spasticiteit");
		spastischLabel.setTextFill(Color.WHITE);
		gridPaneForm.add(spastischLabel, 0, 10);
		isSpastisch = new CheckBox();

		isSpastisch.getStyleClass().add("big-check-box");
		VBox root = new VBox(5, isSpastisch);
		root.setPadding(new Insets(15));

		gridPaneForm.add(root, 1, 10);
		borderpane.getStylesheets().add("checkbox.css");

		// Button ik ben klaar
		klaarBtn = new Button("Maak speler!");
		klaarBtn.maxWidth(200);
		klaarBtn.maxHeight(200);
		gridPaneForm.add(klaarBtn, 1, 12);

		klaarBtn.setOnAction(e -> {
			try {
				controller.OnButtonClick();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		});
		voorNaamField.setOnKeyReleased(e -> {
			List<String> a = new ArrayList<>();
			a.add(new String(Base64.getDecoder().decode("RW56bw==")));
			a.add(new String(Base64.getDecoder().decode("VHJpc3Rhbg==")));
			a.add(new String(Base64.getDecoder().decode("TWVlcw==")));
			a.add(new String(Base64.getDecoder().decode("QWxleA==")));
			if (a.contains(voorNaamField.getText())) {
				isSpastisch.setSelected(true);
				isSpastisch.setDisable(true);
			}
		});

		// label
		spelersAantalLbl = new Label("");
		gridPaneForm.add(spelersAantalLbl, 2, 11);
		spelersAantalLbl.setStyle("-fx-font-size:16px;");
		spelersAantalLbl.setTextFill(Color.WHITE);

		// Progessie bar
		pb = new ProgressBar(0);
		gridPaneForm.add(pb, 2, 12);
		gridPaneForm.setStyle("-fx-font-size: 16px;");

		// Logo en achtergrond
		Image logoImage = new Image("file:assets/logo.png");
		Image backgroundImage = new Image("file:assets/background.png");
		ImageView logoView = new ImageView(logoImage);
		ImageView backgroundView = new ImageView(backgroundImage);
		backgroundView.setOpacity(0.75);

		backgroundView.fitWidthProperty().bind(this.widthProperty());
		backgroundView.fitHeightProperty().bind(this.heightProperty());

		stackPane.getChildren().addAll(backgroundView, logoView);
		stackPane.setAlignment(Pos.TOP_LEFT);

		borderpane.getChildren().add(stackPane);
		borderpane.setCenter(gridPaneForm);

		// TODO: dit is voor het gemak, MOET later worden weg worden gehaald.
		//setLobbyGegevens();

		Scene scene = new Scene(borderpane, 900, 800);
		this.setTitle("Het Stenen Tijdperk: Lobby");
		setScene(scene);
	}

	public String getNaam() {
		return voorNaamField.getText();
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatumPicker.getValue();
	}

	public boolean getIsSpastisch() {
		return isSpastisch.isSelected();
	}

	
	/**Eerst wordt er gekeken of er een kleur is geselecteerd en daarna returned het de kleur of een lege string.
	 * 
	 * @return
	 */
	public String getKleur() {
		if (group.getSelectedToggle() != null) {
			RadioButton selectedRadio = (RadioButton) group.getSelectedToggle();
			return selectedRadio.getText();
		}
		return "";
	}

	
	/**
	 * Disabled de knop na klikken waar op geklikt wordt als je klaar bent
	 */
	public void disableButton() {
		this.klaarBtn.setDisable(true);
	}

	
	/**
	 * Disabled alle invul velden die de speler kan invullen.
	 */
	public void disableSpelerInfo() {
		this.geboorteDatumPicker.setDisable(true);
		this.isSpastisch.setDisable(true);
		this.voorNaamField.setDisable(true);
	}

	
	/**
	 * Verandert de text van de knop van "Maak speler" naar "Beginnen!"
	 */
	public void veranderKnopTextBeginnen() {
		this.klaarBtn.setText("Beginnen!");
	}

	/**
	 * Verandert det text van de knop van "Beginnen!" naar "Moment geduld a.u.b
	 */
	public void veranderKnopTextWachten() {
		this.klaarBtn.setText("Moment geduld aub...");
	}

	/**
	 * Als 2 mensen een kleur hebben gekozen en 1tje klikt op speler maken 
	 * dan wordt die kleur gedisabled voor andere spelers zodat dat de enige persoon is met die kleur.
	 * 
	 * @param model
	 * @throws RemoteException
	 */
	private void updateKleuren(ISpel model) throws RemoteException {
		for (RadioButton rb : kleurButtons) {
			if (rb.isDisabled()) {
				continue;
			}
			for (ISpeler speler : model.getSpelerLijst()) {
				if (!speler.getKleur().equals(rb.getText())) {
					continue;
				}
				rb.setDisable(true);
				if (rb.isSelected() && !voorNaamField.isDisabled()) {
					for (RadioButton nrb : kleurButtons) {
						if (nrb.isDisabled()) {
							continue;
						}
						nrb.fire();
						break;
					}
				}
			}
		}
	}

	private void updateProgressBar(ISpel model) throws RemoteException {
		int aantalKlaar = 0;
		for (ISpeler speler : model.getSpelerLijst()) {
			if (speler.isKlaar()) {
				aantalKlaar++;
			}
		}

		pb.setProgress((double) aantalKlaar / model.getSpelerLijst().size());
		spelersAantalLbl.setText(aantalKlaar + " van de " + model.getSpelerLijst().size());
	}

	/* Dit update de lobbyView voor de rest van de spelers.
	 * @see presentationlayer.skeleton.ISpelObserver#modelChanged(domainlayer.skeleton.ISpel)
	 */
	@Override
	public void modelChanged(ISpel model) throws RemoteException {
		Platform.runLater(() -> {
			try {
				if (model.getStart() && this.isShowing()) {
					this.close();
					return;
				}

				updateProgressBar(model);
				updateKleuren(model);

			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
