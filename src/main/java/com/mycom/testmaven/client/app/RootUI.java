/**
 * 
 */
package com.mycom.testmaven.client.app;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.activity.NovaActivity;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class RootUI extends SimpleLayoutPanel implements UIInitiator {

	@Override
	public Widget init(ApplicationContext appCtx) {
		EventBus placeActivityEvtBus = appCtx.getPlaceActivityEventBus();
		
		

		// TODO: initialize North
		// TODO: initialize West
		// TODO: initialize Top
		// TODO: initialize Center

		return this;
	}

	private static void initRegion(final EventBus evtBus){
		
		ActivityManager headerActManager = new ActivityManager(
				new ActivityMapper() {
					@Override
					public Activity getActivity(Place place) {
						// TODO
						return null;
					}
				}, evtBus);
		headerActManager.setDisplay(new AcceptsOneWidget() {
			@Override
			public void setWidget(IsWidget w) {
				// TODO
			}
		});
	}
	
	interface RegionDef{
		NovaActivity createActivity(ApplicationContext appCtx);
	}
	
}

