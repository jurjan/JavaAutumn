package coursework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Publication {
    protected int id;
    protected String title;
    protected String author;

    public Publication(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Publication(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
