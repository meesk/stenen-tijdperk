package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;
import domainlayer.skeleton.IDobbelsteenWorp;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import presentationlayer.skeleton.IDobbelsteenWorpPane;
import proceslayer.DobbelsteenWorpController;

/**
 * DobbelstenWorpPane.java<br>
 * De view van alle dobbelstenen en wat omheen staat.
 *
 * @author	Erwin Olie, s1103026
 * @version	1.0
 */
public class DobbelsteenWorpView extends Pane implements IDobbelsteenWorpPane {

	/** De views van de dobbelstenen binnen dit gebied. */
	private DobbelsteenView[] dobbelstenen;
	/** De controller waar de acties naar worden gestuurd. */
	private DobbelsteenWorpController controller;

	/**
	 * Het initialiseren van de view van de dobbelsteenworp.
	 * @param dobbelsteenWorp			Het model van de dobbelstenworp.
	 * @param dobbelsteenWorpController	De controller van de dobbelsteenworp.
	 */
	public DobbelsteenWorpView(IDobbelsteenWorp dobbelsteenWorp, DobbelsteenWorpController dobbelsteenWorpController) throws RemoteException {
		// Maak deze klasse toegankelijk voor RMI.
		UnicastRemoteObject.exportObject(this, 0);
		try {
			// Registreer deze instance als observer van het model.
			dobbelsteenWorp.addObserver(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		// Het onthouden van de controller.
		controller = dobbelsteenWorpController;

		// De pane waar de dobbelstenen in geplaatst worden.
		FlowPane flowPane = new FlowPane();

		// Het aanmaken van de views van de dobbelstenen.
		dobbelstenen = new DobbelsteenView[10];
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i] = new DobbelsteenView();
			flowPane.getChildren().add(dobbelstenen[i]);
		}

		// Het aanmaken van de werp-button.
		Button button = new Button("werp!");
		// De button koppelen aan de controller.
		button.setOnAction(e -> controller.onButtonPressed());

		// Het samenvoegen van de views.
		flowPane.getChildren().add(button);
		this.getChildren().add(flowPane);
	}

	/** {@inheritDoc} */
	public void modelChanged(IDobbelsteenWorp model) throws RemoteException {
		IDobbelsteen[] models = model.getDobbelstenen();
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i].modelChanged(models[i]);
		}
	}

}
