package domainlayer.huttegels;

import java.util.ArrayList;
import java.util.List;

import domainlayer.Middelen;

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
			add(new HuttegelStandaard(Middelen.LEEM, Middelen.LEEM, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.HOUT, Middelen.STEEN));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.STEEN, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.LEEM, Middelen.STEEN, Middelen.STEEN));
			add(new HuttegelStandaard(Middelen.STEEN, Middelen.STEEN, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.LEEM, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.LEEM, Middelen.STEEN, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.HOUT, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.LEEM, Middelen.STEEN, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.LEEM, Middelen.LEEM, Middelen.STEEN));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.STEEN, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.LEEM, Middelen.STEEN));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.LEEM, Middelen.STEEN));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.STEEN, Middelen.STEEN));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.LEEM, Middelen.LEEM));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.LEEM, Middelen.GOUD));
			add(new HuttegelStandaard(Middelen.HOUT, Middelen.HOUT, Middelen.LEEM));
		}};
	}

	public HuttegelFactory getInstance() {
		if (instance == null) {
			instance = new HuttegelFactory();
		}
		return instance;
	}

}
