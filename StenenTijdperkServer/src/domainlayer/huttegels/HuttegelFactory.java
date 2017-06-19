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

	private static HuttegelFactory instance;
	private List<IHuttegel> huttegels;

	public HuttegelFactory() {
		huttegels = new ArrayList<IHuttegel>();
		huttegels.add(new HuttegelVrij(1, 7));
		huttegels.add(new HuttegelVrij(1, 7));
		huttegels.add(new HuttegelVrij(1, 7));
		huttegels.add(new HuttegelKiezen(4, 1));
		huttegels.add(new HuttegelKiezen(5, 3));
		huttegels.add(new HuttegelKiezen(4, 3));
		huttegels.add(new HuttegelKiezen(4, 2));
		huttegels.add(new HuttegelKiezen(5, 2));
		huttegels.add(new HuttegelKiezen(5, 1));
		huttegels.add(new HuttegelKiezen(4, 4));
		huttegels.add(new HuttegelStandaard(Middel.LEEM, Middel.LEEM, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.HOUT, Middel.STEEN));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.LEEM, Middel.STEEN, Middel.STEEN));
		huttegels.add(new HuttegelStandaard(Middel.STEEN, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.LEEM, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.HOUT, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.LEEM, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.LEEM, Middel.LEEM, Middel.STEEN));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.STEEN));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.STEEN));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.STEEN, Middel.STEEN));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.LEEM));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.LEEM, Middel.GOUD));
		huttegels.add(new HuttegelStandaard(Middel.HOUT, Middel.HOUT, Middel.LEEM));
	}

	public static HuttegelFactory getInstance() {
		if (instance == null) {
			instance = new HuttegelFactory();
		}
		return instance;
	}

}
