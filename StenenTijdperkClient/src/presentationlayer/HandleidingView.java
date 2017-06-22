package presentationlayer;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * HandleidingPane.java<br>
 * Hier wordt de handleiding in allerlei panes gezet en in een Scene & PrimaryStage gezet.
 *
 * @author Enzo Campfens, s1102421
 * @version 1.0
 *
 */

public class HandleidingView extends Stage {

	public HandleidingView() {

		// Scrollpane gemaakt zodat er gescrolled kan worden in de handleiding.
		ScrollPane scroll = new ScrollPane();

		// De image wordt ingeladen en in een ImageView gezet.
		Image image = new Image("file:assets/manual.jpeg");
		ImageView view = new ImageView(image);

		// Schaald de image bij.
		view.setFitWidth(image.getWidth() / 3);
		view.setFitHeight(image.getHeight() / 3);

		// Zet de Pane met de ImageView in een ScrollPane voor het scrollen.
		scroll.setContent(view);

		// Maakt een nieuwe Scene aan met de ScrollPane om de handleiding te tonen.
		Scene scene = new Scene(scroll, 800, 800);

		// Zet de titel van de PrimaryStage en dat de PrimaryStage altijd on top moet zijn.
		// en daarna wordt de Scene in de PrimaryStage gezet.
		this.setTitle("Het Stenen Tijdperk: Handleiding");
		this.setAlwaysOnTop(true);
		this.setScene(scene);
	}
}
