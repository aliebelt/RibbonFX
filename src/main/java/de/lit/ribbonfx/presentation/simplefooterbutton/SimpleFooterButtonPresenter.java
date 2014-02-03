package de.lit.ribbonfx.presentation.simplefooterbutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SimpleFooterButtonPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Empty
	}

	public void setLeft(boolean left) {
		if (left) {
			this.separatorLeft.setPrefWidth(0);
			this.separatorLeft.setVisible(false);
			this.separatorRight.setPrefWidth(3);
			this.separatorRight.setVisible(true);
		} else {
			this.separatorRight.setPrefWidth(0);
			this.separatorRight.setVisible(false);
			this.separatorLeft.setPrefWidth(3);
			this.separatorLeft.setVisible(true);
		}
	}

	public void setImage(Image image) {
		this.imageViewSimpleButtonSymbol.setImage(image);
	}

	public StringProperty text() {
		return this.labelSimpleButtonText.textProperty();
	}

	public Parent getButton() {
		return this.anchorPaneButton;
	}

	@FXML
	Separator separatorLeft;

	@FXML
	AnchorPane anchorPaneButton;

	@FXML
	ImageView imageViewSimpleButtonSymbol;

	@FXML
	Label labelSimpleButtonText;

	@FXML
	Separator separatorRight;

}
