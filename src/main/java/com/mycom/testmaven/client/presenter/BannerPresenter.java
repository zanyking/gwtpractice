/**
 * 
 */
package com.mycom.testmaven.client.presenter;

import javax.inject.Inject;

import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.EventBus;
import com.mycom.testmaven.client.event.UserChangeEvent;
import com.mycom.testmaven.client.place.SecondPlace;
import com.mycom.testmaven.client.view.BannerView;
import com.mycom.testmaven.client.view.BannerView.Presenter;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class BannerPresenter extends AbstractPresenter implements Presenter {

	private BannerView view;

	/**
	 * 
	 * @param view
	 * @param evtBus
	 */
	@Inject
	public BannerPresenter(BannerView view, 
			EventBus evtBus) {
		super(evtBus);
		this.view = view;
		view.setPresenter(this);
	}

	protected void restoreState(Place mp) {
		String bgColor = "";
		String color = "";
		//strategy 2
//		FragmentStyle fstl = mp.getFragmentStyle();
//		if(fstl.hasBannerStyle()){
//			
//		}
		//strategy 1
		if(mp instanceof SecondPlace){
			SecondPlace tp = (SecondPlace) mp;
			bgColor = tp.getBgColor();
			color = tp.getColor();	
		}
		view.setBackGroundColor(bgColor);
		view.setTextColor(color);
		
	}

	@Override
	public void setUserName(String newUserName) {
		evtBus.fireEvent(new UserChangeEvent(newUserName));
		view.setTitle("hello! " + newUserName);
		view.setUserName(newUserName);
	}

	@Override
	public BannerView getView() {
		return view;
	}





}
