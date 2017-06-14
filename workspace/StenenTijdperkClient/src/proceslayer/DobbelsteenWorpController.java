package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteenWorp;

/**
 * DobbelsteenWorpController.java
 * De controller om de acties uitgevoerd in de view op te vangen.
 *
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public class DobbelsteenWorpController {

	/** Het model dat word weergegeven in de view. */
	private IDobbelsteenWorp model;

	/** Het setten van het model. */
	public DobbelsteenWorpController(IDobbelsteenWorp model) {
		this.model = model;
	}

	/** Het opvangen van de werp-actie en het aanroepen van het model voor de uitvoer hiervan. */
	public void onDobbelsteenWerp() {
		try {
			// Roep het model aan.
			model.werp((int) (Math.random() * 10) + 1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
