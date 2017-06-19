package stenentijdperk;

import java.rmi.Naming;

import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
<<<<<<< HEAD
 * @version	1.0
=======
 * @version	0.7
>>>>>>> 28af035b47953cfee1593c56a0ebf888476e507c
 */
public class StenenTijdperk extends Application {

	/** De main method die de JavaFX applicatie opstart. */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	/** {@inheritDoc} */
	public void start(Stage primaryStage) throws Exception {

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

		// Het definieren van de modellen
		IDobbelsteenWorp dobbelsteenWorp = (IDobbelsteenWorp) Naming.lookup("rmi://localhost/DobbelsteenWorp");
		ISpel spel = (ISpel) Naming.lookup("rmi://localhost/Spel");

		// ...
		HandleidingView handleidingPane = new HandleidingView();


		// Het definieren van de controllers
		DobbelsteenWorpController dobbelsteenWorpController = new DobbelsteenWorpController(dobbelsteenWorp);
		SpelController spelController = new SpelController(handleidingPane, spel);
		LobbyController lobbyController = new LobbyController(spel);

		// Het definieren van de views
		LobbyView lobbyView = new LobbyView(lobbyController, spel);
		SpelView spelView = new SpelView(spel.getSpeelbord(), spelController, dobbelsteenWorpController, dobbelsteenWorp);

		//lobbyController.registerSpelView(spelView);

		// Het voorbereiden en tonen van de stage.
		lobbyView.show();
	}
}