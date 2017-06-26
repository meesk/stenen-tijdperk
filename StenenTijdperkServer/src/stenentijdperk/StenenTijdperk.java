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
import domainlayer.skeleton.ISpel;

/**
 * Een simpele Main-klasse waar de RMI server word opgezet.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Alex de Bruin, s1103096
 * @author Tristan Caspers, s1102755
 * @version 3.0
 */
public class StenenTijdperk {

	private static ISpel spel;

	/** Hier word de server opgezet. */
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		spel = new Spel();

		// Het opzetten van het RMI register.
		LocateRegistry.createRegistry(1099);
		Naming.rebind("Spel", spel);

		System.out.println("Server started...");
	}

	/** @return Het spel dat nu gaande is. */
	public static ISpel getSpel() {
		return spel;
	}
}
