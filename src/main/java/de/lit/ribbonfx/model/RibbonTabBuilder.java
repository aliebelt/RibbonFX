package de.lit.ribbonfx.model;


/**
 * @author aliebelt
 */
public class RibbonTabBuilder {

	RibbonTab ribbonTab;

	/**
	 * Hidden constructor
	 */
	RibbonTabBuilder() {
		this.ribbonTab = new RibbonTab();
	}

	public static RibbonTabBuilder create() {
		return new RibbonTabBuilder();
	}

	public RibbonTabBuilder title(String title) {
		this.ribbonTab.title().set(title);
		return this;
	}

	public RibbonTab build() {
		return this.ribbonTab;
	}

}
