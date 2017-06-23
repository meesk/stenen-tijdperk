package presentationlayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import proceslayer.LocatieController;

/**
 * SpeelbordPane.java<br>
 * De view van het speelbord.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public class SpeelbordView extends Pane {

	/**
	 * Het initaliseren van het SpeelbordView
	 * @param model  Het model van de view (ISpeelbord)
	 */
	public SpeelbordView(ISpeelbord model) {
		Image image = new Image("file:assets/speelbord.jpg");
		ImageView imageView = new ImageView(image);
		
		imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

		     @Override
		     public void handle(MouseEvent event) {
		         System.out.println(event.getSceneX() + " y : " + event.getSceneY());
		         event.consume();
		     }
		});

		this.getChildren().add(imageView);

		try {
			for (ILocatie locatie : model.getLocaties()) {
				this.getChildren().add(new LocatieView(locatie, new LocatieController(locatie)));
			}
			for (ISpoor spoor : model.getSporen()) {
				this.getChildren().add(new SpoorView(spoor));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//new LocatieView(459, 436, 94, 133, new ArrayList<>()), // beschavingskaart 4
		//new LocatieView(553, 436, 94, 133, new ArrayList<>()), // beschavingskaart 3
		//new LocatieView(647, 436, 94, 133, new ArrayList<>()), // beschavingskaart 2
		//new LocatieView(741, 436, 94, 133, new ArrayList<>()), // beschavingskaart 1
	}
}
