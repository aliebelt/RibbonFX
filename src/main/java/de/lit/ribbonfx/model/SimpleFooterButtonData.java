package de.lit.ribbonfx.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SimpleFooterButtonData extends AbstractSimpleButtonData implements ButtonDataFooter {

	ObservableList<? extends Object> popoverContent;

	public SimpleFooterButtonData() {
		super();
		this.popoverContent = FXCollections.observableArrayList();
	}

	public ObservableList<? extends Object> popoverContent() {
		return this.popoverContent;
	}

}
