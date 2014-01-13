package de.lit.ribbonfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class AbstractTab {

	StringProperty title;

	public AbstractTab() {
		this.title = new SimpleStringProperty("unnamed");
	}

	public StringProperty title() {
		return this.title;
	}

}
