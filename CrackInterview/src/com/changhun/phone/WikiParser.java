//package com.changhun.phone;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.json.simple.JSONObject;
//
//
//public class WikiParser {
//	public static int parser(String topic) throws IOException {
//		
//	       URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&selection=0&prop=test&format=json&page="+topic);
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setRequestMethod("GET");
//	        
//	        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        
//	        String line;
//	        
//            JSONObject obj = new JSONObject();
//
//	        while((line = rd.readLine()) != null) {
//
//	        
//	        }
//	        
////	        while((line = rd.readLine()) != null) {
////	            JSONObject obj = new JSONObject();
////
////	            obj.get(data)
////	            
////	            JSONArray results = obj.getJsonArray("data");
////
////	            
////	            
//////	            JSONReader rdr = Json.createReader(is)) {
//////	        	 
//////	        		 JsonObject obj = rdr.readObject();
//////for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//////     System.out.print(result.getJsonObject("from").getString("name"));
//////       System.out.print(": ");
//////        System.out.println(result.getString("message", ""));
//////        System.out.println("-----------");
//////  }
//////       	
//////	        	JSONParser parser = new JSONParser();
//////	            JSONArray arr = (JSONArray) parser.parse(line);
//////	        
//////	            
//////	            Pattern p = Pattern.compile(topic);
//////	            int count = 0;
//////	            int len = arr.length();
//////	            for (int i=0; i< len; i++) {
//////	                Matcher m = p.matcher(arr(i));
//////
//////	                if(m.find) count ++;
//////	            }
////	        }
//	        rd.close();
//	        return 0;
//	}
//	
//	public static void main(String[] args) throws IOException {
//		parser("pizza");
//	}
//}
