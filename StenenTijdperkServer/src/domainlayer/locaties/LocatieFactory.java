package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.skeleton.locaties.ILocatie;

/**
 * @author Erwin Olie, s1103026
 * @version 0.1
 */
public class LocatieFactory {

	private static LocatieFactory instance;
	private List<ILocatie> locaties;

	public LocatieFactory() throws RemoteException {
		locaties = new ArrayList<>();
		locaties.add(new MiddelLocatie(280, 117, 100, 117, Arrays.asList(
			new Point(13, 2),
			new Point(40, 8),
			new Point(21, 23),
			new Point(50, 27),
			new Point(13, 42),
			new Point(40, 44),
			new Point(52, 61)
		), Middel.HOUT));
		locaties.add(new MiddelLocatie(412, 113, 143, 83, Arrays.asList(
			new Point(74, 4),
			new Point(46, 9),
			new Point(102, 10),
			new Point(13, 14),
			new Point(73, 25),
			new Point(40, 27),
			new Point(107, 28)
		), Middel.LEEM));
		locaties.add(new MiddelLocatie(714, 109, 121, 121, Arrays.asList(
			new Point(24, 5),
			new Point(54, 6),
			new Point(45, 21),
			new Point(74, 23),
			new Point(51, 40),
			new Point(78, 45),
			new Point(68, 67)
		), Middel.STEEN));
		locaties.add(new MiddelLocatie(614, 236, 127, 94, Arrays.asList(
			new Point(59, 1),
			new Point(30, 3),
			new Point(88, 5),
			new Point(53, 17),
			new Point(23, 21),
			new Point(80, 24),
			new Point(56, 38)
		), Middel.GOUD));
		locaties.add(new Akker(247, 327, 75, 61, Arrays.asList(
			new Point(28, 2)
		)));
		locaties.add(new Hut(318, 399, 97, 62, Arrays.asList(
			new Point(47, 8),
			new Point(20, 13)
		)));
		locaties.add(new Gereedschapmaker(418, 280, 125, 98, Arrays.asList(
			new Point(54, 23)
		)));
		//locaties.add();
	}

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

	public List<ILocatie> getLocaties() {
		return locaties;
	}
}
