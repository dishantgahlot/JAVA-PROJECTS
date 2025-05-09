import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath = "C:\\Users\\disha\\IdeaProjects\\my first project\\sabrina-carpenter-espresso.wav";

        LocalTime alarmTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (alarmTime == null) {
            try {
                System.out.print("Set the alarm time (HH:mm:ss): ");
                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm is set for: " + alarmTime);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use HH:mm:ss.");
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        }

        Alarm alarm = new Alarm(alarmTime , filePath , scanner);
        Thread thread = new Thread(alarm);
        thread.start();


    }
}
