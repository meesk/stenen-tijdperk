package presentationlayer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import proceslayer.SpelController;

/**
 * EindView.java<br>
 * Een klasse die alle informatie bevat om de eind view te maken.
 *
 * @author Tristan Caspers, s1102755
 * @version 1.6
 */
public class EindView extends Stage {

	public EindView(SpelController spelController, ISpel model) throws RemoteException {

		spelController.registerView(this);
		VBox vbox = new VBox(15);

		// De prijsuitreiking
		Label uitreiking = new Label();
		uitreiking.setText("Speler ... heeft gewonnen!"); // Nog maken
		uitreiking.setStyle("-fx-font-size: 22px");

		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Ronde");
		xAxis.setMinorTickVisible(false);
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Punten");
		yAxis.setMinorTickVisible(false);

		Map<String, Integer> spelerPunten = new HashMap();

		for (int i = 0; i < model.getSpelerLijst().size(); i++) {
			// per speler het totaal aantal punten eerste telling, weg gestopt onder naam.
			spelerPunten.put(model.getSpelerLijst().get(i).getNaam(), model.getSpelerLijst().get(i).ophalenGegevens());
		}

		List<XYChart.Series> seriesList = new ArrayList<Series>();

		for(int i=0; i < model.getSpelerLijst().size(); i++){
			XYChart.Series<Number, Number> series = new XYChart.Series();
			series.setName(model.getSpelerLijst().get(i).getNaam());
			seriesList.add(series);
		}

		for(int l = 0; l < testData.size(); l++) {
			seriesList.get(0).getData().add(new XYChart.Data<Number, Number>(l, testData.get(l)));
		}

		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		// Aanmaken van datapunten
		// for (int i = 0; i < aantalRondes.size(); i++) {} // Nog maken
		//		data1.getData().add(new XYChart.Data<Number, Number>(1, 34));
		//		data1.getData().add(new XYChart.Data<Number, Number>(2, 78));
		//		data2.getData().add(new XYChart.Data<Number, Number>(34, 0));
		//		data2.getData().add(new XYChart.Data<Number, Number>(2, 20));
		//		data3.getData().add(new XYChart.Data<Number, Number>(2, 50));
		//		data3.getData().add(new XYChart.Data<Number, Number>(3, 65));
		//		data4.getData().add(new XYChart.Data<Number, Number>(31, 78));
		//		data4.getData().add(new XYChart.Data<Number, Number>(45, 98));

		// Safety type?
		lineChart.getData().addAll(seriesList.get(0));

		vbox.getChildren().addAll(uitreiking, lineChart);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #6A5b34");
		Scene scene = new Scene(vbox, 400, 400);
		this.setTitle("Einde");
		this.setScene(scene);
	}
}
