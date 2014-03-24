package de.lit.ribbonfx.presentation.subselectorbutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SubSelectorButtonPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public ObjectProperty<Image> image() {
		return this.imageViewButtonSymbol.imageProperty();
	}

	public StringProperty text() {
		return this.labelButtonText.textProperty();
	}

	@FXML
	ImageView imageViewButtonSymbol;

	@FXML
	Label labelButtonText;

}
