package proceslayer;

import domainlayer.skeleton.ITableau;
import presentationlayer.BetaalView;

/**
 * Betaalcontroller.java
 * De controller voor het betalen.
 * 
 * @author Mees Kluivers, s1102358
 * @version 0.1
 */

public class BetaalController {
	
	private BetaalView view;
	private ITableau model;
	
	public BetaalController(ITableau model){
		this.model = model;
	}
	
	public void registerView(BetaalView view){
		this.view = view;
	}
	
	public void onButtonPressed(){
		
	}
	
	public void onBetaalAction() {
		
	}
	
}
