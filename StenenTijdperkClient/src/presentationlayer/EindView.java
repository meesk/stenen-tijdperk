package presentationlayer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import proceslayer.SpelController;

/**
 * EindView.java<br>
 * Een klasse die alle informatie bevat om de eind view te maken.
 *
 * @author Tristan Caspers, s1102755
 * @version 1.0
 */

public class EindView extends Stage {

	@SuppressWarnings("unchecked")
	public EindView(SpelController spelController) {

		spelController.registerView(this);

		VBox vbox = new VBox(15);

		// Announcement
		Label uitreiking = new Label();
		uitreiking.setText("Speler 1 heeft gewonnen!");
		uitreiking.setStyle("-fx-font-size: 20px");

		// Datapunten zijn een aantal spelerspunten per ronde
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Ronde");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Punten");

		XYChart.Series<Number, Number> data1 = new XYChart.Series<Number, Number>();
		data1.setName("Speler 1");
		XYChart.Series<Number, Number> data2 = new XYChart.Series<Number, Number>();
		data2.setName("Speler 2");
		XYChart.Series<Number, Number> data3 = new XYChart.Series<Number, Number>();
		data3.setName("Speler 3");
		XYChart.Series<Number, Number> data4 = new XYChart.Series<Number, Number>();
		data4.setName("Speler 4");

		LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

		// Aanmaken van datapunten
		// for (int i = 0; i < aantalRondes.size(); i++) {}
		data1.getData().add(new XYChart.Data<Number, Number>(1, 34));
		data1.getData().add(new XYChart.Data<Number, Number>(2, 78));
		data1.getData().add(new XYChart.Data<Number, Number>(3, 99));
		data2.getData().add(new XYChart.Data<Number, Number>(1, 0));
		data2.getData().add(new XYChart.Data<Number, Number>(2, 20));
		data2.getData().add(new XYChart.Data<Number, Number>(3, 45));
		data3.getData().add(new XYChart.Data<Number, Number>(1, 43));
		data3.getData().add(new XYChart.Data<Number, Number>(2, 50));
		data3.getData().add(new XYChart.Data<Number, Number>(3, 65));
		data4.getData().add(new XYChart.Data<Number, Number>(1, 8));
		data4.getData().add(new XYChart.Data<Number, Number>(2, 78));
		data4.getData().add(new XYChart.Data<Number, Number>(3, 98));

		lineChart.getData().addAll(data1, data2, data3, data4);

		vbox.getChildren().addAll(uitreiking, lineChart);
		vbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vbox, 400, 400);
		this.setTitle("Einde van het spel");
		this.setScene(scene);
	}
}
