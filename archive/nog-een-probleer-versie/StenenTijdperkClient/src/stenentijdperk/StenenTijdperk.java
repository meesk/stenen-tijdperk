package stenentijdperk;

import java.rmi.Naming;

import domainlayer.skeleton.ISpel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentationlayer.DobbelsteenWorpPane;
import presentationlayer.SpeelbordPane;
import proceslayer.skeleton.IDobbelsteenWorpController;

public class StenenTijdperk extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ISpel spel = (ISpel)Naming.lookup("rmi://localhost/SpelServer");
		
		IDobbelsteenWorpController dobbelsteenWorpController = spel.getDobbelsteenWorpController();
		
		GridPane grid = new GridPane();

		grid.add(new SpeelbordPane(), 0, 0, 4, 1);
		//grid.add(new TableauView(false), 0, 1, 1, 3);

		//grid.add(new TableauView(), 1, 1);
		//grid.add(new TableauView(), 2, 1);
		//grid.add(new TableauView(), 3, 1);

		//grid.add(new BeschavingskaartView(), 1, 2);
		grid.add(new DobbelsteenWorpPane(dobbelsteenWorpController), 2, 2, 2, 1);

		//grid.add(new Button("Vorige Beurt"), 1, 3);
		//grid.add(new Button("Handleiding"), 2, 3);
		//grid.add(new Button("Afsluiten"), 3, 3);
		
		Scene scene = new Scene(grid);
		primaryStage.setTitle("Het Stenen Tijdperk");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
