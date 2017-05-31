package view;

import controller.DobbelsteenController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DobbelsteenView extends Pane {
	
	private Image[] images = new Image[6];
	
	private FlowPane flowPane;
	private Button button;
	
	public DobbelsteenView() {
		
		for (int i = 0; i < 6; i++){
			images[i] = new Image(getClass().getClassLoader().getResourceAsStream(String.format("res/dobs/%d.png", i + 1)));
		}
		
		flowPane = new FlowPane();
		flowPane.setMaxWidth(225);
		
		button = new Button("Dobbelsteen Rollen");
		
		VBox vbox = new VBox(flowPane, button);
		
		this.getChildren().add(vbox);
		
		tekenDobbelstenen(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
	}
	
	public void registerController(DobbelsteenController controller) {
		button.setOnAction(e -> controller.onDobbelsteenClick());
	}
	
	public void tekenDobbelstenen(int[] dobbelstenen) {
		flowPane.getChildren().clear();
		
		for (int dobbelsteen : dobbelstenen) {
			Image image = images[dobbelsteen - 1];
			ImageView imageView = new ImageView(image);

			imageView.setFitHeight(image.getHeight() * 0.20);
			imageView.setFitWidth(image.getWidth() * 0.20);
			
			flowPane.getChildren().add(imageView);
		}
	}
	
}
