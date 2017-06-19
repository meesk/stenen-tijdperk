package proceslayer;

import domainlayer.skeleton.ITableau;
import presentationlayer.TableauView;

/**
 * TableauController.java<br>
 * De controller voor het tableau.
 *
 * @author Tristan Caspers, s1102755
 * @version 1.0
 */
public class TableauController {

	private ITableau model;
	private TableauView view;

	/** Het setten van het model. */
	public TableauController(ITableau model) {
		this.model = model;
	}

	public void registerView(TableauView view) {
		this.view = view;
	}

	public void onButtonPressed() {
		//setGereedschapStatus(boolean status, int positie);
	}

}
