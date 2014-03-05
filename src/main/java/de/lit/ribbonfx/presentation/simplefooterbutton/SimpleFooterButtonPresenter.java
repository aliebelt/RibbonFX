package de.lit.ribbonfx.presentation.simplefooterbutton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import org.controlsfx.control.PopOver;
import org.controlsfx.control.PopOver.ArrowLocation;

public class SimpleFooterButtonPresenter implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.imageViewSimpleButtonSymbol.imageProperty().addListener((Observable o) -> configureHBoxSpacing());
		this.labelSimpleButtonText.textProperty().addListener((Observable o) -> configureHBoxSpacing());
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

	public ObjectProperty<Image> image() {
		return this.imageViewSimpleButtonSymbol.imageProperty();
	}

	public StringProperty text() {
		return this.labelSimpleButtonText.textProperty();
	}

	public Parent getButton() {
		return this.anchorPaneButton;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void popOverContent(ObservableList items, Callback cellFactory) {
		ListView listView = new ListView(items);
		if (cellFactory != null) {
			listView.setCellFactory(cellFactory);
		}
		PopOver popOver = new PopOver(listView);
		popOver.setArrowLocation(ArrowLocation.BOTTOM_CENTER);
		popOver.setHideOnEscape(true);
		popOver.setAutoHide(true);

		popOver.detachedProperty().addListener((Observable o) -> {
			if (popOver.isDetached()) {
				popOver.setAutoHide(false);
			} else {
				popOver.setAutoHide(true);
			}
		});

		this.anchorPaneButton.setOnMousePressed((MouseEvent e) -> {
			if (popOver.isShowing() == false) {
				Point2D point2d = anchorPaneButton.localToScreen(0, 0);
				popOver.show(anchorPaneButton, point2d.getX() + (anchorPaneButton.getWidth() * 0.5), point2d.getY());
			} else {
				popOver.hide();
			}
		});
	}

	private void configureHBoxSpacing() {
		if (this.imageViewSimpleButtonSymbol.getImage() != null && this.labelSimpleButtonText.getText() != "") {
			this.hBoxButtonContent.setSpacing(5);
		} else {
			this.hBoxButtonContent.setSpacing(0);
		}
	}

	@FXML
	Separator separatorLeft;

	@FXML
	AnchorPane anchorPaneButton;

	@FXML
	HBox hBoxButtonContent;

	@FXML
	ImageView imageViewSimpleButtonSymbol;

	@FXML
	Label labelSimpleButtonText;

	@FXML
	Separator separatorRight;

}
