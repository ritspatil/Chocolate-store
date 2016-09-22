package com.example.stride.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.stride.Chocolate;
import com.example.stride.ChocolateFactory;
import com.example.stride.PromotionRules;

@RunWith(Parameterized.class)
public class ChocolateFactoryGeneralTest {

	private String type;
	private static LinkedHashMap<String,Integer> expectedResult;
	private Chocolate chocoObj;	
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
	
	public ChocolateFactoryGeneralTest(Chocolate chocoObj, String type, LinkedHashMap<String,Integer> expectedResult) {
		this.chocoObj = chocoObj;
		this.expectedResult = expectedResult;
		this.type= type;
	}

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		
		LinkedHashMap<String,Integer> sugar = new LinkedHashMap<String,Integer>();		
		Chocolate s = fac.getchocolate("sugar free");	
		s.setCash(6);
		s.setPrice(2);
		s.setWrappers(2);
		sugar.put("sugar free", 5);
		sugar.put("dark", 3);
		
		
		LinkedHashMap<String,Integer> dark = new LinkedHashMap<String,Integer>();
		Chocolate d = fac.getchocolate("dark");					
		d.setCash(12);
		d.setPrice(4);
		d.setWrappers(4);
		dark.put("dark", 3);

		LinkedHashMap<String,Integer> white = new LinkedHashMap<String,Integer>();
		Chocolate w = fac.getchocolate("white");					
		w.setCash(6);
		w.setPrice(2);
		w.setWrappers(2);
		white.put("white", 5);	
		white.put("sugar free", 3);
		white.put("dark", 1);
		
		LinkedHashMap<String,Integer> milk = new LinkedHashMap<String,Integer>();
		Chocolate m = fac.getchocolate("milk");					
		m.setCash(12);
		m.setPrice(2);
		m.setWrappers(5);
		milk.put("milk", 7);	
		milk.put("sugar free", 1);
		
		return Arrays.asList(new Object[][] {
			{ s,"sugar free",sugar},
			{ m,"milk",milk },
			{ d,"dark",dark},
			{ w,"white",white}
		});
	}

	@Test	
	public void checkOutputOrders(){		
		assertEquals(expectedResult, fac.processOrder(chocoObj, type));
	}
	
}
