import java.time.*;
import java.time.format.DateTimeFormatter; 

public class Time {
    public static void main(String[] args){
        LocalDateTime time1= LocalDateTime.now();
        System.out.println(time1);

        LocalDateTime time2= time1.plusYears(2);
        DateTimeFormatter formatter= DateTimeFormatter.BASIC_ISO_DATE;
        String time2_formatted= time2.format(formatter);
        System.out.println(time2_formatted);
    }
}
