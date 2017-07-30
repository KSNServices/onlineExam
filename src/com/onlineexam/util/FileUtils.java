package com.onlineexam.util;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * Class for check different methods for image validation
 * Including image size, image dimensions and image patterns
 * @author Shailesh
 */

public class FileUtils {
	
	private Pattern pattern;
	
	private Matcher matcher;
	
	private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	
	public FileUtils(){
		pattern = Pattern.compile(IMAGE_PATTERN);
   }

	/**
	 * Validate image with regular expression 
	 * @param image image for validation
	 * @return true valid image, false invalid image
	 */
	public boolean validate(final String image) {
		matcher = pattern.matcher(image);
		return matcher.matches();
	}
	
	
	/**
	 * calculate image size in KB
	 */
	public double getImageSize(MultipartFile image) {
		double sizeInKB=0.0;
		sizeInKB = (image.getSize())/1024;
		return sizeInKB;
	}
	
	
	/**
	 * Validate Image dimensions
	 */
	public int[] getDimensions(MultipartFile file){
		int [] imageDimesnions = new int[2];
		try{
			BufferedImage oldImage = ImageIO.read(file.getInputStream());
			imageDimesnions[0]= oldImage.getWidth();
            imageDimesnions[1]= oldImage.getHeight();
			/*ImageInputStream iis = ImageIO.createImageInputStream(fileNew);
	        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
	        if (readers.hasNext()) {
	          //Get the first available ImageReader
	            ImageReader reader = readers.next();
	            reader.setInput(file.getInputStream(), true);
	            imageDimesnions[0]= reader.getWidth(0);
	            imageDimesnions[1]= reader.getHeight(0);
	            System.out.println("Width : " + reader.getWidth(0) + " pixels");
	            System.out.println("Height : " + reader.getHeight(0) + " pixels");
	        }*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return imageDimesnions;
	}
	
	/**
	 * Upload single files
	 * Used for upload employee profile pictures, Logo and single file etc..  
	 */
	public String uploadSingleFiles(MultipartFile logo,String directory){
		  File serverFile = null;
		  try{   
		   byte[] bytes = logo.getBytes();
		   // Creating the directory to store file
		   File dir = new File(directory);
		   if (!dir.exists())
		    dir.mkdirs();
		   String fileName = logo.getOriginalFilename();
		   String extensions = fileName.split("\\.")[1];;
		   Date tempName = new Date();
		   Random randomGenerator = new Random();
		   int randomInt= randomGenerator.nextInt(1000);
		   fileName = String.valueOf(tempName.getTime())+String.valueOf(randomInt)+"."+extensions;
		   // Create the file on server
		   serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
		   BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		   stream.write(bytes);
		   stream.close();
		  }
		  catch(IOException io){
		   io.printStackTrace();
		  }
		  catch(Exception e){
		   e.printStackTrace();
		  }
		  return serverFile.getName();
		 }	
	
	public void readImage(String photo, String noImgThumb, HttpServletResponse httpServletResponse) {
		HttpServletResponse res = httpServletResponse;
		res.setContentType("image/jpg"); // MIME type
		try {
			ServletOutputStream imgStream = res.getOutputStream();
			File imgFile = new File(photo);
			if (!imgFile.exists() || imgFile.isDirectory()) {
				imgFile = new File(noImgThumb);
			}
			InputStream imageStream = new FileInputStream(imgFile);
			byte imgByte[] = new byte[(int) imgFile.length()];
			while ((imageStream.read(imgByte)) != -1) {
				imgStream.write(imgByte);
			}
			imgStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Dalete file from the server directory
	 * @param logoPath
	 * @return
	 */
	public boolean deleteLogoFromDirectory(String logoPath) {
		try{
			File file = new File(logoPath);
			file.deleteOnExit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
}
