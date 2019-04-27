package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import model.Anyag;
import model.Raktar;


import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;




public class Controller implements Initializable {

    @FXML
    public ComboBox projektek; // = new ComboBox();
    @FXML
    public ListView anyagok;
    @FXML
    public TextField sap;
    @FXML
    public TextField mennyiseg;
    @FXML
    private Label anyagLabel;
    @FXML
    private Button rogzitBtn;

    @FXML
    private Button lekerdezBtn;

    private Scene2 scene2;

    private Map<String, String> anyagokMap;
    private List<Anyag> anyagokList;
    private List<String> nevek;


    @FXML
    public void setData() {
        projektek.getItems().clear();
        projektek.getItems().addAll(nevek.stream().sorted().collect(Collectors.toList()));
        anyagok.getItems().clear();
        anyagok.getItems().addAll(anyagokList);
    }

    //@Override
    public void initialize(URL url, ResourceBundle rb) {

        anyagokMap = DBLayer.getAnyagokMap();
        anyagokList = DBLayer.getAnyagok();
        nevek = DBLayer.getProjektNevek();

        sap.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                setAnyagLabel(newValue.toString());
            }
        });


        scene2 = new Scene2();
        setData();
    }

    @FXML
    public void setAnyagLabel(String newStr) {
        if (newStr.length() > 4) {
            Optional<String> sap1 = anyagokMap.keySet().stream().filter(s -> s.startsWith(newStr)).findFirst();
            if (sap1.isPresent()) {
                anyagLabel.setText(anyagokMap.get(sap1.get()));
            }
        }
    }

    @FXML
    public void rogzit(ActionEvent event) throws Exception {

        if (mennyiseg.getText().length() > 0 && sap.getText().length() > 7) {

            Raktar raktar = new Raktar(projektek.getValue().toString(), sap.getText(), Double.parseDouble(mennyiseg.getText()));

            if (DBLayer.rogzitRaktar(raktar))
            {
                resetUrlap();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hiba");
                alert.setContentText("Hiba a tétel rögzítésekor!");
                alert.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        resetUrlap();
                    }
                });
            }
        }
    }

    public void resetUrlap()
    {
        sap.setText("");
        mennyiseg.setText("");
        projektek.setValue(null);
        anyagLabel.setText("");
    }


    public void lekerdez( ActionEvent event) throws Exception{
        scene2.start();
    }
}
