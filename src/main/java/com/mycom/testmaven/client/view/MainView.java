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
	
	public void setBannerView(BannerView bannerView);
	public void setSidebarView(SidebarView sidebarView);
	public void setContentView(ContentView contentView);

	/**
	 * @author Ian YT Tsai (Zanyking)
	 */
	interface Presenter extends Activity{
		
		void goTo(MyPlace place);

		MyPlace getWhere();
		
		void init();
		
//		void setBannerView(BannerView bannerView);
//		void setSidebarView(SidebarView sidebarView);
//		void setContentView(ContentView contentView);
	}//end of class...

	void setPresenter(Presenter presenter);
	
}
