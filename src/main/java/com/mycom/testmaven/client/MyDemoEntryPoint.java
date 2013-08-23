/**
 * 
 */
package com.mycom.testmaven.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.mycom.testmaven.client.inject.MyAppGinjector;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class MyDemoEntryPoint implements EntryPoint {

	// place mapping...

	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

		MyAppGinjector.DEFAULT.getAppContext().handleCurrentHistory();
	}

}
