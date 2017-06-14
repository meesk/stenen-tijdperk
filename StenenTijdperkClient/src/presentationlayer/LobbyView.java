package presentationlayer;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import proceslayer.LobbyController;

/**
 * LobbyView.java
 * Een klasse die alle informatie bevat om de Lobby view te maken.
 *
 * @author Enzo Campfens s1102421,
 * Mees Kluivers s1102358
 * @version 0.1
 */

public class LobbyView extends BorderPane {

	private TextField voorNaamField;
	private DatePicker geboorteDatumPicker;
	private RadioButton radRood, radGroen, radBlauw, radGeel;
	private CheckBox isSpastisch;
	private final ToggleGroup group;
	private LocalDate localDate;

	public LobbyView(Stage primaryStage, LobbyController controller) {

		controller.registerView(this);

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
	    RadioButton radRood = new RadioButton("Rood");
	    radRood.setTextFill(Color.WHITE);
	    gridPaneForm.add(radRood, 1, 3);
	    RadioButton radGroen = new RadioButton("Groen");
	    radGroen.setTextFill(Color.WHITE);
	    gridPaneForm.add(radGroen, 1, 4);
	    RadioButton radBlauw = new RadioButton("Blauw");
	    radBlauw.setTextFill(Color.WHITE);
	    gridPaneForm.add(radBlauw, 1, 5);
	    RadioButton radGeel = new RadioButton("Geel");
	    radGeel.setTextFill(Color.WHITE);
	    gridPaneForm.add(radGeel, 1, 6);

	    // Toevoegen radio buttons aan groep
	    radRood.setToggleGroup(group);
	    radGroen.setToggleGroup(group);
	    radBlauw.setToggleGroup(group);
	    radGeel.setToggleGroup(group);

	    // Radio button spastische speler
	    Label spastischLabel = new Label("Ja, ik heb last van spasticiteit");
	    spastischLabel.setTextFill(Color.WHITE);
	    gridPaneForm.add(spastischLabel, 0, 10);
	    isSpastisch = new CheckBox();
	    isSpastisch.setOnMouseEntered(e -> isSpastisch.setSelected(!isSpastisch.isSelected()));

        isSpastisch.getStyleClass().add("big-check-box");
        VBox root = new VBox(5, isSpastisch);
        root.setPadding(new Insets(15));

	    gridPaneForm.add(root, 1, 10);
	    this.getStylesheets().add("checkbox.css");

	    // Button ik ben klaar
	    Button klaar = new Button("Ik ben klaar");
	    klaar.maxWidth(200);
	    klaar.maxHeight(200);
	    gridPaneForm.add(klaar, 1 , 12);

	    klaar.setOnAction(e -> controller.OnButtonClick());

	    //Progessie bar
	    ProgressBar pb = new ProgressBar(0.25);
	    gridPaneForm.add(pb, 2, 12);
		gridPaneForm.setStyle("-fx-font-size: 16px;");

	    // Logo en achtergrond
		Image logoImage = new Image("file:assets/logo.png");
		Image backgroundImage = new Image("file:assets/background.png");
		ImageView logoView = new ImageView(logoImage);
		ImageView backgroundView = new ImageView(backgroundImage);
		backgroundView.setOpacity(0.75);

		backgroundView.fitWidthProperty().bind(primaryStage.widthProperty());
		backgroundView.fitHeightProperty().bind(primaryStage.heightProperty());

		stackPane.getChildren().addAll(backgroundView, logoView);
		stackPane.setAlignment(Pos.TOP_LEFT);

		this.getChildren().add(stackPane);
		this.setCenter(gridPaneForm);
	}

	public String getNaam() {
		return voorNaamField.getText();
	}

	public LocalDate getGeboorteDatum() {
		localDate = geboorteDatumPicker.getValue();
		return localDate;
	}

	public boolean getIsSpastisch() {
		return isSpastisch.isSelected();
	}

	public ToggleGroup getGroup() {
		return group;
	}
}