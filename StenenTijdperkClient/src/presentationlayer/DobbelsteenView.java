package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import presentationlayer.skeleton.IDobbelsteenObserver;

/**
 * DobbelstenPane.java
 * De view van enkele dobbelstenen.
 *
 * @author	Erwin Olie, s1103026
 * @version	0.3
 */
public class DobbelsteenView extends Pane implements IDobbelsteenObserver {

	/** De View waarin de dobbelsteen-afbeeldingen worden geladen. */
	private ImageView imageView;
	/** De locatie van de dobbelsteen-afbeeldingen. */
	private final String RESOURCE = "file:assets/dobbelstenen/%d.png";

	/** Het initialiseren van de view van de dobbelsteen. */
	public DobbelsteenView() throws RemoteException {
		// Maak deze klasse toegankelijk voor RMI.
		UnicastRemoteObject.exportObject(this, 0);

		// Het inladen van de image van de dobbelsteen.
		Image image = new Image(String.format(RESOURCE, 0));
		imageView = new ImageView(image);

		// Het toevoegen van de image aan de pane.
		this.getChildren().add(imageView);
	}

	/** {@inheritDoc} */
	public void modelChanged(IDobbelsteen model) {
		// Het voorkomen van Thread-problemen.
		Platform.runLater(() -> {
			try {
				// Het inladen van de image van de dobbelsteen.
				Image image = new Image(String.format(RESOURCE, model.getOgen()));
				imageView.setImage(image);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
