package com.example.stride;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public class ChocloateStore {

	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static ArrayList<String> outList= null;
	public static void main(String[] args) {
		String input = "orders.csv";
		String output = "output.csv";
		readWriteFile(input, output);
	}

	public static void readWriteFile(String inputFile, String output){
		//read from csv
		outList = new ArrayList<String>();
		outList.add("milk");
		outList.add("dark");
		outList.add("white");
		outList.add("sugar free");
		//String inputFile = "orders.csv";
		File file = new File(output);


		String line = "";		
		ChocolateFactory choco = new ChocolateFactory();
		try {
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			br = new BufferedReader(new FileReader(inputFile));
			br.readLine();
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] orders = line.split(",");
				Chocolate chocoType = null;
				String chocolateType = orders[3].replaceAll("[-+.^:,'']","").trim();

				if(chocolateType == null || !(chocolateType.equalsIgnoreCase("milk") 
						&& chocolateType.equalsIgnoreCase("dark") &&
						chocolateType.equalsIgnoreCase("white") &&
						chocolateType.equalsIgnoreCase("sugar free"))){					 

					chocoType = choco.getchocolate(chocolateType);					
					chocoType.setCash(Integer.valueOf(orders[0].trim()));
					chocoType.setPrice(Integer.valueOf(orders[1].trim()));
					chocoType.setWrappers(Integer.valueOf(orders[2].trim()));

					LinkedHashMap<String,Integer> totalOrders = choco.processOrder(chocoType,chocolateType);	


					StringBuilder sb = new StringBuilder();
					for (ListIterator<String> i = outList.listIterator(); i.hasNext();) {
						sb.append(outputTotalOrder(totalOrders,i.next()));
						if(!i.hasNext()){
							sb.append(" ");
						}else{
							sb.append(",");
						}						
					}
					sb.append("\n");
					bw.write(sb.toString());

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				br.close();
				bw.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String outputTotalOrder(LinkedHashMap<String,Integer> totalOrders,String key){
		StringBuilder sb = new StringBuilder();
		if(totalOrders.containsKey(key)){
			sb.append(key);
			sb.append(" ");
			sb.append(totalOrders.get(key));
		}else{
			sb.append(key);
			sb.append(" ");
			sb.append("0");
		}		
		return sb.toString();
	}

}
