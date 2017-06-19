package presentationlayer;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
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

	public EindView(Stage primaryStage, SpelController controller) {

		controller.registerView(this);

		Pane pane = new Pane();

		// Datapunten zijn een aantal spelerspunten per ronde
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
		XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
		data.getData().add(new XYChart.Data<String, Number>("Ronde 1", 1000));
		data.getData().add(new XYChart.Data<String, Number>("Ronde 2", 2000));
		data.getData().add(new XYChart.Data<String, Number>("Ronde 3", 3000));

		lineChart.getData().add(data);
		lineChart.setTitle("Speler Statistieken");

		pane.getChildren().add(lineChart);
		Scene scene = new Scene(pane, 400, 400);
		this.setTitle("Einde van het spel");
		this.setScene(scene);
	}
}
