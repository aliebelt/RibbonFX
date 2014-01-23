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
			this.hBoxRibbonGroups.getChildren().add(group);
		}
	}

	public void setContent(Node content) {
		this.content = content;
	}

	public void setContentBackground(Paint contentBackground) {
		String colorCode = "#" + contentBackground.toString().substring(2);
		this.ribbonTabContentContainer.setStyle("-fx-background-color: " + colorCode + ";");
	}

	public void setSelected(boolean isSelected) {
		if (isSelected && content != null) {
			this.ribbonTabContentContainer.getChildren().setAll(this.content);
		} else {
			this.ribbonTabContentContainer.getChildren().clear();
		}
	}

	@FXML
	HBox hBoxRibbonGroups;

	@FXML
	AnchorPane ribbonTabContentContainer;

}
