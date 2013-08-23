/**
 * 
 */
package com.mycom.testmaven.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

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
