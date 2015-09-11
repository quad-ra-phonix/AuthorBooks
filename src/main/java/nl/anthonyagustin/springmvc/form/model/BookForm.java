package nl.anthonyagustin.springmvc.form.model;

/**
 * Created by agustinas on 11-9-2015.
 */
public class BookForm {

    private String title;
    private String genre;
    private int authorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
