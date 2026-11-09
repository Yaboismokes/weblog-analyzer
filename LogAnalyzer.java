
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class LogAnalyzer
{
    public static final int HOURS_PER_DAY = 24;
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];            // {0,0,0,0,0,0,0}
        // Create the reader to obtain the data.
        reader = new LogfileReader();                   //  read the weblog.txt

    }
    //Question 5
    public LogAnalyzer(String fileName) {
        hourCounts = new int[HOURS_PER_DAY];            // {0,0,0,0,0,0,0}
        // Create the reader to obtain the data.
        reader = new LogfileReader(fileName);                   //  read the weblog.txt
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    { //Question 4
        int hour = 0;
        while(hour < hourCounts.length){
            System.out.println(hour + ":" + hourCounts[hour]);
            hour++;
        }

        // System.out.println("Hr: Count");
        // for(int hour = 0; hour < hourCounts.length; hour++) {
        // System.out.println(hour + ": " + hourCounts[hour]);
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    //Question 6/7
    public int numberOfAccesses() {
        int total = 0;
        for(int hour = 0; hour <= hourCounts.length; hour++){
            total = total + hourCounts[hour];
        }
        // Add the value in each element of hourCounts to total. ...
        return total;
    } 
    //Question 8
    public int busiestHour() {
        int busiestHour = 0;
        for(int hour : hourCounts) {
            if(hour > busiestHour) {
                busiestHour = hour;
            }
        }
        return busiestHour;

    }
    //Question 9
    public int quickestHour() {
        int quick = 0;
        for(int hour = 1; hour < hourCounts.length; hour++) {
            if(hourCounts[hour] < hourCounts[quick]) {
                quick = hour;
            }
        }
        return quick;

    }
    //Question 11
    public int busiestTwoHour() {
        int busiest = 0;
        int max = hourCounts[0] + hourCounts[1];
        for(int hour = 1; hour < hourCounts.length - 1; hour++) {
            int total = hourCounts[hour] + hourCounts[hour + 1];
            if(total > max) {
                max = total;
                busiest = hour;
            }
        }
        return busiest;
    }
}
