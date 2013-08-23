/**
 * 
 */
package com.mycom.testmaven.client.inject;

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
	PlaceController getPlaceController();
	
	void handleCurrentHistory();
}
