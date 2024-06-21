package banksimulator;

import de.jangassen.MenuToolkit;
import de.jangassen.icns.*;
import de.jangassen.dialogs.about.AboutStageBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;

public class MainGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/MenuMain.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Simulator");
        primaryStage.show();

//        MenuBar menuBar = new MenuBar();
//        menuBar.useSystemMenuBarProperty().set(true);
//
//        Menu menu = new Menu("Duck");
//        MenuItem item = new MenuItem("Quack!");
//
//        menu.getItems().add(item);
//        menuBar.getMenus().add(menu);
//
//        primaryStage.setScene(new Scene(new Pane(menuBar)));
//        primaryStage.show();


    }
}
