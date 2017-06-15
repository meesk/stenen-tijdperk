package presentationlayer;

import java.io.IOException;

import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpel;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import proceslayer.DobbelsteenWorpController;
import proceslayer.SpelController;

/**
 * SpelView.java - Het bestand met alle informatie om het spelbord te tekenen.
 * 
 * @author Erwin Olie s1103026
 * Enzo Campfens s1102421
 * @versie 0.1
 *
 */

public class SpelView extends Pane{
	
	public SpelView(SpelController spelController, DobbelsteenWorpController dobbelsteenWorpController, IDobbelsteenWorp dobbelsteenWorp) throws Exception {
		// De grid waarop de visuele objecten geplaatst worden.
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #6a5b34");

		// Het plaatsen van de views voor het speelbord en spelerstableau.
		grid.add(new SpeelbordView(), 0, 0, 4, 1);
		// grid.add(new TableauView(false), 0, 1, 1, 3);

		// Het plaatsen van de views van de kleine tableau's van de overige spelers.
		// grid.add(new TableauView(), 1, 1);
		// grid.add(new TableauView(), 2, 1);
		// grid.add(new TableauView(), 3, 1);

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
		
		this.getChildren().add(grid);
	}

}
