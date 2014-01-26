package de.lit.ribbonfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GroupData {

	StringProperty title;
	ObservableList<ButtonData> buttonDataList;

	/**
	 * Hidden constructor
	 */
	public GroupData() {
		this.title = new SimpleStringProperty("unnamed");
		this.buttonDataList = FXCollections.observableArrayList();
	}

	public StringProperty title() {
		return this.title;
	}

	public ObservableList<ButtonData> buttonDataList() {
		return this.buttonDataList;
	}

}