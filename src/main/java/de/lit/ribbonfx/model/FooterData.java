package de.lit.ribbonfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FooterData {

	ObservableList<FooterButtonData> footerLeftButtonDataList;
	ObservableList<FooterButtonData> footerRightButtonDataList;

	/**
	 * Hidden constructor
	 */
	public FooterData() {
		this.footerLeftButtonDataList = FXCollections.observableArrayList();
		this.footerRightButtonDataList = FXCollections.observableArrayList();
	}

	public ObservableList<FooterButtonData> footerLeftButtonDataList() {
		return this.footerLeftButtonDataList;
	}

	public ObservableList<FooterButtonData> footerRightButtonDataList() {
		return this.footerRightButtonDataList;
	}

}
