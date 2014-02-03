package de.lit.ribbonfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class SimpleFooterButtonData extends AbstractSimpleButtonData implements FooterButtonData {

	BooleanProperty left;

	public SimpleFooterButtonData() {
		super();
		this.left = new SimpleBooleanProperty(true);
	}

	public BooleanProperty left() {
		return this.left;
	}

}
