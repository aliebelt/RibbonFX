package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.SimpleFooterButtonData;

/**
 * @author aliebelt
 */
public class SimpleFooterButtonBuilder extends AbstractSimpleButtonBuilder<SimpleFooterButtonBuilder> {

	/**
	 * Hidden constructor
	 */
	SimpleFooterButtonBuilder() {
		super();
		this.simpleButtonData = new SimpleFooterButtonData();
	}

	public static SimpleFooterButtonBuilder create() {
		return new SimpleFooterButtonBuilder();
	}

	public SimpleFooterButtonData build() {
		return (SimpleFooterButtonData) this.simpleButtonData;
	}

}
