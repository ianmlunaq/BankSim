package banksimulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class MenuManager implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<BankCustomer, Integer> customerID;

    @FXML
    private TableColumn<BankCustomer, String> email;

    @FXML
    private TableColumn<BankCustomer, String> fullName;

    @FXML
    private TableColumn<BankCustomer, Integer> balanceCents;

    @FXML
    private TableColumn<BankCustomer, String> accountTypeString;

    @FXML
    private TableView<BankCustomer> table;

    ObservableList<BankCustomer> initialData() throws IOException {
        File customerRecords = new File("BankSim_backup.json");
         return FXCollections.observableArrayList(BankCustomer.importFromBackupFile(customerRecords));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DecimalFormat currency = new DecimalFormat("$0.00");

        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        balanceCents.setCellValueFactory(new PropertyValueFactory<>("balanceCents"));
        accountTypeString.setCellValueFactory(new PropertyValueFactory<>("accountTypeString"));

        try {
            table.setItems(initialData());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void switchToSceneMMenuMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/MenuMain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneHelp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Help.fxml"));
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}