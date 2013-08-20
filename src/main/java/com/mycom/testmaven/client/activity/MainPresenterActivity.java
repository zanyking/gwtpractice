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
import com.mycom.testmaven.client.event.ToChangePlaceEvent;
import com.mycom.testmaven.client.place.MyPlace;
import com.mycom.testmaven.client.view.MainView;

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
			EventBus evtBus,
			PlaceController placeController) {
		this.evtBus = evtBus;
		this.placeController = placeController;
		this.view = view;
		evtBus.addHandler(ToChangePlaceEvent.TYPE, new ToChangePlaceEvent.Handler() {
			public void onPlaceChanged(MyPlace myPlace) {
				goTo(myPlace);
			}
		});
	}

	

	@Override
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus) {
		try{
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
