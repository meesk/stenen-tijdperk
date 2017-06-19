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
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//			    佛祖保佑 永无BUG
package stenentijdperk;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import domainlayer.Spel;

/**
 * StenenTijdperk.java
 * Een simpele Main-klasse waar de RMI server word opgezet.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @version 1.0
 */
public class StenenTijdperk {
	
	/** De main method die de modellen registreert in het register. */
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Het initialiseren van een nieuw spel.
		Spel spel = new Spel();

		// Het opzetten van het RMI register.
		LocateRegistry.createRegistry(1099);
		// Het registreren van het spel.
		Naming.rebind("Spel", spel);

		System.out.println("Server started...");
	}
}
