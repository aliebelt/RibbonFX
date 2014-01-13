package de.lit.ribbonfx;

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
