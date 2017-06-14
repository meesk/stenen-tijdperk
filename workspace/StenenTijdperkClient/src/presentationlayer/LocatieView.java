package presentationlayer;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import proceslayer.LocatieController;

/**
 * LocatieView.java
 * Een klasse die alle informatie bevat om de locatie view te maken.
 *
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */

public class LocatieView extends StackPane {

	public LocatieView(Stage primaryStage, LocatieController controller) {

		controller.registerView(this);

		//this.getChildren().addAll(selectie-overlay,pane-met-stamleden);
	}
}
