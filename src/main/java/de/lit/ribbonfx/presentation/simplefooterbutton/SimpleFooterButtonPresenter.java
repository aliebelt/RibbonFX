package de.lit.ribbonfx.presentation.simplefooterbutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SimpleFooterButtonPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void setLeft(boolean left) {

	}

	public void setImage(Image image) {
		this.imageViewSimpleButtonSymbol.setImage(image);
	}

	public StringProperty text() {
		return this.labelSimpleButtonText.textProperty();
	}

	public void clicked() {

	}

	@FXML
	ImageView imageViewSimpleButtonSymbol;

	@FXML
	Label labelSimpleButtonText;

}
