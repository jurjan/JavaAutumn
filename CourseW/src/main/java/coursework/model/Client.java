package coursework.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Client extends User implements Comparable<Client>{

    private String address;
    //birthDate prideta demonstracijai kaip dirbt su LocalDate
    private LocalDate birthDate;
    private List<Comment> commentList;
    private List<Publication> ownedPublications;
    private List<Publication> borrowedPublications;

    public Client(String login, String password, String name, String surname, String address) {
        super(login, password, name, surname);
        this.address = address;
    }

    public Client(String login, String password, String name, String surname, String address, LocalDate birthDate) {
        super(login, password, name, surname);
        this.address = address;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int compareTo(Client o) {

        return 0;
    }
}
