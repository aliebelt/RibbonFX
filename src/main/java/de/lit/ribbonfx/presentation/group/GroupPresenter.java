package de.lit.ribbonfx.presentation.group;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class GroupPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public StringProperty title() {
		return this.labelGroupTitle.textProperty();
	}

	@FXML
	Label labelGroupTitle;

}
