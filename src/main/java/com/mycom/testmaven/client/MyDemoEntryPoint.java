/**
 * 
 */
package com.mycom.testmaven.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.mycom.testmaven.client.activity.MyAppActivityMapper;
import com.mycom.testmaven.client.place.FirstPlace;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyDemoEntryPoint implements EntryPoint  {

	
	//place mapping...
	MyAppPlaceMapper historyMapper = GWT.create(MyAppPlaceMapper.class);
	PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	Place defaultPlace = new FirstPlace();
	
	SimplePanel appWidget = new SimplePanel();
	MyAppGinjector injector;
	
	@Override
	public void onModuleLoad() {
		injector = GWT.create(MyAppGinjector.class);
		PlaceController placeController = injector.getPlaceController();
		
		//Start Activity mapping...
		//banner
		MyAppActivityMapper myMapper = new MyAppActivityMapper(injector);
		ActivityManager activityManager = new ActivityManager(myMapper, injector.getEventBus());
        activityManager.setDisplay(appWidget);

//        Widget.asWidgetOrNull(w);
        //sidebar
//        MyAppActivityMapper myMapper2 = new MyAppActivityMapper(injector);
//		ActivityManager activityManager2 = new ActivityManager(myMapper2, injector.getEventBus());
//        activityManager2.setDisplay(appWidget2);

        
        
		historyHandler.register(
				placeController, 
				injector.getEventBus(), 
				defaultPlace);
		
		RootPanel.get().add(appWidget);
		historyHandler.handleCurrentHistory();
		injector.getMainActivity().init();
	}

}
