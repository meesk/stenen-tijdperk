package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteenWorp;

/**
 * De controller om de acties uitgevoerd in de view op te vangen.
 *
 * @author	Erwin Olie, s1103026
 * @version	3.0
 */
public class DobbelsteenWorpController {

	private IDobbelsteenWorp model;

	/** 
	 * Het setten van het model. 
	 * @param model  het model IDobbelsteenWorp
	 */
	public DobbelsteenWorpController(IDobbelsteenWorp model) {
		this.model = model;
	}

	/** Het opvangen van de werp-actie en het aanroepen van het model voor de uitvoer hiervan. */
	public void onButtonPressed() {
		try {
			// Roep het model aan.
			model.werp((int) (Math.random() * 10) + 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
