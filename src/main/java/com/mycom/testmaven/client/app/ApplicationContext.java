/**
 * 
 */
package com.mycom.testmaven.client.app;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public interface ApplicationContext {
	/**
	 * 
	 * @return
	 */
	EventBus getMainEventBus();
	/**
	 * 
	 * @return
	 */
	EventBus getPlaceActivityEventBus();
	/**
	 * 
	 * @return
	 */
	PlaceController getPlaceController();
	/**
	 * 
	 */
	void handleCurrentHistory();
}
