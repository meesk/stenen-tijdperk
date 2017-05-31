package presentationlayer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpeelbordPane extends Pane {

	public SpeelbordPane() {
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);

		this.getChildren().add(imageView);
	}

}
