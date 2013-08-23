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
import com.mycom.testmaven.client.place.FirstPlace;
import com.mycom.testmaven.client.place.MyAppPlaceMapper;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class ApplicationContextImpl implements ApplicationContext {

	private final PlaceHistoryHandler historyHandler;
	private final PlaceController placeController;
	private final EventBus mainEventBus;
	
	private Place defaultPlace = new FirstPlace();

	@Inject
	public ApplicationContextImpl(Provider<EventBus> eventBusProvider) {
		
		historyHandler = new PlaceHistoryHandler( 
				(PlaceHistoryMapper) GWT.create(MyAppPlaceMapper.class));
		mainEventBus = eventBusProvider.get();
		
		EventBus placeActivityEvtBus = eventBusProvider.get();

		placeController = new PlaceController(placeActivityEvtBus);
		historyHandler.register(
				placeController, 
				placeActivityEvtBus, 
				defaultPlace);

		SimpleLayoutPanel appWidget = new SimpleLayoutPanel();
		
		//TODO: configure appWidget style...
		
		ActivityManager activityManager = new ActivityManager(
				new ActivityMapper() {
					@Override
					public Activity getActivity(Place place) {
						return MyAppGinjector.DEFAULT.getMainActivity();
					}
				}, placeActivityEvtBus);
        activityManager.setDisplay(appWidget);
        
		
		
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
		return mainEventBus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mycom.testmaven.client.inject.ApplicationContext#getPlaceController()
	 */
	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}



	@Override
	public void handleCurrentHistory() {
		historyHandler.handleCurrentHistory();
	}

}
