/**
 * 
 */
package com.mycom.testmaven.client.view.impl;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
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

	
	
	private static MainViewLayoutPanelUiBinder uiBinder = GWT
            .create(MainViewLayoutPanelUiBinder.class);
	
	public interface MainViewLayoutPanelUiBinder extends UiBinder <Widget, MainViewImpl>{
	}
	
	
	@UiField
	Panel bannerPanel;
	@UiField
	Panel sidebarPanel;
	@UiField
	Panel contentPanel;
	
	@Inject
	public MainViewImpl(BannerView bannerView, 
			SidebarView sidebarView,
			ContentView contentView) {
		initWidget(uiBinder.createAndBindUi(this));
		bannerPanel.add(bannerView);
		
		sidebarPanel.add(sidebarView);
		
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
}
