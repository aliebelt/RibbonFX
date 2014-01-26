package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.AppTabData;


/**
 * @author aliebelt
 */
public class RibbonAppTabBuilder extends AbstractTabBuilder<RibbonAppTabBuilder> {

	/**
	 * Hidden constructor
	 */
	RibbonAppTabBuilder() {
		super.tabData = new AppTabData();
	}

	public static RibbonAppTabBuilder create() {
		return new RibbonAppTabBuilder();
	}

	public AppTabData build() {
		return getAppTabData();
	}

	private AppTabData getAppTabData() {
		return (AppTabData) super.tabData;
	}

}
