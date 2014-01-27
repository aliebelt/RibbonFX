package de.lit.ribbonfx.presentation.tabcontent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

public class TabContentPresenter implements Initializable {

	Node content;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void addGroup(Parent group) {
		if (group != null) {
			this.anchorPaneRibbonToolbar.setPrefHeight(86);
			AnchorPane.setTopAnchor(this.ribbonTabContentContainer, 86.0);
			AnchorPane.setTopAnchor(this.anchorPaneContentBorder, 85.0);
			this.hBoxRibbonGroups.getChildren().add(group);
		}
	}

	public void setContent(Node content) {
		this.content = content;
	}

	public void setAccent(Paint accent) {
		String colorCode = "#" + accent.toString().substring(2);
		this.anchorPaneFirstEmptyRibbonMarker.setStyle("-fx-ribbon-color-base: " + colorCode + ";");
		this.anchorPaneSecondEmptyRibbonMarker.setStyle("-fx-ribbon-color-base: " + colorCode + ";");
	}

	public void setContentBackground(Paint contentBackground) {
		String colorCode = "#" + contentBackground.toString().substring(2);
		this.ribbonTabContentContainer.setStyle("-fx-background-color: " + colorCode + ";");
	}

	public void setSelected(boolean isSelected) {
		// Tab-Content
		if (isSelected && content != null) {
			this.ribbonTabContentContainer.getChildren().setAll(this.content);
			AnchorPane.clearConstraints(this.content);
			AnchorPane.setBottomAnchor(this.content, 0.0);
			AnchorPane.setLeftAnchor(this.content, 0.0);
			AnchorPane.setRightAnchor(this.content, 0.0);
			AnchorPane.setTopAnchor(this.content, 0.0);
		} else {
			this.ribbonTabContentContainer.getChildren().clear();
		}
	}

	@FXML
	AnchorPane anchorPaneRibbonToolbar;

	@FXML
	HBox hBoxRibbonGroups;

	@FXML
	AnchorPane ribbonTabContentContainer;

	@FXML
	AnchorPane anchorPaneContentBorder;

	@FXML
	AnchorPane anchorPaneFirstEmptyRibbonMarker;

	@FXML
	AnchorPane anchorPaneSecondEmptyRibbonMarker;

}
