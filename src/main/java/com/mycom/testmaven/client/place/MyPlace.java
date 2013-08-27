/**
 * 
 */
package com.mycom.testmaven.client.place;

import java.util.Collections;
import java.util.Map;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.mycom.testmaven.client.LocalHashs;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public abstract class MyPlace extends Place {

	
	public static final Class<?>[] Tokenizers = 
			new Class<?>[]{
		
	};
	
	protected String hash;

	public MyPlace(){};
	
	public MyPlace(String hash){
		this.hash = hash;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return this.getClass()+" [hash=" + hash + "]";
	}
	
	public Map<String, String> toMap(){
		if(hash==null||hash.isEmpty())
			return Collections.EMPTY_MAP;
		return LocalHashs.toMap(hash);
	}
	
	public boolean isEmpty(){
		return hash==null || hash.isEmpty();
	}
}
