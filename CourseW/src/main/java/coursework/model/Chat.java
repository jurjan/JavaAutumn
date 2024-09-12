package coursework.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Chat {

    private int id;
    private Book book;
    private List<Comment> messages;

    public Chat(int id, Book book, List<Comment> messages) {
        this.id = id;
        this.book = book;
        this.messages = messages;
    }

    public Chat(Book book, List<Comment> messages) {
        this.book = book;
        this.messages = messages;
    }
}
