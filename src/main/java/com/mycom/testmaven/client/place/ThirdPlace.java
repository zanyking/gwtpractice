/**
 * 
 */
package com.mycom.testmaven.client.place;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.mycom.testmaven.client.LocalHashs;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class ThirdPlace extends MyPlace{
	
	public ThirdPlace(String hash) {
		super(hash);
	}

	public static class Tokenizer implements PlaceTokenizer<ThirdPlace>{
		@Override
		public ThirdPlace getPlace(String token) {
 			return new ThirdPlace(token);
		}
		@Override
		public String getToken(ThirdPlace place) {
			return place.getHash();
		}
	}
	public String getBgColor(){
		return toMap().get("bg-color");
	}
	
	public String getColor(){
		return toMap().get("text-color");
	}
	public static ThirdPlace newInstance(String bgColor, String textColor){
		Map<String, String> params = new HashMap<String, String>();
		params.put("bg-color", bgColor);
		params.put("text-color", textColor);
		return new ThirdPlace(LocalHashs.toHash(params));
	}
}
