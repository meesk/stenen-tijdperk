package presentationlayer;

import domainlayer.skeleton.locaties.ILocatie;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * LocatieView.java Een klasse die alle informatie bevat om de locatie view te
 * maken.
 *
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */

public class LocatieView extends StackPane {

	public LocatieView(int x, int y, int w, int h) {
		Rectangle rectangle = new Rectangle(w, h);
		rectangle.setFill(Color.DARKGOLDENROD);
		rectangle.setOpacity(0.2);
		rectangle.setOnMouseMoved(e -> rectangle.setOpacity(0.85));
		rectangle.setOnMouseExited(e -> rectangle.setOpacity(0.2));
		rectangle.setOnMouseClicked(e -> System.out.println("geklikt op locatie!"));
		this.getChildren().add(rectangle);
		this.setLayoutX(x);
		this.setLayoutY(y);

		// controller.registerView(this);
	}

	public void modelChanged(ILocatie locatie) {
		//
	}
}
