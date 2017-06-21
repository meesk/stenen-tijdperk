package presentationlayer;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import domainlayer.huttegels.HuttegelLocatie;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import presentationlayer.skeleton.ILocatieObserver;
import proceslayer.LocatieController;
import stenentijdperk.StenenTijdperk;

/**
 * LocatieView.java Een klasse die alle informatie bevat om de locatie view te
 * maken.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */

public class LocatieView extends StackPane implements ILocatieObserver {

	private StackPane pane;

	public LocatieView(ILocatie model, LocatieController controller) throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);

		Rectangle rectangle = new Rectangle(model.getWidth(), model.getHeight());
		rectangle.setFill(Color.DARKGOLDENROD);
		rectangle.setOpacity(0.0);
		rectangle.setOnMouseMoved(e -> rectangle.setOpacity(0.85));
		rectangle.setOnMouseExited(e -> rectangle.setOpacity(0.0));
		rectangle.setOnMouseClicked(e -> controller.onKiesLocatie());

		pane = new StackPane();
		this.getChildren().add(pane);
		this.getChildren().add(rectangle);
		this.setLayoutX(model.getX());
		this.setLayoutY(model.getY());

		model.registerObserver(this);

	}

	@Override
	public void modelChanged(ILocatie model) throws RemoteException {

		Platform.runLater(() -> {

			try {
				List<Point> cirkels = model.getCirkels();
				List<IStamlid> stamleden = model.getStamleden();

				pane.getChildren().clear();
				//@@ LELIJK
				int[] loc = new int[] { 91, 175, 259, 343 };
				for (int i = 0; i < loc.length; i++) {
					if (model.getX() == loc[i] && model.getY() == 476 && model.getWidth() == 82 && model.getHeight() == 90) {
						System.out.println("huttegel!" + i);
						IHuttegel huttegel = StenenTijdperk.getSpel().getSpeelbord().getHuttegels()[i].get(0);
						Image x = new Image("file:assets/huttegels/" + huttegel.getAsset());
						ImageView imageView = new ImageView(x);
						imageView.setFitWidth(x.getWidth() / 8);
						imageView.setFitHeight(x.getHeight() / 8);
						//imageView.relocate(loc[i], 472);
						imageView.setTranslateX(0);
						imageView.setTranslateY(0);
						StackPane.setAlignment(imageView, Pos.TOP_LEFT);
						pane.getChildren().add(imageView);
					}
				}
				for (int i = 0; i < stamleden.size(); i++) {
					Point point = cirkels.get(i);
					Image poppetje = new Image("file:assets/stamlid_" + stamleden.get(i).getSpeler().getKleur() + ".png");
					ImageView imageView = new ImageView(poppetje);
					//imageView.relocate(point.getX(), point.getY());
					imageView.setTranslateX(point.getX());
					imageView.setTranslateY(point.getY());
					StackPane.setAlignment(imageView, Pos.TOP_LEFT);
					pane.getChildren().add(imageView);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
