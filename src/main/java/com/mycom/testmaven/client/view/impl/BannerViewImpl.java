/**
 * 
 */
package com.mycom.testmaven.client.view.impl;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.mycom.testmaven.client.view.BannerView;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class BannerViewImpl extends FlowPanel implements BannerView, ClickHandler {

	private Presenter presenter;
	private Label label;
	private TextBox usrNameTxb;
	
	@Inject
	public BannerViewImpl() {
		label = new Label("Hello! please type your name!");
		label.setStylePrimaryName("header-title");
		add(label);
		
		Button btn = new Button("Change user name");
		btn.addClickHandler(this);
		add(btn);
		
		usrNameTxb = new TextBox();
		add(usrNameTxb);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see idv.zanyking.client.view.BannerView#setUserName(java.lang.String)
	 */
	@Override
	public void setUserName(String name) {
		usrNameTxb.setValue("");
		label.setText("hello! user: "+name);
	}

	@Override
	public void onClick(ClickEvent event) {
		presenter.setUserName(usrNameTxb.getText());
	}


	@Override
	public void setBackGroundColor(String bgColor) {
		this.getElement().getStyle().setBackgroundColor(bgColor);
	}

	@Override
	public void setTextColor(String color) {
		this.getElement().getStyle().setColor(color);
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
