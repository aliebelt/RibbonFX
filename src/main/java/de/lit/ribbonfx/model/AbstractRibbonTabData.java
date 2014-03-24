package de.lit.ribbonfx.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class AbstractRibbonTabData extends CommonTabData {

	ObjectProperty<FooterData> footer;

	public AbstractRibbonTabData() {
		this.footer = new SimpleObjectProperty<FooterData>();
	}

	public ObjectProperty<FooterData> footer() {
		return this.footer;
	}

}
