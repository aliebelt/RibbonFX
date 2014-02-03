package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.FooterButtonData;
import de.lit.ribbonfx.model.FooterData;

/**
 * @author aliebelt
 */
public class FooterBuilder {

	FooterData footerData;

	/**
	 * Hidden constructor
	 */
	FooterBuilder() {
		this.footerData = new FooterData();
	}

	public static FooterBuilder create() {
		return new FooterBuilder();
	}

	public FooterBuilder leftButtons(FooterButtonData... buttons) {
		this.footerData.footerLeftButtonDataList().addAll(buttons);
		return this;
	}

	public FooterBuilder rightButtons(FooterButtonData... buttons) {
		this.footerData.footerRightButtonDataList().addAll(buttons);
		return this;
	}

	public FooterData build() {
		return this.footerData;
	}

}
