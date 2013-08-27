/**
 * 
 */
package com.mycom.testmaven.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public abstract class NovaActivity extends AbstractActivity {

	/*
	 * Adapter between the old EventBus and the new one
	 */
	@Override
	@Deprecated
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus) {
		start(panel, (EventBus) eventBus);
	}

	protected abstract void start(AcceptsOneWidget panel, EventBus eventBus);
}
