package presentationlayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import proceslayer.LocatieController;

/**
 * De view van het speelbord.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class SpeelbordView extends Pane {

	/**
	 * Het initaliseren van het SpeelbordView
	 * @param model  Het model van de view (ISpeelbord)
	 */
	public SpeelbordView(ISpeelbord model) {
		// Het tekenen van de afbeelding van het speelbord
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);
		this.getChildren().add(imageView);

		try {
			// Het tekenen van de locaties op het speelbord.
			for (ILocatie locatie : model.getLocaties()) {
				this.getChildren().add(new LocatieView(locatie, new LocatieController(locatie)));
			}
			// Het tekenen van de sporen op het speelbord.
			for (ISpoor spoor : model.getSporen()) {
				this.getChildren().add(new SpoorView(spoor));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
