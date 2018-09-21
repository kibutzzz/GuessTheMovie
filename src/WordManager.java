import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {
    private String mRandomMovie;

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
        while (this.mRandomMovie == "") {
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
}
