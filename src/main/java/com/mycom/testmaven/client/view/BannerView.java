/**
 * 
 */
package com.mycom.testmaven.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface BannerView  extends IsWidget{

	void setUserName(String name);
	
	void setTitle(String newTile);

	void setBackGroundColor(String bgColor);

	void setTextColor(String color);
	

	interface Presenter{
		void setUserName(String txt);
		BannerView getView();//XXX reverse control due to UiBinder
	}
	

	
	void setPresenter(Presenter presenter);
}
