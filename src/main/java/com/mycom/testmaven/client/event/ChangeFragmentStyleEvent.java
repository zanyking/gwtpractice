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
public class ChangeFragmentStyleEvent extends Event<ChangeFragmentStyleEvent.Handler> {

	public interface Handler extends EventHandler{
		
		void chanageFragementStyle(MyPlace myPlace);
		
	}
	public static final Type<Handler> TYPE = 
			new Type<Handler>();
	
	private MyPlace myPlace;
	
	/**
	 * 
	 * @param myPlace
	 */
	public ChangeFragmentStyleEvent(MyPlace myPlace) {
		this.myPlace = myPlace;
	}

	@Override
	public Event.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.chanageFragementStyle(myPlace);
	}

	
	

}
