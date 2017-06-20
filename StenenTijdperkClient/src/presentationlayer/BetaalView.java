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


	public BetaalView(boolean voeden, BetaalController controller) throws RemoteException {
		BorderPane borderpane = new BorderPane();
		
		UnicastRemoteObject.exportObject(this,0);

		controller.registerView(this);

		GridPane gridPane = new GridPane();

		Label voedsel = new Label("voedsel");
		Label hout = new Label("hout");
		Label leem = new Label("leem");
		Label steen = new Label("steen");
		Label goud = new Label("goud");


        SpinnerValueFactory<Integer> valueVoedsel =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        SpinnerValueFactory<Integer> valueHout =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        SpinnerValueFactory<Integer> valueLeem =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        SpinnerValueFactory<Integer> valueSteen =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        SpinnerValueFactory<Integer> valueGoud =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        inputVoedsel.setValueFactory(valueVoedsel);
        inputHout.setValueFactory(valueHout);
        inputLeem.setValueFactory(valueLeem);
        inputSteen.setValueFactory(valueSteen);
        inputGoud.setValueFactory(valueGoud);

		HBox hbox = new HBox();

		Button betalenButton = new Button("Betalen middelen");
		betalenButton.setOnMouseClicked(e -> controller.onButtonPressed());

		// Toon dit alleen voor het voeden van de stamleden
		if(voeden) {
			gridPane.add(voedsel, 0, 1);
			gridPane.add(inputVoedsel, 0, 2);
			Button verliesPuntenButton = new Button("Verlies 10 punten");
			verliesPuntenButton.setOnMouseClicked(e -> controller.onVerliesPuntenPressed());
			hbox.getChildren().add(verliesPuntenButton);
			borderpane.setAlignment(verliesPuntenButton, Pos.BOTTOM_LEFT);
		}

		hbox.getChildren().add(betalenButton);

		gridPane.add(hout, 1, 1);
		gridPane.add(inputHout, 1, 2);

		gridPane.add(leem, 2, 1);
		gridPane.add(inputLeem, 2, 2);

		gridPane.add(steen, 3, 1);
		gridPane.add(inputSteen, 3, 2);

		gridPane.add(goud, 4, 1);
		gridPane.add(inputGoud, 4, 2);

		gridPane.setAlignment(Pos.CENTER);
		borderpane.setCenter(gridPane);
		borderpane.setBottom(hbox);
		borderpane.setAlignment(betalenButton, Pos.BOTTOM_RIGHT);

		borderpane.setStyle("-fx-background-color: #6a5b34");
		
		// Maakt een nieuwe Scene aan met de ScrollPane om de handleiding te tonen.
		Scene scene = new Scene(borderpane, 800, 800);

		// Zet de titel van de PrimaryStage en dat de PrimaryStage altijd on top moet zijn.
		// en daarna wordt de Scene in de PrimaryStage gezet.
		this.setTitle("Betalen middelen");
		this.setAlwaysOnTop(true);
		this.setScene(scene);
	}

	public int getVoedsel(){
		return inputVoedsel.getValue();
	}

	public int getHout(){
		return inputHout.getValue();
	}

	public int getLeem(){
		return inputLeem.getValue();
	}

	public int getSteen(){
		return inputSteen.getValue();
	}

	public int getGoud(){
		return inputGoud.getValue();
	}

	@Override
	public void modelChanged(ITableau model) throws RemoteException {

	}
}
