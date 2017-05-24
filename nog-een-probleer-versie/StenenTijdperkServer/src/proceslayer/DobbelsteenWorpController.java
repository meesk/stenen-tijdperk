package proceslayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import domainlayer.DobbelsteenWorp;
import domainlayer.skeleton.IDobbelsteenWorp;
import presentationlayer.skeleton.IDobbelsteenWorpPane;
import proceslayer.skeleton.IDobbelsteenWorpController;

public class DobbelsteenWorpController extends UnicastRemoteObject implements IDobbelsteenWorpController {

	private static final long serialVersionUID = 1L;

	private IDobbelsteenWorp model;
	private List<IDobbelsteenWorpPane> views;

	public DobbelsteenWorpController() throws RemoteException {
		model = new DobbelsteenWorp();
		views = new ArrayList<>();
	}

	public void register(IDobbelsteenWorpPane view) {
		views.add(view);
	}

	public void updateModel() throws RemoteException {
		for (IDobbelsteenWorpPane view : views) {
			view.updateModel(model);
		}
	}

	public void onDobbelsteenWerp() throws RemoteException {
		model.werp((int) (Math.random() * 10) + 1);
		updateModel();
	}

}
