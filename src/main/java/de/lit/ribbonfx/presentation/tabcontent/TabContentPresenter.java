package de.lit.ribbonfx.presentation.tabcontent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class TabContentPresenter implements Initializable {

	ImageView contentBackgroundImage;
	Node content;
	Node footer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void addGroup(Parent group) {
		if (group != null) {
			this.anchorPaneRibbonToolbar.setPrefHeight(86);
			AnchorPane.setTopAnchor(this.vBoxTabContentContainer, 86.0);
			AnchorPane.setTopAnchor(this.anchorPaneContentBorder, 85.0);
			this.hBoxRibbonGroups.getChildren().add(group);
		}
	}

	public void setContent(Node content) {
		this.content = content;
		if (this.content != null) {
			AnchorPane.setBottomAnchor(this.content, 0.0);
			AnchorPane.setLeftAnchor(this.content, 0.0);
			AnchorPane.setRightAnchor(this.content, 0.0);
			AnchorPane.setTopAnchor(this.content, 0.0);
			Platform.runLater(() -> setSelected(true));
		}
	}

	public void setFooter(Node footer) {
		this.footer = footer;
		if (this.footer != null) {
			AnchorPane.setBottomAnchor(this.footer, 0.0);
			AnchorPane.setLeftAnchor(this.footer, 0.0);
			AnchorPane.setRightAnchor(this.footer, 0.0);
			AnchorPane.setTopAnchor(this.footer, 0.0);
			Platform.runLater(() -> setSelected(true));
		}
	}

	public void setAccent(Paint accent) {
		String colorCode = "#" + accent.toString().substring(2);
		this.anchorPaneFirstEmptyRibbonMarker.setStyle("-fx-ribbon-color-base: " + colorCode + ";");
		this.anchorPaneSecondEmptyRibbonMarker.setStyle("-fx-ribbon-color-base: " + colorCode + ";");
	}

	public void setContentBackgroundColor(Paint contentBackgroundColor) {
		String colorCode = "#" + contentBackgroundColor.toString().substring(2);
		this.anchorPaneContentContainer.setStyle("-fx-ribbon-tab-content-background-color: " + colorCode + ";");
	}

	public void setContentBackgroundImage(ImageView contentBackgroundImage) {
		this.contentBackgroundImage = contentBackgroundImage;
		if (this.contentBackgroundImage != null) {
			AnchorPane.setBottomAnchor(this.contentBackgroundImage, 0.0);
			AnchorPane.setRightAnchor(this.contentBackgroundImage, 0.0);
			Platform.runLater(() -> setSelected(true));
		}
	}

	public void setSelected(boolean isSelected) {
		// Tab-Content-Background-Image
		if (isSelected && contentBackgroundImage != null && content.getParent() != this.anchorPaneContentContainer) {
			this.anchorPaneContentContainer.getChildren().add(this.contentBackgroundImage);
		}
		// Tab-Content
		if (isSelected && content != null && content.getParent() != this.anchorPaneContentContainer) {
			this.anchorPaneContentContainer.getChildren().add(this.content);
		}
		// Footer
		if (isSelected && footer != null && footer.getParent() != this.anchorPaneFooterContainer) {
			this.anchorPaneFooterContainer.getChildren().setAll(this.footer);
		}
	}

	@FXML AnchorPane anchorPaneRibbonToolbar;
	@FXML HBox hBoxRibbonGroups;
	@FXML VBox vBoxTabContentContainer;
	@FXML AnchorPane anchorPaneContentContainer;
	@FXML AnchorPane anchorPaneFooterContainer;
	@FXML AnchorPane anchorPaneContentBorder;
	@FXML AnchorPane anchorPaneFirstEmptyRibbonMarker;
	@FXML AnchorPane anchorPaneSecondEmptyRibbonMarker;

}
