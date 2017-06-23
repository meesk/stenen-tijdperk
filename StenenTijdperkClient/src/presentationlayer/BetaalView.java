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

/**
 * BetaalView.java
 * De view van het betalen van middelen.
 *
 * @author Mees Kluivers, s1102358
 * @author Erwin Olie, s1103026
 * @version 1.0
 */

public class BetaalView extends Stage implements ITableauObserver {

	private boolean minPunten;
	private Map<String, Spinner<Integer>> spinners;

	/**
	 * De constructor van de betaalview
	 * 
	 * @param tableau  Het model van de view
	 * @param message  De text die getoond moet worden op het scherm
	 * @param voedsel  Optie om voedsel te tonen op het scherm
	 * @param grondstoffen  Optie om grondstoffen te tonen op het scherm
	 * @param stamleden  Optie om stamleden te tonen op het scherm
	 * @param minPunten  Optie om de -10 punten te tonen op het scherm
	 * @throws RemoteException
	 */
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
			});
			buttonBox.getChildren().add(punten);
		}
		context.getChildren().add(buttonBox);

		context.setStyle("-fx-background-color: #6a5b34");
		Scene scene = new Scene(context);
		this.setAlwaysOnTop(true);
		this.setScene(scene);
	}

	/**
	 * Initialiseren van alle spinners op de betaalview
	 * @param naam  De naam van de spinner
	 * @param hoeveelheid  De maximale hoeveelheid van een spinner
	 * @return VBox  alle spinners met hun namen
	 */
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

	/** 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void modelChanged(ITableau model) throws RemoteException {

	}
}
