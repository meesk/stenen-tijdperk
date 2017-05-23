package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TableauView extends Pane {

	public TableauView() {
		this (true);
	}
	
	public TableauView(boolean mini) {

		Image image = new Image(getClass().getClassLoader().getResourceAsStream( "res/tableau.png"));
		ImageView imageView = new ImageView(image);

		if (!mini) {
			imageView.setFitHeight(image.getHeight() * 0.25);
			imageView.setFitWidth(image.getWidth() * 0.25);
		} else {
			imageView.setFitHeight(image.getHeight() * 0.0625);
			imageView.setFitWidth(image.getWidth() * 0.0625);
		}

		this.getChildren().add(imageView);
	}
}
