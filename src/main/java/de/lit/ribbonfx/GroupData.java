package de.lit.ribbonfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GroupData {

	StringProperty title;

	/**
	 * Hidden constructor
	 */
	GroupData() {
		this.title = new SimpleStringProperty("unnamed");
	}

	public StringProperty title() {
		return this.title;
	}

}
