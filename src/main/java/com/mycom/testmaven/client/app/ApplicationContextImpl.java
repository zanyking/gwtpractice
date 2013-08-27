/**
 * 
 */
package com.mycom.testmaven.client.app;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.inject.MyAppGinjector;
import com.mycom.testmaven.client.place.FirstPlace;
import com.mycom.testmaven.client.place.MyAppPlaceHistoryMapper;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class ApplicationContextImpl implements ApplicationContext {

	private PlaceHistoryHandler historyHandler;
	private PlaceController placeController;
	private EventBus mainEventBus;
	private EventBus placeActivityEventBus;
	
	private Place defaultPlace = new FirstPlace();

	@Inject
	public ApplicationContextImpl(Provider<EventBus> eventBusProvider) {
		
		mainEventBus = eventBusProvider.get();
		
		placeActivityEventBus = initPlaceHistoryHandling(eventBusProvider);

		UIInitiator initiator = MyAppGinjector.DEFAULT.getUIInitiator();
		RootLayoutPanel.get().add(initiator.init(this));
	}




	private EventBus initPlaceHistoryHandling(
			Provider<EventBus> eventBusProvider) {
		historyHandler = new PlaceHistoryHandler( 
				(PlaceHistoryMapper) GWT.create(MyAppPlaceHistoryMapper.class));
		EventBus placeActivityEvtBus = eventBusProvider.get();
		placeController = new PlaceController(placeActivityEvtBus);
		historyHandler.register(
				placeController, 
				placeActivityEvtBus, 
				defaultPlace);
		return placeActivityEvtBus;
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

	
	public EventBus getPlaceActivityEventBus() {
		return placeActivityEventBus;
	}


	static class Skeleton extends Composite{

		public void setMasterV(IsWidget w) {
			// TODO Auto-generated method stub
			
		}

		public void setMasterH(IsWidget w) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
