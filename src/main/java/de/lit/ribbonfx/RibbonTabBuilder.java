package de.lit.ribbonfx;

/**
 * @author aliebelt
 */
public class RibbonTabBuilder extends AbstractTabBuilder<RibbonTabBuilder> {

	/**
	 * Hidden constructor
	 */
	RibbonTabBuilder() {
		super.tabData = new TabData();
	}

	public static RibbonTabBuilder create() {
		return new RibbonTabBuilder();
	}

	public TabData build() {
		return getTabData();
	}

	private TabData getTabData() {
		return (TabData) super.tabData;
	}

}
