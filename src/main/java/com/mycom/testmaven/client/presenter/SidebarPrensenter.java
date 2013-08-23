/**
 * 
 */
package com.mycom.testmaven.client.presenter;

import javax.inject.Inject;

import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.event.ChangeFragmentStyleEvent;
import com.mycom.testmaven.client.place.FirstPlace;
import com.mycom.testmaven.client.place.MyPlace;
import com.mycom.testmaven.client.place.SecondPlace;
import com.mycom.testmaven.client.place.ThirdPlace;
import com.mycom.testmaven.client.view.SidebarView;
import com.mycom.testmaven.client.view.SidebarView.Presenter;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class SidebarPrensenter extends AbstractPresenter implements Presenter {
	
	private SidebarView view;
	
	@Inject
	public SidebarPrensenter(SidebarView view, EventBus evtBus) {
		super(evtBus);
		this.view = view;
		view.setPresenter(this);
	}
	
	protected void restoreState(Place mp){
		String bgColor = "";
		String color = "";
		
		if(mp instanceof FirstPlace){
			FirstPlace fp = (FirstPlace) mp;
			if(!fp.isEmpty()){
				view.setSidebarBackGroundColorInput(bgColor = fp.getBgColor());
				view.setSidebarLabelColorInput(color = fp.getColor());	
			}
		}else if(mp instanceof SecondPlace){
			SecondPlace sp = (SecondPlace) mp;
			if(!sp.isEmpty()){
				view.setBannerBackGroundColorInput(sp.getBgColor());
				view.setBannerLabelColorInput(sp.getColor());	
			}
		}else if(mp instanceof ThirdPlace){
			ThirdPlace tp = (ThirdPlace)mp;
			if(!tp.isEmpty()){
				view.setContentBackGroundColorInput(tp.getBgColor());
				view.setContentLabelColorInput(tp.getColor());	
			}
		}
		view.setSidebarBackGroundColor(bgColor);
		view.setSidebarLabelColor(color);
	}

	@Override
	public void goToFirst() {
		FirstPlace newPlace = FirstPlace.newInstance(
				view.getSidebarBackgroundColorInput(), 
				view.getSidebarLabelColorInput());
		fireStyleChange(newPlace);
	}
	@Override
	public void goToSecond() {
		SecondPlace newPlace = SecondPlace.newInstance(
				view.getBannerBackgroundColorInput(), 
				view.getBannerLabelColorInput());
		fireStyleChange(newPlace);
	}
	@Override
	public void goToThird() {
		ThirdPlace newPlace = ThirdPlace.newInstance(
				view.getContentBackgroundColorInput(), 
				view.getContentLabelColorInput());
		fireStyleChange(newPlace);
	}

	private void fireStyleChange(MyPlace newPlace){
		//XXX trigger point of firing PlaceChangeEvent.
		//publish 
		evtBus.fireEvent(new ChangeFragmentStyleEvent(newPlace));
	}

	@Override
	public SidebarView getView() {
		return view;
	}
	
}