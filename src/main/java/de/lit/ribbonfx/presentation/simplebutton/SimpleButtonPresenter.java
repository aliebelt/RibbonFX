package de.lit.ribbonfx.presentation.simplebutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SimpleButtonPresenter implements Initializable {

	StringProperty text = new SimpleStringProperty("");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.text.addListener((Observable o) -> {
			String currentText = text.get();
			if (currentText != null) {
				String[] textLines = currentText.split("\n");
				if (textLines.length > 0) {
					labelSimpleButtonTextFirstLine.setText(textLines[0]);
				}
				if (textLines.length > 1) {
					labelSimpleButtonTextSecondLine.setText(textLines[1]);
				}
			} else {
				labelSimpleButtonTextFirstLine.setText("");
				labelSimpleButtonTextSecondLine.setText("");
			}
		});
	}

	public void setImage(Image image) {
		this.imageViewSimpleButtonSymbol.setImage(image);
	}

	public StringProperty text() {
		return this.text;
	}

	@FXML
	ImageView imageViewSimpleButtonSymbol;

	@FXML
	Label labelSimpleButtonTextFirstLine;

	@FXML
	Label labelSimpleButtonTextSecondLine;

}
