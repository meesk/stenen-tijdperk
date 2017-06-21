package presentationlayer;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentationlayer.skeleton.ISpelObserver;
import proceslayer.BetaalController;
import proceslayer.DobbelsteenWorpController;
import proceslayer.SpelController;
import stenentijdperk.StenenTijdperk;

/**
 * SpelView.java<br>
 * Het bestand met alle informatie om het spelbord te tekenen.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @version 1.0
 */

public class SpelView extends Stage implements ISpelObserver {

	private GridPane grid;

	public SpelView(ISpeelbord speelbord, SpelController spelController,
			DobbelsteenWorpController dobbelsteenWorpController, IDobbelsteenWorp dobbelsteenWorp, ISpel model)
			throws Exception {

		UnicastRemoteObject.exportObject(this, 0);
		model.registerObserver(this);

		Pane pane = new Pane();

		// De grid waarop de visuele objecten geplaatst worden.
		grid = new GridPane();
		grid.setStyle("-fx-background-color: #6a5b34");

		// Het plaatsen van de views voor het speelbord en spelerstableau.
		grid.add(new SpeelbordView(speelbord), 0, 0, 4, 1);

		// Het plaatsen van de view voor de dobbelstenen & worp.
		// grid.add(new BeschavingskaartView(), 1, 2);
		grid.add(new DobbelsteenWorpView(dobbelsteenWorp, dobbelsteenWorpController), 2, 2, 2, 1);

		// Het plaatsen van de buttons.
		// grid.add(new Button("Vorige Beurt"), 1, 3);

		// De knop en de knop action voor de handleiding.
		Button handleidingButton = new Button("Handleiding");
		handleidingButton.setOnAction(e -> spelController.onHandleidingButtonClick());
		grid.add(handleidingButton, 2, 3);

		Button opslaan = new Button("Opslaan");
		opslaan.setOnAction(e -> {
			try {
				spelController.onOpslaanButtonClick();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		grid.add(opslaan, 3, 3);

		pane.getChildren().add(grid);
		Scene scene = new Scene(pane);
		this.setScene(scene);
	}
	
	private void toonSpelView(ISpel spel) throws RemoteException {
		grid.add(new TableauView(1.0, StenenTijdperk.getSpeler().getTableau()), 0, 1, 1, 3);
		List<ISpeler> spelers = spel.getSpelerLijst();
		spelers.remove(StenenTijdperk.getSpeler());
		for (int i = 1; i <= spelers.size(); i++) {
			grid.add(new TableauView(0.3, spelers.get(i - 1).getTableau()), i, 1);
		}
		for (int i = 3; i > spelers.size(); i--) {
			grid.add(new TableauView(0.3, null), i, 1);
		}
		this.show();
		this.sizeToScene();
	}
	
	private void toonBetaalView(ISpel spel) throws RemoteException { 
		BetaalView bv = new BetaalView(true, false, new BetaalController(StenenTijdperk.getSpeler().getTableau()));
		bv.show();
		StenenTijdperk.getSpeler().getTableau().registerObserver(bv);
	}

	@Override
	public void modelChanged(ISpel spel) throws RemoteException {
		Platform.runLater(() -> {
			try {
				if (spel.getStart() && !this.isShowing()) {
					toonSpelView(spel);
				}
				if (spel.getVoeden()) {
					toonBetaalView(spel);
				}

			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
