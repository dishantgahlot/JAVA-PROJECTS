import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangmanGame {
    public static  void main(String[] args) {
            String filePath = "C:\\Users\\disha\\IdeaProjects\\my first project\\src\\word.txt";
            ArrayList<String> words = new ArrayList<>();

         try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }

        catch(FileNotFoundException e){
            System.out.println("FILE NOT FOUND");
        }
        catch(IOException f){
            System.out.println("SOMETHING WENT WRONG ");
        }
        Random random = new Random();
         String word = words.get(random.nextInt(words.size()));

         Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuesses = 0 ;
        char guess;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('-');
        }

         while(wrongGuesses < 6) {
          System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
          System.out.println("WELCOME TO JAVA HANGMAN 🪂");
          System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");

             System.out.println(hangmanart(wrongGuesses));

         System.out.print("WORD : ");
          for (Character c : wordState) {
              System.out.print(c + " ");
          }

          System.out.print("\nGUESS YOUR LETTER : ");
          guess = scanner.next().toLowerCase().charAt(0);


          if (word.indexOf(guess) >= 0) {
              System.out.println("CORRECT GUESS !👌");

              for (int i = 0; i < word.length(); i++) {
                  if (word.charAt(i) == guess) {
                      wordState.set(i, guess);
                  }
              }
          }
          else {
              wrongGuesses++;
              System.out.println("WRONG GUESS ! 😔");

              }
          if(!wordState.contains('-')){
              System.out.println("YOU WON !!❤️");
              System.out.println("THE WORLD IS : " + word );
              break;
          }
            }

         if(wrongGuesses >= 6){
        System.out.println(hangmanart(wrongGuesses));
        System.out.println("THANKS FOR PLAYING BYE!👋");
        System.out.println("THE WORLD IS : " + word);
         }


    }
     static String hangmanart(int wrongGuesses){
        return switch(wrongGuesses) {
            case 0 -> """   
                    """;
            case 1 -> """
                       o
                    
                    """;
            case 2 -> """
                      o
                      |
                      
                    """;
            case 3 -> """
                     0
                    /|
                    
                    """;
            case 4 -> """
                      0
                     /|\\
                     
                    """;

            case 5 -> """
                      o
                     /|\\
                     /
                    """;

            case 6 -> """
                      o
                     /|\\
                     / \\
                    """;
            default -> "INVALID NUMBER ";


        };
    }

}
