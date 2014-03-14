package de.lit.ribbonfx.presentation.footer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FooterPresenter implements Initializable {

	static final double FOOTER_RIGHT_CONTENT_OFFSET = 15d;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initStageStateListening();
	}

	public void addLeftButton(Parent button) {
		this.hBoxLeftButtons.getChildren().add(button);
	}

	public void addRightButton(Parent button) {
		this.hBoxRightButtons.getChildren().add(button);
	}

	public void enableCornerResize(boolean enable) {
		imageViewCornerResize.setVisible(enable);
		if (enable) {
			AnchorPane.setRightAnchor(hBoxRightButtons, FOOTER_RIGHT_CONTENT_OFFSET);
		} else {
			AnchorPane.setRightAnchor(hBoxRightButtons, 0d);
		}
	}

	private void initStageStateListening() {
		processScene(hBoxLeftButtons.getScene());
		hBoxLeftButtons.sceneProperty().addListener((sceneProperty, oldScene, newScene) -> {
			if (newScene != null) {
				processScene(newScene);
				newScene.windowProperty().addListener((windowProperty, oldWindow, newWindow) -> {
					processStage(newWindow);
				});
			}
		});
	}

	private void processScene(Scene scene) {
		if (scene != null) {
			processStage(scene.getWindow());
		}
	}

	private Stage processStage(Window window) {
		if (window != null && window instanceof Stage) {
			Stage stage = (Stage) window;
			enableCornerResize(!(stage.isMaximized() || stage.isFullScreen()));
			stage.maximizedProperty().addListener(o -> enableCornerResize(!stage.isMaximized()));
			stage.fullScreenProperty().addListener(o -> enableCornerResize(!stage.isFullScreen()));
			return stage;
		}
		return null;
	}

	@FXML
	HBox hBoxLeftButtons;

	@FXML
	HBox hBoxRightButtons;

	@FXML
	ImageView imageViewCornerResize;

}
