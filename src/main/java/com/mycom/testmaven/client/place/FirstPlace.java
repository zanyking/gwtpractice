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
public class FirstPlace extends MyPlace{
	
	public FirstPlace() {
		super();
	}

	protected FirstPlace(String hash) {
		super(hash);
	}

	public static class Tokenizer implements PlaceTokenizer<FirstPlace>{
		@Override
		public FirstPlace getPlace(String token) {
 			return new FirstPlace(token);
		}
		@Override
		public String getToken(FirstPlace place) {
			return place.getHash();
		}
	}
	
	public String getBgColor(){
		return toMap().get("bg-color");
	}
	
	public String getColor(){
		return toMap().get("text-color");
	}
	
	public static FirstPlace newInstance(String bgColor, String textColor){
		Map<String, String> params = new HashMap<String, String>();
		params.put("bg-color", bgColor);
		params.put("text-color", textColor);
		return new FirstPlace(LocalHashs.toHash(params));
	}
}
