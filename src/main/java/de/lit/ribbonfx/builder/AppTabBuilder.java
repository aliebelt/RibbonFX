package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.AppTabData;


/**
 * @author aliebelt
 */
public class AppTabBuilder extends AbstractTabBuilder<AppTabBuilder> {

	/**
	 * Hidden constructor
	 */
	AppTabBuilder() {
		super.tabData = new AppTabData();
	}

	public static AppTabBuilder create() {
		return new AppTabBuilder();
	}

	public AppTabData build() {
		return getAppTabData();
	}

	private AppTabData getAppTabData() {
		return (AppTabData) super.tabData;
	}

}
