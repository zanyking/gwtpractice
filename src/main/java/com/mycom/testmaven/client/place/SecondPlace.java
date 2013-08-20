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
public class SecondPlace extends MyPlace{



	protected SecondPlace(String hash) {
		super(hash);
	}
	
	public static class Tokenizer implements PlaceTokenizer<SecondPlace>{
		@Override
		public SecondPlace getPlace(String token) {
 			return new SecondPlace(token);
		}
		@Override
		public String getToken(SecondPlace place) {
			return place.getHash();
		}
	}
	public String getBgColor(){
		return toMap().get("bg-color");
	}
	
	public String getColor(){
		return toMap().get("text-color");
	}
	public static SecondPlace newInstance(String bgColor, String textColor){
		Map<String, String> params = new HashMap<String, String>();
		params.put("bg-color", bgColor);
		params.put("text-color", textColor);
		return new SecondPlace(LocalHashs.toHash(params));
	}
	
}
