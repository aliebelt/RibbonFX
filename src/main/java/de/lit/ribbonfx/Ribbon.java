package de.lit.ribbonfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.actions.ButtonAction;
import de.lit.ribbonfx.presentation.container.ContainerPresenter;
import de.lit.ribbonfx.presentation.container.ContainerView;

public class Ribbon extends AnchorPane {

	TabPane ribbonTabPane;
	ContainerPresenter ribbonTabPanePresenter;

	/**
	 * Hidden constructor
	 */
	public Ribbon() {
		setBackground(new Background((BackgroundFill) null));
		ContainerView tabPaneView = new ContainerView();
		this.ribbonTabPane = (TabPane) tabPaneView.getView();
		this.ribbonTabPanePresenter = (ContainerPresenter) tabPaneView.getPresenter();

		getChildren().add(this.ribbonTabPane);
		AnchorPane.setBottomAnchor(this.ribbonTabPane, 0.0);
		AnchorPane.setLeftAnchor(this.ribbonTabPane, 0.0);
		AnchorPane.setRightAnchor(this.ribbonTabPane, 0.0);
		AnchorPane.setTopAnchor(this.ribbonTabPane, 0.0);
	}

	public void setAccent(Paint accent) {
		this.ribbonTabPanePresenter.setAccent(accent);
	}

	public TabPane getTabPane() {
		return this.ribbonTabPane;
	}

	public final void setOnAction(EventHandler<ActionEvent> value) {
		this.onAction.set(value);
	}

	public void fire(ButtonAction buttonAction) {
		fireEvent(buttonAction);
	}

	ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<EventHandler<ActionEvent>>() {
		@Override
		protected void invalidated() {
			setEventHandler(ActionEvent.ACTION, get());
		}

		@Override
		public Object getBean() {
			return Ribbon.this;
		}

		@Override
		public String getName() {
			return "onAction";
		}
	};

}
