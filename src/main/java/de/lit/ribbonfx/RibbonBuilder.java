package de.lit.ribbonfx;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Tab;
import de.lit.ribbonfx.presentation.tabcontent.TabContentPresenter;
import de.lit.ribbonfx.presentation.tabcontent.TabContentView;

/**
 * @author aliebelt
 */
public class RibbonBuilder {

	Ribbon ribbon;
	AppTabData appTabData;
	List<TabData> tabDataList;

	/**
	 * Hidden constructor
	 */
	RibbonBuilder() {
		this.ribbon = new Ribbon();
		this.tabDataList = new ArrayList<TabData>();
	}

	public static RibbonBuilder create() {
		return new RibbonBuilder();
	}

	public RibbonBuilder appTab(AppTabData appTab) {
		this.appTabData = appTab;
		return this;
	}

	public RibbonBuilder tabs(TabData... tabs) {
		for (TabData iTabData : tabs) {
			this.tabDataList.add(iTabData);
		}
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
			TabContentView tabContentView = new TabContentView();
			TabContentPresenter tabContentPresenter = (TabContentPresenter) tabContentView.getPresenter();
			iTab.setContent(tabContentView.getView());
			// Customize Tag
			iTab.textProperty().bind(iTabData.title());
			iTab.disableProperty().bind(iTabData.disabled());
			tabContentPresenter.setContent(iTabData.content().get());
			// Add Tab
			this.ribbon.getTabPane().getTabs().add(iTab);
			if (noTabIsSelected) {
				this.ribbon.getTabPane().getSelectionModel().select(iTab);
				noTabIsSelected = false;
			}
		}
		return this.ribbon;
	}

}
