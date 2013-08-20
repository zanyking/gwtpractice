/**
 * 
 */
package com.mycom.testmaven.client.view.impl;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mycom.testmaven.client.view.SidebarView;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class SidebarViewImpl extends VerticalPanel implements SidebarView, ClickHandler{

	private Presenter presenter;
	
	@Inject
	public SidebarViewImpl(Presenter presenter) {
		this.presenter = presenter;
		presenter.setView(this);
		drawFirst();
		this.add(new Label("====================="));
		drawSecond();
		this.add(new Label("====================="));
		drawThird();
	}

	private TextBox sidebarBgColorTxb;
	private TextBox sidebarTextColorTxb;
	private Anchor goToFirst;
	private void drawFirst(){
		Label label = new Label("Sidebar background-color: ");
		this.add(label);
		
		sidebarBgColorTxb = new TextBox();
		sidebarBgColorTxb.setValue("#33FFCC");
		this.add(sidebarBgColorTxb);
		
		label = new Label("Sidebar label-color: ");
		this.add(label);
		
		sidebarTextColorTxb = new TextBox();
		sidebarTextColorTxb.setValue("#FF6633");
		this.add(sidebarTextColorTxb);
		
		goToFirst = new Anchor("goto First");
		goToFirst.addClickHandler(this);
		this.add(goToFirst);
	}
	
	private TextBox bannerBgColorTxb;
	private TextBox bannerTextColorTxb;
	private Anchor goToSecond;
	private void drawSecond(){
		Label label = new Label("Banner background-color: ");
		this.add(label);
		
		bannerBgColorTxb = new TextBox();
		bannerBgColorTxb.setValue("#FF6633");
		this.add(bannerBgColorTxb);
		
		label = new Label("Banner text-color: ");
		this.add(label);
		
		bannerTextColorTxb = new TextBox();
		bannerTextColorTxb.setValue("#FFCC33");
		this.add(bannerTextColorTxb);
		
		goToSecond = new Anchor("goto second");
		this.add(goToSecond);
		goToSecond.addClickHandler(this);
	}
	
	private TextBox contentBgColorTxb;
	private TextBox contentTextColorTxb;
	private Anchor goToThird;
	private void drawThird(){
		Label label = new Label("background-color: ");
		this.add(label);
		
		contentBgColorTxb = new TextBox();
		contentBgColorTxb.setValue("#FF3333");
		this.add(contentBgColorTxb);
		
		label = new Label("text-color: ");
		this.add(label);
		
		contentTextColorTxb = new TextBox();
		contentTextColorTxb.setValue("#5CB800");
		this.add(contentTextColorTxb);
		
		goToThird = new Anchor("goto third");
		this.add(goToThird);
		goToThird.addClickHandler(this);
	}

	
	
	@Override
	public Widget asWidget() {
		return this;
	}

	
	@Override
	public void onClick(ClickEvent event) {
		System.out.println("link click source: "+event.getSource());
		if(goToFirst == event.getSource())
			presenter.goToFirst();
		else if(goToSecond == event.getSource())
			presenter.goToSecond();
		else if(goToThird == event.getSource())
			presenter.goToThird();
	}
	
	
	
	@Override
	public String getSidebarBackgroundColorInput() {
		return sidebarBgColorTxb.getValue();
	}
	@Override
	public String getSidebarLabelColorInput() {
		return sidebarTextColorTxb.getValue();
	}
	@Override
	public String getBannerBackgroundColorInput() {
		return bannerBgColorTxb.getValue();
	}
	@Override
	public String getBannerLabelColorInput() {
		return bannerTextColorTxb.getValue();
	}
	@Override
	public String getContentBackgroundColorInput() {
		return contentBgColorTxb.getValue();
	}
	@Override
	public String getContentLabelColorInput() {
		return contentTextColorTxb.getValue();
	}

	@Override
	public void setSidebarBackGroundColorInput(String bgColor) {
		sidebarBgColorTxb.setValue(bgColor);
	}
	public void setSidebarBackGroundColor(String bgColor) {
		this.getElement().getStyle().setBackgroundColor(bgColor);
	}
	public void setSidebarLabelColor(String color) {
		this.getElement().getStyle().setColor(color);		
	}

	@Override
	public void setSidebarLabelColorInput(String color) {
		sidebarTextColorTxb.setValue(color);
	}
	@Override
	public void setBannerBackGroundColorInput(String bgColor) {
		bannerBgColorTxb.setValue(bgColor);
	}
	@Override
	public void setBannerLabelColorInput(String color) {
		bannerTextColorTxb.setValue(color);
	}
	@Override
	public void setContentBackGroundColorInput(String bgColor) {
		contentBgColorTxb.setValue(bgColor);
	}
	@Override
	public void setContentLabelColorInput(String color) {
		contentTextColorTxb.setValue(color);
	}
	
	
}
