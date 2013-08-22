/**
 * 
 */
package com.mycom.testmaven.client.view.impl;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.mycom.testmaven.client.view.BannerView;
import com.mycom.testmaven.client.view.ContentView;
import com.mycom.testmaven.client.view.MainView;
import com.mycom.testmaven.client.view.SidebarView;

/**
 * 
 * a pure Java GUI programming impl of MainView... 
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MainViewImpl extends Composite implements MainView{

	
	
//	private static Binder uiBinder = GWT.create(Binder.class);
	
	public interface Binder extends UiBinder <Widget, MainViewImpl>{
	}
	
	
	@UiField
	Panel bannerPanel;
	@UiField
	Panel sidebarPanel;
	@UiField
	Panel contentPanel;
	
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	@Inject
	public MainViewImpl(Binder binder) {
		initWidget(binder.createAndBindUi(this));
	}

	public void setBannerView(BannerView bannerView) {
		bannerPanel.add(bannerView);
	}

	public void setSidebarView(SidebarView sidebarView) {
		sidebarPanel.add(sidebarView);
	}

	public void setContentView(ContentView contentView) {
		contentPanel.add(contentView);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public Widget root() {
		return this;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}
}
