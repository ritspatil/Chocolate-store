package com.example.stride.test;

import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.example.stride.ChocolateFactory;

public class TestNullValue {


	ChocolateFactory fac = new ChocolateFactory();

	@Parameter
	public String type;
	@Test
	@Parameters(name = "inValidDataCheck")
	public void checkInvalidReturnedChocolateType(){
		assertNull(fac.getchocolate(type));
	}
	
	@Parameters
	public static String[] inValidDataCheck() {
		String[] str = {"",")))","**","aa"};
		return str;
	}
	


}
