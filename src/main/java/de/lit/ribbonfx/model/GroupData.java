package de.lit.ribbonfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GroupData {

	StringProperty title;

	/**
	 * Hidden constructor
	 */
	public GroupData() {
		this.title = new SimpleStringProperty("unnamed");
	}

	public StringProperty title() {
		return this.title;
	}

}
