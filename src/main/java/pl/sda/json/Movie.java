package pl.sda.json;

/**
 * Created by RENT on 2017-03-02.
 */
public class Movie {
    private String originalTitle;
    private String plTitle;
    private User director;
    private Integer boxOffice;

    public void setBoxOffice(Integer boxOffice) {
        this.boxOffice = boxOffice;
    }

    public Integer getBoxOffice() {
        return boxOffice;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPlTitle() {
        return plTitle;
    }

    public User getDirector() {
        return director;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setPlTitle(String plTitle) {
        this.plTitle = plTitle;
    }

    public void setDirector(User director) {
        this.director = director;
    }
}

