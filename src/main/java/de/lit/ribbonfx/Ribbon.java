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

	TabPane tabPane;
	ContainerPresenter tabPanePresenter;

	/**
	 * Hidden constructor
	 */
	public Ribbon() {
		setBackground(new Background((BackgroundFill) null));
		ContainerView tabPaneView = new ContainerView();
		this.tabPane = (TabPane) tabPaneView.getView();
		this.tabPanePresenter = (ContainerPresenter) tabPaneView.getPresenter();

		getChildren().add(this.tabPane);
		AnchorPane.setBottomAnchor(this.tabPane, 0.0);
		AnchorPane.setLeftAnchor(this.tabPane, 0.0);
		AnchorPane.setRightAnchor(this.tabPane, 0.0);
		AnchorPane.setTopAnchor(this.tabPane, 0.0);
	}

	public void setAccent(Paint accent) {
		this.tabPanePresenter.setAccent(accent);
	}

	public TabPane getTabPane() {
		return this.tabPane;
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
