import java.util.Scanner;

public class GuessTheMovie {

    public static void main(String[] args) {
        WordManager wordManager = new WordManager();
        System.out.println("Você está adivinhando: " + wordManager.getMovieNameWithUnderscoredLetters());
        Scanner scanner = new Scanner(System.in);
        while(!wordManager.hasCompletedTheWord()){
            System.out.println(wordManager.takeAGuess(scanner.next().charAt(0)));
            System.out.println("Você está adivinhando: " + wordManager.getMovieNameWithUnderscoredLetters());
        }
    }

}
