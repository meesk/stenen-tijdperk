package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.huttegels.HuttegelKiezen;
import domainlayer.huttegels.HuttegelStandaard;
import domainlayer.huttegels.HuttegelVrij;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.huttegels.IHuttegel;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import presentationlayer.skeleton.ITableauObserver;
import proceslayer.BetaalController;

/**
 * TableauView.java<br>
 * Een klasse die alle informatie bevat om de tableau view te maken.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public class TableauView extends StackPane implements ITableauObserver {

	private double scale = 1.00;
	private ImageView[] gereedschap;
	private ImageView[] huttegels;
	private Label naam;

	public TableauView(ITableau model) {
		this(false, model);
	}

	public TableauView(boolean large, ITableau model) {

		try {
			UnicastRemoteObject.exportObject(this, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		if (!large) {
			scale = 0.3;
		}

		if (true) {
			Image image = new Image("file:assets/tableau.png");
			if (model == null) {
				image = new Image("file:assets/tableau_null.png");
			}
			ImageView imageView = new ImageView(image);

			imageView.setFitHeight(image.getHeight() / 4 * scale);
			imageView.setFitWidth(image.getWidth() / 4 * scale);

			this.getChildren().add(imageView);
		}

		if (model == null) {
			return;
		}

		{
			Pane pane = new Pane();

			gereedschap = new ImageView[3];
			for (int i = 0; i < 3; i++) {
				Image image = new Image("file:assets/gereedschap/0.png");
				ImageView imageView = new ImageView(image);

				imageView.setFitHeight(image.getHeight() * 2 / 4 * scale);
				imageView.setFitWidth(image.getWidth() * 2 / 4 * scale);
				imageView.relocate(70 / 4 * scale, 35 / 4 * scale + (i * 265 / 4 * scale));

				gereedschap[i] = imageView;

				pane.getChildren().add(imageView);
			}

			this.getChildren().add(pane);
		}

		{
			Pane pane = new Pane();

			huttegels = new ImageView[5];
			for (int i = 0; i < 5; i++) {
				Image image = new Image("file:assets/huttegels/null.png");
				ImageView imageView = new ImageView(image);

				imageView.setFitHeight(image.getHeight() / 6 / 100 * 102 * scale);
				imageView.setFitWidth(image.getWidth() / 6 / 100 * 102 * scale);
				imageView.relocate(8 * scale + (i * 95 * scale), 200 * scale);

				huttegels[i] = imageView;

				pane.getChildren().add(imageView);
			}

			this.getChildren().add(pane);
		}

		naam = new Label();
		naam.setFont(Font.font(18));
		this.getChildren().add(naam);

		if (model != null) {
			try {
				model.registerObserver(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	public void modelChanged(ITableau tableau) throws RemoteException {
		Platform.runLater(() -> {
			try {
				
				int[] gereedschap = tableau.getGereedschap();
				boolean[] gereedschapGebruikt = tableau.getGereedschapGebruikt();
				for (int i = 0; i < gereedschap.length; i++) {
					this.gereedschap[i].setImage(new Image("file:assets/gereedschap/" + gereedschap[i] + ".png"));
					this.gereedschap[i].setRotate(gereedschapGebruikt[i] ? 90 : 0);
				}
				
				

				List<IHuttegel> huttegels = tableau.getHuttegels();
				for (int i = 0; i < huttegels.size(); i++) {
					try {
						this.huttegels[i % 5].setImage(new Image("file:assets/huttegels/" + huttegels.get(i).getAsset()));
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
				
				
				
				
				System.out.println(tableau.getSpeler().getKleur());
				naam.setStyle("-fx-font-color:" + tableau.getSpeler().getKleur() + ";");
				naam.setText(tableau.getSpeler().getNaam());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
