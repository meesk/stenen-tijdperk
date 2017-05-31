package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpeelbordView extends Pane {

	public SpeelbordView() {

		Image image = new Image(getClass().getClassLoader().getResourceAsStream("res/speelbord.jpg"));
		ImageView imageView = new ImageView(image);

		imageView.setFitHeight(image.getHeight() * 0.25);
		imageView.setFitWidth(image.getWidth() * 0.25);

		this.getChildren().add(imageView);
	}
}
