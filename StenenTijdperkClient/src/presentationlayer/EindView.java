package presentationlayer;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import domainlayer.skeleton.ISpel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import proceslayer.SpelController;

/**
 * Een klasse die alle informatie bevat om de eind view te maken.
 *
 * @author Tristan Caspers, s1102755
 * @author Enzo Campfens, s1102421
 * @version 3.0
 */
public class EindView extends Stage {

	/**
	 * Het initialiseren van de view van het einde.
	 * @param spelController  De controller van het spel.
	 * @param model  Het model van het spel.
	 * @throws RemoteException
	 */
	public EindView(SpelController spelController, ISpel model) throws RemoteException {

		spelController.registerView(this);
		VBox vbox = new VBox(15);

		// De prijsuitreiking
		Label uitreiking = new Label();
		uitreiking.setText("Speler ... heeft gewonnen!"); // Nog maken
		uitreiking.setStyle("-fx-font-size: 22px");
		uitreiking.setTextFill(Color.WHITE);

		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Ronde");
		xAxis.setTickLabelFill(Color.WHITE);
		xAxis.setMinorTickVisible(false);
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Punten");
		yAxis.setTickLabelFill(Color.WHITE);
		yAxis.setMinorTickVisible(false);

		Map<String, List<Integer>> puntenGeschiedenis = model.getPuntenGeschiedenis();

		List<XYChart.Series> seriesList = new ArrayList<Series>();

		int naamLoop = 0;
		for (Entry<String, List<Integer>> entry : puntenGeschiedenis.entrySet()) {
			XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
			series.setName(model.getSpelerLijst().get(naamLoop).getNaam());
			seriesList.add(series);
			naamLoop++;
		}

		int puntenLoop = 0;
		for (Entry<String, List<Integer>> entry : puntenGeschiedenis.entrySet()) {
			for(int l = 0; l < puntenGeschiedenis.get(entry.getKey()).size(); l++) {
				seriesList.get(puntenLoop).getData().add(new XYChart.Data<Number, Number>(l, puntenGeschiedenis.get(entry.getKey()).get(l)));
			}
			puntenLoop++;
		}

		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		// Safety type?
		for(int q = 0; q < seriesList.size(); q++) {
			lineChart.getData().addAll(seriesList.get(q));
		}

		vbox.getChildren().addAll(uitreiking, lineChart);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #6A5b34");
		Scene scene = new Scene(vbox, 400, 400);
		this.setTitle("Het Stenen Tijdperk: Einde");
		this.setScene(scene);
	}
}

