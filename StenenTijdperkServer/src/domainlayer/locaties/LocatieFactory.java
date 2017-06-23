package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.enums.Middel;
import domainlayer.huttegels.HuttegelLocatie;
import domainlayer.skeleton.locaties.ILocatie;

/**
 * Deze factory maakt alle locaties aan voor het spel.
 * 
 * @author Erwin Olie, s1103026
 * @author Mees Kluivers, s1102358
 * @version 3.0
 */
public class LocatieFactory {

	private static LocatieFactory instance;
	private List<ILocatie> locaties;

	public LocatieFactory() throws RemoteException {
		locaties = new ArrayList<>();
		
		// Dit is het Bos
		locaties.add(new MiddelLocatie(280, 117, 100, 117, Arrays.asList(
			new Point(13, 2),
			new Point(40, 8),
			new Point(21, 23),
			new Point(50, 27),
			new Point(13, 42),
			new Point(40, 44),
			new Point(52, 61)
		), Middel.HOUT));
		
		// Dit is de Leemgroeve
		locaties.add(new MiddelLocatie(412, 113, 143, 83, Arrays.asList(
			new Point(74, 4),
			new Point(46, 9),
			new Point(102, 10),
			new Point(13, 14),
			new Point(73, 25),
			new Point(40, 27),
			new Point(107, 28)
		), Middel.LEEM));
		
		// Dit is de Steengroeve
		locaties.add(new MiddelLocatie(714, 109, 121, 121, Arrays.asList(
			new Point(24, 5),
			new Point(54, 6),
			new Point(45, 21),
			new Point(74, 23),
			new Point(51, 40),
			new Point(78, 45),
			new Point(68, 67)
		), Middel.STEEN));
		
		// Dit is de Rivier
		locaties.add(new MiddelLocatie(614, 236, 127, 94, Arrays.asList(
			new Point(59, 1),
			new Point(30, 3),
			new Point(88, 5),
			new Point(53, 17),
			new Point(23, 21),
			new Point(80, 24),
			new Point(56, 38)
		), Middel.GOUD));
		
		// Dit is de Jacht
		locaties.add(new MiddelLocatie(94, 80, 127, 220, generatePoints(40), Middel.VOEDSEL));
		
		// Dit is de Akker
		locaties.add(new Akker(247, 327, 75, 61, Arrays.asList(
			new Point(28, 2)
		)));
		
		// Dit is de Hut
		locaties.add(new Hut(318, 399, 97, 62, Arrays.asList(
			new Point(47, 8),
			new Point(20, 13)
		)));
		
		// Dit is de Gereedschapmaker
		locaties.add(new Gereedschapmaker(418, 280, 125, 98, Arrays.asList(
			new Point(54, 23)
		)));
		
		// Dit zijn de Huttegels
		locaties.add(new HuttegelLocatie(91, 476, 82, 90, Arrays.asList(new Point(26, 18)), 0));
		locaties.add(new HuttegelLocatie(175, 476, 82, 90, Arrays.asList(new Point(26, 18)), 1));
		locaties.add(new HuttegelLocatie(259, 476, 82, 90, Arrays.asList(new Point(26, 18)), 2));
		locaties.add(new HuttegelLocatie(343, 476, 82, 90, Arrays.asList(new Point(26, 18)), 3));
		
		// Dit zijn de Beschavingskaarten
		locaties.add(new Beschavingskaart(463, 438, 85, 145, Arrays.asList(new Point(26, 18)), 0));
		locaties.add(new Beschavingskaart(560, 438, 85, 145, Arrays.asList(new Point(26, 18)), 1));
		locaties.add(new Beschavingskaart(653, 438, 85, 145, Arrays.asList(new Point(26, 18)), 2));
		locaties.add(new Beschavingskaart(749, 438, 85, 145, Arrays.asList(new Point(26, 18)), 3));
	}
	
	
	/**
	 * Het genereren van willekeurige cirkel-punten voor de Jacht.
	 * @param aantal  Het aantal punten dat je wilt genereren.
	 * @return Een lijst met random punten voor de jacht.
	 */
	private ArrayList<Point> generatePoints(int aantal){
		ArrayList<Point> points = new ArrayList<Point>();

		for(int i = 0; i < aantal; i++){
			int x = ThreadLocalRandom.current().nextInt(5, 120 + 1);
			int y = ThreadLocalRandom.current().nextInt(5, 220 + 1);
			points.add(new Point(x,y));
		}
		return points;
	}

	/**
	 * Deze methode zorgt dat op een singleton-wijze de factory verkregen word.
	 * @return De instance van de factory van de locaties.
	 */
	public static LocatieFactory getInstance() {
		if (instance == null) {
			try {
				instance = new LocatieFactory();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	/** @return Alle locaties op het speelbord. */
	public List<ILocatie> getLocaties() {
		return locaties;
	}
}
