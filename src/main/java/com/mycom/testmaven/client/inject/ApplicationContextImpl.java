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
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.place.FirstPlace;
import com.mycom.testmaven.client.place.MyAppPlaceHistoryMapper;

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
				(PlaceHistoryMapper) GWT.create(MyAppPlaceHistoryMapper.class));
		mainEventBus = eventBusProvider.get();
		
		EventBus placeActivityEvtBus = eventBusProvider.get();

		placeController = new PlaceController(placeActivityEvtBus);
		historyHandler.register(
				placeController, 
				placeActivityEvtBus, 
				defaultPlace);

		SimpleLayoutPanel appWidget = new SimpleLayoutPanel();
		
		initActivityManagement(placeActivityEvtBus, appWidget);

		RootLayoutPanel.get().add(appWidget);
	}
	
	
	private void initActivityManagement( EventBus placeActivityEvtBus, 
			AcceptsOneWidget appWidget){
		//TODO: configure appWidget style...
		ActivityManager activityManager = new ActivityManager(
				new ActivityMapper() {
					@Override
					public Activity getActivity(Place place) {
						return MyAppGinjector.DEFAULT.getMainActivity();
					}
				}, placeActivityEvtBus);
		
		//TODO: init MasterV
		//TODO: init MasterH
		//TODO: init Content
		//TODO: init aside
		
        activityManager.setDisplay(appWidget);
	}
	

	@Override
	public EventBus getMainEventBus() {
		return mainEventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public void handleCurrentHistory() {
		historyHandler.handleCurrentHistory();
	}

}
