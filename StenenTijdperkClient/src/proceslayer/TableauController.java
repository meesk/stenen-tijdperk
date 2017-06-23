package proceslayer;

import domainlayer.skeleton.ITableau;
import presentationlayer.TableauView;

/**
 * De controller voor het tableau.
 *
 * @author Tristan Caspers, s1102755
 * @version 3.0
 */
public class TableauController {

	private ITableau model;
	private TableauView view;

	/** 
	 * Het iniitaliseren van de controller.
	 * @param model  Het model ITableau
	 */
	public TableauController(ITableau model) {
		this.model = model;
	}

	/**
	 * Het registreren van een nieuwe view.
	 * @param view  De view die geregistreerd word.
	 */
	public void registerView(TableauView view) {
		this.view = view;
	}
}
