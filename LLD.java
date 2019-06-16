
package Main;

import java.text.*;
import java.util.*;

public class LLD {

  // All Date Values in Array Format
  private ArrayList<String> wholeDate = new ArrayList<String>();
  // Calender Instance to pull ALL Values from JVM
  private Calendar cal = Calendar.getInstance(TimeZone.getDefault());
  // =============================================================//
  // Days of The week in an easy to pull Array
  public final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  // Object Variable.
  private String day = days[0];
  // =============================================================//
  // Months in an easy to pull array
  public final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
      "October", "November", "December"};
  private String month = months[0];
  // =============================================================//
  // Various Variables for the OBJECT itself.
  private String year = "---";
  private String time = "---";
  private String timeWithSeconds = "---";
  private String timeWithAMPM = "---";
  // ============================================================//
  // Checks if any values set are NOT from the JVM
  private boolean isCustomDate = false;
  // If the date has a time.
  private boolean hasTime = true;

  // =============================================================//
  // Fresh Objects Set the date from the JVM.
  public LLD() {
    LL.LL_LINK(); // EMPTY MESSAGE TO LINK TO MAIN LIBRARY
    setCurrentDate("yyyy MM dd kk mm ss aa");
  }

  // =============================================================//
  // Custom Date Object WITH Time passed.
  public LLD(String day, String month, String year, String time) {
    this.year = year;
    this.month = month;
    this.day = day;
    this.time = time;
    this.timeWithSeconds = time + ":00";
    setCustomDate(true);
  }

  // =============================================================//
  // Custom Date Object WITHOUT Time passed.
  public LLD(String day, String month, String year) {
    this.year = year;
    this.month = month;
    this.day = day;
    setCustomDate(true);
    setHasTime(false);
  }
  // =============================================================//

  // Sets the Current Date, DEFAULT for this Date Object.
  private void setCurrentDate(String TimeDateFormat) {
    Date date = cal.getTime();
    SimpleDateFormat sdf = new SimpleDateFormat(TimeDateFormat);

    String[] d = sdf.format(date).split(" ");

    for (int i = 0; i < d.length; i++) {
      wholeDate.add(d[i]);
    }

    this.year = d[0];
    this.month = d[1];
    this.day = d[2];

    this.time = d[3] + ":" + d[4];
    this.timeWithSeconds = d[3] + ":" + d[4] + ":" + d[5];
    try {
      this.timeWithAMPM = d[3] + ":" + d[4] + " " + d[6];
    } catch (ArrayIndexOutOfBoundsException e) {
      timeWithAMPM = "INVALID_DATE_TIME_FORMAT_FOR_AM_PM";
    }

  }

  // =============================================================//
  // Returns Name of the day
  public String getNameOfDayInDate() {
    if (this.isCustomDate == true)
      return this.day;
    else
      return days[cal.get(Calendar.DAY_OF_WEEK) - 1];
  }

  // =============================================================//
  // Returns day of the month
  public String getDayOfMonth() {
    return this.day;
  }

  // =============================================================//
  // Returns month name
  public String getNameOfMonthInDate() {
    if (this.isCustomDate == true)
      return this.month;
    else
      return months[cal.get(Calendar.MONTH)];
  }

  // =============================================================//
  // Returns year
  public String getYearInDate() {
    if (this.isCustomDate == true)
      return this.year;
    else
      return String.valueOf(cal.get(Calendar.YEAR));
  }

  // =============================================================//
  // Returns time as STRING, not an int or float.
  public String getTimeOfDayInDate() {
    return this.time;
  }

  // =============================================================//
  // Returns Time with AM/PM indicator
  public String getTimeOfDayInDateWithAMPM() {
    return this.timeWithAMPM;
  }

  // =============================================================//
  // Returns time with Seconds added on.
  public String getTimeOfDayInDateWithSeconds() {
    return this.timeWithSeconds;
  }

  // =============================================================//
  // Returns whole date array
  public ArrayList<String> getWholeDate() {
    return this.wholeDate;
  }

  // =============================================================//
  // Check if custom date has been set
  public boolean isCustomDate() {
    return isCustomDate;
  }

  // =============================================================//
  // Makes Date Custom.
  private void setCustomDate(boolean isCustomDate) {
    this.isCustomDate = isCustomDate;
  }

  // =============================================================//
  // Does Date have a time variable?
  public boolean HasTime() {
    return hasTime;
  }

  // =============================================================//
  // Toggles True/False Boolean for previous
  private void setHasTime(boolean hasTime) {
    this.hasTime = hasTime;
  }

  // ===============================================================//
  // Converts Millis to String Time
  public String MillisToTimeString(long ms) {
    long totalSecs = ms / 1000;
    long hours = (totalSecs / 3600);
    long mins = ((totalSecs / 60) % 60);
    long secs = (totalSecs % 60);

    String minsString = (mins == 0) ? "00" : ((mins < 10) ? "0" + mins : "" + mins);
    String secsString = (secs == 0) ? "00" : ((secs < 10) ? "0" + secs : "" + secs);

    if (hours > 0)
      return hours + ":" + minsString + ":" + secsString;
    else
      return mins + ":" + secsString;
  }

}
