package de.lit.ribbonfx.builder;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.Ribbon;
import de.lit.ribbonfx.actions.ButtonAction;
import de.lit.ribbonfx.model.AppTabData;
import de.lit.ribbonfx.model.ButtonData;
import de.lit.ribbonfx.model.ButtonDataFooter;
import de.lit.ribbonfx.model.FooterData;
import de.lit.ribbonfx.model.GroupData;
import de.lit.ribbonfx.model.SimpleButtonData;
import de.lit.ribbonfx.model.SimpleFooterButtonData;
import de.lit.ribbonfx.model.TabData;
import de.lit.ribbonfx.presentation.footer.FooterPresenter;
import de.lit.ribbonfx.presentation.footer.FooterView;
import de.lit.ribbonfx.presentation.group.GroupPresenter;
import de.lit.ribbonfx.presentation.group.GroupView;
import de.lit.ribbonfx.presentation.simplebutton.SimpleButtonPresenter;
import de.lit.ribbonfx.presentation.simplebutton.SimpleButtonView;
import de.lit.ribbonfx.presentation.simplefooterbutton.SimpleFooterButtonPresenter;
import de.lit.ribbonfx.presentation.simplefooterbutton.SimpleFooterButtonView;
import de.lit.ribbonfx.presentation.tabcontent.TabContentPresenter;
import de.lit.ribbonfx.presentation.tabcontent.TabContentView;

/**
 * @author aliebelt
 */
public class RibbonBuilder {

	Ribbon ribbon;
	AppTabData appTabData;
	ObservableList<TabData> tabDataList;
	Paint accent;
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

	public RibbonBuilder accent(Paint accent) {
		this.accent = accent;
		return this;
	}

	public RibbonBuilder contentBackground(Paint contentBackground) {
		this.contentBackground = contentBackground;
		return this;
	}

	public Ribbon build() {
		// Customize Ribbon
		if (this.accent != null) {
			this.ribbon.setAccent(this.accent);
		}
		// App-Tab
		if (this.appTabData != null) {
			// Initialize Tab
			Tab appTab = new Tab();
			appTab.setClosable(false);
			appTab.setId("ribbonAppTab");
			TabContentView appTabContentView = new TabContentView();
			TabContentPresenter appTabContentPresenter = (TabContentPresenter) appTabContentView.getPresenter();
			appTab.setContent(appTabContentView.getView());
			// Customize Tab
			appTab.textProperty().bind(this.appTabData.title());
			appTab.disableProperty().bind(this.appTabData.disabled());
			appTabContentPresenter.setContent(this.appTabData.content().get());
			appTab.selectedProperty().addListener((Observable o) -> appTabContentPresenter.setSelected(appTab.isSelected()));
			if (this.contentBackground != null) {
				appTabContentPresenter.setContentBackground(this.contentBackground);
			}
			if (this.accent != null) {
				appTabContentPresenter.setAccent(this.accent);
			}
			if (this.appTabData.footer().get() != null) {
				FooterData footerData = this.appTabData.footer().get();
				FooterView footerView = new FooterView();
				FooterPresenter footerPresenter = (FooterPresenter) footerView.getPresenter();
				for (ButtonDataFooter iFooterButton : footerData.footerLeftButtonDataList()) {
					if (iFooterButton instanceof SimpleFooterButtonData) {
						SimpleFooterButtonData iSimpleFooterButtonData = (SimpleFooterButtonData) iFooterButton;
						// Initialize simple-footer-button
						SimpleFooterButtonView iSimpleFooterButtonView = new SimpleFooterButtonView();
						SimpleFooterButtonPresenter iSimpleFooterButtonPresenter = (SimpleFooterButtonPresenter) iSimpleFooterButtonView.getPresenter();
						Parent iSimpleFooterButton = iSimpleFooterButtonView.getView();
						// Customize simple-footer-button
						iSimpleFooterButtonPresenter.setLeft(true);
						iSimpleFooterButtonPresenter.image().bind(iSimpleFooterButtonData.image());
						iSimpleFooterButtonPresenter.text().bind(iSimpleFooterButtonData.text());
						iSimpleFooterButton.disableProperty().bind(iSimpleFooterButtonData.disabled());
						iSimpleFooterButtonPresenter.getButton().setOnMouseClicked(
								(MouseEvent e) -> this.ribbon.fire(new ButtonAction(iSimpleFooterButtonData)));
						// Add simple-footer-button
						footerPresenter.addLeftButton(iSimpleFooterButton);
					}
				}
				for (ButtonDataFooter iFooterButton : footerData.footerRightButtonDataList()) {
					if (iFooterButton instanceof SimpleFooterButtonData) {
						SimpleFooterButtonData iSimpleFooterButtonData = (SimpleFooterButtonData) iFooterButton;
						// Initialize simple-footer-button
						SimpleFooterButtonView iSimpleFooterButtonView = new SimpleFooterButtonView();
						SimpleFooterButtonPresenter iSimpleFooterButtonPresenter = (SimpleFooterButtonPresenter) iSimpleFooterButtonView.getPresenter();
						Parent iSimpleFooterButton = iSimpleFooterButtonView.getView();
						// Customize simple-footer-button
						iSimpleFooterButtonPresenter.setLeft(false);
						iSimpleFooterButtonPresenter.image().bind(iSimpleFooterButtonData.image());
						iSimpleFooterButtonPresenter.text().bind(iSimpleFooterButtonData.text());
						iSimpleFooterButton.disableProperty().bind(iSimpleFooterButtonData.disabled());
						iSimpleFooterButtonPresenter.getButton().setOnMouseClicked(
								(MouseEvent e) -> this.ribbon.fire(new ButtonAction(iSimpleFooterButtonData)));
						// Add simple-footer-button
						footerPresenter.addRightButton(iSimpleFooterButton);
					}
				}
				appTabContentPresenter.setFooter(footerView.getView());
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
			// Customize Tab
			iTab.textProperty().bind(iTabData.title());
			iTab.disableProperty().bind(iTabData.disabled());
			iTabContentPresenter.setContent(iTabData.content().get());
			iTab.selectedProperty().addListener((Observable o) -> iTabContentPresenter.setSelected(iTab.isSelected()));
			if (this.contentBackground != null) {
				iTabContentPresenter.setContentBackground(this.contentBackground);
			}
			if (this.accent != null) {
				iTabContentPresenter.setAccent(this.accent);
			}
			if (iTabData.footer().get() != null) {
				FooterData iFooterData = iTabData.footer().get();
				FooterView iFooterView = new FooterView();
				FooterPresenter iFooterPresenter = (FooterPresenter) iFooterView.getPresenter();
				for (ButtonDataFooter kFooterButton : iFooterData.footerLeftButtonDataList()) {
					if (kFooterButton instanceof SimpleFooterButtonData) {
						SimpleFooterButtonData kSimpleFooterButtonData = (SimpleFooterButtonData) kFooterButton;
						// Initialize simple-footer-button
						SimpleFooterButtonView kSimpleFooterButtonView = new SimpleFooterButtonView();
						SimpleFooterButtonPresenter kSimpleFooterButtonPresenter = (SimpleFooterButtonPresenter) kSimpleFooterButtonView.getPresenter();
						Parent kSimpleFooterButton = kSimpleFooterButtonView.getView();
						// Customize simple-footer-button
						kSimpleFooterButtonPresenter.setLeft(true);
						kSimpleFooterButtonPresenter.image().bind(kSimpleFooterButtonData.image());
						kSimpleFooterButtonPresenter.text().bind(kSimpleFooterButtonData.text());
						kSimpleFooterButton.disableProperty().bind(kSimpleFooterButtonData.disabled());
						kSimpleFooterButtonPresenter.getButton().setOnMouseClicked(
								(MouseEvent e) -> this.ribbon.fire(new ButtonAction(kSimpleFooterButtonData)));
						// Add simple-footer-button
						iFooterPresenter.addLeftButton(kSimpleFooterButton);
					}
				}
				for (ButtonDataFooter kFooterButton : iFooterData.footerRightButtonDataList()) {
					if (kFooterButton instanceof SimpleFooterButtonData) {
						SimpleFooterButtonData kSimpleFooterButtonData = (SimpleFooterButtonData) kFooterButton;
						// Initialize simple-footer-button
						SimpleFooterButtonView kSimpleFooterButtonView = new SimpleFooterButtonView();
						SimpleFooterButtonPresenter kSimpleFooterButtonPresenter = (SimpleFooterButtonPresenter) kSimpleFooterButtonView.getPresenter();
						Parent kSimpleFooterButton = kSimpleFooterButtonView.getView();
						// Customize simple-footer-button
						kSimpleFooterButtonPresenter.setLeft(false);
						kSimpleFooterButtonPresenter.image().bind(kSimpleFooterButtonData.image());
						kSimpleFooterButtonPresenter.text().bind(kSimpleFooterButtonData.text());
						kSimpleFooterButton.disableProperty().bind(kSimpleFooterButtonData.disabled());
						kSimpleFooterButtonPresenter.getButton().setOnMouseClicked(
								(MouseEvent e) -> this.ribbon.fire(new ButtonAction(kSimpleFooterButtonData)));
						// Add simple-footer-button
						iFooterPresenter.addRightButton(kSimpleFooterButton);
					}
				}
				iTabContentPresenter.setFooter(iFooterView.getView());
			}
			// Add Tab
			this.ribbon.getTabPane().getTabs().add(iTab);
			if (iTabData.disabled().get() == false && noTabIsSelected) {
				this.ribbon.getTabPane().getSelectionModel().select(iTab);
				noTabIsSelected = false;
			}
			// Add ribbon-groups to tab
			for (GroupData jGroupData : iTabData.groupDataList()) {
				// Initialize Group
				GroupView jGroupView = new GroupView();
				GroupPresenter jGroupPresenter = (GroupPresenter) jGroupView.getPresenter();
				// Customize Group
				jGroupPresenter.title().bind(jGroupData.title());
				// Add Group
				iTabContentPresenter.addGroup(jGroupView.getView());
				// Add ribbon-buttons to group
				for (ButtonData kButtonData : jGroupData.buttonDataList()) {
					if (kButtonData instanceof SimpleButtonData) {
						SimpleButtonData kSimpleButtonData = (SimpleButtonData) kButtonData;
						// Initialize simple-button
						SimpleButtonView kSimpleButtonView = new SimpleButtonView();
						SimpleButtonPresenter kSimpleButtonPresenter = (SimpleButtonPresenter) kSimpleButtonView.getPresenter();
						Parent kSimpleButton = kSimpleButtonView.getView();
						// Customize simple-button
						kSimpleButtonPresenter.setImage(kSimpleButtonData.image().get());
						kSimpleButtonPresenter.text().bind(kSimpleButtonData.text());
						kSimpleButton.disableProperty().bind(kSimpleButtonData.disabled());
						kSimpleButton.setOnMouseClicked((MouseEvent e) -> this.ribbon.fire(new ButtonAction(kSimpleButtonData)));
						// Add simple-button
						jGroupPresenter.addGroupElement(kSimpleButton);
					}
				}
			}
		}
		return this.ribbon;
	}
}
