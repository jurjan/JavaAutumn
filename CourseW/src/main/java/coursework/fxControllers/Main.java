package coursework.fxControllers;

import coursework.StartGUI;
import coursework.hibenateControllers.GenericHibernate;
import coursework.model.Admin;
import coursework.model.Client;
import coursework.model.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

//Norėdama pasiekti formos elementus iki forma yra sugeneruojama, turiu implementuoti Initializable interfeisą.
//Jums automatiškai siūlys initialize metodą įgyvendint, ten dedat kodą, kuris turi būt vykdomas pirmiausia
//Mūsų atveju gavosi, kad reikia ištraukt userius iš DB
public class Main implements Initializable {
    @FXML
    //Stenkitės nurodyti tikslius duomenų tipus, kurie bus saugomi ListView
    public ListView<User> userListField;
    @FXML
    public TextField loginField;
    @FXML
    public TextField nameField;
    @FXML
    public PasswordField pswField;
    @FXML
    public TextField surnameField;
    @FXML
    public TextField addressField;
    @FXML
    public DatePicker bDate;
    @FXML
    public TextField phoneNumField;
    @FXML
    public RadioButton adminChk;
    @FXML
    public RadioButton clientChk;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coursework");
    GenericHibernate hibernate = new GenericHibernate(entityManagerFactory);

    public void createNewUser() {
        if (clientChk.isSelected()) {
            Client client = new Client(loginField.getText(), pswField.getText(), nameField.getText(), surnameField.getText(), addressField.getText(), bDate.getValue());
            hibernate.create(client);
        } else {
            Admin admin = new Admin(loginField.getText(), pswField.getText(), nameField.getText(), surnameField.getText(), phoneNumField.getText());
            hibernate.create(admin);
        }
        fillUserList();
    }

    public void disableFields() {
        if (clientChk.isSelected()) {
            addressField.setDisable(false);
            bDate.setDisable(false);
            phoneNumField.setDisable(true);
        } else {
            addressField.setDisable(true);
            bDate.setDisable(true);
            phoneNumField.setDisable(false);
        }
    }

    public void fillUserList() {
        userListField.getItems().clear();
        List<User> userList = hibernate.getAllRecords(User.class);
        userListField.getItems().addAll(userList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillUserList();
    }

    public void loadUserData() {
        User selectedUser = userListField.getSelectionModel().getSelectedItem();

        User userInfoFromDb = hibernate.getEntityById(User.class, selectedUser.getId());

        nameField.setText(userInfoFromDb.getName());
        surnameField.setText(userInfoFromDb.getSurname());

        if (userInfoFromDb instanceof Client) {
            Client client = (Client) userInfoFromDb;
            addressField.setText(client.getAddress());
        } else {
            Admin admin = (Admin) userInfoFromDb;
            phoneNumField.setText(admin.getPhoneNum());
        }

    }

    public void updateUser() {
        User selectedUser = userListField.getSelectionModel().getSelectedItem();
        User userInfoFromDb = hibernate.getEntityById(User.class, selectedUser.getId());

        userInfoFromDb.setName(nameField.getText());
        //Likusius pabaigti

        hibernate.update(userInfoFromDb);
        fillUserList();
    }

    public void deleteUser() {

        User selectedUser = userListField.getSelectionModel().getSelectedItem();
        hibernate.delete(User.class, selectedUser.getId());
        fillUserList();
    }

    public void loadProductForm() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartGUI.class.getResource("productWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Book Exchange Test");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }
}
