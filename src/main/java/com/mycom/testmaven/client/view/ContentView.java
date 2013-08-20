/**
 * 
 */
package com.mycom.testmaven.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * 
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface ContentView  extends IsWidget{
	/**
	 * 
	 * @param color
	 */
	void setBackGroundColor(String color);
	/**
	 * 
	 * @param color
	 */
	void setTextColor(String color);
	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	interface Presenter{
		void setView(ContentView view);//XXX reverse control due to UiBinder
	}
}
