import java.util.Scanner;

public class GuessTheMovie {

    public static void main(String[] args) {
        WordManager wordManager = new WordManager();
        Scanner scanner = new Scanner(System.in);
        while(!(!wordManager.hasCompletedTheWord() ^ !wordManager.hasLostTheGame())){
            System.out.println("Você está adivinhando: " + wordManager.getMovieNameWithUnderscoredLetters());
            System.out.println("Voce disse ("+wordManager.getHowManyWrongLetters()+") letras erradas");
            System.out.print("Diga uma letra: ");
            System.out.println(wordManager.takeAGuess(scanner.next().charAt(0)));
        }
        System.out.println("\n");
        if(wordManager.hasLostTheGame()){
            System.out.println("Voce Perdeu!");
        } else {
            System.out.println("Você Ganhou!");
        }
        System.out.println("O filme era: "+ wordManager.getMovieName());
        System.out.println("Você errou "+ wordManager.getHowManyWrongLetters() + " letras");
    }

}
