public class GuessTheMovie {

    public static void main(String[] args) {
        WordManager wordManager = new WordManager();
        System.out.println(wordManager.getMovieNameWithUnderscoredLetters());
        System.out.println(wordManager.takeAGuess('a'));
        System.out.println(wordManager.takeAGuess('b'));
        System.out.println(wordManager.takeAGuess('b'));
    }

}
