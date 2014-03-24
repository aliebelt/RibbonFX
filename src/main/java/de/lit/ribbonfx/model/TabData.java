package de.lit.ribbonfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TabData extends AbstractRibbonTabData {

	ObservableList<GroupData> groupDataList;

	/**
	 * Hidden constructor
	 */
	public TabData() {
		this.groupDataList = FXCollections.observableArrayList();
	}

	public ObservableList<GroupData> groupDataList() {
		return this.groupDataList;
	}

}
