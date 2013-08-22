/**
 * 
 */
package com.mycom.testmaven.client.presenter;

import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.mycom.testmaven.client.place.ThirdPlace;
import com.mycom.testmaven.client.view.ContentView;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
@RunWith(JukitoRunner.class)
public class TestContentPresenter {
	public static class Module extends JukitoModule {
		protected void configureTest() {
			bind(ContentPresenter.class);
			bindMock(ContentView.class);
			bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
			
		}
	}

	@Test
	public void test(ContentPresenter cp) {
		cp.restoreState(ThirdPlace.newInstance("white", "black"));
		
	}
}
