package de.lit.ribbonfx;

import de.lit.ribbonfx.model.RibbonTab;
import de.lit.ribbonfx.model.RibbonTabApplication;


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

	public RibbonBuilder applicationTab(RibbonTabApplication tab) {
		// TODO
		return this;
	}

	public RibbonBuilder ribbonTabs(RibbonTab... tabs) {
		// TODO
		return this;
	}

	public Ribbon build() {
		return ribbon;
	}

}
