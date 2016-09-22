package com.example.stride.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import com.example.stride.ChocloateStore;


public class ChocoStoreTestSpecs {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static ArrayList<String> outList= null;
	
	static String input = "";
	static String output = "";
	
	@Before
	public void initialize(){		
		input="Orders.csv";
		output="outputTest.csv";
	}
	
	@Test
	public void shouldReadFile() {	
		System.out.println("Inside shouldReadFile()");  
		ChocloateStore.readWriteFile(input,output); 
	}
	
}
