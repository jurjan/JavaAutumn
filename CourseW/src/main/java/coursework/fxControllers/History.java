package coursework.fxControllers;

import coursework.hibenateControllers.CustomHibernate;
import coursework.model.Client;
import coursework.model.PeriodicRecord;
import coursework.model.Publication;
import coursework.model.User;
import coursework.model.enums.PublicationStatus;
import jakarta.persistence.EntityManagerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class History implements Initializable {

    @FXML
    public TableView<PeriodicRecord> bookHistoryTable;
    @FXML
    public TableColumn<PeriodicRecord, Integer> colId;
    @FXML
    public TableColumn<PeriodicRecord, String> colReturnDate;
    @FXML
    public TableColumn<PeriodicRecord, String> colStatus;
    @FXML
    public TableColumn<PeriodicRecord, String> colTransactionDate;
    @FXML
    public TableColumn<PeriodicRecord, String> colPublication;
    @FXML
    public TableColumn<PeriodicRecord, String> colClient;
    @FXML
    public DatePicker startDateField;
    @FXML
    public DatePicker endDateField;
    @FXML
    public ComboBox<PublicationStatus> PublicationStatusField;
    @FXML
    public ComboBox<Client> clientField;
    @FXML
    public TextField publicationTitleField;

    EntityManagerFactory entityManagerFactory;
    CustomHibernate hibernate;
    User currentUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colTransactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        colPublication.setCellValueFactory(new PropertyValueFactory<>("publication"));
        colClient.setCellValueFactory(new PropertyValueFactory<>("client"));
    }

    public void setData(EntityManagerFactory entityManagerFactory, User currentUser) {
        this.entityManagerFactory = entityManagerFactory;
        this.hibernate = new CustomHibernate(entityManagerFactory);
        this.currentUser = currentUser;
        loadAllRecords();
    }

    public void setData(EntityManagerFactory entityManagerFactory, User currentUser, int id) {
        this.entityManagerFactory = entityManagerFactory;
        this.hibernate = new CustomHibernate(entityManagerFactory);
        this.currentUser = currentUser;
        loadPublicationsById(id);
    }

    private void loadAllRecords() {
        bookHistoryTable.getItems().clear();
        bookHistoryTable.getItems().addAll(hibernate.getAllRecords(PeriodicRecord.class));
    }

    private void loadPublicationsById(int id) {
        bookHistoryTable.getItems().clear();
        bookHistoryTable.getItems().addAll(hibernate.getPeriodicById(id));

    }

    public void filterRecords() {
    }


}
