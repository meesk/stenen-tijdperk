package presentationlayer;

import javafx.stage.Stage;
import proceslayer.SpelController;

/**
 * EindView.java<br>
 * Een klasse die alle informatie bevat om de eind view te maken.
 *
 * @author Tristan Caspers, s1102755
 * @version 1.0
 */

public class EindView {

	public EindView(Stage primaryStage, SpelController controller) {

		controller.registerView(this);

		// View nog opbouwen!
		//.getChildren().addAll(..., ...);
	}
}
