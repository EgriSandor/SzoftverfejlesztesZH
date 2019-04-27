package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.IOException;

public class Scene2 {


    public void start() throws Exception {
        Parent root;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/lekerdezes.fxml"));
            root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Raktár lekérdezés");
            stage.setScene(new Scene(root, 700, 400));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
