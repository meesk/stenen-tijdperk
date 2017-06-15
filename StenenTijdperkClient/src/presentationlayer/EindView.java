package presentationlayer;

import javafx.stage.Stage;
import proceslayer.SpelController;

/**
 * @author Tristan Caspers s1102755
 * @version 0.1
 */

public class EindView {

	public EindView(Stage primaryStage, SpelController controller) {

		controller.registerView(this);

		// View nog opbouwen!
		//.getChildren().addAll(..., ...);
	}
}
