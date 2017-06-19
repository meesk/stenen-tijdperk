package proceslayer;

import java.rmi.RemoteException;
import java.util.Map;

import domainlayer.Tableau;
import domainlayer.enums.Middel;
import presentationlayer.BetaalView;

/**
 * BetaalController.java<br>
 * De controller voor het betalen.
 *
 * @author Mees Kluivers, s1102358
 * @version 1.0
 */

public class BetaalController {

	private BetaalView view;
	private Tableau model;
	private Map<Middel, Integer> middelen;

	private Middel voedsel = Middel.VOEDSEL;
	private Middel hout = Middel.HOUT;
	private Middel leem = Middel.LEEM;
	private Middel steen = Middel.STEEN;
	private Middel goud = Middel.GOUD;

	public BetaalController(Tableau model){
		this.model = model;
	}

	public void registerView(BetaalView view){
		this.view = view;
	}

	public void onButtonPressed() throws RemoteException{
		int aantalVoedsel = view.getVoedsel();
		int aantalHout = view.getHout();
		int aantalLeem = view.getLeem();
		int aantalSteen = view.getSteen();
		int aantalGoud = view.getGoud();

		middelen.put(voedsel, aantalVoedsel);
		middelen.put(hout, aantalHout);
		middelen.put(leem, aantalLeem);
		middelen.put(steen, aantalSteen);
		middelen.put(goud, aantalGoud);

		// Uitvoeren van de actie voeden stamleden
		model.voedenStamleden(middelen);

	}

	public void onVerliesPuntenPressed(){
		model.verliesPunten();
	}

	public void onBetaalAction() {

	}

}
