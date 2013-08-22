/**
 * 
 */
package com.mycom.testmaven.client.presenter;

import javax.inject.Inject;

import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.place.ThirdPlace;
import com.mycom.testmaven.client.view.ContentView;
import com.mycom.testmaven.client.view.ContentView.Presenter;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class ContentPresenter extends AbstractPresenter implements Presenter {
	
	private ContentView view;

	@Inject
	public ContentPresenter(ContentView view, 
			EventBus evtBus) {
		super(evtBus);
		this.view = view;
		view.setPresenter(this);
	}
	
	protected void restoreState(Place myPlace){
		String bgColor = "";
		String color = "";
		if(myPlace instanceof ThirdPlace){
			ThirdPlace tp = (ThirdPlace) myPlace;
			bgColor = tp.getBgColor();
			color = tp.getColor();	
		}
		view.setBackGroundColor(bgColor);
		view.setTextColor(color);
	}

	@Override
	public ContentView getView() {
		return view;
	}

}
