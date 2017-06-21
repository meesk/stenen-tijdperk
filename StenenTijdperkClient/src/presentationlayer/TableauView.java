package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.huttegels.IHuttegel;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import presentationlayer.skeleton.ITableauObserver;
import stenentijdperk.StenenTijdperk;

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
	private Pane middelPane;
	private ImageView achtergrond;

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

			if (model != null) {
		        try {
					switch (model.getSpeler().getKleur()) {
					case "Rood" : imageView.setEffect(new InnerShadow(8, Color.RED)); break;
					case "Blauw" : imageView.setEffect(new InnerShadow(8, Color.BLUE)); break;
					case "Geel" : imageView.setEffect(new InnerShadow(8, Color.YELLOW)); break;
					case "Groen" : imageView.setEffect(new InnerShadow(8, Color.GREEN)); break;
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}

			imageView.setFitHeight(image.getHeight() / 4 * scale);
			imageView.setFitWidth(image.getWidth() / 4 * scale);

			this.getChildren().add(imageView);

			achtergrond = imageView;
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

		middelPane = new Pane();
		middelPane.setPrefWidth(this.getWidth());
		middelPane.setPrefHeight(this.getHeight());

		this.getChildren().add(middelPane);

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

	private void tekenTableau(ITableau tableau) throws RemoteException {
		achtergrond.setEffect(null);
		switch (tableau.getSpeler().getKleur()) {
		case "Rood" : achtergrond.setEffect(new InnerShadow(3, Color.RED)); break;
		case "Blauw" : achtergrond.setEffect(new InnerShadow(3, Color.BLUE)); break;
		case "Geel" : achtergrond.setEffect(new InnerShadow(3, Color.YELLOW)); break;
		case "Groen" : achtergrond.setEffect(new InnerShadow(3, Color.GREEN)); break;
		}
		if (StenenTijdperk.getSpel().getBeurtSpeler().equals(tableau.getSpeler())) {
			switch (tableau.getSpeler().getKleur()) {
			case "Rood" : achtergrond.setEffect(new InnerShadow(80, Color.DARKRED)); break;
			case "Blauw" : achtergrond.setEffect(new InnerShadow(80, Color.DARKBLUE)); break;
			case "Geel" : achtergrond.setEffect(new InnerShadow(80, Color.DARKGOLDENROD)); break;
			case "Groen" : achtergrond.setEffect(new InnerShadow(80, Color.DARKGREEN)); break;
			}
		}
	}

	private void tekenStamleden(ITableau tableau) throws RemoteException {
		middelPane.getChildren().clear();
		for (int i = 0; i < tableau.getStamleden().size(); i++) {

			Image image =  new Image("file:assets/stamlid_" + tableau.getSpeler().getKleur() + ".png");
			ImageView imageView = new ImageView(image);

			imageView.setFitHeight(image.getHeight() * scale);
			imageView.setFitWidth(image.getWidth() * scale);
			imageView.relocate(100 * scale + i * 30 * scale, 0);

			middelPane.getChildren().add(imageView);
		};
	}

	private void tekenGereedschap(ITableau tableau) throws RemoteException {
		int[] gereedschap = tableau.getGereedschap();
		boolean[] gereedschapGebruikt = tableau.getGereedschapGebruikt();
		for (int i = 0; i < gereedschap.length; i++) {
			this.gereedschap[i].setImage(new Image("file:assets/gereedschap/" + gereedschap[i] + ".png"));
			this.gereedschap[i].setRotate(gereedschapGebruikt[i] ? 90 : 0);
		}
	}

	private void tekenHuttegels(ITableau tableau) throws RemoteException {
		List<IHuttegel> huttegels = tableau.getHuttegels();
		for (int i = 0; i < huttegels.size(); i++) {
			try {
				this.huttegels[i % 5].setImage(new Image("file:assets/huttegels/" + huttegels.get(i).getAsset()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	private void tekenNaam(ITableau tableau) throws RemoteException {
		naam.setStyle("-fx-font-color:" + tableau.getSpeler().getKleur() + ";");
		naam.setText(tableau.getSpeler().getNaam());
	}

	@Override
	public void modelChanged(ITableau tableau) throws RemoteException {
		Platform.runLater(() -> {
			try {
				tekenTableau(tableau);
				tekenStamleden(tableau);
				tekenGereedschap(tableau);
				tekenHuttegels(tableau);
				tekenNaam(tableau);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
