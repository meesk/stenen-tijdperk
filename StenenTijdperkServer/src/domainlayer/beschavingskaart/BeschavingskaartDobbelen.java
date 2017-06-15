package domainlayer.beschavingskaart;




/**
 * @author Alex de Bruin, s1103096
 * @version 0.1
 * <br>
* <br>
 * Dit is de constructor voor de beschavingskaart <br> waar je met een dobbelsteen moet gooien om een aantal middelen te verkrijgen.
 */
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import java.rmi.RemoteException;
import domainlayer.Speelbord;

public class BeschavingskaartDobbelen extends Beschavingskaart {


	private int waarde;
	private Middel[] middel;

	public BeschavingskaartDobbelen(String asset, int waarde, Middel[] middel, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException {
		super(asset, achtergrond, status, kosten);
		this.asset = asset;
		this.waarde = waarde;
		this.middel = middel;
		this.waarde = waarde;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {


	}

	@Override
	public domainlayer.enums.BeschavingskaartStatus getStatus() {
		return status;
	}

	public void setStatus(BeschavingskaartStatus status){
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

	public Middel[] getMiddel() {
		return middel;
	}

}
