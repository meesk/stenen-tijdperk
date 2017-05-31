package controller;

import view.DobbelsteenView;

public class DobbelsteenController {

	private DobbelsteenView view;
	
	public DobbelsteenController(DobbelsteenView view) {
		this.view = view;
	}
	
	public void onDobbelsteenClick() {
		view.tekenDobbelstenen(new int[] { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4 });
	}


}
