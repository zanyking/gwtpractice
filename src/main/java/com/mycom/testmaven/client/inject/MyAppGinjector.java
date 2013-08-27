/**
 * 
 */
package com.mycom.testmaven.client.inject;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.app.ApplicationContext;
import com.mycom.testmaven.client.app.UIInitiator;
import com.mycom.testmaven.client.view.MainView;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
@GinModules(MyAppGinModule.class)
public interface MyAppGinjector extends Ginjector {

	MyAppGinjector DEFAULT = GWT.create(MyAppGinjector.class);
	PlaceController getPlaceController();
	EventBus getEventBus();
	MainView.Presenter getMainActivity();
	ApplicationContext getAppContext();
	
	UIInitiator getUIInitiator();
}
