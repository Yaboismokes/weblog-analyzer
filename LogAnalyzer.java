
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
        for(; total <= hourCounts.length; total++){

        }
        // Add the value in each element of hourCounts to total. ...
        return total;
    } 

}
