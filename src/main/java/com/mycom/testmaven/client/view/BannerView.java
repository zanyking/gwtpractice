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

	/**
	 * 
	 * @param name
	 */
	void setUserName(String name);
	
	/**
	 * 
	 * @param newTile
	 */
	void setTitle(String newTile);
	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	interface Presenter{
		void setUserName(String txt);
		void setView(BannerView view);//XXX reverse control due to UiBinder
	}
	
	void setBackGroundColor(String bgColor);

	void setTextColor(String color);
}
