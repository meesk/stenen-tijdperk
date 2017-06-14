package presentationlayer;

import domainlayer.skeleton.IDobbelsteenWorp;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import proceslayer.DobbelsteenWorpController;
import proceslayer.SpelController;

public class SpelView {
	
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
		Button button = new Button("Handleiding");
		button.setOnAction(e -> spelController.onHandleidingButtonClick());
		grid.add(button, 2, 3);
		// grid.add(new Button("Afsluiten"), 3, 3);
	}

}
