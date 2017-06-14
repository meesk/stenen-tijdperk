package presentationlayer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * SpeelbordPane.java
 * De view van het speelbord.
 * 
 * @author Erwin Olie, s1103026
 * @version 0.2
 */
public class SpeelbordView extends Pane {

	public SpeelbordView() {
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);

		this.getChildren().add(imageView);
		new LocatieView(this, 280, 117, 100, 117); // bos
		new LocatieView(this, 412, 113, 143, 83); // leemgroeve
		new LocatieView(this, 714, 109, 121, 121); // steengroeve
		new LocatieView(this, 614, 236, 127, 94); // rivier
		new LocatieView(this, 459, 436, 94, 133); // beschavingskaart 4
		new LocatieView(this, 553, 436, 94, 133); // beschavingskaart 3
		new LocatieView(this, 647, 436, 94, 133); // beschavingskaart 2
		new LocatieView(this, 741, 436, 94, 133); // beschavingskaart 1
		new LocatieView(this, 128, 260, 110, 68); // jacht
		new LocatieView(this, 91, 476, 82, 90); // huttegel 1
		new LocatieView(this, 175, 476, 82, 90); // huttegel 2
		new LocatieView(this, 259, 476, 82, 90); // huttegel 3
		new LocatieView(this, 343, 476, 82, 90); // huttegel 4
		new LocatieView(this, 247, 327, 75, 61); // akker
		new LocatieView(this, 318, 399, 97, 62); // hut
		new LocatieView(this, 418, 280, 125, 98); // gereedschapsmaker
	}

}
