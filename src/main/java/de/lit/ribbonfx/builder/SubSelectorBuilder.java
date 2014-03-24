package de.lit.ribbonfx.builder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.SubSelector;
import de.lit.ribbonfx.model.CommonTabData;

/**
 * @author aliebelt
 */
public class SubSelectorBuilder {

	SubSelector subSelector;
	ObservableList<CommonTabData> subSelectionList;
	Paint accent;

	/**
	 * Hidden constructor
	 */
	SubSelectorBuilder() {
		this.subSelector = new SubSelector();
		this.subSelectionList = FXCollections.observableArrayList();
	}

	public static SubSelectorBuilder create() {
		return new SubSelectorBuilder();
	}

	public SubSelectorBuilder subSelections(CommonTabData... subSelections) {
		this.subSelectionList.addAll(subSelections);
		return this;
	}

	public SubSelectorBuilder accent(Paint accent) {
		this.accent = accent;
		return this;
	}

	public SubSelector build() {
		// Customize SubSelector
		if (this.accent != null) {
			// TODO
			// this.ribbon.setAccent(this.accent);
		}
		boolean noTabIsSelected = true;
		for (CommonTabData iSubSelectionData : this.subSelectionList) {
			// Initialize Tab
			Tab iTab = new Tab();
			iTab.setClosable(false);
			// TODO Same content for multi tabs
			iTab.contentProperty().bind(iSubSelectionData.content());
			// Customize Tab
			iTab.textProperty().bind(iSubSelectionData.title());
			iTab.disableProperty().bind(iSubSelectionData.disabled());
			// Add Tab
			this.subSelector.getTabPane().getTabs().add(iTab);
			if (iSubSelectionData.disabled().get() == false && noTabIsSelected) {
				this.subSelector.getTabPane().getSelectionModel().select(iTab);
				noTabIsSelected = false;
			}
		}
		return this.subSelector;
	}

}
