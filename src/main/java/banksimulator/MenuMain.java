package banksimulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuMain {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSceneMenuManager(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/MenuManager.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneMenuCustomer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/MenuCustomer.fxml"));
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
