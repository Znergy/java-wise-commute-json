package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        JSONObject json = new JSONObject();

        // gateway
        HashMap<String, Integer> gatewayValues = new HashMap<>();
        gatewayValues.put("clackamas", 1234);
        gatewayValues.put("airport", 3444);
        gatewayValues.put("gresham", 3335);
        gatewayValues.put("hillsboro", 1010);
        gatewayValues.put("city center", 1111);

        HashMap<String, HashMap> gatewayStop = new HashMap<>();
        gatewayStop.put("gateway", gatewayValues);

        // lents
        HashMap<String, Integer> lentsValues = new HashMap<>();
        lentsValues.put("clackamas", 1234);
        lentsValues.put("city center", 1111);

        HashMap<String, HashMap> lentsStop = new HashMap<>();
        lentsStop.put("lents", lentsValues);

        // holgate
        HashMap<String, Integer> holgateValues = new HashMap<>();
        holgateValues.put("clackamas", 1234);
        holgateValues.put("city center", 1111);

        HashMap<String, HashMap> holgateStop = new HashMap<>();
        holgateStop.put("holgate", holgateValues);

        JSONArray stopList = new JSONArray();
        stopList.put(holgateStop);
        stopList.put(lentsStop);
        stopList.put(gatewayStop);

        HashMap<String, JSONArray> stops = new HashMap<>();
        stops.put("stops", stopList);

        json.put("wiseCommute", stops);

        JSONObject resultSet = json.getJSONObject("wiseCommute");
        JSONArray stopResponse = resultSet.getJSONArray("stops");

        String userStop = "gateway";
        String userDirection = "clackamas";

        String jsonString = json.toString();
        JSONObject jsonResult = new JSONObject(jsonString);
        JSONArray stopArray = jsonResult.getJSONObject("wiseCommute").getJSONArray("stops");
        if(stopArray != null) {
            for(int i = 0; i < stopArray.length(); i++) {
                System.out.println(stopArray.getJSONObject(i).getJSONObject("holgate"));
            }
        }

        // how to pull out the stop ID
//        System.out.println(stopArray.getJSONObject(2).getJSONObject(userStop).getInt(userDirection));

        //how to search json

//        for(int i = 0; i < stopArray.length(); i++) {
//            if (userStop.equals(stopArray.getJSONObject(i).getJSONObject(userStop))) {
//                System.out.println("found!");
//            }
//        }
    }
}
