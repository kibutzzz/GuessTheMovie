import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {
    private String mRandomMovie;
    private char[] mGuessedLetters = {'a','e','i','o','u'};

    public WordManager() {
        setRandomMovie();


        System.out.println(this.mRandomMovie);
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
            int len = this.mRandomMovie.length();
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
            } else if (new String(mGuessedLetters).contains(Character.toString(mRandomMovie.charAt(i)))) {
                movie += mRandomMovie.charAt(i);
            } else {
                movie += "_";
            }
        }
        return movie;
    }
}
