package domainlayer.skeleton.spoor;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de interface waar de sporen van overerven
*/

import java.rmi.Remote;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
public interface ISpoor extends Remote{

	public void verwijderPunten(ISpeler speler, int aantal);
	public void verhoogPunten(ISpeler speler, int aantal);
	public Map<ISpeler, Integer> getMarkeerstenen();
}

