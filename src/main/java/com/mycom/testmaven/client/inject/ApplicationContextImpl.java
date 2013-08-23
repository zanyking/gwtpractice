/**
 * 
 */
package com.mycom.testmaven.client.inject;

import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.MyAppPlaceMapper;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class ApplicationContextImpl implements ApplicationContext {

	private final PlaceHistoryHandler historyHandler;
	private final PlaceController placeController;
	private Place defaultPlace;

	@Inject
	public ApplicationContextImpl(Provider<EventBus> eventBusProvider) {
		
		historyHandler = new PlaceHistoryHandler( 
				(PlaceHistoryMapper) GWT.create(MyAppPlaceMapper.class));
		
		EventBus placeActivityEvtBus = eventBusProvider.get();

		placeController = new PlaceController(placeActivityEvtBus);

		SimpleLayoutPanel appWidget = new SimpleLayoutPanel();
		//TODO: configure appWidget style...
		ActivityManager activityManager = new ActivityManager(, placeActivityEvtBus);
		
        activityManager.setDisplay(appWidget);
		historyHandler.register(
				placeController, 
				placeActivityEvtBus, 
				defaultPlace);
		
		RootLayoutPanel.get().add(appWidget);
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycom.testmaven.client.inject.ApplicationContext#getMainEventBus()
	 */
	@Override
	public EventBus getMainEventBus() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycom.testmaven.client.inject.ApplicationContext#getPlaceController()
	 */
	@Override
	public PlaceController getPlaceController() {
		return null;
	}

}
