package coursework.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private LocalDateTime timestamp;
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replies;
    @ManyToOne
    private Comment parentComment;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Chat chat;


    public Comment(String title, String body, LocalDateTime timestamp, List<Comment> replies, Comment parentComment, Client client) {
        this.title = title;
        this.body = body;
        this.timestamp = timestamp;
        this.replies = replies;
        this.parentComment = parentComment;
        this.client = client;
    }
}
