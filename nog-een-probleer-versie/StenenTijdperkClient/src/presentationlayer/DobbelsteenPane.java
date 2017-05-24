package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import presentationlayer.skeleton.IDobbelsteenPane;

public class DobbelsteenPane extends Pane implements IDobbelsteenPane {

	private ImageView imageView;
	private final String RESOURCE = "file:assets/dobbelstenen/%d.png";

	public DobbelsteenPane() throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);

		Image image = new Image(String.format(RESOURCE, 0));
		imageView = new ImageView(image);

		this.getChildren().add(imageView);
	}

	public void updateModel(IDobbelsteen model) {
		Platform.runLater(() -> {
			try {
				Image image = new Image(String.format(RESOURCE, model.getOgen()));
				imageView.setImage(image);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}

}
