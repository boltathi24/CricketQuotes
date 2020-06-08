package com.cq.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cq.data.DBUtil;



public class ProcessRequest extends DBUtil {

	public JSONObject getImageDataAndPlayerDataForPlayer(String playerName) throws ClassNotFoundException, SQLException {
		HashMap<String, String> data = executeQueryForRead(
				"select ImageData.imageDataValue, PlayerData.playerName,PlayerData.playerAge,PlayerData.runScored  from ImageData join PlayerData on PlayerData.playerId=ImageData.playerId where PlayerData.playerName=\""
						+ playerName + "\"");
//		System.out.println(data);
//		ArrayList<HashMap<String,String>> multiValues=executeQueryForReadMultiValues(
//				"select QuotesData.quoteContent from QuotesData join PlayerData on QuotesData.playerId=PlayerData.playerId where playerName=\""
//						+ playerName + "\"");
		return new JSONObject(data);
		
		
	}
	
	public JSONObject getQuoteDataForPlayer(String playerName) throws ClassNotFoundException, SQLException {
//		HashMap<String, String> data = executeQueryForRead(
//				"select ImageData.imageDataValue, PlayerData.playerName,PlayerData.playerAge,PlayerData.runScored  from ImageData join PlayerData on PlayerData.playerId=ImageData.playerId where PlayerData.playerName=\""
//						+ playerName + "\"");
//		System.out.println(data);
		ArrayList<HashMap<String,String>> multiValues=executeQueryForReadMultiValues(
				"select QuotesData.quoteContent from QuotesData join PlayerData on QuotesData.playerId=PlayerData.playerId where playerName=\""
						+ playerName + "\"");
//		System.out.println(multiValues);
		Set<String> keys=multiValues.get(0).keySet();
		JSONObject js=new JSONObject();
		
		
		for(String key:keys)
		{
		JSONArray tempJsa=new JSONArray();
		for(HashMap<String,String> temp:multiValues)
		{
			
			tempJsa.put(temp.get(key));
			
		}
		js.put(key, tempJsa);
		}
		return js;
		
		
	}
	

}
