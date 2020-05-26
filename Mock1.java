package MockHackathon;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

import org.json.simple.JSONObject;

//import jdk.nashorn.internal.parser.JSONParser;

import java.math.RoundingMode;
import java.text.DecimalFormat;



public class Mock1 
{

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		
		JSONObject obj1 = new JSONObject();
		//JSONObject obj3= new JSONObject();
		
		try 
		{
			File file =new File("F:\\NFT\\MockHackathon\\Memory.txt");
			FileReader fr = new FileReader(file);
			BufferedReader sc = new BufferedReader(fr);
			String data="";
			
	    	
			DecimalFormat obj2 = new DecimalFormat("###.##");
			//String readLine=null;
	        int line = 0, i=0;
	        double sum=0, avg;
	        double[] arr1 = new double[1000];
			while(data!=null)
			{
				data = sc.readLine();
		        //System.out.println(data);
				
				if (line % 2 != 0) 
	        	{    	
	        		String str1 = between(data, ":", "TOTAL SWAP").trim();
	                double num1 = Double.parseDouble(str1);
	                double num2  = num1/1000;
	                
	                	
	                obj2.setRoundingMode(RoundingMode.DOWN);
	                String num3 = obj2.format(num2);
	                double num4 = Double.parseDouble(num3);
	                arr1[i] = num4;
	                
	                System.out.println(num4);
	                sum = sum+num4;
	                
	                String str2=i+"s";
	                obj1.values("values",str2+":"+num4);
	  			  	
	                i=i+1;	
	             }
	             line++;
		    }
			avg = sum/(i);
		    String avg1=obj2.format(avg);
	        // System.out.println("average: "+avg1);  
		    obj1.avg("AverageMemory(MB)",avg1);
	    		    
	        Arrays.sort(arr1);
	        double max = arr1[arr1.length-1];
	        obj1.max("MaxMemory(MB)",max);
	    	obj1.source("Usecasename","HomePage");
	        // System.out.println("Maximum: "+arr1[arr1.length-1]);
	            
		    sc.close();
		} 
		catch (FileNotFoundException e) 
		{
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		
		try
		{	
			FileWriter fw=new FileWriter("F:\\NFT\\MockHackathon\\jsonFile.txt");
			fw.write(obj1.toString());
			fw.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}
	

	static String between(String value, String a, String b) 
	{
		// Return a substring between the two strings.
		int pos1 = value.indexOf(a);
		if (pos1 == -1) 
		{
			return "";
		}
		int pos2 = value.indexOf(b);
		if (pos2 == -1) 
		{
			return "";
		}
		int	adjustedPos1 = pos1 + a.length();
		if (adjustedPos1 > pos2) 
		{
			return "";
		}
		return value.substring(adjustedPos1, pos2);
	}
}