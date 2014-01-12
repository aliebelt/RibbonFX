package de.lit.ribbonfx;

import javafx.scene.control.TabPane;

/**
 * @author aliebelt
 */
public class Ribbon {

	TabPane ribbon;

	/**
	 * Hidden constructor
	 */
	Ribbon() {
		ribbon = new TabPane();
	}

	public static Ribbon create() {
		return new Ribbon();
	}

	public Ribbon applicationTab(RibbonTabApplication tab) {
		// TODO
		return this;
	}

	public Ribbon ribbonTabs(RibbonTab... tabs) {
		// TODO
		return this;
	}

	public TabPane build() {
		return ribbon;
	}

}
