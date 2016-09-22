package com.example.stride;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PromotionRules {

	ArrayList<String> promo = new ArrayList<String>();
	
	public ArrayList<String> getchocolate(String chocoType){

		if(chocoType == null){
			return null;
		}		
		if(chocoType.equalsIgnoreCase("dark")){
			promo.add("dark,1");		
		}
		if(chocoType.equalsIgnoreCase("milk")){
			promo.add("milk,1");	
			promo.add("sugar free,1");			
		}
		if(chocoType.equalsIgnoreCase("white")){
			promo.add("white,1");	
			promo.add("sugar free,1");			
		}
		if(chocoType.equalsIgnoreCase("sugar free")){			
			promo.add("sugar free,1");	
			promo.add("dark,1");	
		}
		return promo;
	}
}
