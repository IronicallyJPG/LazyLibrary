package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LL {
	
	/* Welcome to this Library.
	 * Adding Some basic Methods.
	 * Feel Free to use them.
	 * 'DEV_MODE' set to true will output more USEFUL Errors instead of sidestepping them
	 * 
	 * TO USE: just do LL. to  get all these functions, AFTER making sure to setup your workspace
	*/

	//====================================================================//
	// 		Basic Variables Needed Supplied for Library              	  //
	public static String AUTHOR 	= "Charles";
	public static String LibName 	= "LazyLib";
	public static String VERSION 	= "1.5.2";
	public static String Desc 		= "A Simple Lazy Library.";
	public static boolean DEV_MODE 	= false;
	public static ArrayList<Object> runtimeArgs;
	private static LLD date = new LLD(); // Dates Extension
	private static LLN net 	= new LLN(); // Netowkring Extension
	private static LLIO io 	= new LLIO();// I/O Extension
	private static LLE en	= new LLE(); // Encryption Extension
	private static LLM math = new LLM(); // Math Extension
	
	
	//=====================================================================//
	// Averages
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static int AverageInt(int[] in){
		return math.averageInt(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static int AverageInt(ArrayList<Integer> in){
		return math.averageInt(in);
	}
	//==================
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static long AverageLong(long[] in){
		return math.averageLong(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static long AverageLong(ArrayList<Long> in){
		return math.averageLong(in);
	}
	//==================
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static float AverageFLOAT(float[] in){
		return math.averageFloat(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static float AverageFloat(ArrayList<Float> in){
		return math.averageFloat(in);
	}
	//==================
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static double AverageDouble(double[] in){
		return math.averageDouble(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static double AverageDouble(ArrayList<Double> in){
		return math.averageDouble(in);
	}
	//=====================================
	// Highest Values
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static int highestINTFromArray(int[] in){
		return math.findLargestValueINT(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static int highestINTFromList(ArrayList<Integer> in){
		return math.findLargestValueINT(in);
	}
	//==================
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static long highestLONGFromArray(long[] in){
		return math.findLargestValueLONG(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static long highestLONGFromArray(ArrayList<Long> in){
		return math.findLargestValueLONG(in);
	}
	//==================
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static float highestFLOATFromArray(float[] in){
		return math.findLargestValueFLOAT(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static float highestFLOATFromArray(ArrayList<Float> in){
		return math.findLargestValueFLOAT(in);
	}
	//==================
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static double highestDOUBLEFromArray(double[] in){
		return math.findLargestValueDOUBLE(in);
	}
	/**
	 * Takes a List/Array and Makes an Average out of all the values
	 * 
	 * @param in The input
	 * */
	public static double highestDOUBLEFromArray(ArrayList<Double> in){
		return math.findLargestValueDOUBLE(in);
	}
	
	//=====================================================================//
	
	
	
	//=====================================================================//
	/**
	 * Console wrapped into an easier to access method. 
	 * ( Saving you from System.out.println(s) )
	 * @param t The String to write to console. 
	*/
	public static void console(Object t){
		System.out.println(t);
	}
	/**
	 * SLOW PRINT Tool
	 * @param t The String to write to console.
	 * @param seconds Time to display test. 
	*/
	public static void slowPrint(Object t, int seconds){
		char[] test = t.toString().toCharArray();
		int timer = ((seconds*1000)/test.length);
		for(char f : test){
			System.out.print(f);
			try {Thread.sleep(timer);} catch (InterruptedException e) {if(DEV_MODE==true)e.printStackTrace();} // Slow Print Trick
		}
	}
	/**
	 * Sends a message only seen when DEV_MODE is enabled
	 * @param message Info to display.
	 * @param time Add a time to the message
	 * */
	public static void DebugMsg(Object message, String time){
		if(DEV_MODE==true)console("<<DEBUG : "+time+">> "+message);
	}
	/**
	 * Sends a message only seen when DEV_MODE is enabled
	 * @param message Info to display.
	 * */
	public static void DebugMsg(Object message){
		if(DEV_MODE==true)console("<<DEBUG>>"+message);
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
		ret.trim();
		return ret;
	}
	//=====================================================================//
	/**
	 * Pauses Thread
	 * @param seconds Time in SECONDS to pause Thread
	 * */
	public static void pauseCurrentThread(float seconds){
		try {
			Thread.currentThread();
			Thread.sleep(((long)(seconds*1000)));
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
	 * TRIES to convent a String to Integer
	 * @param input String to check
	 * */
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	        
	    }
	}
	/**
	 * Returns Random Number
	 * @param max Ceiling for Random Value 
	 * */
	public static int random(int max){
		if(max<=0){max = 2;}
		Random rand = new Random();
		return rand.nextInt(max);
	} 
	/**
	 * INT -> HEX
	 * @param value INT in
	 * */
	public static String HexfromInt(int value){
		return Integer.toHexString(value);
	} 
	/**
	 * INT -> BINARY
	 * @param value INT in
	 * */
	public static String BinaryfromInt(int value){
		return Integer.toBinaryString(value);
	} 
	/**
	 * INT -> Octal
	 * @param value INT in
	 * */
	public static String OctalfromInt(int value){
		return Integer.toOctalString(value);
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
	 * Adds a 'section' cutter. Pointless? Maybe
	 * */
	public static void newSection(){
		console("//==========================================================//");
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
	 * The Sentence Similar to the word to letters array method 
	 * @param sent The Sentence to break up
	 * 
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
	//======================================================
	/**
	 * Prompts a question while return the answer as a string.
	 * @param q Question to prompt.
	 * */
	public static String BasicHash(String in, int max){
		return en.Basichash(in, max);
	}
	//======================================================
	// Sound Thread to pass on
	public static Thread soundThread(String FileName, boolean repeat){
		return new LLS(FileName, repeat);
	}
	//======================================================
	// Press Enter to continue bit.
	public static void pressEnterToContinue(){
		LL.askQuestion("Press Enter To Continue");
	}
	
	//=======================
	// ALL THE KEYZ
	public static int getKeyVal(char in){return in;}
	
	public static final int
	KEY_APOSTROPHE    = 39,
	KEY_COMMA         = 44,
	KEY_MINUS         = 45,
	KEY_PERIOD        = 46,
	KEY_SLASH         = 47,
	KEY_0             = 48,
	KEY_1             = 49,
	KEY_2             = 50,
	KEY_3             = 51,
	KEY_4             = 52,
	KEY_5             = 53,
	KEY_6             = 54,
	KEY_7             = 55,
	KEY_8             = 56,
	KEY_9             = 57,
	KEY_SEMICOLON     = 59,
	KEY_EQUAL         = 61,
	
	KEY_a             = 97,
	KEY_b             = 98,
	KEY_c             = 99,
	KEY_d             = 100,
	KEY_e             = 101,
	KEY_f             = 102,
	KEY_g             = 103,
	KEY_h             = 104,
	KEY_i             = 105,
	KEY_j             = 106,
	KEY_k             = 107,
	KEY_l             = 108,
	KEY_m             = 109,
	KEY_n             = 110,
	KEY_o             = 111,
	KEY_p             = 112,
	KEY_q             = 113,
	KEY_r             = 114,
	KEY_s             = 115,
	KEY_t             = 116,
	KEY_u             = 117,
	KEY_v             = 118,
	KEY_w             = 119,
	KEY_x             = 120,
	KEY_y             = 121,
	KEY_z             = 122,
	
	KEY_A             = 65,
	KEY_B             = 66,
	KEY_C             = 67,
	KEY_D             = 68,
	KEY_E             = 69,
	KEY_F             = 70,
	KEY_G             = 71,
	KEY_H             = 72,
	KEY_I             = 73,
	KEY_J             = 74,
	KEY_K             = 75,
	KEY_L             = 76,
	KEY_M             = 77,
	KEY_N             = 78,
	KEY_O             = 79,
	KEY_P             = 80,
	KEY_Q             = 81,
	KEY_R             = 82,
	KEY_S             = 83,
	KEY_T             = 84,
	KEY_U             = 85,
	KEY_V             = 86,
	KEY_W             = 87,
	KEY_X             = 88,
	KEY_Y             = 89,
	KEY_Z             = 90,
	
	KEY_LEFT_BRACKET  = 91,
	KEY_BACKSLASH     = 92,
	KEY_RIGHT_BRACKET = 93,
	KEY_GRAVE_ACCENT  = 96,
	KEY_WORLD_1       = 161,
	KEY_RIGHT         = 262,
	KEY_LEFT          = 263,
	KEY_DOWN          = 264,
	KEY_UP            = 265,
	KEY_WORLD_2       = 162;	
//================================
	public static void LL_LINK(){
		/*
		 * I Exist for the Sole Purpose of Linking LL to Extensions
		 * */
	}
}
