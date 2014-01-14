package de.lit.ribbonfx;


/**
 * @author aliebelt
 */
public class RibbonTabBuilder {

	TabData ribbonTab;

	/**
	 * Hidden constructor
	 */
	RibbonTabBuilder() {
		this.ribbonTab = new TabData();
	}

	public static RibbonTabBuilder create() {
		return new RibbonTabBuilder();
	}

	public RibbonTabBuilder title(String title) {
		this.ribbonTab.title().set(title);
		return this;
	}

	public TabData build() {
		return this.ribbonTab;
	}

}
