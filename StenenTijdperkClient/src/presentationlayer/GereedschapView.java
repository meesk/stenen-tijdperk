package presentationlayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ITableau;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * GereedschapView.java<br>
 * De view voor het tonen van de gereedschap
 * @author Erwin Olie, s1103026
 * @version 1.0
 *
 */

public class GereedschapView extends Stage {
	
	/**
	 * Het initialiseren van de GereedschapView
	 * @param tableau  Het model van de view (ITableau)
	 * @throws RemoteException
	 */

	public GereedschapView(ITableau tableau) throws RemoteException {
		 
		int[] gereedschap = tableau.getGereedschap();
		boolean[] gereedschapGebruikt = tableau.getGereedschapGebruikt();	
		
		HBox context = new HBox();
		
		for (int i = 0; i < 3; i++) {
			if (gereedschap[i] == 0) {
				continue;
			}
			Image image = new Image("file:assets/gereedschap/" + gereedschap[i] + ".png");
			ImageView imageView = new ImageView(image);

			imageView.setFitHeight(110);
			imageView.setFitWidth(110);
			
			imageView.setRotate(gereedschapGebruikt[i] ? 90 : 0);
			
			if (!gereedschapGebruikt[i]) {
				final int index = i;
				imageView.setOnMouseClicked(e -> {
					try {
						tableau.gebruikGereedschap(index);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
					imageView.setRotate(90);
					imageView.setOnMouseClicked(n -> { });
				});
			}
			
			context.getChildren().add(imageView);
		}
		
		Button bevestigen = new Button("Bevestigen");
		bevestigen.setPrefSize(110,  110);
		bevestigen.setOnAction(e -> this.close());
		context.getChildren().add(bevestigen);
		
		Scene scene = new Scene(context);
		this.setScene(scene);
		
	}
}
