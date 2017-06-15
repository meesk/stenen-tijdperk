package stenentijdperk;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import domainlayer.Spel;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * StenenTijdperk.java
 * Een simpele Main-klasse waar de RMI server word opgezet.
 *
 * @author Erwin Olie s1103026,
 * Enzo Campfens s1102421,
 * Mees Kluivers s1102358,
 * Tristan Caspers s1102755
 * @version 0.6
 */
public class StenenTijdperk extends Application {

	//
	//                 _oo0oo_
	//                o8888888o
	//                88" . "88
	//                (| -_- |)
	//                0\  =  /0
	//              ___/`---'\___
	//            .' \\|     |// '.
	//           / \\|||  :  |||// \
	//          / _||||| -:- |||||- \
	//         |   | \\\  -  /// |   |
	//         | \_|  ''\---/''  |_/ |
	//         \  .-\__  '-'  ___/-. /
	//       ___'. .'  /--.--\  `. .'___
	//    ."" '<  `.___\_<|>_/___.' >' "".
	//   | | :  `- \`.;`\ _ /`;.`/ - ` : | |
	//   \  \ `_.   \_ __\ /__ _/   .-` /  /
	//=====`-.____`.___ \_____/___.-`___.-'=====
	//
	//
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//
	//A buddha statue to bless your code to be bug free.
	//

	/** De main method die de controllers registreert in het register. */
//	public static void main(String[] args) throws RemoteException, MalformedURLException {
//		// Het initialiseren van een nieuw spel.
//		Spel spel = new Spel();
//		// Het vragen met hoeveel spelers het spel wordt gespeelt.
//		spel.initAantalSpelSpelers();
//
//		// Het opzetten van het RMI register.
//		LocateRegistry.createRegistry(1099);
//		// Het registreren van het dobbelsteenworp-model in het register.
//		Naming.rebind("DobbelsteenWorp", spel.getDobbelsteenWorp());
//		// Het registreren van het spel.
//		Naming.rebind("Spel", spel);
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Het initialiseren van een nieuw spel.
		Spel spel = new Spel();
		// Het vragen met hoeveel spelers het spel wordt gespeelt.

		// Het opzetten van het RMI register.
		LocateRegistry.createRegistry(1099);
		// Het registreren van het dobbelsteenworp-model in het register.
		Naming.rebind("DobbelsteenWorp", spel.getDobbelsteenWorp());
		// Het registreren van het spel.
		Naming.rebind("Spel", spel);

		spel.initAantalSpelSpelers();
	}
}
