package es.uem.aju.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.uem.aju.common.dto.BaseDTO;

public class JSONObjectParser {

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static <T extends BaseDTO> T fromJSonToObject(String json, Class<T> type){
		return type.cast(gson.fromJson(json, type));		
	}
	
	public static String fromObjectToJson(Object obj){
		return gson.toJson(obj);
	}
}
