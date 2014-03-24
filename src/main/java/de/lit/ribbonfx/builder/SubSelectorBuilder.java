package de.lit.ribbonfx.builder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.SubSelector;
import de.lit.ribbonfx.model.CommonTabData;
import de.lit.ribbonfx.model.SubSelectorButtonData;
import de.lit.ribbonfx.presentation.subselectorbutton.SubSelectorButtonPresenter;
import de.lit.ribbonfx.presentation.subselectorbutton.SubSelectorButtonView;

/**
 * @author aliebelt
 */
public class SubSelectorBuilder {

	SubSelector subSelector;
	ObservableList<SubSelectorButtonData> topButtonList;
	ObservableList<CommonTabData> subSelectionList;
	ObservableList<SubSelectorButtonData> bottomButtonList;
	Paint accent;

	/**
	 * Hidden constructor
	 */
	SubSelectorBuilder() {
		this.subSelector = new SubSelector();
		this.topButtonList = FXCollections.observableArrayList();
		this.subSelectionList = FXCollections.observableArrayList();
		this.bottomButtonList = FXCollections.observableArrayList();
	}

	public static SubSelectorBuilder create() {
		return new SubSelectorBuilder();
	}

	public SubSelectorBuilder topButtons(SubSelectorButtonData... topButtons) {
		this.topButtonList.addAll(topButtons);
		return this;
	}

	public SubSelectorBuilder subSelections(CommonTabData... subSelections) {
		this.subSelectionList.addAll(subSelections);
		return this;
	}

	public SubSelectorBuilder bottomButtons(SubSelectorButtonData... bottomButtons) {
		this.bottomButtonList.addAll(bottomButtons);
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
		for (SubSelectorButtonData iTopButtonData : this.topButtonList) {
			SubSelectorButtonView iTopButtonView = new SubSelectorButtonView();
			SubSelectorButtonPresenter iTopButtonPresenter = (SubSelectorButtonPresenter) iTopButtonView.getPresenter();
			iTopButtonPresenter.image().bind(iTopButtonData.image());
			iTopButtonPresenter.text().bind(iTopButtonData.text());
			Parent iTopButton = iTopButtonView.getView();
			iTopButton.setLayoutX(8);
			iTopButton.setLayoutY(8);
			this.subSelector.getChildren().add(iTopButton);
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
		for (SubSelectorButtonData iBottomButtonData : this.bottomButtonList) {
			// TODO Button Module
			SubSelectorButtonView iTopButtonView = new SubSelectorButtonView();
			SubSelectorButtonPresenter iTopButtonPresenter = (SubSelectorButtonPresenter) iTopButtonView.getPresenter();
			iTopButtonPresenter.image().bind(iBottomButtonData.image());
			iTopButtonPresenter.text().bind(iBottomButtonData.text());
			Parent iBottomButton = iTopButtonView.getView();
			iBottomButton.setLayoutX(8);
			iBottomButton.setLayoutY(170);
			this.subSelector.getChildren().add(iBottomButton);
		}
		return this.subSelector;
	}
}
