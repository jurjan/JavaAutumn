package coursework.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Client extends User{

    private String address;
    private List<Comment> commentList;
    private List<Publication> ownedPublications;
    private List<Publication> borrowedPublications;

    public Client(String login, String password, String name, String surname, String address) {
        super(login, password, name, surname);
        this.address = address;
    }
}
