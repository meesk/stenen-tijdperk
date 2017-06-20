package proceslayer;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import domainlayer.Tableau;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ITableau;
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
	private ITableau model;
	private Map<Middel, Integer> middelen;

	private Middel voedsel = Middel.VOEDSEL;
	private Middel hout = Middel.HOUT;
	private Middel leem = Middel.LEEM;
	private Middel steen = Middel.STEEN;
	private Middel goud = Middel.GOUD;

	public BetaalController(ITableau tableau) throws RemoteException{
		this.model = tableau;
	}


	public void registerView(BetaalView view){
		this.view = view;
	}
	
	public void showView(){
		view.show();
	}


	public void onButtonPressed() {
		
		int aantalVoedsel = view.getVoedsel();
		int aantalHout = view.getHout();
		int aantalLeem = view.getLeem();
		int aantalSteen = view.getSteen();
		int aantalGoud = view.getGoud();

		middelen = new HashMap<Middel, Integer>();
		middelen.put(voedsel, aantalVoedsel);
		middelen.put(hout, aantalHout);
		middelen.put(leem, aantalLeem);
		middelen.put(steen, aantalSteen);
		middelen.put(goud, aantalGoud);

		// Uitvoeren van de actie voeden stamleden
		try {
			// Als het succesvol is gegaan close de view
			boolean b = model.voedenStamleden(middelen);
			if(b){
				view.close();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onVerliesPuntenPressed(){
		try {
			model.verliesPunten();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onBetaalAction() {

	}

}
