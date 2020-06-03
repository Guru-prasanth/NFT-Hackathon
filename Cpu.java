package Hackathon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Cpu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		JSONObject object = new JSONObject();
		JSONArray values=new JSONArray();
		
		File file=new File("F:\\NFT\\Hackathon\\CPU.txt");
		
		float max=0;
		float total=0;
		float avg=0;
		
		int count=1;
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(file));
		
			String str1="";
		
			
			while((str1=br.readLine())!=null)
			{
				String s1=str1.substring(42,46);
				
				s1=s1.trim();
				
				float val=Float.parseFloat(s1);
				
				if(max<val)
				{
					max=val;
				}
				
				total=total+val;
			
				//System.out.println(count+"s:"+s1);
				String cnt=count+"s";
				
				JSONObject obj1 = new JSONObject();
				obj1.put(cnt,val);
				values.add(obj1);
				
				count++;
			}
		}
		
		catch(Exception e)
		{
			
		}
		//System.out.println("count:"+count);
		
		avg=total/(count-1);
		
		double average = Math.round(avg * 100.0) / 100.0;
		
		//System.out.println("max :"+max);
		//System.out.println("avg:"+avg1);
		
		
		object.put("values",values);
		object.put("maxcpu",max);
		object.put("Avgcpu",average);
		
		JSONObject final1=new JSONObject();
		
		final1.put("sampletransaction", object);
		
		try
		{
		
		FileWriter fw=new FileWriter("F:\\NFT\\Hackathon\\jsonoutput.json");
		
		fw.write(final1.toString());
		fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//reading file
		
		
		System.out.print(values.toJSONString());
		
				JSONParser jsonParser = new JSONParser();
				
				
				try
				{
					FileReader reader = new FileReader("F:\\NFT\\Hackathon\\jsonoutput.json");
		            Object obj = jsonParser.parse(reader);
		            JSONObject jo=(JSONObject)obj;
		            
		            System.out.println(jo.toString());
		            
		            
		            
		            Double Avg1=(Double)jo.get("AverageMemory(MB)");
		        } 
				catch(Exception e)
				{
					System.out.println(e);
				}
	}

}