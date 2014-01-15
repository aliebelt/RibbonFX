package de.lit.ribbonfx;

/**
 * @author aliebelt
 */
public class RibbonAppTabBuilder {

	AppTabData appTabData;

	/**
	 * Hidden constructor
	 */
	RibbonAppTabBuilder() {
		this.appTabData = new AppTabData();
	}

	public static RibbonAppTabBuilder create() {
		return new RibbonAppTabBuilder();
	}

	public RibbonAppTabBuilder title(String title) {
		this.appTabData.title().set(title);
		return this;
	}

	public RibbonAppTabBuilder disabled(boolean disabled) {
		this.appTabData.disabled().set(disabled);
		return this;
	}

	public AppTabData build() {
		return this.appTabData;
	}

}
