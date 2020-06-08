package com.cq.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.json.JSONObject;

public class Utility {
	
	public String convertByteArrayToBase64 (byte[] byteValue) throws IOException {
		// open image
	
		 return Base64.getEncoder().encodeToString(byteValue);	
		
		
		}
	public JSONObject mergeJsons(JSONObject js1,JSONObject js2)
	{
		JSONObject mergedJSON = new JSONObject();
		
			mergedJSON = new JSONObject(js1, JSONObject.getNames(js1));
			for (String crunchifyKey : JSONObject.getNames(js2)) {
				mergedJSON.put(crunchifyKey, js2.get(crunchifyKey));
			}
			return mergedJSON;
		
 
	}

	public String convertBase64FromImagePath (String filePath) throws IOException {
		// open image
	
		 return Base64.getEncoder().encodeToString(getByteArrayOfFile(filePath));	
		
		
		}
	
	public byte[] getByteArrayOfFile(String filePath) throws IOException
	{
		 File imgPath = new File(filePath);
		 byte[] fileContent = Files.readAllBytes(imgPath.toPath());
		 return fileContent;
	}
	
	public byte[] convertBase64ToByteArray (String encoded) throws IOException {
		 // open image
		
		return new String(Base64.getDecoder().decode(encoded)).getBytes();
		
	
		
	
		
		
		}
	

	public String convertToImage(String value,String fileName) throws IOException
	{
		File of = new File(System.getProperty("user.dir")+"/src/test/resources/imageFiles/"+fileName+".jpg");		
//		byte[] val=value.getBytes();
		byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(value);
		FileOutputStream osf = new FileOutputStream(of);
		osf.write(btDataFile);
		osf.flush();
		System.out.println(of.getAbsolutePath());
		return of.getAbsolutePath();			
	}
	
	
	public String convertToImage(byte[] value,String fileName) throws IOException
	{
		File of = new File(System.getProperty("user.dir")+"/src/test/resources/imageFiles/"+fileName+".jpg");		
		FileOutputStream osf = new FileOutputStream(of);
		osf.write(value);
		osf.flush();
		
		return of.getAbsolutePath();			
	}
	

//	
//	public static void main(String[] args) throws IOException
//	{
//		Utility util=new Utility();
//		
//	
//		byte[] val=util.getByteArrayOfFile("/home/local/ZOHOCORP/athithan-7130/Desktop/sp13-warner.jpg");
//		util.convertToImage(val, Double.toString(Math.random()));
//
//	}
	
	

}
