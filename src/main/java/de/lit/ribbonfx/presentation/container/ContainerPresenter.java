package de.lit.ribbonfx.presentation.container;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Paint;

public class ContainerPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void setAccent(Paint accent) {
		String colorCode = "#" + accent.toString().substring(2);
		this.tabPaneRibbon.setStyle("-fx-ribbon-color-base: " + colorCode + ";");
	}

	@FXML
	TabPane tabPaneRibbon;

}
