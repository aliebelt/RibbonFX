package de.lit.ribbonfx;

import javafx.scene.control.TabPane;
import de.lit.ribbonfx.presentation.ribbon.RibbonView;

public class Ribbon {

	TabPane ribbon;

	/**
	 * Hidden constructor
	 */
	Ribbon() {
		TabPane ribbon = (TabPane) new RibbonView().getView();
		this.ribbon = ribbon;
	}

	public TabPane getRibbon() {
		return this.ribbon;
	}

}
