package de.lit.ribbonfx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.presentation.group.GroupPresenter;
import de.lit.ribbonfx.presentation.group.GroupView;
import de.lit.ribbonfx.presentation.tabcontent.TabContentPresenter;
import de.lit.ribbonfx.presentation.tabcontent.TabContentView;

/**
 * @author aliebelt
 */
public class RibbonBuilder {

	Ribbon ribbon;
	AppTabData appTabData;
	ObservableList<TabData> tabDataList;
	Paint contentBackground;

	/**
	 * Hidden constructor
	 */
	RibbonBuilder() {
		this.ribbon = new Ribbon();
		this.tabDataList = FXCollections.observableArrayList();
	}

	public static RibbonBuilder create() {
		return new RibbonBuilder();
	}

	public RibbonBuilder appTab(AppTabData appTab) {
		this.appTabData = appTab;
		return this;
	}

	public RibbonBuilder tabs(TabData... tabs) {
		this.tabDataList.addAll(tabs);
		return this;
	}

	public RibbonBuilder background(Paint contentBackground) {
		this.contentBackground = contentBackground;
		return this;
	}

	public Ribbon build() {
		if (this.appTabData != null) {
			// Initialize Tab
			Tab appTab = new Tab();
			appTab.setClosable(false);
			appTab.setId("ribbonAppTab");
			TabContentView appTabContentView = new TabContentView();
			TabContentPresenter appTabContentPresenter = (TabContentPresenter) appTabContentView.getPresenter();
			appTab.setContent(appTabContentView.getView());
			// Customize Tag
			appTab.textProperty().bind(this.appTabData.title());
			appTab.disableProperty().bind(this.appTabData.disabled());
			appTabContentPresenter.setContent(this.appTabData.content().get());
			appTab.selectedProperty().addListener((Observable o) -> appTabContentPresenter.setSelected(appTab.isSelected()));
			if (this.contentBackground != null) {
				appTabContentPresenter.setContentBackground(this.contentBackground);
			}
			// Add Tab
			this.ribbon.getTabPane().getTabs().add(appTab);
		}
		boolean noTabIsSelected = true;
		for (TabData iTabData : this.tabDataList) {
			// Initialize Tab
			Tab iTab = new Tab();
			iTab.setClosable(false);
			iTab.setId("ribbonTab");
			TabContentView iTabContentView = new TabContentView();
			TabContentPresenter iTabContentPresenter = (TabContentPresenter) iTabContentView.getPresenter();
			iTab.setContent(iTabContentView.getView());
			// Customize Tag
			iTab.textProperty().bind(iTabData.title());
			iTab.disableProperty().bind(iTabData.disabled());
			iTabContentPresenter.setContent(iTabData.content().get());
			iTab.selectedProperty().addListener((Observable o) -> iTabContentPresenter.setSelected(iTab.isSelected()));
			if (this.contentBackground != null) {
				iTabContentPresenter.setContentBackground(this.contentBackground);
			}
			// Add Tab
			this.ribbon.getTabPane().getTabs().add(iTab);
			if (noTabIsSelected) {
				this.ribbon.getTabPane().getSelectionModel().select(iTab);
				noTabIsSelected = false;
			}
			for (GroupData jGroupData : iTabData.groupDataList()) {
				// Initialize Group
				GroupView jGroupView = new GroupView();
				GroupPresenter jGroupPresenter = (GroupPresenter) jGroupView.getPresenter();
				// Customize Group
				jGroupPresenter.title().bind(jGroupData.title());
				// Add Group
				iTabContentPresenter.addGroup(jGroupView.getView());
			}
		}
		return this.ribbon;
	}
}
