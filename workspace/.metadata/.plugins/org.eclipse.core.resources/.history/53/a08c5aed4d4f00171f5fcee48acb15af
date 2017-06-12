package stenentijdperk;

import java.rmi.Naming;

import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentationlayer.DobbelsteenWorpPane;
import presentationlayer.HandleidingPane;
import presentationlayer.LobbyView;
import presentationlayer.SpeelbordPane;
import proceslayer.DobbelsteenWorpController;
import proceslayer.LobbyController;
import proceslayer.SpelController;

/**
 * StenenTijdperk.java
 * Een simpele Main-klasse waar de client word opgezet.
 * 
 * @author	Erwin Olie, s1103026
 * Enzo Campfens s1102421
 * Mees Kluivers s1102358
 * @version	0.5
 */
public class StenenTijdperk extends Application {

	/** De main method die de javafx applicatie opstart. */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	/** {@inheritDoc} */
	public void start(Stage primaryStage) throws Exception {

		// Het ontvangen van het model dat dobbelsteen worpen beheert.
		IDobbelsteenWorp dobbelsteenWorp = (IDobbelsteenWorp) Naming.lookup("rmi://localhost/DobbelsteenWorp");
		ISpel spel = (ISpel) Naming.lookup("rmi://localhost/Spel");
		// dobbelsteenworppane hierzo
		HandleidingPane handleidingPane = new HandleidingPane();
		
		
		// Het aanmaken van een controller die dobbelsteen worpen beheert.
		DobbelsteenWorpController dobbelsteenWorpController = new DobbelsteenWorpController(dobbelsteenWorp);
		
		SpelController spelController = new SpelController(handleidingPane);
		
		LobbyController lobbyController = new LobbyController(spel);
		
		LobbyView lobbyView = new LobbyView(primaryStage, lobbyController);
		
		
		// De grid waarop de visuele objecten geplaatst worden.
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #6a5b34");

		// Het plaatsen van de views voor het speelbord en spelerstableau.
		grid.add(new SpeelbordPane(), 0, 0, 4, 1);
		// grid.add(new TableauView(false), 0, 1, 1, 3);

		// Het plaatsen van de views van de kleine tableau's van de overige spelers.
		// grid.add(new TableauView(), 1, 1);
		// grid.add(new TableauView(), 2, 1);
		// grid.add(new TableauView(), 3, 1);

		// Het plaatsen van de view voor de dobbelstenen & worp.
		// grid.add(new BeschavingskaartView(), 1, 2);
		grid.add(new DobbelsteenWorpPane(dobbelsteenWorp, dobbelsteenWorpController), 2, 2, 2, 1);

		// Het plaatsen van de buttons.
		// grid.add(new Button("Vorige Beurt"), 1, 3);
		
		// De knop en de knop action voor de handleiding.
		Button button = new Button("Handleiding");
		button.setOnAction(e -> spelController.onHandleidingButtonClick());
		grid.add(button, 2, 3);
		// grid.add(new Button("Afsluiten"), 3, 3);

		// Het voorbereiden en tonen van de stage.
		Scene scene = new Scene(lobbyView, 1000, 800);
		primaryStage.setTitle("Het Stenen Tijdperk");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}