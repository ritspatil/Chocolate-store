package com.example.stride.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.junit.Before;
import org.junit.Test;
import com.example.stride.Chocolate;
import com.example.stride.ChocolateFactory;
import com.example.stride.PromotionRules;


public class ChocolateFactoryTestSpecs {

	private String type;
	private static LinkedHashMap<String,Integer> expectedResult;
	private Chocolate chocoType;	
	LinkedHashMap<String,Integer> totalOrders = null;
	PromotionRules rules = null;
	List<String> alreadyVisited = null;
	ArrayList<String> promo = null;
	ListIterator<String> ii = null;

	static ChocolateFactory fac = new ChocolateFactory();;

	@Before
	public void initialize(){	
		
		totalOrders = new LinkedHashMap<String,Integer>();
		rules = new PromotionRules();
		alreadyVisited = new LinkedList<String>();
	}
	
	@Test	
	public void checkSugarFreeChocolateType(){
		expectedResult = new LinkedHashMap<String,Integer>();
		type="sugar free";
		chocoType = fac.getchocolate(type);					
		chocoType.setCash(6);
		chocoType.setPrice(2);
		chocoType.setWrappers(2);
		expectedResult.put("sugar free", 5);
		expectedResult.put("dark", 3);
		assertEquals(expectedResult, fac.processOrder(chocoType, type));
	}
	
	@Test	
	public void checkDarkChocolateType(){
		expectedResult = new LinkedHashMap<String,Integer>();
		type="dark";
		chocoType = fac.getchocolate(type);					
		chocoType.setCash(12);
		chocoType.setPrice(4);
		chocoType.setWrappers(4);
		expectedResult.put("dark", 3);		
		assertEquals(expectedResult, fac.processOrder(chocoType, type));
	}
	
	@Test	
	public void checkWhiteChocolateType(){
		expectedResult = new LinkedHashMap<String,Integer>();
		type="white";
		chocoType = fac.getchocolate(type);					
		chocoType.setCash(6);
		chocoType.setPrice(2);
		chocoType.setWrappers(2);
		expectedResult.put("white", 5);	
		expectedResult.put("sugar free", 3);
		expectedResult.put("dark", 1);
		assertEquals(expectedResult, fac.processOrder(chocoType, type));
	}
	
	@Test
	public void checkMilkChocolateType(){
		expectedResult = new LinkedHashMap<String,Integer>();
		type="milk";
		chocoType = fac.getchocolate(type);					
		chocoType.setCash(12);
		chocoType.setPrice(2);
		chocoType.setWrappers(5);
		expectedResult.put("milk", 7);	
		expectedResult.put("sugar free", 1);	
		assertEquals(expectedResult, fac.processOrder(chocoType, type));
	}

}
