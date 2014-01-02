public class Meetings {
    private long StartTime;
    private long EndTime;

    public Meetings() {
        this.StartTime = System.currentTimeMillis();
        this.EndTime = System.currentTimeMillis() + (1000 * 60 * 60); // Add an hour
    }

    public Meetings(long sTime, long eTime) {
        this.StartTime = sTime;
        this.EndTime = eTime;
    }
    public long getStartTime() {
        return StartTime;
    }

    public void setStartTime(long sTime) {
        StartTime = sTime;
    }

    public long getEndTime() {
        return EndTime;
    }

    public void setEndTime(long eTime) {
        EndTime = eTime;
    }
}
