package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LL {
	
	/* Welcome to this Library.
	 * Adding Some basic Methods.
	*/

	//====================================================================//
	// 		Basic Variables Needed Supplied for Library              	  //
	public static String AUTHOR 	= "Charles";
	public static String LibName 	= "LazyLib";
	public static String VERSION 	= "1.3.0";
	public static String Desc 	= "A Simple Lazy Library.";
	public static boolean DEV_MODE = false;
	public static ArrayList<Object> runtimeArgs;
	private static LLD date = new LLD();
	private static LLN net = new LLN();
	private static LLIO io = new LLIO();
	//=====================================================================//
	
	/**
	 * Console wrapped into an easier to access method. ( Saving you from System.out.println(s) )
	 * @param t The String to write to console. 
	*/
	public static void console(Object t){
		System.out.println(t);
	}
	public static void toggle_DevMode(boolean t){
		DEV_MODE=t;
	}
	//=====================================================================//
	
	/**
	 * Prompts a question while return the answer as a string.
	 * @param q Question to prompt.
	 * */
	public static String askQuestion(String q){
		String ret = "No Answer";
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.print(q);
		ret = s.nextLine();
		return ret;
	}
	//=====================================================================//
	public static void pauseCurrentThread(int seconds){
		try {
			Thread.currentThread();
			Thread.sleep((seconds*1000));
		} catch (InterruptedException e) {
			if(DEV_MODE==true)e.printStackTrace();
		}
	}
	
	/**
	 * Returns The Letters from a word as an ArrayList of Letters
	 * @param s String to Break Down.
	 * */
	public static ArrayList<Character> lettersAsArray(String s){
		ArrayList<Character> ret = new ArrayList<Character>();
		ret.clear();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				ret.add(s.charAt(i));
				if(DEV_MODE==true)LL.console("Space At Index: "+i);
			}else{
				ret.add(s.charAt(i));
			}
		}
		return ret;
	}
	//=====================================================================//
	
	/**
	 * Simple Boolean return if an int is even or not
	 * @param i Int To Check.
	 * */
	public static boolean isIntEven(int i){
		if(i %2 == 0){
			return true;
		}else{
			return false;
		}
	}
	//=====================================================================//
	/**
	 * Simply adds a way to seperate console output. For Debug Purposes.
	*/
	public static void newSection(){
		console("//=====================================================================//");
	}
	//=====================================================================//
	/**
	 * Converts standard array object to arraylist object.
	 * @param o Array[] TO ArrayList<> 
	*/
	public static ArrayList<Object> returnArrayListFromArray(Object[] o){
		ArrayList<Object> ret = new ArrayList<Object>();
		for(int i = 0; i < o.length; i++){
			ret.add(o[i]);
		}
		return ret;
	}
	//===================================================================//
	/**
	 * MUST BE RUN IN MAIN METHOD! TRANSFERING RUNTIME ARGS TO HERE FOR STORAGE!
	* */
	public static final void SPECIAL_argsToArrayList(Object[] o){
		runtimeArgs = returnArrayListFromArray(o);
	}
	//===================================================================//
	/**
	 * @param sent The Sentence of words to break. Similar to the word to letters array method 
	*/
	public static ArrayList<String> sentenceBreaker(String sent){
		ArrayList<String> ret = new ArrayList<String>();
		if( !(sent.isEmpty()) ){
			String[] temp = sent.split(" ");
			for(int i = 0; i < temp.length; i++){
				ret.add(temp[i]);
			}
		}
		return ret;
	}
	//==================================================================//
	/**
	 * Returns Current Directory
	*/
	public static String getCurrentDirectory(){
		return System.getProperty("user.dir");
	}
	/**
	 * Returns an Array of Directory Contents.
	*/
	public static String[] getCurrentDirectoryContents(){
		return io.getCDContents();
	}
	
	//==================================================================//
	/**
	 * Returns Current Day
	*/
	public static String getCurrentDay(){
		date = new LLD();
		return date.getNameOfDayInDate();
	}
	/**
	 * Returns Current Month
	*/
	public static String getCurrentMonth(){
		date = new LLD();
		return date.getNameOfMonthInDate();
	}
	/**
	 * Returns Current Year
	*/
	public static String getCurrentYear(){
		date = new LLD();
		return date.getYearInDate();
	}
	/**
	 * Returns Current Time
	*/
	public static String getCurrentTime(){
		date = new LLD();
		return date.getTimeOfDayInDate();
	}
	/**
	 * Returns Current Time with AM/PM
	*/
	public static String getCurrentTimeWithAmPm(){
		date = new LLD();
		return date.getTimeOfDayInDateWithAMPM();
	}
	/**
	 * Returns Current Day of Month
	*/
	public static String getCurrentDayOfTheMonth(){
		date = new LLD();
		return date.getDayOfMonth();
	}
	/**
	 * Returns Current Date in a String format
	*/
	public static String getWholeDateAsString(){
		date = new LLD();
		return "Current Date:\n\tMonth\t: "+getCurrentMonth()+
							"\n\tDay\t: "+getCurrentDay()+"/"+getCurrentDayOfTheMonth()+
							"\n\tYear\t: "+getCurrentYear();
	}
	/**
	 * Returns Days of the week as an array
	*/
	public static String[] getDaysOfTheWeek(){
		return date.days;
	}
	/**
	 * Returns Months as Array
	*/
	public static String[] getMonthsOfTheYear(){
		return date.months;
	}
	//=============================================================//
	/**
	 * Returns Number of Processors Availible
	*/
	public static Object getAvailibleProcessor(){
		return  Runtime.getRuntime().availableProcessors();
	}
	/**
	 * Returns Java Version
	*/
	public static String getJavaVersion(){
		return System.getProperty("java.version");
	}
	/**
	 * Returns Current OS Name Ex. "Windows 7"
	*/
	public static String getOsName(){
		return System.getProperty("os.name");
	}
	/**
	 * Returns Current Language in use
	*/
	public static String getCurrentLang(){
		switch(System.getProperty("user.language").substring(0, 2)){
			case "en": return "English";
			case "fr": return "French";
			case "ko": return "Korean";
			case "zh": return "Chinese";
			case "de": return "German";
			case "es": return "Spanish";
			default: return "Unknown Language";
		}
	}
	/**
	 * Returns Current OS Architecture, such as x86, amd64, ect
	*/
	public static String getOsArchitecture(){
		return System.getProperty("os.arch");
	}
	/**
	 * Returns Current Username
	*/
	public static String getCurrentUserName(){
		return System.getProperty("user.name");
	}
	/**
	 * Returns Current Country
	*/
	public static String getCurrentCountry(){
		return System.getProperty("user.country");
	}
	//=============================================================//
	/**
	 * Returns amount of repeats in an array.
	 * @param l Array to Check
	 * @param toCheckFor Object to look for in an array
	*/
	public static int countRepeatsInArray(ArrayList<?> l, Object toCheckFor){
		int ret = -1;
		for(int i = 0; i < l.size(); i++){
			if(l.get(i).equals(toCheckFor)){
				ret++;
			}
		}
		return ret;
	}
	/**
	 * Shuffles a given Arraylist
	*/
	public static void ShuffleArrayList(ArrayList<?> ls){
		Collections.shuffle(ls);
	}
	/**
	 * Shuffles a given list
	*/
	public static void ShuffleList(List<?> list){
		Collections.shuffle(list);
	}
	//=============================================================//
	/**
	 * Creates a txt file with passed name
	*/
	public static File newFile(String name){
		return io.createFile(name);
	}
	/**
	 * Creates a temporary txt file with passed name
	*/
	public static File newTempFile(String name){
		return io.createTempFile(name);
	}
	
	//=====================
	/**
	 * deletes a txt file with passed name
	*/
	public static void deleteFile(String name){
		File f = new File(name+".txt");
		io.delFile(f);
	}
	/**
	 * deletes a txt file with passed name AND Extension
	*/
	public static void deleteFile(String name, String ext_WithOut_Period){
		File f = new File(name+"."+ext_WithOut_Period);
		io.delFile(f);
	}
	/**
	 * Deletes a given file.
	*/
	public static void deleteFile(File f){
		io.delFile(f);
	}
	//======================
	/**
	 * Writes text to file given filename, data to write, and if it belongs on a new line
	*/
	public static void writeToFileName(String fileName, String dataToWrite, boolean newLine){
		File f = new File(fileName+".txt");
		io.writeTextToFile(f, dataToWrite, newLine);
	}
	/**
	 * Writes to a given file.
	*/
	public static void writeToFile(File f,String dataToWrite, boolean newLine){
		io.writeTextToFile(f, dataToWrite, newLine);
	}
	//======================
	/**
	 * Gets Text from a file with given name
	*/
	public static String getDataFromFile(String fileName){
		File f = new File(fileName+".txt");
		return io.getTextFromFile(f);
	}
	//======================
	/**
	 * Gets Words from a file. Could use clarity.
	*/
	public static ArrayList<String> getDataFromFileAsArrayListOfWords(String fileName){
		ArrayList<String> ret = new ArrayList<String>();
		ret.clear();
		File f = new File(fileName+".txt");
		String[] t = io.getTextFromFile(f).split(" ");
		for(int i = 0 ; i < t.length; i++){
			ret.add(t[i]);
		}
		return ret;
	}
	//======================
	/**
	 * Captures a screenshot, then saves with given name
	*/
	public static void scrnShot(String sc){
		io.ScreenShot(sc);
	}
	//======================
	/**
	 * is file present?
	*/
	public static boolean isFilePresent(String fileName){
	    File f = new File(fileName+".txt");
	    return io.doesFileExist(f);
	}
	/**
	 * is file present WTIH specified extension?
	*/
	public static boolean isFilePresentExt(String fileName, String extension){
	    File f = new File(fileName+"."+extension);
	    return io.doesFileExist(f);
	}
	//==================================================
	// Net Tools!
	/**
	 * Debug for host work
	*/
	public static void testHost(){
		net.currentHostTest();
	}
	/**
	 * Is connected to internet?
	*/
	public static boolean isOnline(){
		return net.connectedToInternet();
	}
	/**
	 * Tests if site is up.
	*/
	public static boolean isSiteOnline(String url){
		return net.siteonline(url);
	}
	//=================================================
	/**
	 * Returns a float concersion of F TO C
	*/
	public static float FahrenheitToCelcius(float currentFTemp){
		float ret = 0.0f;
		ret = (((currentFTemp - 32)*5)/9);
		return ret;
	}
	/**
	 * Returns a float concersion of C TO F
	*/
	public static float CelciusToFahrenheit(float currentCTemp){
		float ret = 0.0f;
		ret =  (9*currentCTemp/5 + 32);
		return ret;
	}
	/**
	 * Executes external program
	*/
	public static void executeExternalProgram(String program) throws IOException{
		Runtime r = Runtime.getRuntime();
		r.exec(program);
	}
	public static void runHostCMD(String com){
		Runtime t = Runtime.getRuntime();
		try {
			t.exec(com);
		} catch (IOException e) {
			if(DEV_MODE)e.printStackTrace();
			console("ERROR EXECUTING COMMAND");
		}
	}
	
	
}
