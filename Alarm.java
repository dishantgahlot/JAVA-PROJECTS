import javax.crypto.spec.PSource;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Alarm implements Runnable {

    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;

    public Alarm(LocalTime alarmTime, String filePath, Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        while (LocalTime.now().isBefore(alarmTime)) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                int hours;
                int minutes;
                int seconds;

                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");

            }
        }


        alarmRun(filePath);

    }

    private void alarmRun(String filePath) {

        File file = new File(filePath);
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file); Clip clip = AudioSystem.getClip()) {
            clip.open(audioStream);
            clip.start();
            String choice;
            String x;
            System.out.print("\nPRESS (YES) TO STOP THE ALARM  OR TYPE (SNO) TO SNOOZE : ");
            choice = scanner.nextLine().toUpperCase();

                 switch(choice){
                    case "YES" -> clip.stop();

                    case "SNO" -> {

                        do {
                            clip.stop();
                            String input;
                            LocalTime snoozeTime = null;

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                            while (snoozeTime == null) {
                                try {
                                    System.out.print("Set the snooze time (HH:mm:ss): ");
                                    input = scanner.nextLine();
                                    snoozeTime = LocalTime.parse(input, formatter);
                                    System.out.println("Alarm is snoozed for: " + snoozeTime);


                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid time format. Please use HH:mm:ss.");
                                } catch (Exception e) {
                                    System.out.println("Something went wrong.");
                                }
                            }

                            while (LocalTime.now().isBefore(snoozeTime)) {
                                try {
                                    Thread.sleep(1000);
                                    LocalTime now = LocalTime.now();
                                    int hours;
                                    int minutes;
                                    int seconds;

                                    System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
                                } catch (InterruptedException e) {
                                    System.out.println("Thread was interrupted.");

                                }


                            }

                            clip.start();
                            clip.setFramePosition(0);

                            System.out.print("\nENTER (S) TO Snooze again or (E) to exit : ");
                            x = scanner.nextLine().toUpperCase();

                        } while (x.contains("S"));
                        clip.stop();
                    }

                    default -> System.out.println("ILLEEGAL EXCEPTION " + choice);


                }
            }

        catch (
                UnsupportedAudioFileException e) {
            System.out.println("AUDIO FILE IS NOT SUPPORTED");
        } catch (
                FileNotFoundException e) {
            System.out.println("FILE IS NOT FOUND ");
        } catch (
                LineUnavailableException e) {
            System.out.println("LINE IS NOT AVALIABLE");
        } catch (
                IOException e) {

            System.out.println("SOMETHING WENT WRONG");
        }
    }
}












