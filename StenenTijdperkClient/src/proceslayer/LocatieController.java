package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.LocatieView;
import stenentijdperk.StenenTijdperk;

/**
 * LocatieController.java
 * De controller voor de locatie.
 *
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */
public class LocatieController {

	private ILocatie model;
	private LocatieView view;

	/** Het setten van het model. */
	public LocatieController(ILocatie model) {
		this.model = model;
	}

	public void registerView(LocatieView view) {
		this.view = view;
	}

	public void onKiesLocatie() {

		try {
			if (StenenTijdperk.getSpeler().equals(StenenTijdperk.getSpel().getBeurtSpeler())){
				System.out.println("hoi! ik heb op een locatie geklikt =)");
				try {
					model.plaatsStamlid(StenenTijdperk.getSpeler());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Je hebt geen beurt. wacht please!!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
