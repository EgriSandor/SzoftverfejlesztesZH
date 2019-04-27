package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Anyag;
import model.Raktar;
import model.RaktarOssz;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class Controller2 implements Initializable {

    @FXML
    public TableView table1;

    @FXML
    public TableColumn sapCol ;
    @FXML
    public TableColumn projektCol ;
    @FXML
    public TableColumn mennyCol ;



    //@Override
    public void initialize(URL url, ResourceBundle rb) {

         sapCol.setCellValueFactory(new PropertyValueFactory<RaktarOssz, String>("sap"));
         projektCol.setCellValueFactory(new PropertyValueFactory<RaktarOssz, String>("projekt"));
         mennyCol.setCellValueFactory(new PropertyValueFactory<RaktarOssz, Double>("mennyiseg"));
;
        ObservableList anyagok = FXCollections.observableList( DBLayer.getRaktarOssz());

        table1.setItems(anyagok);
        table1.refresh();

    }


}
