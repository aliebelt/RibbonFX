package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.SubSelectorButtonData;

/**
 * @author aliebelt
 */
public class SubSelectorButtonBuilder extends AbstractSimpleButtonBuilder<SubSelectorButtonBuilder> {

	/**
	 * Hidden constructor
	 */
	SubSelectorButtonBuilder() {
		super();
		this.simpleButtonData = new SubSelectorButtonData();
	}

	public static SubSelectorButtonBuilder create() {
		return new SubSelectorButtonBuilder();
	}

	public SubSelectorButtonData build() {
		return (SubSelectorButtonData) this.simpleButtonData;
	}

}
