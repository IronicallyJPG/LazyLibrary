package Charles.LazyLibrary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LLD extends LL{
	
	private ArrayList<String> wholeDate = new ArrayList<String>();
	private Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	//=============================================================//
	public final String[] days = {
			"Sunday", 
			"Monday", 
			"Tuesday",
			"Wednesday",
			"Thursday",
			"Friday",
			"Saturday"
	};
	private String day = "---";
	//=============================================================//
	public final String[] months = {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
	};
	private String month = months[0];
	//=============================================================//
	private String year = "---";
	//=============================================================//
	private String time = "---";
	private String timeWithSeconds = "---";
	private String timeWithAMPM = "---";
	//============================================================//
	private boolean isCustomDate = false;
	private boolean hasTime = true;
	
	//=============================================================//
	//=============================================================//
	public LLD(){
		setCurrentDate();
	}
	//=============================================================//
	public LLD(String day, String month, String year, String time){
		this.year = year;
	    this.month = month;
	    this.day = day;
	    this.time = time;
	    this.timeWithSeconds = time+":00";
	    setCustomDate(true);
	}
	//=============================================================//
	public LLD(String day, String month, String year){
		this.year = year;
	    this.month = month;
	    this.day = day;
	    setCustomDate(true);
	    setHasTime(false);
	}
	//=============================================================//
	//=============================================================//
	
	private void setCurrentDate(){
		Date date  = cal.getTime();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd hh mm ss aa");
	    
	    String[] d = sdf.format(date).split(" "); 
	    
	    for(int i = 0; i < d.length; i++){
	    	wholeDate.add(d[i]);
	    }
	    this.year = d[0];
	    this.month = d[1];
	    this.day = d[2];
	    
	    this.time = d[3]+":"+d[4];
	    this.timeWithSeconds = d[3]+":"+d[4]+":"+d[5];
	    this.timeWithAMPM =d[3]+":"+d[4]+" "+d[6];
	}
	//=============================================================//
	public String getNameOfDayInDate(){
		if(this.isCustomDate==true){
			return this.day;
		}else{
			return days[cal.get(Calendar.DAY_OF_WEEK)-1];
		}
	}
	//=============================================================//
	public String getDayOfMonth(){
		return this.day;
	}
	//=============================================================//
	public String getNameOfMonthInDate() {
		if(this.isCustomDate==true){
			return this.month;
		}else{
			return months[cal.get(Calendar.MONTH)];
		}
	}
	//=============================================================//
	public String getYearInDate() {
		if(this.isCustomDate==true){
			return this.year;
		}else{
			return String.valueOf(cal.get(Calendar.YEAR));
		}
	}
	//=============================================================//
	public String getTimeOfDayInDate() {
		return this.time;
	}
	//=============================================================//
	public String getTimeOfDayInDateWithAMPM() {
		return this.timeWithAMPM;
	}
	//=============================================================//
	public String getTimeOfDayInDateWithSeconds() {
		return this.timeWithSeconds;
	}
	//=============================================================//
	public ArrayList<String> getWholeDate(){
		return this.wholeDate;
	}
	//=============================================================//
	public boolean isCustomDate() {
		return isCustomDate;
	}
	//=============================================================//
	private void setCustomDate(boolean isCustomDate) {
		this.isCustomDate = isCustomDate;
	}
	//=============================================================//
	public boolean HasTime() {
		return hasTime;
	}
	//=============================================================//
	private void setHasTime(boolean hasTime) {
		this.hasTime = hasTime;
	}
	//=============================================================//
	
}
