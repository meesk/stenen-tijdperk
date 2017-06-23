package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;
import domainlayer.skeleton.IDobbelsteenWorp;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import presentationlayer.skeleton.IDobbelsteenWorpObserver;
import proceslayer.DobbelsteenWorpController;

/**
 * De view van alle dobbelstenen en wat omheen staat.
 *
 * @author	Erwin Olie, s1103026
 * @version	3.0
 */
public class DobbelsteenWorpView extends StackPane implements IDobbelsteenWorpObserver {

	private Label totaal;
	private DobbelsteenView[] dobbelstenen;

	/**
	 * Het initialiseren van de view van de dobbelsteenworp.
	 * @param dobbelsteenWorp  Het model van de dobbelstenworp.
	 * @param dobbelsteenWorpController  De controller van de dobbelsteenworp.
	 */
	public DobbelsteenWorpView(IDobbelsteenWorp dobbelsteenWorp, DobbelsteenWorpController dobbelsteenWorpController) throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
		
		try {
			dobbelsteenWorp.addObserver(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		HBox[] context = new HBox[] { new HBox(), new HBox() };
		
		// Het aanmaken van de views van de losse dobbelstenen.
		dobbelstenen = new DobbelsteenView[10];
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i] = new DobbelsteenView();
			context[i / 5].getChildren().add(dobbelstenen[i]);
		}

		// Het aanmaken van de werp-button.
		//Button button = new Button("werp!");
		// De button koppelen aan de controller.
		//button.setOnAction(e -> controller.onButtonPressed());

		// Het samenvoegen van de views.
		//flowPane.getChildren().add(button);
		
		VBox container = new VBox();
		container.getChildren().addAll(context);
		this.getChildren().add(container);
		
		// De overlay met het totaal van de dobbelsteenworp.
		totaal = new Label("= 0");
		totaal.setFont(Font.font(42));
		totaal.setTextFill(Color.DARKTURQUOISE);
		StackPane.setAlignment(totaal, Pos.CENTER_LEFT);
		this.getChildren().add(totaal);
	}

	@Override
	/** {@inheritDoc} */
	public void modelChanged(IDobbelsteenWorp model) throws RemoteException {
		IDobbelsteen[] models = model.getDobbelstenen();
		// Het updaten van alle losse dobbelstenen.
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i].modelChanged(models[i]);
		}
		Platform.runLater(() -> {
			try {
				// Het updaten van het totaal op de overlay.
				totaal.setText("= " + model.getTotaal());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
//
	}
}
