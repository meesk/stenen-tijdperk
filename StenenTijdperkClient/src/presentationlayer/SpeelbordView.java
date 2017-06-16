package presentationlayer;

import java.awt.Point;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * SpeelbordPane.java
 * De view van het speelbord.
 *
 * @author Erwin Olie, s1103026
 * @version 0.3
 */
public class SpeelbordView extends Pane {

	public SpeelbordView() {
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);

		this.getChildren().add(imageView);

		this.getChildren().addAll(
			new LocatieView(280, 117, 100, 117, new ArrayList<Point>() {{
				add(new Point(13, 2));
				add(new Point(40, 8));
				add(new Point(21, 23));
				add(new Point(50, 27));
				add(new Point(13, 42));
				add(new Point(40, 44));
				add(new Point(52, 61));
			}}), // bos
			new LocatieView(412, 113, 143, 83, new ArrayList<>()), // leemgroeve
			new LocatieView(714, 109, 121, 121, new ArrayList<>()), // steengroeve
			new LocatieView(614, 236, 127, 94, new ArrayList<>()), // rivier
			new LocatieView(459, 436, 94, 133, new ArrayList<>()), // beschavingskaart 4
			new LocatieView(553, 436, 94, 133, new ArrayList<>()), // beschavingskaart 3
			new LocatieView(647, 436, 94, 133, new ArrayList<>()), // beschavingskaart 2
			new LocatieView(741, 436, 94, 133, new ArrayList<>()), // beschavingskaart 1
			new LocatieView(128, 260, 110, 68, new ArrayList<>()), // jacht
			new LocatieView(91, 476, 82, 90, new ArrayList<>()), // huttegel 1
			new LocatieView(175, 476, 82, 90, new ArrayList<>()), // huttegel 2
			new LocatieView(259, 476, 82, 90, new ArrayList<>()), // huttegel 3
			new LocatieView(343, 476, 82, 90, new ArrayList<>()), // huttegel 4
			new LocatieView(247, 327, 75, 61, new ArrayList<>()), // akker
			new LocatieView(318, 399, 97, 62, new ArrayList<>()), // hut
			new LocatieView(418, 280, 125, 98, new ArrayList<>()) // gereedschapsmaker
		);
	}
}
