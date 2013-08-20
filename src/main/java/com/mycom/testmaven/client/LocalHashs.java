/**
 * 
 */
package com.mycom.testmaven.client;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class LocalHashs {

	/**
	 * 
	 * @param hash
	 * @return
	 */
	public static Map<String, String> toMap(String hash) {
		Map<String, String> ans = new HashMap<String, String>();
		
		String[] pairs = hash.split("[\\/]");
		String[] kvs = null;
		for(String pair : pairs){
			kvs = pair.split("=");
			System.out.println("KVs="+kvs[0]+" , "+kvs[1]);
			ans.put(kvs[0], kvs[1]);
		}
		return ans;
	}

	/**
	 * 
	 * @param params
	 * @return
	 */
	public static String toHash(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getValue() != null) {
				sb.append(entry.getKey()).append("=").append(entry.getValue())
						.append("/");
			}
		}
		return sb.toString();
	}
	
}
