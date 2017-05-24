package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;
import domainlayer.skeleton.IDobbelsteenWorp;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import presentationlayer.skeleton.IDobbelsteenWorpPane;
import proceslayer.skeleton.IDobbelsteenWorpController;

public class DobbelsteenWorpPane extends Pane implements IDobbelsteenWorpPane {

	private DobbelsteenPane[] dobbelstenen;

	public DobbelsteenWorpPane(IDobbelsteenWorpController controller) throws RemoteException {
		UnicastRemoteObject.exportObject(this, 0);
		controller.register(this);
		
		FlowPane flowPane = new FlowPane();
		
		dobbelstenen = new DobbelsteenPane[10];
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i] = new DobbelsteenPane();
			flowPane.getChildren().add(dobbelstenen[i]);
		}
		
		Button button = new Button("werp!");
		button.setOnAction(e -> {
			try {
				controller.onDobbelsteenWerp();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		});
		
		flowPane.getChildren().add(button);
		
		this.getChildren().add(flowPane);
	}

	@Override
	public void updateModel(IDobbelsteenWorp model) throws RemoteException {
		IDobbelsteen[] models = model.getDobbelstenen();
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i].updateModel(models[i]);
		}
	}

}
