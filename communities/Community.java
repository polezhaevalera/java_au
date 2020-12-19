import java.util.List;

public class Community {

    public final String title;
    private final Genre genre;

    public Community(String title, Genre genre){

        this.title = title;
        this.genre = genre;

    }

    public String getTitle() {
        return title;
    }
    public Genre getGenre() {
        return genre;
    }
}
