package de.lit.ribbonfx.presentation.subselector;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SubSelectorPresenter implements Initializable {

	@FXML
	TabPane tabPaneSubSelector;

	DoubleProperty maxTabTextWidth = new SimpleDoubleProperty();
	int tabTextLeftPadding = 21;
	int tabLongestTextRightPadding = 37;
	double subSelectionWidth;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabPaneSubSelector.getTabs().addListener((Observable o) -> processTabs());
		maxTabTextWidth.addListener((Observable o) -> configureTabSize());
	}

	public void setAccent(Paint accent) {
		// TODO Auto-generated method stub
	}

	private void processTabs() {
		maxTabTextWidth.set(0);
		Platform.runLater(() -> {
			for (Tab iTab : tabPaneSubSelector.getTabs()) {
				double tabTextWidth = getTextBounds(iTab.getText()).getWidth();
				if (tabTextWidth > maxTabTextWidth.get()) {
					maxTabTextWidth.set(tabTextWidth);
				}
			}
		});
	}

	private void configureTabSize() {
		subSelectionWidth = tabTextLeftPadding + maxTabTextWidth.get() + tabLongestTextRightPadding;
		tabPaneSubSelector.setTabMinHeight(subSelectionWidth);
		tabPaneSubSelector.setTabMaxHeight(subSelectionWidth);

		Platform.runLater(() -> {
			for (Tab iTab : tabPaneSubSelector.getTabs()) {
				Bounds tabTextBouds = getTextBounds(iTab.getText());

				int horizontalOffset = (int) ((-subSelectionWidth * 0.5) + (tabTextBouds.getWidth() * 0.5) + 20);
				int topOffset = 0;
				int bottomOffset = 0;
				// ATTENTION: Change if tab text style is changed!!!!
				{
					if ((int) (tabTextBouds.getHeight()) == 17) {
						topOffset = -6;
						bottomOffset = -1;
					} else if ((int) (tabTextBouds.getHeight()) == 34) {
						topOffset = -3;
						bottomOffset = 2;
					} else {
						System.err.println("Text size changed: " + tabTextBouds);
					}
				}
				iTab.setStyle("-fx-padding: " + horizontalOffset + "px " + topOffset + "px " + -horizontalOffset + "px " + bottomOffset + "px;");
			}
		});
	}

	private Bounds getTextBounds(String text) {
		Text dummyText = new Text(text);
		// ATTENTION: Change if tab text style is changed!!!!
		{
			dummyText.setFont(new Font(13));
		}
		dummyText.snapshot(null, null);
		return dummyText.getLayoutBounds();
	}

}
