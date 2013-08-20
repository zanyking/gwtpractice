/**
 * 
 */
package com.mycom.testmaven.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;
import com.mycom.testmaven.client.place.MyPlace;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class ToChangePlaceEvent extends Event<ToChangePlaceEvent.Handler> {

	public interface Handler extends EventHandler{
		
		void onPlaceChanged(MyPlace myPlace);
		
	}
	public static final Type<Handler> TYPE = 
			new Type<Handler>();
	
	private MyPlace myPlace;
	
	/**
	 * 
	 * @param myPlace
	 */
	public ToChangePlaceEvent(MyPlace myPlace) {
		this.myPlace = myPlace;
	}

	@Override
	public Event.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onPlaceChanged(myPlace);
	}

	
	

}
