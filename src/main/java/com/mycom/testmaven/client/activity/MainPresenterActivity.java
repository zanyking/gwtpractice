/**
 * 
 */
package com.mycom.testmaven.client.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.event.InitStateEvent;
import com.mycom.testmaven.client.event.ChangeFragmentStyleEvent;
import com.mycom.testmaven.client.place.MyPlace;
import com.mycom.testmaven.client.view.BannerView;
import com.mycom.testmaven.client.view.ContentView;
import com.mycom.testmaven.client.view.MainView;
import com.mycom.testmaven.client.view.SidebarView;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MainPresenterActivity extends AbstractActivity implements MainView.Presenter{
	private MainView view;
	
	private PlaceController placeController;
	private EventBus evtBus;

	
	
	@Inject
	public MainPresenterActivity(MainView view,
			BannerView.Presenter bannerPresenter,
			SidebarView.Presenter sidebarPresenter,
			ContentView.Presenter contentPresenter,
			EventBus evtBus,
			PlaceController placeController) {
		this.evtBus = evtBus;
		this.placeController = placeController;
		this.view = view;
		view.setPresenter(this);
		//init view
		view.setBannerView(bannerPresenter.getView());
		view.setSidebarView(sidebarPresenter.getView());
		view.setContentView(contentPresenter.getView());
		//subscribe...
		evtBus.addHandler(ChangeFragmentStyleEvent.TYPE, 
				new ChangeFragmentStyleEvent.Handler() {
			public void chanageFragementStyle(MyPlace myPlace) {
				goTo(myPlace);
			}
		});
	}

	@Override
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus) {
		try{
			//drawing...
			panel.setWidget(view.root());
		}catch(RuntimeException e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void goTo(MyPlace place) {
		placeController.goTo(place);
	}

	@Override
	public MyPlace getWhere() {
		return (MyPlace) placeController.getWhere();
	}

	public void init() {
		evtBus.fireEvent(new InitStateEvent(placeController.getWhere()));
	}


}
