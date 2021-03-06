package presentationlayer;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import presentationlayer.skeleton.ILocatieObserver;
import proceslayer.skeleton.ILocatieController;
import stenentijdperk.StenenTijdperk;

/**
 * Een klasse die alle informatie bevat om de locatie view te maken.
 *
 * @author Erwin Olie, s1103026
 * @author Mees Kluivers, s1102358
 * @version 3.0
 */

public class LocatieView extends StackPane implements ILocatieObserver {

	private StackPane pane;

	/**
	 * Het initaliseren van de LocatieView
	 * @param model  Het model van de view (ILocatie)
	 * @param controller  De controller van de view (LocatieController)
	 */
	public LocatieView(ILocatie model, ILocatieController controller) throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);

		// Het aanmaken van de overlay als locatie-markering.
		Rectangle rectangle = new Rectangle(model.getWidth(), model.getHeight());
		rectangle.setFill(Color.DARKGOLDENROD);
		rectangle.setOpacity(0.0);
		rectangle.setOnMouseMoved(e -> rectangle.setOpacity(0.70));
		rectangle.setOnMouseExited(e -> rectangle.setOpacity(0.0));
		rectangle.setOnMouseClicked(e -> {
			try {
				controller.onKiesLocatie();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// Het toevoegen van de onderdelen aan de hoofdpane.
		pane = new StackPane();
		this.getChildren().add(pane);
		this.getChildren().add(rectangle);
		this.setLayoutX(model.getX());
		this.setLayoutY(model.getY());

		model.registerObserver(this);

	}

	@Override
	/** {@inheritDoc} */
	public void modelChanged(ILocatie model) throws RemoteException {

		Platform.runLater(() -> {

			try {
				List<Point> cirkels = model.getCirkels();
				List<IStamlid> stamleden = model.getStamleden();

				pane.getChildren().clear();

				// Het tekenen van de juiste huttegel afbeelding op de locatie (indien relevant)
				int[] loc = new int[] { 91, 175, 259, 343 };
				for (int i = 0; i < loc.length; i++) {
					if (model.getX() == loc[i] && model.getY() == 476 && model.getWidth() == 82 && model.getHeight() == 90) {
						IHuttegel huttegel = StenenTijdperk.getSpel().getSpeelbord().getHuttegels()[i].get(0);
						Image x = new Image("file:assets/huttegels/" + huttegel.getAsset());
						ImageView imageView = new ImageView(x);
						imageView.setFitWidth(x.getWidth() / 8);
						imageView.setFitHeight(x.getHeight() / 8);
						imageView.setTranslateX(0);
						imageView.setTranslateY(0);
						StackPane.setAlignment(imageView, Pos.TOP_LEFT);
						pane.getChildren().add(imageView);
					}
				}

				// Het tekenen van de juiste beschavingskaart afbeelding op de locatie (indien relevant)
				int[] bLoc = new int[] { 463, 560, 653, 749 };
				for (int i = 0; i < bLoc.length; i++) {
					if (model.getX() == bLoc[i] && model.getY() == 438 && model.getWidth() == 85 && model.getHeight() == 145) {
						IBeschavingskaart beschavingskaart = StenenTijdperk.getSpel().getSpeelbord().getBeschavingskaarten()[i];
						if (beschavingskaart == null) {
							continue;
						}
						Image x = new Image("file:assets/beschavingskaarten/" + beschavingskaart.getAsset());
						ImageView imageView = new ImageView(x);
						imageView.setFitWidth(x.getWidth() / 6);
						imageView.setFitHeight(x.getHeight() / 6);
						imageView.setTranslateX(0);
						imageView.setTranslateY(0);
						StackPane.setAlignment(imageView, Pos.TOP_LEFT);
						pane.getChildren().add(imageView);
					}
				}

				// Het tekenen van de stamleden die op de locatie geplaatst zijn.
				for (int i = 0; i < stamleden.size(); i++) {
					Point point = cirkels.get(i);
					Image poppetje = new Image("file:assets/stamlid_" + stamleden.get(i).getSpeler().getKleur() + ".png");
					ImageView imageView = new ImageView(poppetje);
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
