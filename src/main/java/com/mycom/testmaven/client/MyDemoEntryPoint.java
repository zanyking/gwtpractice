/**
 * 
 */
package com.mycom.testmaven.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.mycom.testmaven.client.inject.MyAppGinjector;
import com.mycom.testmaven.client.place.FirstPlace;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class MyDemoEntryPoint implements EntryPoint {

	// place mapping...
	Place defaultPlace = new FirstPlace();

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

		MyAppGinjector.DEFAULT.getAppContext().handleCurrentHistory();
	}

}
