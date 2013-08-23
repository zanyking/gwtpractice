/**
 * 
 */
package com.mycom.testmaven.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.mycom.testmaven.client.inject.MyAppGinjector;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class MyAppActivityMapper implements ActivityMapper {

	private MyAppGinjector injector;

	public MyAppActivityMapper(MyAppGinjector injector) {
		this.injector = injector;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.
	 * gwt.place.shared.Place)
	 */
	@Override
	public Activity getActivity(Place place) {
		// Detecting place to use different setting, but I see no point in
		// current scenario, do it in the future.
		System.out.println(">>>>>>> mapping activity to place: "+place);
		Activity mainPresenter = injector.getMainActivity();
		return mainPresenter;
	}

}
