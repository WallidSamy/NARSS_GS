/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import narss_gs.SerialPortComm;

/**
 *
 * @author hani
 */
public class NARSS_GSFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SerialPortComm serial = new SerialPortComm();

        if (!serial.isSlected()) {
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Ground Station");
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("User cancelled");
            System.exit(0);

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
