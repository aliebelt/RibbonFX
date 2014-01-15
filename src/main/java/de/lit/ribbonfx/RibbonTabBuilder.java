package de.lit.ribbonfx;

/**
 * @author aliebelt
 */
public class RibbonTabBuilder {

	TabData tabData;

	/**
	 * Hidden constructor
	 */
	RibbonTabBuilder() {
		this.tabData = new TabData();
	}

	public static RibbonTabBuilder create() {
		return new RibbonTabBuilder();
	}

	public RibbonTabBuilder title(String title) {
		this.tabData.title().set(title);
		return this;
	}

	public RibbonTabBuilder disabled(boolean disabled) {
		this.tabData.disabled().set(disabled);
		return this;
	}

	public TabData build() {
		return this.tabData;
	}

}
