package de.lit.ribbonfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FooterData {

	ObservableList<ButtonDataFooter> footerLeftButtonDataList;
	ObservableList<ButtonDataFooter> footerRightButtonDataList;

	/**
	 * Hidden constructor
	 */
	public FooterData() {
		this.footerLeftButtonDataList = FXCollections.observableArrayList();
		this.footerRightButtonDataList = FXCollections.observableArrayList();
	}

	public ObservableList<ButtonDataFooter> footerLeftButtonDataList() {
		return this.footerLeftButtonDataList;
	}

	public ObservableList<ButtonDataFooter> footerRightButtonDataList() {
		return this.footerRightButtonDataList;
	}

}
