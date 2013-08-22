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

	void setBackGroundColor(String color);

	void setTextColor(String color);
	
	void setPresenter(Presenter presenter);
	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	interface Presenter{
		ContentView getView();
	}
}
