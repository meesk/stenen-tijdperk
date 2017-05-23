import controller.DobbelsteenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.BeschavingskaartView;
import view.DobbelsteenView;
import view.SpeelbordView;
import view.TableauView;

public class Main extends Application {

	private static DobbelsteenView dobbelsteenView;
	private static DobbelsteenController dobbelsteenController;
	
	public static void main(String[] args) {
		
		dobbelsteenView = new DobbelsteenView();
		dobbelsteenController = new DobbelsteenController(dobbelsteenView);
		dobbelsteenView.registerController(dobbelsteenController);
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();

		grid.add(new SpeelbordView(), 0, 0, 4, 1);
		grid.add(new TableauView(false), 0, 1, 1, 3);

		grid.add(new TableauView(), 1, 1);
		grid.add(new TableauView(), 2, 1);
		grid.add(new TableauView(), 3, 1);

		grid.add(new BeschavingskaartView(), 1, 2);
		grid.add(dobbelsteenView, 2, 2, 2, 1);

		grid.add(new Button("Vorige Beurt"), 1, 3);
		grid.add(new Button("Handleiding"), 2, 3);
		grid.add(new Button("Afsluiten"), 3, 3);
		
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
