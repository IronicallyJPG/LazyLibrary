
package Main;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

public class LLIO {
	
	// ==============================================================//
	// Object to hold all Methods.
	public LLIO() {
		LL.LL_LINK();
	}
	
	// Creates a File
	public File createFile(String name) {
		File fileA = null;
		try {
			fileA = new File((name + ".txt"));
			if (fileA.createNewFile()) {
				if (LL.DEV_MODE == true) {
					LL.console("File '" + name + ".txt' has been created successfully");
				}
			}
			else {
				if (LL.DEV_MODE == true) {
					LL.console("File '" + name + ".txt' already present at the specified location");
				}
			}
		}
		catch (IOException e) {
			LL.console("Exception Occurred:");
			if (LL.DEV_MODE == true) {
				e.printStackTrace();
			}
		}
		return fileA;
	}
	
	// Creates a File with Temporary Tag SET TO TRUE! Meaning it is DELETED upon
	// exit.
	public File createTempFile(String name) {
		File fileA = null;
		try {
			fileA = new File((name + ".txt"));
			if (fileA.createNewFile()) {
				fileA.deleteOnExit();
				if (LL.DEV_MODE == true) {
					LL.console("File '" + name + ".txt' has been created successfully");
				}
			}
			else {
				if (LL.DEV_MODE == true) {
					LL.console("File '" + name + ".txt' already present at the specified location");
				}
			}
		}
		catch (IOException e) {
			LL.console("Exception Occurred:");
			if (LL.DEV_MODE == true) {
				e.printStackTrace();
			}
		}
		return fileA;
	}
	
	// ==============================================================//
	// Creates a File.
	public File createFile(String name, String ext) {
		File fileA = null;
		try {
			fileA = new File((name + "." + ext));
			fileA.getName();
			if (fileA.createNewFile()) {
				if (LL.DEV_MODE == true) {
					LL.console("File has been created successfully");
				}
			}
			else {
				if (LL.DEV_MODE == true) {
					LL.console("File already present at the specified location");
				}
			}
		}
		catch (IOException e) {
			LL.console("Exception Occurred:");
			if (LL.DEV_MODE == true) {
				e.printStackTrace();
			}
		}
		return fileA;
	}
	
	// ==============================================================//
	// Creates a Directory.
	public File createDirectory(String name) {
		File fileA = new File((name));
		if (fileA.mkdir()) {
			if (LL.DEV_MODE == true) {
				LL.console("File has been created successfully");
			}
		}
		else {
			if (LL.DEV_MODE == true) {
				LL.console("File already present at the specified location");
			}
		}
		return fileA;
	}
	
	// ==============================================================//
	// Deletes a File.
	public void delFile(File a) {
		if (a.delete()) {
			if (LL.DEV_MODE == true) {
				LL.console("File Deleted!");
			}
		}
		else {
			if (LL.DEV_MODE == true) {
				LL.console("File Not Found For Deletion!");
			}
		}
	}
	
	// ==============================================================//
	// Pulls Text from file.
	public String getTextFromFile(File f) {
		String ret = "";
		if (f.exists()) {
			BufferedReader br = null;
			try {
				String sCurrentLine;
				br = new BufferedReader(new FileReader(f));
				while ((sCurrentLine = br.readLine()) != null) {
					if (ret.isEmpty()) {
						ret = sCurrentLine;
					}
					else {
						ret = ret + " " + sCurrentLine;
					}
				}
			}
			catch (IOException e) {
				LL.console("Error!");
				if (LL.DEV_MODE == true) {
					e.printStackTrace();
				}
			}
			finally {
				try {
					if (br != null) {
						br.close();
					}
				}
				catch (IOException ex) {
					LL.console("Error!");
					if (LL.DEV_MODE == true) {
						ex.printStackTrace();
					}
				}
			}
		}
		else {
			LL.console("No File Found!");
		}
		return ret;
	}
	
	// ==============================================================//
	// Writes passed Data to file.
	public String writeTextToFile(File f, String dataToWrite, boolean newLine) {
		String ret = " ";
		if (f.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
				if (newLine == true) {
					writer.write(dataToWrite + "\n");
				}
				else {
					writer.write(dataToWrite);
				}
				writer.flush();
				writer.close();
				
			}
			catch (IOException e) {
				LL.console("Error!");
				if (LL.DEV_MODE == true) {
					e.printStackTrace();
				}
			}
		}
		else {
			LL.console("No File Found!!!");
		}
		return ret;
	}
	
	// Does File Exist? Returns Boolean answer
	public boolean doesFileExist(File f) {
		return f.exists();
	}
	
	// Get Files in Folder
	public String[] getFilesInFolder(String FolderPath) {
		File folder = new File(FolderPath);
		File[] listOfFiles = folder.listFiles();
		String[] ret = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; i++) {
			ret[i] = listOfFiles[i].getName();
		}
		return ret;
	}
	
	// ================================================================
	// Saves a Screenshot. With passed name.
	public void ScreenShot(String fileName) {
		try {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screenSize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			ImageIO.write(image, "png", new File(fileName));
		}
		catch (IOException | AWTException e) {
			LL.console("Error!");
			if (LL.DEV_MODE == true) {
				e.printStackTrace();
			}
		}
	}
	
	// ================================================================
	// Gets Current Directory Contents!
	// Returns Array of Strings/Names
	public String[] getCDContents() {
		File cd = new File(LL.getCurrentDirectory());
		String[] files = cd.list();
		return files;
	}
}
