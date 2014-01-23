package de.lit.ribbonfx.presentation.tabcontent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class TabContentPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void setContent(Node content) {
		if (content != null) {
			this.ribbonTabContentContainer.getChildren().setAll(content);
		} else {
			this.ribbonTabContentContainer.getChildren().clear();
		}
	}

	public void addGroup(Parent group) {
		if (group != null) {
			this.hBoxRibbonGroups.getChildren().add(group);
		}
	}

	@FXML
	HBox hBoxRibbonGroups;

	@FXML
	AnchorPane ribbonTabContentContainer;

}
