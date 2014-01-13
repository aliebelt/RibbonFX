package de.lit.ribbonfx;

import javafx.scene.control.TabPane;

/**
 * @author aliebelt
 */
public class RibbonBuilder {

	TabPane ribbon;

	/**
	 * Hidden constructor
	 */
	RibbonBuilder() {
		ribbon = new TabPane();
	}

	public static RibbonBuilder create() {
		return new RibbonBuilder();
	}

	public RibbonBuilder applicationTab(RibbonTabApplication tab) {
		// TODO
		return this;
	}

	public RibbonBuilder ribbonTabs(RibbonTab... tabs) {
		// TODO
		return this;
	}

	public TabPane build() {
		return ribbon;
	}

}
