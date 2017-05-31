import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String chatServerURL = "rmi://localhost/SpeelbordServer";
		ISpeelbord chatServer = (ISpeelbord)Naming.lookup(chatServerURL);
		new Speler("LoremIpsum", chatServer);
	}
}
