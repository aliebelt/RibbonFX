package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.ButtonDataFooter;
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

	public FooterBuilder leftButtons(ButtonDataFooter... buttons) {
		this.footerData.footerLeftButtonDataList().addAll(buttons);
		return this;
	}

	public FooterBuilder rightButtons(ButtonDataFooter... buttons) {
		this.footerData.footerRightButtonDataList().addAll(buttons);
		return this;
	}

	public FooterData build() {
		return this.footerData;
	}

}
