package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Map.Entry;

import domainlayer.skeleton.spoor.ISpoor;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import presentationlayer.skeleton.ISpoorObserver;

public class SpoorView extends StackPane implements ISpoorObserver {

	public SpoorView(ISpoor spoor) throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
		try {
			spoor.registerObserver(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.setPickOnBounds(false);
	}

	@Override
	public void modelChanged(ISpoor spoor) throws RemoteException {
		Platform.runLater(() -> {
			try {
				this.getChildren().clear();
				Map<String, Integer> markeerstenen = spoor.getMarkeerstenen();
				int i = 0;
				for (Entry<String, Integer> set : markeerstenen.entrySet()) {
					Image image = new Image("file:assets/markeerstenen/" + set.getKey() + ".png");
					ImageView imageView = new ImageView(image);

					imageView.setFitHeight(image.getHeight() / 3);
					imageView.setFitWidth(image.getWidth() / 3);

					int place = set.getValue() % spoor.getPunten().length;
					while (place < 0) {
						place += spoor.getPunten().length;
					}
					
					imageView.setTranslateX(spoor.getPunten()[place].getX() + 10 * i);
					imageView.setTranslateY(spoor.getPunten()[place].getY());

					this.getChildren().add(imageView);
					i++;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
