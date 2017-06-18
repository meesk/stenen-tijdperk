//package mees;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import domainlayer.Spel;
//import domainlayer.Speler;
//import domainlayer.Stamlid;
//import domainlayer.Tableau;
//import domainlayer.enums.Middel;
//import domainlayer.spoor.Puntenspoor;
//import javafx.stage.Stage;
//import presentationlayer.LobbyView;
//import proceslayer.LobbyController;
//import stenentijdperk.StenenTijdperk;
//
//import static org.junit.Assert.*;
//
//public class VerliesPuntenTest {
//		
//		public Tableau tableau;
//		public Tableau tableauFout;
//		public Map<Middel, Integer> middelen;
//		public List<Stamlid> stamleden;
//		public Puntenspoor ps;
//		public Speler speler;
//		
//		@Before
//		public void setUp() throws RemoteException{
//			StenenTijdperk stp = new StenenTijdperk();
//			Puntenspoor  ps = new Puntenspoor();
//			speler = new Speler(new Spel(), new LobbyView(new Stage(), new LobbyController(new Spel())));
//			ps.verhoogProductie(speler, 20);
//		}
//		
//		@Test
//		public void testVerliesPuntenCorrect() throws RemoteException {
//			ps.verwijderPunten(speler, 10);
//			
//			assertEquals("moet gelijk zijn aan 10", 10,  ps.getProductie(speler));
//		}
//
//}
