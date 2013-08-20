/**
 * 
 */
package com.mycom.testmaven.client.view;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.mycom.testmaven.client.place.MyPlace;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface MainView extends IsWidget{
	/**
	 * the root widget of main view.
	 * @return
	 */
	Widget root();
	
	/**
	 * @author Ian YT Tsai (Zanyking)
	 */
	interface Presenter extends Activity{
		
		void goTo(MyPlace place);

		MyPlace getWhere();
		
		void init();
	}//end of class...
	
}
