package presentationlayer;

<<<<<<< HEAD
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import proceslayer.TableauController;

/**
 * TableauView.java
 * Een klasse die alle informatie bevat om de tableau view te maken.
 *
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */

public class TableauView extends StackPane {

	public TableauView(Stage primaryStage, TableauController controller) {

		controller.registerView(this);

		// View nog opbouwen!
		//this.getChildren().addAll();
	}
}
=======
import domainlayer.skeleton.ITableau;

public class TableauView {

	public void modelChanged(ITableau tableau) {
		//
	}

}
>>>>>>> 02428e714a0cc4023c621104c5265cf7013645ea
