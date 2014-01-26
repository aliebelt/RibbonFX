package de.lit.ribbonfx.presentation.simplebutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SimpleButtonPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public StringProperty text() {
		return this.labelSimpleButtonText.textProperty();
	}

	public void clicked() {

	}

	@FXML
	Label labelSimpleButtonText;

}
