package coursework.fxControllers;

import coursework.hibenateControllers.GenericHibernate;
import coursework.model.Client;
import coursework.model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Main {
    @FXML
    public ListView<User> userListField;
    public TextField loginField;
    public TextField nameField;
    public PasswordField pswField;
    public TextField surnameField;
    public TextField addressField;
    public DatePicker bDate;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coursework");

    public void createNewUser() {
        Client client = new Client(loginField.getText(), pswField.getText(), nameField.getText(), surnameField.getText(), addressField.getText(), bDate.getValue());
        GenericHibernate hibernate = new GenericHibernate(entityManagerFactory);

        hibernate.create(client);
    }
}
