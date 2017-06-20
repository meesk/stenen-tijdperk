package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ITableau;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import presentationlayer.skeleton.ITableauObserver;
import proceslayer.BetaalController;

/**
 * BetaalView.java<br>
 * Een klasse die alle informatie bevat om de betaal view te maken.
 *
 * @author Mees Kluivers, s1102358
 * @version 1.0
 */

public class BetaalView extends Stage implements ITableauObserver {

	Spinner<Integer> inputVoedsel = new Spinner<Integer>();
	Spinner<Integer> inputHout = new Spinner<Integer>();
	Spinner<Integer> inputLeem = new Spinner<Integer>();
	Spinner<Integer> inputSteen = new Spinner<Integer>();
	Spinner<Integer> inputGoud = new Spinner<Integer>();
	Spinner<Integer> inputStamleden = new Spinner<Integer>();

	public BetaalView(boolean voeden, boolean toonStamleden, BetaalController controller) throws RemoteException {

		UnicastRemoteObject.exportObject(this, 0);

		BorderPane borderPane = new BorderPane();

		controller.registerView(this);

		GridPane gridPane = new GridPane();

		Label voedsel = new Label("voedsel");
		Label hout = new Label("hout");
		Label leem = new Label("leem");
		Label steen = new Label("steen");
		Label goud = new Label("goud");
		Label stamleden = new Label("stamleden");

		SpinnerValueFactory<Integer> valueVoedsel = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
		SpinnerValueFactory<Integer> valueHout = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
		SpinnerValueFactory<Integer> valueLeem = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
		SpinnerValueFactory<Integer> valueSteen = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
		SpinnerValueFactory<Integer> valueGoud = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
		SpinnerValueFactory<Integer> valueStamleden = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

		inputVoedsel.setValueFactory(valueVoedsel);
		inputHout.setValueFactory(valueHout);
		inputLeem.setValueFactory(valueLeem);
		inputSteen.setValueFactory(valueSteen);
		inputGoud.setValueFactory(valueGoud);
		inputStamleden.setValueFactory(valueGoud);

		HBox hbox = new HBox();

		Button betalenButton = new Button("Betalen middelen");
		betalenButton.setOnAction(e -> this.close());

		// Toon dit alleen voor het voeden van de stamleden
		if (voeden) {
			gridPane.add(voedsel, 1, 1);
			gridPane.add(inputVoedsel, 1, 2);
			Button verliesPuntenButton = new Button("Verlies 10 punten");
			verliesPuntenButton.setOnMouseClicked(e -> controller.onVerliesPuntenPressed());
			hbox.getChildren().add(verliesPuntenButton);
			borderPane.setAlignment(verliesPuntenButton, Pos.BOTTOM_LEFT);
		}

		hbox.getChildren().add(betalenButton);

		if (!toonStamleden) {
			gridPane.add(hout, 1, 1);
			gridPane.add(inputHout, 1, 2);

			gridPane.add(leem, 2, 1);
			gridPane.add(inputLeem, 2, 2);

			gridPane.add(steen, 3, 1);
			gridPane.add(inputSteen, 3, 2);

			gridPane.add(goud, 4, 1);
			gridPane.add(inputGoud, 4, 2);
		}

		if (toonStamleden) {
			gridPane.add(stamleden, 1, 1);
			gridPane.add(inputStamleden, 1, 2);
		}

		gridPane.setAlignment(Pos.CENTER);
		borderPane.setCenter(gridPane);
		borderPane.setBottom(hbox);
		borderPane.setAlignment(betalenButton, Pos.BOTTOM_RIGHT);

		borderPane.setStyle("-fx-background-color: #6a5b34");

		Scene scene = new Scene(borderPane);
		this.setScene(scene);
	}

	public int getVoedsel() {
		return inputVoedsel.getValue();
	}

	public int getHout() {
		return inputHout.getValue();
	}

	public int getLeem() {
		return inputLeem.getValue();
	}

	public int getSteen() {
		return inputSteen.getValue();
	}

	public int getGoud() {
		return inputGoud.getValue();
	}

	@Override
	public void modelChanged(ITableau model) throws RemoteException {

	}

	public int getStamleden() {
		return inputStamleden.getValue();
	}
}
