package de.lit.ribbonfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TabData extends AbstractTabData {

	ObservableList<GroupData> groupDataList;

	/**
	 * Hidden constructor
	 */
	TabData() {
		this.groupDataList = FXCollections.observableArrayList();
	}

	public ObservableList<GroupData> groupDataList() {
		return this.groupDataList;
	}

}
