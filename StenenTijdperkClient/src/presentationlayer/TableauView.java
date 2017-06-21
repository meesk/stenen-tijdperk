package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.huttegels.IHuttegel;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
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
	private GridPane middelen;
	private ImageView achtergrond;
	private Label voedsel;
	private Label hout;
	private Label leem;
	private Label steen;
	private Label goud;
	private Stage largeTableau;

	public TableauView(double scale, ITableau model) {
		try {
			UnicastRemoteObject.exportObject(this, 0);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		this.scale = scale;

		initTableau(model);

		if (model == null) {
			return;
		}

		initGereedschap();
		initHuttegels();
		
		middelen = new GridPane();
		
		middelen.setHgap(10);
		
		voedsel = new Label();
		hout = new Label();
		leem = new Label();
		steen = new Label();
		goud = new Label();
		
		middelen.add(voedsel, 1, 5);
		middelen.add(hout, 2, 5);
		middelen.add(leem, 3, 5);
		middelen.add(steen, 4, 5);
		middelen.add(goud, 5, 5);
		middelen.setAlignment(Pos.CENTER);
		middelen.setMinHeight(10);
		

		middelPane = new Pane();
		middelPane.setPrefWidth(this.getWidth());
		middelPane.setPrefHeight(this.getHeight());

		this.getChildren().add(middelPane);
		this.getChildren().add(middelen);

		naam = new Label();
		naam.setFont(Font.font(36 * scale));
		naam.setAlignment(Pos.BASELINE_RIGHT);
		this.getChildren().add(naam);
		
		if (scale == 0.3) {
			initLargeTableau(model);
		}

		if (model != null) {
			try {
				model.registerObserver(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void initGereedschap() {
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
	
	private void initHuttegels() {
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
	
	private void initTableau(ITableau model) {
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
	
	private void initLargeTableau(ITableau model) {
		largeTableau = new Stage();
		Scene scene = new Scene(new TableauView(1.5, model));
		largeTableau.setScene(scene);
		Pane enlargeButton = new Pane();
		enlargeButton.setPrefHeight(this.getPrefHeight());
		enlargeButton.setPrefWidth(this.getPrefWidth());
		enlargeButton.setOnMouseClicked(e -> {
			largeTableau.show();
		});
		this.getChildren().add(enlargeButton);
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
	
	private void tekenMiddelen(ITableau tableau) throws RemoteException{
		voedsel.setText(tableau.getMiddelen().get(Middel.VOEDSEL).toString());
		hout.setText(tableau.getMiddelen().get(Middel.HOUT).toString());
		leem.setText(tableau.getMiddelen().get(Middel.LEEM).toString());
		steen.setText(tableau.getMiddelen().get(Middel.STEEN).toString());
		goud.setText(tableau.getMiddelen().get(Middel.GOUD).toString());
		
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
				tekenMiddelen(tableau);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
