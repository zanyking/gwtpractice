/**
 * 
 */
package com.mycom.testmaven.client.presenter;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.event.InitStateEvent;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public abstract class AbstractPresenter {
	protected EventBus evtBus;

	public AbstractPresenter(EventBus evtBus) {
		this.evtBus = evtBus;
		evtBus.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler(){
			@Override
			public void onPlaceChange(PlaceChangeEvent event) {
				Place place = event.getNewPlace();
				System.out.println(this.getClass()+" handling PlaceChangeEvent...");
				restoreState(place);
			}});
		evtBus.addHandler(InitStateEvent.TYPE, new InitStateEvent.Handler(){
			public void onInit(Place place) {
				System.out.println(this.getClass()+" handling InitStateEvent...");
				restoreState(place);
			}});
		
	}

	protected abstract void restoreState(Place place) ;
	
	
}
