/**
 * 
 */
package com.mycom.testmaven.client.actions;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class FragmentStyleAction {
	
	private EventBus evtBus;

	@Inject
	public FragmentStyleAction(EventBus evtBus) {
		this.evtBus = evtBus;
	}

	public void changeStyle(Fragment frg, FGStyle style){
		
	}
	
	
}
