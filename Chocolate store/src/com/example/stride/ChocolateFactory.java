package com.example.stride;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class ChocolateFactory {

	LinkedHashMap<String,Integer> totalOrders = null;
	PromotionRules rules = null;
	List<String> alreadyVisited = null;
	ArrayList<String> promo = null;
	ListIterator<String> ii = null;

	public Chocolate getchocolate(String chocoType){

		
		
		if(chocoType == null){
			return null;
		}		
		if(chocoType.equalsIgnoreCase("dark")){
			return new DarkChocolate();
		}
		if(chocoType.equalsIgnoreCase("milk")){
			return new MilkChocolate();
		}
		if(chocoType.equalsIgnoreCase("white")){
			return new WhiteChocolate();
		}
		if(chocoType.equalsIgnoreCase("sugar free")){
			return new SugarFreeChocolate();
		}
		return null;
	}

	public LinkedHashMap<String,Integer> processOrder(Chocolate choco, String type){

		totalOrders = new LinkedHashMap<String,Integer>();
		rules = new PromotionRules();
		alreadyVisited = new LinkedList<String>();
		
		int numchocolates = (int)(choco.getCash()/choco.getPrice());
		totalOrders.put(type, numchocolates);

		
		PromotionRules rules = new PromotionRules();
		promo = rules.getchocolate(type);

		int counter =0;
		for (ii = promo.listIterator(); ii.hasNext();) {
			String[] str = ii.next().split(",");
			String key = str[0];
			int value = Integer.parseInt(str[1]);
			alreadyVisited.add(key);
			if(key.equalsIgnoreCase(type)){
				processChocolateOrder(type,choco,numchocolates,key,value,counter,promo);
			}else{
				processChocolateOrder(type,choco,totalOrders.get(key),key,value,counter,promo);				
			}
		}
		System.out.println(totalOrders);
		return totalOrders;
		
	}
	
	public void processChocolateOrder(String type,Chocolate choco,int numchocolates, String key, int value,int counter,ArrayList<String> promo){
		while(numchocolates >=choco.getWrappers()){
			counter = counter + value;
			//sugarFreeCounter = sugarFreeCounter+ sufree;
			int remaingChoco = (numchocolates % choco.getWrappers());
			int chocosToTrade = (numchocolates - (remaingChoco)) ;
			int chocoReturnedUnits = (int)chocosToTrade/choco.getWrappers();
			if(!key.equalsIgnoreCase(type)){
				ArrayList<String> promoNew = rules.getchocolate(key);
				for (ListIterator<String> i = promoNew.listIterator(); i.hasNext();) {
					String str = i.next();
					if(!promo.contains(str)){
						ii.add(str);
						ii.previous();
					}
				}				
			}
			updateCholate(promo,key,chocoReturnedUnits);
			totalOrders.put(key, totalOrders.get(key)+chocoReturnedUnits*value);
			numchocolates = remaingChoco + chocoReturnedUnits*value;
			counter--;
		}
	}

	public void updateCholate(ArrayList<String> promo,String keyMain, int chocoReturnedUnits){		

		for (ListIterator<String> i = promo.listIterator(); i.hasNext();) {
			String[] str = i.next().split(",");
			String key = str[0];
			int value = Integer.parseInt(str[1]);
			if(!alreadyVisited.contains(key)){
				if(!totalOrders.containsKey(key)){
					totalOrders.put(key, chocoReturnedUnits * value);
				}else{
					totalOrders.put(key, totalOrders.get(key)+value);	
				}	
			}else{
				totalOrders.put(key, totalOrders.get(key));				
			}
		}
	}

}
