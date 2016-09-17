package es.uem.aju.common.util;

public class StringUtils {	
	
	public static boolean isNumber(String number){
		try{
			Integer.parseInt(number);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}
