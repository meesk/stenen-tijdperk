package presentationlayer;

import java.awt.Point;
import java.rmi.RemoteException;

import domainlayer.skeleton.locaties.ILocatie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import proceslayer.LocatieController;

/**
 * LocatieView.java <br>
 * Een klasse die alle informatie bevat om de locatie view te
 * maken.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */

public class LocatieView extends StackPane {

	public LocatieView(ILocatie model, LocatieController controller) throws RemoteException {
		Rectangle rectangle = new Rectangle(model.getWidth(), model.getHeight());
		rectangle.setFill(Color.DARKGOLDENROD);
		rectangle.setOpacity(0.0);
		rectangle.setOnMouseMoved(e -> rectangle.setOpacity(0.85));
		rectangle.setOnMouseExited(e -> rectangle.setOpacity(0.0));
		rectangle.setOnMouseClicked(e -> controller.onKiesLocatie());

		Pane pane = new Pane();

		for (Point point : model.getCirkels()) {
			Image poppetje = new Image("file:assets/gele_poppetje.png");
			ImageView imageView = new ImageView(poppetje);
			imageView.relocate(point.getX(), point.getY());
			pane.getChildren().add(imageView);
		}

		this.getChildren().add(pane);
		this.getChildren().add(rectangle);
		this.setLayoutX(model.getX());
		this.setLayoutY(model.getY());

	}

	public void modelChanged(ILocatie locatie) {
		//
	}
}
