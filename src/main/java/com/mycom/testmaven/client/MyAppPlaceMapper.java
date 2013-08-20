/**
 * 
 */
package com.mycom.testmaven.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.mycom.testmaven.client.place.FirstPlace;
import com.mycom.testmaven.client.place.SecondPlace;
import com.mycom.testmaven.client.place.ThirdPlace;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
@WithTokenizers({
	FirstPlace.Tokenizer.class,
	SecondPlace.Tokenizer.class,
	ThirdPlace.Tokenizer.class
})
public interface MyAppPlaceMapper extends PlaceHistoryMapper{

}
