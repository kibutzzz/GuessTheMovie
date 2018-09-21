import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {
    private String mRandomMovie;
    private ArrayList<Character> mGuessedLetters;

    public WordManager() {
        setRandomMovie();
        mGuessedLetters = new ArrayList<>();
    }

    private void setRandomMovie() {
        Scanner moviesFileScanner = this.makeNewFileScanner("movies.txt");
        ArrayList<String> moviesList = new ArrayList<>();

        while (moviesFileScanner.hasNextLine()) {
            moviesList.add(moviesFileScanner.nextLine());
        }
        this.mRandomMovie = "";
        while (this.mRandomMovie.length() < 2) {
            int randomIndex = (int) (Math.random() * moviesList.size());
            this.mRandomMovie = moviesList.get(randomIndex);
        }
    }

    private Scanner makeNewFileScanner(String fileName) {
        File movieFile = new File(fileName);
        try {
            Scanner scanner = new Scanner(movieFile);
            return scanner;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (Exception ex) {
            System.out.println("Erro desconhecido: " + ex.toString());
        }
        return null;
    }

    public String getMovieNameWithUnderscoredLetters() {
        String movie = "";
        for (int i = 0; i < mRandomMovie.length(); i++) {
            if (mRandomMovie.charAt(i) == ' ') {
                movie += " ";
            } else if (guessedLettersContainsCharacter(mRandomMovie.charAt(i))) {
                movie += mRandomMovie.charAt(i);
            } else {
                movie += "_";
            }
        }
        return movie;
    }

    public String takeAGuess(char letter) {
        if (guessedLettersContainsCharacter(letter)) {
            return "Você já escolheu essa letra";
        }
        mGuessedLetters.add(letter);
        return "Você escolheu a letra '" + letter + "'";
    }

    private boolean guessedLettersContainsCharacter(char character) {
        char[] guessedLettersCharArray;
        guessedLettersCharArray = new char[mGuessedLetters.size()];
        for (int i = 0; i < guessedLettersCharArray.length; i++) {
            guessedLettersCharArray[i] = mGuessedLetters.get(i);
        }
        return new String(guessedLettersCharArray).contains(Character.toString(character));
    }

    public boolean hasCompletedTheWord() {
        return getMovieNameWithUnderscoredLetters().equals(mRandomMovie);
    }

    public int getHowManyWrongLetters() {
        int wrongLettersCount = mGuessedLetters.size();
        String movieLetters = getMovieLettersWithoutDuplicates();

        for (int i = 0; i < movieLetters.length(); i++) {
            if (guessedLettersContainsCharacter(movieLetters.charAt(i))) {
                wrongLettersCount--;
            }
        }

        return wrongLettersCount;
    }

    public boolean hasLostTheGame() {
        return getHowManyWrongLetters() >= 10;
    }

    private String getMovieLettersWithoutDuplicates() {
        String movieLetters = "";

        for (int i = 0; i < mRandomMovie.length(); i++) {
            if (!movieLetters.contains(Character.toString(mRandomMovie.charAt(i)))) {
                movieLetters += mRandomMovie.charAt(i);
            }
        }

        return movieLetters;
    }

    public String getMovieName(){
        return mRandomMovie;
    }
}
