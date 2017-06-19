package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ITableau;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import presentationlayer.skeleton.ITableauObserver;

/**
 * TableauView.java<br>
 * Een klasse die alle informatie bevat om de tableau view te maken.
 *
 * @author Erwin Olie, s1103026
<<<<<<< HEAD
 * @version 1.0
=======
 * @version 0.3
 */

/**
 * @author erwin
 *
>>>>>>> 28af035b47953cfee1593c56a0ebf888476e507c
 */
public class TableauView extends StackPane implements ITableauObserver {

	private double scale = 1.00;
	private ImageView[] gereedschap;

	public TableauView(ITableau model) {
		this(false, model);
	}

<<<<<<< HEAD
	public TableauView(boolean large) {

		Image image = new Image("file:assets/tableau.png");
		ImageView imageView = new ImageView(image);

		if (large) {
			imageView.setFitHeight(image.getHeight() * 0.25);
			imageView.setFitWidth(image.getWidth() * 0.25);
		} else {
			imageView.setFitHeight(image.getHeight() * 0.0625);
			imageView.setFitWidth(image.getWidth() * 0.0625);
=======
	public TableauView(boolean large, ITableau model) {

		try {
			UnicastRemoteObject.exportObject(this, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (!large) {
			scale = 0.4;
		}

		if (true) {
			Image image = new Image("file:assets/tableau.png");
			ImageView imageView = new ImageView(image);

			imageView.setFitHeight(image.getHeight() / 4 * scale);
			imageView.setFitWidth(image.getWidth() / 4 * scale);

			this.getChildren().add(imageView);
>>>>>>> 28af035b47953cfee1593c56a0ebf888476e507c
		}

		Pane pane = new Pane();

		gereedschap = new ImageView[3];
		for (int i = 0; i < 3; i++) {
			Image image = new Image("file:assets/gereedschap/0.png");
			ImageView imageView = new ImageView();

			imageView.setFitHeight(image.getHeight() * 2 / 4 * scale);
			imageView.setFitWidth(image.getWidth() * 2 / 4 * scale);
			imageView.relocate(70 / 4 * scale, 35 / 4 * scale + (i * 265 / 4 * scale));

			gereedschap[i] = imageView;

			pane.getChildren().add(imageView);
		}

		this.getChildren().add(pane);

		if (model != null) {
			try {
				model.registerObserver(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	public void modelChanged(ITableau tableau) throws RemoteException {
		int[] gereedschap = tableau.getGereedschap();
		boolean[] gereedschapGebruikt = tableau.getGereedschapGebruikt();
		for (int i = 0; i < gereedschap.length; i++) {
			this.gereedschap[i].setImage(new Image("file:assets/gereedschap/" + gereedschap[i] + ".png"));
			this.gereedschap[i].setRotate(gereedschapGebruikt[i] ? 90 : 0);
		}
	}
}
