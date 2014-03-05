package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.SimpleButtonData;

/**
 * @author aliebelt
 */
public class SimpleButtonBuilder extends AbstractSimpleButtonBuilder<SimpleButtonBuilder> {

	/**
	 * Hidden constructor
	 */
	SimpleButtonBuilder() {
		super();
		this.simpleButtonData = new SimpleButtonData();
	}

	public static SimpleButtonBuilder create() {
		return new SimpleButtonBuilder();
	}

	public SimpleButtonData build() {
		return (SimpleButtonData) this.simpleButtonData;
	}

}
