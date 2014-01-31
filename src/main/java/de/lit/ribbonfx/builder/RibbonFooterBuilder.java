package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.FooterButtonData;
import de.lit.ribbonfx.model.FooterData;

/**
 * @author aliebelt
 */
public class RibbonFooterBuilder {

	FooterData footerData;

	/**
	 * Hidden constructor
	 */
	RibbonFooterBuilder() {
		this.footerData = new FooterData();
	}

	public static RibbonFooterBuilder create() {
		return new RibbonFooterBuilder();
	}

	public RibbonFooterBuilder leftButtons(FooterButtonData... buttons) {
		this.footerData.footerLeftButtonDataList().addAll(buttons);
		return this;
	}

	public RibbonFooterBuilder rightButtons(FooterButtonData... buttons) {
		this.footerData.footerRightButtonDataList().addAll(buttons);
		return this;
	}

	public FooterData build() {
		return this.footerData;
	}

}
