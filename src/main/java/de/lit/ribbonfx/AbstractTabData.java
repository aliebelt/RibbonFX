package de.lit.ribbonfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class AbstractTabData {

	StringProperty title;
	BooleanProperty disabled;

	public AbstractTabData() {
		this.title = new SimpleStringProperty("unnamed");
		this.disabled = new SimpleBooleanProperty(false);
	}

	public StringProperty title() {
		return this.title;
	}

	public BooleanProperty disabled() {
		return this.disabled;
	}

}
