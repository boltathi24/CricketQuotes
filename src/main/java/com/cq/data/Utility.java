package com.cq.data;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Utility {
	
	public String convertByteArrayToBase64 (byte[] byteValue) throws IOException {
		// open image
	
		 return Base64.getEncoder().encodeToString(byteValue);	
		
		
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
		System.out.println(of.getAbsolutePath());
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
