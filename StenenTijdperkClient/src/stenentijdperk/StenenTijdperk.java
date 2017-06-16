package stenentijdperk;

import java.rmi.Naming;

import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentationlayer.DobbelsteenWorpView;
import presentationlayer.HandleidingView;
import presentationlayer.LobbyView;
import presentationlayer.SpeelbordView;
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
 * @version	0.6
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
		LobbyView lobbyView = new LobbyView(primaryStage, lobbyController);
		SpelView spelView = new SpelView(spelController, dobbelsteenWorpController, dobbelsteenWorp);

		// Het voorbereiden en tonen van de stage.
		Scene scene = new Scene(spelView, 884, 780);
		primaryStage.setTitle("Het Stenen Tijdperk");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}