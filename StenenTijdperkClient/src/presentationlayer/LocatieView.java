package presentationlayer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import domainlayer.skeleton.locaties.ILocatie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	private List<Point> points;
	
	public LocatieView(int x, int y, int w, int h, List<Point> points) {
		Rectangle rectangle = new Rectangle(w, h);
		rectangle.setFill(Color.DARKGOLDENROD);
		rectangle.setOpacity(0.0);
		rectangle.setOnMouseMoved(e -> rectangle.setOpacity(0.85));
		rectangle.setOnMouseExited(e -> rectangle.setOpacity(0.0));
		rectangle.setOnMouseClicked(e -> System.out.println("geklikt op locatie!"));
		
		Pane pane = new Pane();
		this.points = points;
		
		for (Point point : points) {
			Image poppetje = new Image("file:assets/gele_poppetje.png");
			ImageView imageView = new ImageView(poppetje);
			imageView.relocate(point.getX(), point.getY());
			pane.getChildren().add(imageView);
		}
		
		this.getChildren().add(pane);
		this.getChildren().add(rectangle);
		this.setLayoutX(x);
		this.setLayoutY(y);
		
		// controller.registerView(this);
	}

	public void modelChanged(ILocatie locatie) {
		//
	}
}
