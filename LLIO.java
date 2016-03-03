package Charles.LazyLibrary;

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

	public LLIO(){}
	
	public void createFile(String name){
		try {
		     File fileA = new File((name+".txt"));
		     if (fileA.createNewFile()){
		    	 console("File '"+name+".txt' has been created successfully");
		     }
		     else{
		    	 console("File '"+name+".txt' already present at the specified location");
		     }
	    	} catch (IOException e) {
	    		console("Exception Occurred:");
		        e.printStackTrace();
		  }
	}
	public void createTempFile(String name){
		try {
		     File fileA = new File((name+".txt"));
		     if (fileA.createNewFile()){
		    	 fileA.deleteOnExit();
		    	 console("File '"+name+".txt' has been created successfully");
		     }
		     else{
		    	 console("File '"+name+".txt' already present at the specified location");
		     }
	    	} catch (IOException e) {
	    		console("Exception Occurred:");
		        e.printStackTrace();
		  }
	}
	//==============================================================//
	public void createFile(String name, String ext){
		try {
		     File fileA = new File((name+"."+ext));
		     fileA.getName();
		     if (fileA.createNewFile()){
		    	 console("File has been created successfully");
		     }
		     else{
		    	 console("File already present at the specified location");
		     }
	    	} catch (IOException e) {
	    		console("Exception Occurred:");
		        e.printStackTrace();
		  }
	}
	//==============================================================//
	public void deleteFile(File a){
		if(a.delete()){
			console("File Deleted!");
		}else{
			console("File Not Found For Deletion!");
		}
	}
	//==============================================================//
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
				e.printStackTrace();
			} finally{
				try{
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}else{
			console("No File Found!");
		}
		return ret;
	}
	//==============================================================//
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
				e.printStackTrace();
			}
		}else{
			console("No File Found!");
		}
		return ret;
	}
	public   boolean doesFileExist(File f){
	    return f.exists();
	}
	//================================================================
	public void ScreenShot(String fileName){
		try { 
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   	Rectangle screenRectangle = new Rectangle(screenSize);
		   	Robot robot = new Robot();
		   	BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", new File(fileName));
		} catch (IOException | AWTException e) {
			e.printStackTrace();
		}
	}
	//================================================================
	public String[] getCDContents(){
		File cd = new File(getCurrentDirectory());
		String[] files = cd.list();
		return files;
	}
}
