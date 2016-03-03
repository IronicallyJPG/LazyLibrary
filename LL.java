package Charles.LazyLibrary;

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
	public static String author 	= "Charles";
	public static String LibName 	= "LazyLib";
	public static String Version 	= "0.1.0";
	public static String Desc 		= "A Simple Lazy Library.";
	public static ArrayList<Object> runtimeArgs;
	private static LLD date = new LLD();
	private static LLN net = new LLN();
	private static LLIO io = new LLIO();
	//=====================================================================//
	
	/**
	 * @param t The String to write to console. 
	*/
	public static void console(Object t){
		System.out.println(t);
	}
	//=====================================================================//
	
	/**
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
	
	/**
	 * @param s String to Break Down.
	 * */
	public static ArrayList<Character> lettersAsArray(String s){
		ArrayList<Character> ret = new ArrayList<Character>();
		ret.clear();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				ret.add(s.charAt(i));
				LL.console("Space At Index: "+i);
			}else{
				ret.add(s.charAt(i));
			}
		}
		return ret;
	}
	//=====================================================================//
	
	/**
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
	
	public static void newSection(){
		console("//=====================================================================//");
	}
	//=====================================================================//
	
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
	
	public static String getCurrentDirectory(){
		return System.getProperty("user.dir");
	}
	public static String[] getCurrentDirectoryContents(){
		return io.getCDContents();
	}
	
	//==================================================================//
	
	public static String getCurrentDay(){
		date = new LLD();
		return date.getNameOfDayInDate();
	}
	public static String getCurrentMonth(){
		date = new LLD();
		return date.getNameOfMonthInDate();
	}
	public static String getCurrentYear(){
		date = new LLD();
		return date.getYearInDate();
	}
	public static String getCurrentTime(){
		date = new LLD();
		return date.getTimeOfDayInDate();
	}
	public static String getCurrentTimeWithAmPm(){
		date = new LLD();
		return date.getTimeOfDayInDateWithAMPM();
	}
	public static String getCurrentDayOfTheMonth(){
		date = new LLD();
		return date.getDayOfMonth();
	}
	public static String getWholeDateAsString(){
		date = new LLD();
		return "Current Date:\n\tMonth\t: "+getCurrentMonth()+
							"\n\tDay\t: "+getCurrentDay()+"/"+getCurrentDayOfTheMonth()+
							"\n\tYear\t: "+getCurrentYear();
	}
	public static String[] getDaysOfTheWeek(){
		return date.days;
	}
	public static String[] getMonthsOfTheYear(){
		return date.months;
	}
	//=============================================================//
	 
	public static Object getAvailibleProcessor(){
		return  Runtime.getRuntime().availableProcessors();
	}
	public static String getJavaVersion(){
		return System.getProperty("java.version");
	}
	public static String getOsName(){
		return System.getProperty("os.name");
	}
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
	public static String getOsArchitecture(){
		return System.getProperty("os.arch");
	}
	public static String getCurrentUserName(){
		return System.getProperty("user.name");
	}
	public static String getCurrentCountry(){
		return System.getProperty("user.country");
	}
	//=============================================================//
	public static int countRepeatsInArray(ArrayList<?> l, Object toCheckFor){
		int ret = -1;
		for(int i = 0; i < l.size(); i++){
			if(l.get(i).equals(toCheckFor)){
				ret++;
			}
		}
		return ret;
	}
	public static void ShuffleArrayList(ArrayList<?> ls){
		Collections.shuffle(ls);
	}
	public static void ShuffleList(List<?> list){
		Collections.shuffle(list);
	}
	//=============================================================//
	
	public static void newFile(String name){
		io.createFile(name);
	}
	public static void newTempFile(String name){
		io.createTempFile(name);
	}
	public static void deleteFile(String name){
		File f = new File(name+".txt");
		io.deleteFile(f);
	}
	public static void deleteFile(String name, String ext_WithOut_Period){
		File f = new File(name+"."+ext_WithOut_Period);
		io.deleteFile(f);
	}
	public static void writeToFile(String fileName, String dataToWrite, boolean newLine){
		File f = new File(fileName+".txt");
		io.writeTextToFile(f, dataToWrite, newLine);
	}
	public static String getDataFromFile(String fileName){
		File f = new File(fileName+".txt");
		return io.getTextFromFile(f);
	}
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
	public static void scrnShot(String sc){
		io.ScreenShot(sc);
	}
	//======
	public static void deleteAFile(File f){
		io.deleteFile(f);
	}
	public static void writeToFile(File f, String dataToWrite, boolean newLine){
		io.writeTextToFile(f, dataToWrite, newLine);
	}
	public static boolean isFilePresent(String fileName){
	    File f = new File(fileName+".txt");
	    return io.doesFileExist(f);
	}
	public static boolean isFilePresentExt(String fileName, String extension){
	    File f = new File(fileName+"."+extension);
	    return io.doesFileExist(f);
	}
	//==================================================
	// Net Tools!
	public static void testHost(){
		net.currentHostTest();
	}
	public static boolean isOnline(){
		return net.connectedToInternet();
	}
	public static boolean isSiteOnline(String url){
		return net.siteonline(url);
	}
	//=================================================
	public static float FahrenheitToCelcius(float currentFTemp){
		float ret = 0.0f;
		ret = (((currentFTemp - 32)*5)/9);
		return ret;
	}
	public static float CelciusToFahrenheit(float currentCTemp){
		float ret = 0.0f;
		ret =  (9*currentCTemp/5 + 32);
		return ret;
	}
	public static void executeExternalProgram(String program) throws IOException{
		Runtime r = Runtime.getRuntime();
		r.exec(program);
	}
	
	
}
