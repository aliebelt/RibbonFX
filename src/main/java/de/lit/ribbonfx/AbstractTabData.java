package de.lit.ribbonfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class AbstractTabData {

	StringProperty title;

	public AbstractTabData() {
		this.title = new SimpleStringProperty("unnamed");
	}

	public StringProperty title() {
		return this.title;
	}

}
