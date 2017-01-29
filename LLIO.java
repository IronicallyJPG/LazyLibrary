package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LLIO extends LL{
	
	
	//==============================================================//
	// Object to hold all Methods.
	public LLIO(){LL.LL_LINK();}
	
	// Creates a File
	public File createFile(String name){
		File fileA = null;
		try {
		     fileA = new File((name+".txt"));
		     if (fileA.createNewFile()){
		    	 if(DEV_MODE==true)console("File '"+name+".txt' has been created successfully");
		     }
		     else{
		    	 if(DEV_MODE==true)console("File '"+name+".txt' already present at the specified location");
		     }
	    	}catch (IOException e) {
	    		console("Exception Occurred:");
	    		if(DEV_MODE==true)e.printStackTrace();
	    	}
		return fileA;
	}
	// Creates a File with Temporary Tag SET TO TRUE! Meaning it is DELETED upon exit.
	public File createTempFile(String name){
		File fileA = null;
		try {
		     fileA = new File((name+".txt"));
		     if (fileA.createNewFile()){
		    	 fileA.deleteOnExit();
		    	 if(DEV_MODE==true)console("File '"+name+".txt' has been created successfully");
		     }
		     else{
		    	 if(DEV_MODE==true)console("File '"+name+".txt' already present at the specified location");
		     }
	    	} catch (IOException e) {
	    		console("Exception Occurred:");
		        if(DEV_MODE==true)e.printStackTrace();
		  }
		return fileA;
	}
	//==============================================================//
	// Creates a File.
	public void createFile(String name, String ext){
		try {
		     File fileA = new File((name+"."+ext));
		     fileA.getName();
		     if (fileA.createNewFile()){
		    	 if(DEV_MODE==true)console("File has been created successfully");
		     }
		     else{
		    	 if(DEV_MODE==true)console("File already present at the specified location");
		     }
	    	} catch (IOException e) {
	    		console("Exception Occurred:");
		        if(DEV_MODE==true)e.printStackTrace();
		  }
	}
	//==============================================================//
	// Deletes a File.
	public void delFile(File a){
		if(a.delete()){
			if(DEV_MODE==true)console("File Deleted!");
		}else{
			if(DEV_MODE==true)console("File Not Found For Deletion!");
		}
	}
	//==============================================================//
	// Pulls Text from file.
	public String getTextFromFile(File f){
		String ret = "";
		if(f.exists()){
			BufferedReader br = null;
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader(f));
				while ((sCurrentLine = br.readLine()) != null) {
					if(ret.isEmpty()){
						ret = sCurrentLine;
					}else{
						ret = ret+" "+sCurrentLine;
					}
				}
			} catch (IOException e) {
				console("Error!");
				if(DEV_MODE==true)e.printStackTrace();
			} finally{
				try{
					if (br != null)br.close();
				} catch (IOException ex) {
					console("Error!");
					if(DEV_MODE==true)ex.printStackTrace();
				}
			}
		}else{
			console("No File Found!");
		}
		return ret;
	}
	//==============================================================//
	// Writes passed Data to file.
	public String writeTextToFile(File f, String dataToWrite, boolean newLine){
		String ret = " ";
		if(f.exists()){
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
				if(!(getDataFromFile(f.getName().replaceAll(".txt", " ").trim()).equals(null)) || !(getDataFromFile(f.getName().replaceAll(".txt", " ").trim()).isEmpty())){dataToWrite=dataToWrite+" ";}else{newLine=false;}	
				if(newLine==true)writer.newLine();	
				writer.write(dataToWrite);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				console("Error!");
				if(DEV_MODE==true)e.printStackTrace();
			}
		}else{
			console("No File Found!");
		}
		return ret;
	}
	// Does File Exist? Returns Boolean answer
	public boolean doesFileExist(File f){
	    return f.exists();
	}
	//================================================================
	// Saves a Screenshot. With passed name.
	public void ScreenShot(String fileName){
		try { 
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   	Rectangle screenRectangle = new Rectangle(screenSize);
		   	Robot robot = new Robot();
		   	BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", new File(fileName));
		} catch (IOException | AWTException e) {
			console("Error!");
			if(DEV_MODE==true)e.printStackTrace();
		}
	}
	//================================================================
	// Gets Current Directory Contents!
	// Returns Array of Strings/Names
	public String[] getCDContents(){
		File cd = new File(getCurrentDirectory());
		String[] files = cd.list();
		return files;
	}
}
