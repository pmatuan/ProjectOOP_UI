package controller;

import VietnameseHistorical.Dynasty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.input.MouseEvent;

public class DynastyController {
    @FXML
    private TextField input;
    @FXML
    private Button btnTimKiem;
    @FXML
    private ListView<Dynasty> listviewTrieuDai;
    private ObservableList<Dynasty> dynasties;
    Gson gson = new Gson();

    public DynastyController(TextField input, Button btnTimKiem, ListView<Dynasty> listviewTrieuDai) throws FileNotFoundException {
        this.input = input;
        this.btnTimKiem = btnTimKiem;
        this.listviewTrieuDai = listviewTrieuDai;
        dynasties = FXCollections.observableList(gson.fromJson(new FileReader("data/Dynasty.json"), new TypeToken<List<Dynasty>>() {
        }.getType()));
    }

    public void initialize() {
        listviewTrieuDai.setItems(dynasties);
        listviewTrieuDai.setCellFactory(listView -> new ListCell<Dynasty>() {
            @Override
            protected void updateItem(Dynasty item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName() + " (" + item.getDates() + ")");
                }
            }
        });

        btnTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                ObservableList<Dynasty> dynasty_search = FXCollections.observableArrayList();
                String inputName = input.getText();
                for(Dynasty d:dynasties){
                    if(d.getName().contains(inputName)){
                        dynasty_search.add(d);
                    }
                }
                listviewTrieuDai.setItems(dynasty_search);
            }
        });
    }
}
