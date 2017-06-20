package domainlayer.huttegels;

import java.util.ArrayList;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author Erwin Olie, s1103026
 * @version 0.1
 */
public class HuttegelFactory {

	private static HuttegelFactory instance;
	private List<IHuttegel> huttegels;

	public HuttegelFactory() {
		huttegels = new ArrayList<IHuttegel>();
		huttegels.add(new HuttegelVrij("vrij/01.png", 1, 7));
		huttegels.add(new HuttegelVrij("vrij/02.png", 1, 7));
		huttegels.add(new HuttegelVrij("vrij/03.png", 1, 7));
		huttegels.add(new HuttegelKiezen("kiezen/01.png", 5, 4));
		huttegels.add(new HuttegelKiezen("kiezen/02.png", 4, 4));
		huttegels.add(new HuttegelKiezen("kiezen/03.png", 4, 3));
		huttegels.add(new HuttegelKiezen("kiezen/04.png", 5, 1));
		huttegels.add(new HuttegelKiezen("kiezen/05.png", 4, 2));
		huttegels.add(new HuttegelKiezen("kiezen/06.png", 5, 3));
		huttegels.add(new HuttegelKiezen("kiezen/07.png", 4, 1));
		huttegels.add(new HuttegelKiezen("kiezen/08.png", 5, 2));

		huttegels.add(new HuttegelStandaard("standaard/01.png", Middel.LEEM, Middel.STEEN, Middel.STEEN));
		huttegels.add(new HuttegelStandaard("standaard/02.png", Middel.HOUT, Middel.LEEM, Middel.STEEN));
		huttegels.add(new HuttegelStandaard("standaard/03.png", Middel.HOUT, Middel.HOUT, Middel.STEEN));
		huttegels.add(new HuttegelStandaard("standaard/04.png", Middel.HOUT, Middel.LEEM, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/05.png", Middel.HOUT, Middel.HOUT, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/06.png", Middel.HOUT, Middel.STEEN, Middel.STEEN));
		huttegels.add(new HuttegelStandaard("standaard/07.png", Middel.HOUT, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/08.png", Middel.LEEM, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/09.png", Middel.LEEM, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/10.png", Middel.HOUT, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/11.png", Middel.LEEM, Middel.LEEM, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/12.png", Middel.HOUT, Middel.LEEM, Middel.STEEN));
		huttegels.add(new HuttegelStandaard("standaard/13.png", Middel.HOUT, Middel.LEEM, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/14.png", Middel.LEEM, Middel.LEEM, Middel.STEEN));
		huttegels.add(new HuttegelStandaard("standaard/15.png", Middel.STEEN, Middel.STEEN, Middel.GOUD));
		huttegels.add(new HuttegelStandaard("standaard/16.png", Middel.HOUT, Middel.LEEM, Middel.LEEM));
		huttegels.add(new HuttegelStandaard("standaard/17.png", Middel.HOUT, Middel.HOUT, Middel.LEEM));
	}

	public static HuttegelFactory getInstance() {
		if (instance == null) {
			instance = new HuttegelFactory();
		}
		return instance;
	}

}
