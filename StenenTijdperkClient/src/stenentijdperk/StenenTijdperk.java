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
//			    ä½›ç¥–ä¿�ä½‘ æ°¸æ— BUG
package stenentijdperk;

import java.rmi.Naming;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.application.Application;
import javafx.stage.Stage;
import presentationlayer.EindView;
import presentationlayer.HandleidingView;
import presentationlayer.LobbyView;
import presentationlayer.SpelView;
import proceslayer.DobbelsteenWorpController;
import proceslayer.LobbyController;
import proceslayer.SpelController;

/**
 * StenenTijdperk.java
 * Een simpele Main-klasse waar de client word opgezet.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * 
 * @version	1.0
 * 
 */
public class StenenTijdperk extends Application {

	private static ISpel spel;
	private static ISpeler speler;
	private static String ip;

	/** 
	 * De main method dies de JavaFX applicatie opstart.
	 * @param args
	 */
	public static void main(String[] args) {
		ip = args[0];
		launch(args);
	}

	@Override
	/** {@inheritDoc} */
	public void start(Stage primaryStage) throws Exception {
		// Het definieren van het model

		spel = (ISpel) Naming.lookup("rmi://"+ip+"/Spel");
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

		//lobbyController.registerSpelView(spelView);

		// Het voorbereiden en tonen van de stage.
		lobbyView.setResizable(false);
		lobbyView.show();

	}
	
	
	/**
	 * getter voor het spel dat geinitializeerd is door de server.
	 * @return ISpel  het model ISpel
	 */
	public static ISpel getSpel() {
		return spel;
	}

	
	/**
	 * getter voor het speler ophalen van de huidige client.
	 * @return  ISpeler  het model ISpel
	 */
	public static ISpeler getSpeler() {
		return speler;
	}

	
	/**
	 * Geeft de client een specifieke speler.
	 * @param spelSpeler  De speler op te setten
	 */
	public static void setSpeler(ISpeler spelSpeler) {
		speler = spelSpeler;
	}
}