//package presentationlayer;
//
//import java.rmi.RemoteException;
//
//public class BetaalView extends Stage implements ITableauObserver {
//
//	private Spinner<Integer> inputVoedsel = new Spinner<Integer>();
//	private Spinner<Integer> inputHout = new Spinner<Integer>();
//	private Spinner<Integer> inputLeem = new Spinner<Integer>();
//	private Spinner<Integer> inputSteen = new Spinner<Integer>();
//	private Spinner<Integer> inputGoud = new Spinner<Integer>();
//	private Spinner<Integer> inputStamleden = new Spinner<Integer>();
//	private Label aantalBetalen;
//
//	public BetaalView(boolean voeden, boolean toonStamleden, BetaalController controller) throws RemoteException {
//
//		BorderPane borderPane = new BorderPane();
//
//		UnicastRemoteObject.exportObject(this,0);
//
//
//		controller.registerView(this);
//
//		GridPane gridPane = new GridPane();
//
//		Label voedsel = new Label("voedsel");
//		Label hout = new Label("hout");
//		Label leem = new Label("leem");
//		Label steen = new Label("steen");
//		Label goud = new Label("goud");
//		Label stamleden = new Label("stamleden");
//
//		SpinnerValueFactory<Integer> valueVoedsel = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
//		SpinnerValueFactory<Integer> valueHout = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
//		SpinnerValueFactory<Integer> valueLeem = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
//		SpinnerValueFactory<Integer> valueSteen = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
//		SpinnerValueFactory<Integer> valueGoud = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
//		SpinnerValueFactory<Integer> valueStamleden = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
//
//		inputVoedsel.setValueFactory(valueVoedsel);
//		inputHout.setValueFactory(valueHout);
//		inputLeem.setValueFactory(valueLeem);
//		inputSteen.setValueFactory(valueSteen);
//		inputGoud.setValueFactory(valueGoud);
//		inputStamleden.setValueFactory(valueGoud);
//
//		HBox hbox = new HBox();
//
//		Button betalenButton = new Button("Plaatsen");
//		betalenButton.setOnMouseClicked(e -> controller.onButtonPressed());
//
//		if (voeden) {
//			gridPane.add(voedsel, 0, 1);
//			gridPane.add(inputVoedsel, 0, 2);
//			aantalBetalen = new Label("moetietsstaandenkik");
//			aantalBetalen.setTextAlignment(TextAlignment.CENTER);
//			aantalBetalen.setStyle("-fx-font-size: 15pt;");
//			betalenButton.setText("Betalen middelen");
//			borderPane.setTop(aantalBetalen);
//			Button verliesPuntenButton = new Button("Verlies 10 punten");
//			verliesPuntenButton.setOnMouseClicked(e -> controller.onVerliesPuntenPressed());
//			hbox.getChildren().add(verliesPuntenButton);
//			BorderPane.setAlignment(verliesPuntenButton, Pos.BOTTOM_LEFT);
//			this.initStyle(StageStyle.UNDECORATED);
//		}
//
//		hbox.getChildren().add(betalenButton);
//
//		if (!toonStamleden) {
//			gridPane.add(hout, 1, 1);
//			gridPane.add(inputHout, 1, 2);
//
//			gridPane.add(leem, 2, 1);
//			gridPane.add(inputLeem, 2, 2);
//
//			gridPane.add(steen, 3, 1);
//			gridPane.add(inputSteen, 3, 2);
//
//			gridPane.add(goud, 4, 1);
//			gridPane.add(inputGoud, 4, 2);
//		}
//
//		if (toonStamleden) {
//			betalenButton.setOnAction(e -> this.close());
//			gridPane.add(stamleden, 1, 1);
//			gridPane.add(inputStamleden, 1, 2);
//		}
//
//		gridPane.setAlignment(Pos.CENTER);
//
//
//		// Zet de titel van de PrimaryStage en dat de PrimaryStage altijd on top moet zijn.
//		// en daarna wordt de Scene in de PrimaryStage gezet.
//		this.setTitle("Betalen middelen");
//		this.setAlwaysOnTop(true);
//
//		borderPane.setCenter(gridPane);
//		borderPane.setBottom(hbox);
//		BorderPane.setAlignment(betalenButton, Pos.BOTTOM_RIGHT);
//
//		borderPane.setStyle("-fx-background-color: #6a5b34");
//
//		Scene scene = new Scene(borderPane);
//
//		this.setScene(scene);
//	}
//
//	public int getVoedsel() {
//		return inputVoedsel.getValue();
//	}
//
//	public int getHout() {
//		return inputHout.getValue();
//	}
//
//	public int getLeem() {
//		return inputLeem.getValue();
//	}
//
//	public int getSteen() {
//		return inputSteen.getValue();
//	}
//
//	public int getGoud() {
//		return inputGoud.getValue();
//	}
//
//	@Override
//	public void modelChanged(ITableau model) throws RemoteException {
//		Platform.runLater(() -> {
//			try{
//				int stamleden = model.getStamleden().size();
//				int voedselspoor = StenenTijdperk.getSpel().getSpeelbord().getVoedselspoor().getMarkeerSteen(StenenTijdperk.getSpeler());
//				aantalBetalen.setText("Aantal te betalen middelen : " + (stamleden - voedselspoor));
//			}catch(RemoteException ex){
//
//			}
//		});
//
//	}
//
//	public int getStamleden() {
//		return inputStamleden.getValue();
//	}
//}
