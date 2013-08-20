/**
 * 
 */
package com.mycom.testmaven.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.Event;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class InitStateEvent extends Event<InitStateEvent.Handler> {
	
	public static final Type<Handler> TYPE = 
			new Type<Handler>();
	
	public interface Handler extends EventHandler{
		void onInit(Place place);
	}

	private Place place;
	
	public InitStateEvent(Place place) {
		this.place = place;
	}

	@Override
	public Event.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onInit(place);
	}
}
