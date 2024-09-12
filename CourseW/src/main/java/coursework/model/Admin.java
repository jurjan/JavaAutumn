package coursework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin extends User{

    private String phoneNum;
    public Admin(int id, String login, String password, String name, String surname, String phoneNum) {
        super(id, login, password, name, surname);
        this.phoneNum = phoneNum;
    }

    public Admin(String login, String password, String name, String surname, String phoneNum) {
        super(login, password, name, surname);
        this.phoneNum = phoneNum;
    }
}
