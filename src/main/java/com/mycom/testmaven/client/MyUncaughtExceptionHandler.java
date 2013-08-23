/**
 * 
 */
package com.mycom.testmaven.client;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.GWT.UncaughtExceptionHandler#onUncaughtException(java.lang.Throwable)
	 */
	@Override
	public void onUncaughtException(Throwable e) {
		e.printStackTrace();
	}

}
