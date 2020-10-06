public class Time {
    int hour;
    private int minute;
    private int second;
    public Time(int hour, int minute, int second){
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59){
            throw new UnsupportedOperationException("Invalid time values");
        }
        else{
            this.hour= hour;
            this.minute= minute;
            this.second= second;
        }
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    public void setMinute(int newMinute){
        if (newMinute < 0 || newMinute > 59){
            throw new UnsupportedOperationException("Invalid time values");
        }
        else {
            minute= newMinute;
        }
    }
    public void setSecond(int newSecond){
        if (newSecond < 0 || newSecond > 59){
            throw new UnsupportedOperationException("Invalid time values");
        }
        else {
            second= newSecond;
        }
    }
    public String getCurrentTime(){
        return String.format("%d:%d:%d", hour, minute, second);
    }
}
