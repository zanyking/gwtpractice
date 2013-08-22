/**
 * 
 */
package com.mycom.testmaven.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface SidebarView  extends IsWidget{

	String getSidebarBackgroundColorInput();
	String getSidebarLabelColorInput();
	String getBannerBackgroundColorInput();
	String getBannerLabelColorInput();
	String getContentBackgroundColorInput();
	String getContentLabelColorInput();
	
	void setSidebarBackGroundColor(String bgColor);
	void setSidebarLabelColor(String color);
	
	void setSidebarBackGroundColorInput(String bgColor);
	void setSidebarLabelColorInput(String color);
	void setBannerBackGroundColorInput(String bgColor);
	void setBannerLabelColorInput(String color);
	void setContentBackGroundColorInput(String bgColor);
	void setContentLabelColorInput(String color);
	
	
	void setPresenter(Presenter presenter);
	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	interface Presenter{
		SidebarView getView();
		
		void goToFirst();

		void goToSecond();

		void goToThird();
	}
	
}
