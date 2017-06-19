package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor die de kaarten die Voedselspoor punten dragen en kaarten die puntenSpoor puntendragen aanmaakt.
*/

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;
import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;
import domainlayer.Speelbord;
import domainlayer.Stamlid;
import domainlayer.Tableau;


public class BeschavingskaartSpoor extends Beschavingskaart{

	private int waarde;

	BeschavingskaartSpoor(String asset, int waarde, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
	 super(asset, achtergrond, status, kosten);
	 this.waarde = waarde;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		//actie uitvoeren
		if(waarde == 1){
			Speelbord speelbord = super.speelbord;
			Voedselspoor voedselspoor = speelbord.getVoedselspoor();
			int productie = voedselspoor.getProductie(speler);
			if(productie < 10){
				voedselspoor.verhoogProductie(speler);
			}
		} else {
			Speelbord speelbord = super.speelbord;
			Puntenspoor puntenspoor = speelbord.getPuntenspoor();
			puntenspoor.verhoogProductie(speler, waarde);
		}
		// verwijderen stamleden
		Tableau tableau = speler.getTableau();
		List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
			try {
				return s.getSpeler() == speler;
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

		// Beschavingskaart naar tableau
		//moet denk niet hier

	}

	@Override
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;
	}

	public String getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public int getWaarde() {
		return waarde;
	}


}
