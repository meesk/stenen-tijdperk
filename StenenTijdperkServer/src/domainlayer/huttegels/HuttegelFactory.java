package domainlayer.huttegels;

import java.util.ArrayList;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelFactory {

	private HuttegelFactory instance;
	private List<IHuttegel> huttegels;

	public HuttegelFactory() {
		huttegels = new ArrayList<IHuttegel>() {{
			add(new HuttegelVrij(1, 7));
			add(new HuttegelVrij(1, 7));
			add(new HuttegelVrij(1, 7));
			add(new HuttegelKiezen(4, 1));
			add(new HuttegelKiezen(5, 3));
			add(new HuttegelKiezen(4, 3));
			add(new HuttegelKiezen(4, 2));
			add(new HuttegelKiezen(5, 2));
			add(new HuttegelKiezen(5, 1));
			add(new HuttegelKiezen(4, 4));
			add(new HuttegelStandaard(Middel.LEEM, Middel.LEEM, Middel.GOUD));
			add(new HuttegelStandaard(Middel.HOUT, Middel.HOUT, Middel.STEEN));
			add(new HuttegelStandaard(Middel.HOUT, Middel.STEEN, Middel.GOUD));
			add(new HuttegelStandaard(Middel.LEEM, Middel.STEEN, Middel.STEEN));
			add(new HuttegelStandaard(Middel.STEEN, Middel.STEEN, Middel.GOUD));
			add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.GOUD));
			add(new HuttegelStandaard(Middel.LEEM, Middel.STEEN, Middel.GOUD));
			add(new HuttegelStandaard(Middel.HOUT, Middel.HOUT, Middel.GOUD));
			add(new HuttegelStandaard(Middel.LEEM, Middel.STEEN, Middel.GOUD));
			add(new HuttegelStandaard(Middel.LEEM, Middel.LEEM, Middel.STEEN));
			add(new HuttegelStandaard(Middel.HOUT, Middel.STEEN, Middel.GOUD));
			add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.STEEN));
			add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.STEEN));
			add(new HuttegelStandaard(Middel.HOUT, Middel.STEEN, Middel.STEEN));
			add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.LEEM));
			add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.GOUD));
			add(new HuttegelStandaard(Middel.HOUT, Middel.HOUT, Middel.LEEM));
		}};
	}

	public HuttegelFactory getInstance() {
		if (instance == null) {
			instance = new HuttegelFactory();
		}
		return instance;
	}

}
