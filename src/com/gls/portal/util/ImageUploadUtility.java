/**
 * 
 * 
 * 	Name 						Date 							Comments 
 * ------------------------------------------------------------------------------------------------------
 * Riyasdeen 					15-10-2012					Initial Version 
 * Riyasdeen 					15-10-2012					Added  imageLocation parameter in upload Image method
 * Riyasdeen 					28-12-2012					Added  modifyImageName method to modify the image name and added image id parameter
 * 															in uploadImage method.
 * Riyasdeen 					28-12-2012					Added a check to validate the multipartFile contains the filename.
 * Riyasdeen 					31-12-2012					Added a support to create a different directory for storing restaurant ,promotion and menu images.
 * 
 */


package com.gls.portal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ImageUploadUtility {	
	//private static org.slf4j.Logger logger = LoggerFactory.getLogger(ImageUploadUtility.class); 
	
	public static Map<String, String> uploadImage(MultipartHttpServletRequest multipartRequest,String imageLocation,String imageId)throws IOException{
		String imagePath=imageLocation;
		//System.out.println("imageId::::"+imageId);
		final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
		Iterator<String> fileNames = multipartRequest.getFileNames();
		String modifiedImageName="";
		Map<String, String> imageNameMap = new HashMap<String, String>();
		int i=1;
	
		try{
		
			while (fileNames.hasNext()) {
				System.out.println("Upload image ..!!!!!!!!");
				String fileName = fileNames.next();
				System.out.println("FILE NAME::::::::::::"+fileName);
				MultipartFile multipartFile = multipartRequest.getFile(fileName);
				System.out.println("multipartFile.getName()  "+multipartFile.getName());
				System.out.println("multipart file:::::::::::::::::::::::::::;"+multipartFile);
				modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
				
				if(multipartFile.getName().contains("image") && imageId.equals("offerPreviewImage")){
					
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						
						String fileExtension="";
						if(multipartFile.getOriginalFilename()!=null && !multipartFile.getOriginalFilename().equals("")){
							int mid= multipartFile.getOriginalFilename().lastIndexOf(".");
							fileName=multipartFile.getOriginalFilename().substring(0,mid);
							fileExtension=multipartFile.getOriginalFilename().substring(mid+1,multipartFile.getOriginalFilename().length());	
								
						}
						
						modifiedImageName = "offerPreviewImage."+fileExtension.toLowerCase();
						System.out.println("modifiedImageName:::"+modifiedImageName);
					} else {
						modifiedImageName = "";
					}
					String rewardsImageName="REWARDS_OFFER"+String.valueOf(i);
					//System.out.println("rewardsImageName::::Main:::"+rewardsImageName);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				
					
				}
				 if(multipartFile.getName().contains("file")){
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
					} else {
						modifiedImageName = "";
					}
					String rewardsImageName="REWARDS"+String.valueOf(i);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}
				
				if(multipartFile.getName().contains("merchantThumbImage")){
					System.out.println("THumb image::::::::::::::::::::::::::::");
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
						System.out.println("THumb image::::::::::::::::::::::::::::"+modifiedImageName);
					} else {
						modifiedImageName = "";
					}
					//System.out.println("merchnt ::: thumb::::::::"+modifiedImageName);
					String rewardsImageName="REWARDS"+String.valueOf(i);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}

				if(multipartFile.getName().contains("itemImage")){	
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
					} else {
						modifiedImageName = "";
					}
					
					String rewardsImageName="REWARDS"+String.valueOf(i);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}
				
				if(multipartFile.getName().contains("offerMainImage")){	
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
						//System.out.println("modifiedImageName:::"+modifiedImageName);
					} else {
						modifiedImageName = "";
					}
					String rewardsImageName="REWARDS_OFFER"+String.valueOf(i);
					//System.out.println("rewardsImageName::::Main:::"+rewardsImageName);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}
				if(multipartFile.getName().contains("offerThumbImage")){	
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
						//System.out.println("modifiedImageName::::thumb:::"+modifiedImageName);
					} else {
						modifiedImageName = "";
					}
					String rewardsImageName="REWARDS_OFFER"+String.valueOf(i);
					//System.out.println("rewardsImageName::::thumb:::"+rewardsImageName);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}
				
				if(multipartFile.getName().contains("mainImage")){	
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
					} else {
						modifiedImageName = "";
					}
					String rewardsImageName="REWARDS_REWARD"+String.valueOf(i);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}
				
				if(multipartFile.getName().contains("thumbImage")){	
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
					} else {
						modifiedImageName = "";
					}
					String rewardsImageName="REWARDS_REWARD"+String.valueOf(i);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}

				if(multipartFile.getName().contains("merchantMainImage")){
					System.out.println("MAIN image:::::::::::::::::::::::::");
					if(!multipartFile.getOriginalFilename().equalsIgnoreCase("")){
						modifiedImageName = modifyImageName(imageId,multipartFile.getOriginalFilename());
						System.out.println("MAIN image::::::::::::::::::>>>:::::::"+modifiedImageName);
					} else {
						modifiedImageName = "";
					}
					//System.out.println("merchnt ::: main::::::::"+modifiedImageName);
					String rewardsImageName="REWARDS"+String.valueOf(i);
					imageNameMap.put(rewardsImageName,modifiedImageName);
					i++;
				}
				
				
				InputStream inputStream = null;
				OutputStream outputStream = null;	
				File imageDirectory=new File(imagePath);				
				if(!imageDirectory.exists()){					
					imageDirectory.mkdirs();					
				}
				if(multipartFile.getSize()>0){
					inputStream = multipartFile.getInputStream();
					outputStream = new FileOutputStream(imagePath+modifiedImageName);
					int readBytes = 0;
					byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];				
					while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
						outputStream.write(buffer, 0, readBytes);
					}
					outputStream.close();
					inputStream.close();
				}
				
				
				
			}		

			return imageNameMap;
		}
		catch(Exception e){
			e.printStackTrace();
			//logger.error(e.toString());
			
		}
		return imageNameMap;	
	}
	 
	static int number=0;	
	public static int getUniquenumber(int numbercount){		
		number=number+1;	
	    numbercount=number;
		return number;		
	}

	public static String modifyImageName(String imageId,String imageName){
		System.out.println("IMAGE NAME::::"+imageName);
		System.out.println("imageId::::"+imageId);
		
		String fileExtension="";
		String fileName="";
		if(imageName!=null && !imageName.equals("")){
			int mid= imageName.lastIndexOf(".");
			fileName=imageName.substring(0,mid);
			fileExtension=imageName.substring(mid+1,imageName.length());	
				
		}
		
		String modifiedImageName="img_"+imageId+"_"+String.valueOf(System.currentTimeMillis())+getUniquenumber(1)+"."+fileExtension;
		
		System.out.println("time:::"+String.valueOf(System.currentTimeMillis()));
		System.out.println("modifiedImageName::::>>>>>>>>>>>>>>>>"+modifiedImageName);
		return modifiedImageName;
	}
}
