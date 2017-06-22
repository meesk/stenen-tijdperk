package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import domainlayer.enums.Middel;
import domainlayer.skeleton.ITableau;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import presentationlayer.skeleton.ITableauObserver;

public class BetaalView extends Stage implements ITableauObserver {

	private boolean minPunten;
	private Map<String, Spinner<Integer>> spinners;

	public BetaalView(ITableau tableau, String message, boolean voedsel, boolean grondstoffen, boolean stamleden,
			boolean minPunten) throws RemoteException {
		
		UnicastRemoteObject.exportObject(this, 0);

		this.minPunten = false;
		spinners = new HashMap<>();

		VBox context = new VBox(10);

		Label infoLabel = new Label(message);
		infoLabel.setFont(Font.font(32));
		HBox infoBox = new HBox(infoLabel);
		context.getChildren().add(infoBox);

		HBox betaalBox = new HBox();
		if (voedsel) {
			VBox voedselSpinner = initSpinner("voedsel", tableau.getMiddelen().get(Middel.VOEDSEL));
			betaalBox.getChildren().add(voedselSpinner);
		}
		if (grondstoffen) {
			VBox houtSpinner = initSpinner("hout", tableau.getMiddelen().get(Middel.HOUT));
			VBox leemSpinner = initSpinner("leem", tableau.getMiddelen().get(Middel.LEEM));
			VBox steenSpinner = initSpinner("steen", tableau.getMiddelen().get(Middel.STEEN));
			VBox goudSpinner = initSpinner("goud", tableau.getMiddelen().get(Middel.GOUD));
			betaalBox.getChildren().addAll(houtSpinner, leemSpinner, steenSpinner, goudSpinner);
		}
		if (stamleden) {
			VBox stamlidSpinner = initSpinner("stamleden", tableau.getStamleden().size());
			betaalBox.getChildren().add(stamlidSpinner);
		}
		context.getChildren().add(betaalBox);

		Button bevestigen = new Button("Bevestigen");
		bevestigen.setOnAction(e -> this.close());
		HBox buttonBox = new HBox(bevestigen);
		if (minPunten) {
			Button punten = new Button("-10 Punten");
			punten.setOnAction(e -> {
			this.minPunten = true;
			 this.close();
			}
			);
			buttonBox.getChildren().add(punten);
		}
		context.getChildren().add(buttonBox);

		context.setStyle("-fx-background-color: #6a5b34");
		Scene scene = new Scene(context);
		this.setAlwaysOnTop(true);
		this.setScene(scene);
	}

	private VBox initSpinner(String naam, int hoeveelheid) {
		VBox box = new VBox();

		// Maak de afbeelding aan
		Image image = new Image("file:assets/betaal_icons/" + naam + ".png");
		ImageView imageView = new ImageView(image);
		box.getChildren().add(imageView);

		// Maak de beschrijving aan, bijvoorbeeld: "goud: (3)"
		String text = String.format("%s: (%d)", naam, hoeveelheid);
		Label beschrijving = new Label(text);
		beschrijving.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		box.getChildren().add(beschrijving);

		// Maak de relevante spinner aan
		Spinner<Integer> spinner = new Spinner<Integer>();
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, hoeveelheid, 0);
		spinner.setValueFactory(valueFactory);

		box.getChildren().add(spinner);

		spinners.put(naam, spinner);
		return box;
	}

	public int getStamleden() {
		return spinners.get("stamleden").getValue();
	}

	public int getVoedsel() {
		return spinners.get("voedsel").getValue();
	}

	public int getHout() {
		return spinners.get("hout").getValue();
	}

	public int getLeem() {
		return spinners.get("leem").getValue();
	}

	public int getSteen() {
		return spinners.get("steen").getValue();
	}

	public int getGoud() {
		return spinners.get("goud").getValue();
	}
	
	public boolean isMinPunten() {
		return this.minPunten;
	}

	@Override
	public void modelChanged(ITableau model) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
