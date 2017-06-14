package presentationlayer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * SpeelbordPane.java
 * De view van het speelbord.
 * 
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class SpeelbordView extends Pane {

	/** Hier wordt het speelbord geinitialiseerd */
	public SpeelbordView() {
		// Het inladen van de image van het speelbord.
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);

		// Het toevoegen van de ingeladen elementen aan de pane.
		this.getChildren().add(imageView);
	}

}
