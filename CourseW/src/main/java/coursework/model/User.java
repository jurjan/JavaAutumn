package coursework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    protected int id;
    protected String login;
    protected String password;
    protected String name;
    protected String surname;
    //jei daugiau yra, prirasot


    public User(int id, String login, String password, String name, String surname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

}
