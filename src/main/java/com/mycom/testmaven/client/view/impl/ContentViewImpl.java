/**
 * 
 */
package com.mycom.testmaven.client.view.impl;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.mycom.testmaven.client.view.ContentView;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class ContentViewImpl extends FlowPanel implements ContentView{

	@SuppressWarnings("unused")
	private Presenter presenter;
	private Label label;
	
	@Inject
	public ContentViewImpl() {
		label = new Label("a test content which is good to perform test.");
		this.add(label);
	}
	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setBackGroundColor(String color) {
		this.getElement().getStyle().setBackgroundColor(color);
	}
	@Override
	public void setTextColor(String color) {
		this.getElement().getStyle().setColor(color);
	}
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
