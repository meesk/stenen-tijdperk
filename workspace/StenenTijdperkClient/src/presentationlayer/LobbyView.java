package presentationlayer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LobbyView extends BorderPane {

	public LobbyView(Stage primaryStage){
		
		StackPane stackPane = new StackPane();
		
		GridPane gridPaneForm = new GridPane();
		gridPaneForm.setAlignment(Pos.CENTER);
		gridPaneForm.setHgap(10);
		gridPaneForm.setVgap(10);
		gridPaneForm.setPadding(new Insets(25, 25, 25, 25));
	    
	    // Voornaam input
	    Label voornaam = new Label("Voornaam:");
	    voornaam.setTextFill(Color.WHITE);
	    gridPaneForm.add(voornaam, 0, 1);
	    TextField voorNaamField = new TextField();
	    gridPaneForm.add(voorNaamField, 1, 1);
	    
	    // Date picker input
	    Label geboorteDatum = new Label("Geboorte datum:");
	    geboorteDatum.setTextFill(Color.WHITE);
	    gridPaneForm.add(geboorteDatum, 0, 2);
	    DatePicker geboorteDatumPicker = new DatePicker();
	    gridPaneForm.add(geboorteDatumPicker, 1, 2);
	    
	    // Kies kleur input
	    Label kiesKleur = new Label("Kies uw kleur:");
	    kiesKleur.setTextFill(Color.WHITE);
	    gridPaneForm.add(kiesKleur, 0, 4);
	    
	    // Radio buttons kleuren
	    final ToggleGroup group = new ToggleGroup();
	    RadioButton radRood = new RadioButton("Rood");
	    radRood.setTextFill(Color.WHITE);
	    gridPaneForm.add(radRood, 1, 3);
	    RadioButton radGroen = new RadioButton("Groen");
	    radGroen.setTextFill(Color.WHITE);
	    gridPaneForm.add(radGroen, 1, 4);
	    RadioButton radBlauw = new RadioButton("Blauw");
	    radBlauw.setTextFill(Color.WHITE);
	    gridPaneForm.add(radBlauw, 1, 5);
	    RadioButton radGeel = new RadioButton("Geel");
	    radGeel.setTextFill(Color.WHITE);
	    gridPaneForm.add(radGeel, 1, 6);
	    
	    // Toevoegen radio buttons aan groep
	    radRood.setToggleGroup(group);
	    radGroen.setToggleGroup(group);
	    radBlauw.setToggleGroup(group);
	    radGeel.setToggleGroup(group);
	    
	    // Radio button spastische speler
	    Label spastischLabel = new Label("Ja, ik heb last van spasticiteit");
	    spastischLabel.setTextFill(Color.WHITE);
	    gridPaneForm.add(spastischLabel, 0, 10);
	    RadioButton spastischRad = new RadioButton();
	    gridPaneForm.add(spastischRad, 1, 10);
	    
	    // Button ik ben klaar
	    Button klaar = new Button("Ik ben klaar");
	    klaar.maxWidth(200);
	    klaar.maxHeight(200);
	    gridPaneForm.add(klaar, 1 , 12);
	    
	    //Progessie bar
	    ProgressBar pb = new ProgressBar(0.25);
	    gridPaneForm.add(pb, 2, 12);  
		gridPaneForm.setStyle("-fx-font-size: 16px;");
		
	    // Logo en achtergrond
		Image logoImage = new Image("file:assets/logo.png");
		Image backgroundImage = new Image("file:assets/background.png");
		ImageView logoView = new ImageView(logoImage);
		ImageView backgroundView = new ImageView(backgroundImage);
		backgroundView.setOpacity(0.75);
		
		backgroundView.fitWidthProperty().bind(primaryStage.widthProperty());
		backgroundView.fitHeightProperty().bind(primaryStage.heightProperty());
		
		stackPane.getChildren().addAll(backgroundView, logoView);
		stackPane.setAlignment(Pos.TOP_LEFT);
		
		this.getChildren().add(stackPane);
		this.setCenter(gridPaneForm);
	}
}