import java.util.Random;
import java.util.Scanner;

public class albus {

    public static  void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numofdice  = 0;
        int choice = 0 ;
        int numofrool = 0;
        String valid;

do {
    System.out.println("WELCOME TO JAVA DICE ROLLING GAME");
    System.out.print("ENTER THE NUMBER OF DICE TO BE ROOLED : ");
    numofdice = scanner.nextInt();

    if (numofdice == 0) {
        System.out.println("NUMBER OF DICE CANNOT BE ZERO ");
    } else if (numofdice < 0) {
        System.out.println("NUMBER OF DICE CANNOT BE NEGATIVE");
    } else {
        for (int i = 0; i < numofdice; i++) {
            choice = random.nextInt(1, 7);
            dies(choice);
            System.out.println(" YOU ROLLED : " + choice);
          numofrool += choice;}

    }

    System.out.println("NUMBER OF ROOLS ARE : " + numofrool);
    System.out.print("YOU WANT TO EXIT GAME (YES/NO) : ");
    valid = scanner.next();
}while(valid.equalsIgnoreCase("yes"));

        System.out.println("THANKS FOR PLAYING 😊!! HAVE A NICE DAY ❤️");









    }
    static void dies(int choice){
        String die1 = """
                 ------------
                |            |
                |     ●      |
                |            |
                |            |
                 -----------
               """;
        String die2 = """
                 -------------
                |             |
                |  ●          |
                |         ●   |
                |             |
                 --------------
                """;
        String die3 = """
                 --------------
                | ●            |
                |      ●       |
                |            ● |
                |               |
                 ---------------
                
                """;
        String die4 = """
                ------------
                |  ●      ● |
                |            |
                |  ●     ●  |
                |            |
                 ------------         
                 """;
        String die5 = """
                 ------------
                |  ●      ●  |
                |      ●     |
                |  ●       ● |
                |             |
                 ------------
                 """;
        String die6 = """
                 ------------
                |  ●  ●   ● |
                |            |
                | ●   ●   ● |
                |            |
                 ------------
                """;

        switch(choice) {
          case 1 -> System.out.println(die1);
          case 2 -> System.out.println(die2);
          case 3 -> System.out.println(die3);
          case 4 -> System.out.println(die4);
          case 5 -> System.out.println(die5);
          case 6 -> System.out.println(die6);
          default -> System.out.println("INVALID ROLL !!");
      }

        }

                  
}


        

    
