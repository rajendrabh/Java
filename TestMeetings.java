/*
*  Description : Given a list to Calendar meetings find the most minute that is overlapped.
*
*/

import java.util.*;
import java. io.*;
import java.text.SimpleDateFormat;

public class TestMeetings {

    public static void main(String[] args) {
        List<Meetings> meetingsList = new ArrayList<Meetings>();
        meetingsList.add(new Meetings());
        meetingsList.add(new Meetings(System.currentTimeMillis() + (2* 1000 * 60 * 60), System.currentTimeMillis() + (3* 1000 * 60 * 60)));
        meetingsList.add(new Meetings());
        meetingsList.add(new Meetings(System.currentTimeMillis() + (3* 1000 * 60 * 60), System.currentTimeMillis() + (4* 1000 * 60 * 60)));
        meetingsList.add(new Meetings());
        meetingsList.add(new Meetings(System.currentTimeMillis() + (2* 1000 * 60 * 60), System.currentTimeMillis() + (5* 1000 * 60 * 60)));
        meetingsList.add(new Meetings());
        meetingsList.add(new Meetings(System.currentTimeMillis() + (4* 1000 * 60 * 60), System.currentTimeMillis() + (6* 1000 * 60 * 60)));
        findMaxOverlaptime(meetingsList);
    }

    public static void findMaxOverlaptime(List<Meetings> meetings) {
        Map<String, Integer> overLaphashMap = new HashMap<String, Integer>();
        for (Meetings meeting : meetings) {
            if (meeting.getStartTime() > meeting.getEndTime()) {
                System.out.println("Start Time " + meeting.getStartTime() + " cannot be more than End Time " + meeting.getEndTime());
                return; // Exception if Start time is more than End Time
            }
            // This will be incremented in one minute interval
            long time_interval = meeting.getStartTime();
            for (int i = 0; time_interval < meeting.getEndTime(); i++) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd-H:mm"); // Specify the Date Format
                String key = (String)timeFormat.format(time_interval); // Convert the time_interval into DateFormat

                // Now add the key to HashMap
                if (overLaphashMap.get(key) == null) {
                    overLaphashMap.put(key, 1);
                } else { // If the key is already in the HashMap then increment the value
                    int value = overLaphashMap.get(key).intValue();
                    value++;
                    overLaphashMap.put(key, value);
                }
                // Now increment the time/date by 1 minute
                time_interval = time_interval + (60 * 1000);
            }
        }
        // Create a value Comparator object so we can create a TreeMap
        //   that will store the elements in the Hash with sorted values.
        ValueComparator valComp =  new ValueComparator(overLaphashMap);

        // Declare a TreeMap with ValueComparator object so it can sort based on values in the Hash
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(valComp);
 
        //Store all the elements into TreeMap
        sorted_map.putAll(overLaphashMap);
        //System.out.println("results: " + sorted_map);

        // *** PRINT THE SORTED MAP ***
        // Get all entries into a set
        Set<Map.Entry<String, Integer>> entrySet = sorted_map.entrySet();

        // Get key and value from each entry
        for (Map.Entry<String, Integer> entry: entrySet)
            System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
}

class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
