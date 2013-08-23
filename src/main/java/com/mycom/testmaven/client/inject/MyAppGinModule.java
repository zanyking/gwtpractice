/**
 * 
 */
package com.mycom.testmaven.client.inject;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.mycom.testmaven.client.MyPlaceController;
import com.mycom.testmaven.client.activity.MainPresenterActivity;
import com.mycom.testmaven.client.presenter.BannerPresenter;
import com.mycom.testmaven.client.presenter.ContentPresenter;
import com.mycom.testmaven.client.presenter.SidebarPrensenter;
import com.mycom.testmaven.client.view.BannerView;
import com.mycom.testmaven.client.view.ContentView;
import com.mycom.testmaven.client.view.MainView;
import com.mycom.testmaven.client.view.SidebarView;
import com.mycom.testmaven.client.view.impl.BannerViewImpl;
import com.mycom.testmaven.client.view.impl.ContentViewImpl;
import com.mycom.testmaven.client.view.impl.MainViewImpl;
import com.mycom.testmaven.client.view.impl.SidebarViewImpl;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyAppGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		//all presenter should depends on this event bus.
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		//experimental stuff...
		bind(PlaceController.class).to(MyPlaceController.class).in(Singleton.class);
		bind(ApplicationContext.class).to(ApplicationContextImpl.class).in(Singleton.class);
		
		// binding view implementations.
		bind(ContentView.class).to(ContentViewImpl.class);
		bind(BannerView.class).to(BannerViewImpl.class);
		bind(SidebarView.class).to(SidebarViewImpl.class);
		
		//bind presenter impls...
		bind(ContentView.Presenter.class).to(ContentPresenter.class);
		bind(BannerView.Presenter.class).to(BannerPresenter.class);
		bind(SidebarView.Presenter.class).to(SidebarPrensenter.class);
		
		// entrypoint view.
		bind(MainView.class).to(MainViewImpl.class).in(Singleton.class);
		bind(MainView.Presenter.class).to(MainPresenterActivity.class).in(Singleton.class);
		
	}

}
