package de.lit.ribbonfx;

import de.lit.ribbonfx.model.Tab;
import de.lit.ribbonfx.model.AppTab;


/**
 * @author aliebelt
 */
public class RibbonBuilder {

	Ribbon ribbon;

	/**
	 * Hidden constructor
	 */
	RibbonBuilder() {
		ribbon = new Ribbon();
	}

	public static RibbonBuilder create() {
		return new RibbonBuilder();
	}

	public RibbonBuilder applicationTab(AppTab tab) {
		// TODO
		return this;
	}

	public RibbonBuilder ribbonTabs(Tab... tabs) {
		// TODO
		return this;
	}

	public Ribbon build() {
		return ribbon;
	}

}
