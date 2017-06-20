package presentationlayer;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.locaties.ILocatie;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import presentationlayer.skeleton.ILocatieObserver;
import proceslayer.LocatieController;

/**
 * LocatieView.java Een klasse die alle informatie bevat om de locatie view te
 * maken.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */

public class LocatieView extends StackPane implements ILocatieObserver {

	private Pane pane;

	public LocatieView(ILocatie model, LocatieController controller) throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);

		Rectangle rectangle = new Rectangle(model.getWidth(), model.getHeight());
		rectangle.setFill(Color.DARKGOLDENROD);
		rectangle.setOpacity(0.0);
		rectangle.setOnMouseMoved(e -> rectangle.setOpacity(0.85));
		rectangle.setOnMouseExited(e -> rectangle.setOpacity(0.0));
		rectangle.setOnMouseClicked(e -> controller.onKiesLocatie());

		pane = new Pane();
		/*
		 * for (Point point : model.getCirkels()) { Image poppetje = new
		 * Image("file:assets/gele_poppetje.png"); ImageView imageView = new
		 * ImageView(poppetje); imageView.relocate(point.getX(), point.getY());
		 * pane.getChildren().add(imageView); }
		 */
		this.getChildren().add(pane);
		this.getChildren().add(rectangle);
		this.setLayoutX(model.getX());
		this.setLayoutY(model.getY());

		model.registerObserver(this);

	}

	public void modelChanged(ILocatie model) throws RemoteException {

		Platform.runLater(() -> {

			try {
				List<Point> cirkels = model.getCirkels();
				List<IStamlid> stamleden = model.getStamleden();

				for (int i = 0; i < stamleden.size(); i++) {
					Point point = cirkels.get(i);
					Image poppetje = new Image("file:assets/gele_poppetje.png");
					ImageView imageView = new ImageView(poppetje);
					imageView.relocate(point.getX(), point.getY());
					pane.getChildren().add(imageView);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
