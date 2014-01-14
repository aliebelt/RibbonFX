package de.lit.ribbonfx;

/**
 * @author aliebelt
 */
public class RibbonAppTabBuilder {

	AppTabData ribbonAppTab;

	/**
	 * Hidden constructor
	 */
	RibbonAppTabBuilder() {
		this.ribbonAppTab = new AppTabData();
	}

	public static RibbonAppTabBuilder create() {
		return new RibbonAppTabBuilder();
	}

	public RibbonAppTabBuilder title(String title) {
		this.ribbonAppTab.title().set(title);
		return this;
	}

	public AppTabData build() {
		return this.ribbonAppTab;
	}

}
