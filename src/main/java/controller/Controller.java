package controller;

import VietnameseHistorical.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button DangXuat;

    @FXML
    private Button btnChiTiet;

    @FXML
    private Button btnChiTiet_NV;

    @FXML
    private Button btnDiTichLichSu;

    @FXML
    private Button btnLeHoiVanHoa;

    @FXML
    private Button btnNVLQ;

    @FXML
    private Button btnNhanVatLichSu;

    @FXML
    private Button btnSKLQ;

    @FXML
    private Button btnSKLQ_NV;

    @FXML
    private Button btnSuKienLichSu;

    @FXML
    private Button btnTDLQ_NV;

    @FXML
    private Button btnTimKiem;

    @FXML
    private Button btnTimKiem_NV;

    @FXML
    private Button btnTrangChu;

    @FXML
    private Button btnTrieuDai;

    @FXML
    private BorderPane contentNhanVat;

    @FXML
    private GridPane contentTrangChu;

    @FXML
    private BorderPane contentTrieuDai;

    @FXML
    private TextField input;

    @FXML
    private TextField input_NV;


    @FXML
    private ListView<Dynasty> listviewTrieuDai;

    @FXML
    private ListView<Figure> listviewNhanVat;



    @FXML
    void handleClicksSidebar(ActionEvent event) throws FileNotFoundException {
        if (event.getSource() == btnTrangChu) {
            resetVisible();
            contentTrangChu.setVisible(true);
        } else if (event.getSource() == btnTrieuDai) {
            resetVisible();
            contentTrieuDai.setVisible(true);
        }
        else if(event.getSource() == btnNhanVatLichSu) {
            resetVisible();
            contentNhanVat.setVisible(true);
        }
    }

    void resetVisible() {
        contentTrangChu.setVisible(false);
        contentTrieuDai.setVisible(false);
        contentNhanVat.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DynastyController dynastyController = new DynastyController(input, btnTimKiem, btnChiTiet, btnNVLQ, btnSKLQ, listviewTrieuDai);
            dynastyController.initialize();
            FigureController figurecontroller = new FigureController(input_NV, btnTimKiem_NV, btnChiTiet_NV, btnTDLQ_NV, btnSKLQ_NV, listviewNhanVat);
            figurecontroller.initialize();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}








