package presentationlayer;

import domainlayer.skeleton.ITableau;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * TableauView.java
 * Een klasse die alle informatie bevat om de tableau view te maken.
 *
 * @author Erwin Olie, s1103026
 * @version 0.2
 */

public class TableauView extends StackPane {

	public TableauView() {
		this(false);
	}
	
	public TableauView(boolean large) {

		Image image = new Image("file:assets/tableau.png");
		ImageView imageView = new ImageView(image);

		if (large) {
			imageView.setFitHeight(image.getHeight() * 0.25);
			imageView.setFitWidth(image.getWidth() * 0.25);
		} else {
			imageView.setFitHeight(image.getHeight() * 0.0625);
			imageView.setFitWidth(image.getWidth() * 0.0625);
		}

		this.getChildren().add(imageView);
	}

	public void modelChanged(ITableau tableau) {
		//
	}
}
