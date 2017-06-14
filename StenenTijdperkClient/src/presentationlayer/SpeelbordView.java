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
		
		imageView.setOnMouseClicked(e -> System.out.println("["+e.getX()+", "+e.getY()+"]"));
		
		// Voedsel : [61.0, 71.0] [241.0, 295.0]
		// Hout : [251.0, 64.0] [389.0, 223.0]
		// Leem : [414.0, 61.0] [570.0, 194.0]
		// Steen : [696.0, 67.0] [830.0, 214.0]
		// Hut : [316.0, 383.0] [397.0, 443.0]
		// Akker : [236.0, 300.0] [354.0, 367.0]
		// Gereedschap : [409.0, 260.0] [557.0, 389.0]

		// Het toevoegen van de ingeladen elementen aan de pane.
		this.getChildren().add(imageView);
	}

}
