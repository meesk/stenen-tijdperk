package presentationlayer;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;

import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.locaties.ILocatie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * SpeelbordPane.java<br>
 * De view van het speelbord.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public class SpeelbordView extends Pane {

	public SpeelbordView(ISpeelbord model) {
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);

		this.getChildren().add(imageView);

		try {
			for (ILocatie locatie : model.getLocaties()) {
				this.getChildren().add(new LocatieView(locatie));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//new LocatieView(459, 436, 94, 133, new ArrayList<>()), // beschavingskaart 4
		//new LocatieView(553, 436, 94, 133, new ArrayList<>()), // beschavingskaart 3
		//new LocatieView(647, 436, 94, 133, new ArrayList<>()), // beschavingskaart 2
		//new LocatieView(741, 436, 94, 133, new ArrayList<>()), // beschavingskaart 1
		//new LocatieView(128, 260, 110, 68, new ArrayList<>()), // jacht
		//new LocatieView(91, 476, 82, 90, new ArrayList<>()), // huttegel 1
		//new LocatieView(175, 476, 82, 90, new ArrayList<>()), // huttegel 2
		//new LocatieView(259, 476, 82, 90, new ArrayList<>()), // huttegel 3
		//new LocatieView(343, 476, 82, 90, new ArrayList<>()), // huttegel 4
	}
}
