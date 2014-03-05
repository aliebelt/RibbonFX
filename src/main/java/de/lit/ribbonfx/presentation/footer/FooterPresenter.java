package de.lit.ribbonfx.presentation.footer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

public class FooterPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void addLeftButton(Parent button) {
		this.hBoxLeftButtons.getChildren().add(button);
	}

	public void addRightButton(Parent button) {
		this.hBoxRightButtons.getChildren().add(button);
	}

	@FXML
	HBox hBoxLeftButtons;

	@FXML
	HBox hBoxRightButtons;

}
