package de.lit.ribbonfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
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

	public Ribbon build() {
		if (this.appTabData != null) {
			// Initialize Tab
			Tab iTab = new Tab();
			iTab.setClosable(false);
			iTab.setId("ribbonAppTab");
			TabContentView tabContentView = new TabContentView();
			TabContentPresenter tabContentPresenter = (TabContentPresenter) tabContentView.getPresenter();
			iTab.setContent(tabContentView.getView());
			// Customize Tag
			iTab.textProperty().bind(this.appTabData.title());
			iTab.disableProperty().bind(this.appTabData.disabled());
			tabContentPresenter.setContent(this.appTabData.content().get());
			// Add Tab
			this.ribbon.getTabPane().getTabs().add(iTab);
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
