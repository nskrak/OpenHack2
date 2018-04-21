package com.example.nskra.openhack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWeb {

    public static Object[][] coords(URL url) throws IOException {
        JSONParser parser = new JSONParser();

        // Make a URL to the web page

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));


        try {

            Object obj = parser.parse(br);
            JSONObject jsonObject = (JSONObject) obj;

            long antal = (Long) jsonObject.get("nhits");
            int santal = (int)antal;

            JSONArray records = (JSONArray) jsonObject.get("records");

            Object[][] xy = new Object[santal][2];

            System.out.println("Tr�ffar: " + antal);
            System.out.println("\nPumpar:");

            for(int i = 0; i < antal; i++){
                Map geo = (Map) ((Map) records.get(i)).get("geometry");
                JSONArray coords = (JSONArray) geo.get("coordinates");
                for(int j = 0; j < 2; j++){
                    xy[i][j] = coords.get(j);
                }
            }
//            for(int i = 0; i < 10; i++){
//            	System.out.println("");
//            	for(int j = 0; j < 2; j++){
//            		System.out.print(xy[i][j] + " ");
//            	}
//            }
            return xy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}