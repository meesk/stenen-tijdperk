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

import java.rmi.Naming;

import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentationlayer.EindView;
import presentationlayer.HandleidingView;
import presentationlayer.LobbyView;
import presentationlayer.SpelView;
import proceslayer.DobbelsteenWorpController;
import proceslayer.LobbyController;
import proceslayer.SpelController;

/**
 * StenenTijdperk.java<br>
 * Een simpele Main-klasse waar de client word opgezet.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @version	1.0
*/
public class StenenTijdperk extends Application {

	private static ISpel spel;
	private static ISpeler speler;

	/** De main method die de JavaFX applicatie opstart. */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	/** {@inheritDoc} */
	public void start(Stage primaryStage) throws Exception {
		// Het definieren van het model
		spel = (ISpel) Naming.lookup("rmi://145.101.89.143/Spel");
		//spel = (ISpel) Naming.lookup("rmi://localhost/Spel");

		// ...
		HandleidingView handleidingPane = new HandleidingView();


		// Het definieren van de controllers
		DobbelsteenWorpController dobbelsteenWorpController = new DobbelsteenWorpController(spel.getDobbelsteenWorp());
		SpelController spelController = new SpelController(handleidingPane, spel);
		LobbyController lobbyController = new LobbyController(spel);

		// Het definieren van de views
		LobbyView lobbyView = new LobbyView(lobbyController, spel);
		SpelView spelView = new SpelView(spel.getSpeelbord(), spelController, dobbelsteenWorpController, spel.getDobbelsteenWorp(), spel);
		EindView eindView = new EindView(spelController);

		//lobbyController.registerSpelView(spelView);

		// Het voorbereiden en tonen van de stage.
		lobbyView.show();
	}

	public static ISpel getSpel() {
		return spel;
	}

	public static ISpeler getSpeler() {
		return speler;
	}

	public static void setSpeler(ISpeler s) {
		speler = s;
	}
}