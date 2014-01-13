package de.lit.ribbonfx;

/**
 * @author aliebelt
 */
public class RibbonAppTabBuilder {

	RibbonAppTab ribbonAppTab;

	/**
	 * Hidden constructor
	 */
	RibbonAppTabBuilder() {
		this.ribbonAppTab = new RibbonAppTab();
	}

	public static RibbonAppTabBuilder create() {
		return new RibbonAppTabBuilder();
	}

	public RibbonAppTabBuilder title(String title) {
		this.ribbonAppTab.title().set(title);
		return this;
	}

	public RibbonAppTab build() {
		return this.ribbonAppTab;
	}

}
