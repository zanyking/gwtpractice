/**
 * 
 */
package com.mycom.testmaven.client.place;

import javax.inject.Inject;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyPlaceController extends PlaceController {

	@Inject
	public MyPlaceController(EventBus eventBus) {
		super(eventBus);
	}

}
