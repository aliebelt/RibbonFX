package de.lit.ribbonfx;

import de.lit.ribbonfx.model.AppTab;
import de.lit.ribbonfx.model.Tab;

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

	public RibbonBuilder applicationTab(AppTab applicationTab) {
		// TODO
		return this;
	}

	public RibbonBuilder tabs(Tab... tabs) {
		// TODO
		return this;
	}

	public Ribbon build() {
		return ribbon;
	}

}
