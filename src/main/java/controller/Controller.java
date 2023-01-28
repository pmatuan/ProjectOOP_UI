package controller;

import VietnameseHistorical.Dynasty;
import VietnameseHistorical.Festival;
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
    private Button btnChiTietLehoi;

    @FXML
    private Button btnDiTichLichSu;

    @FXML
    private Button btnLeHoiVanHoa;

    @FXML
    private Button btnNVLQ;

    @FXML
    private Button btnNVLQLehoi;

    @FXML
    private Button btnNhanVatLichSu;

    @FXML
    private Button btnSKLQ;

    @FXML
    private Button btnSKLQLehoi;

    @FXML
    private Button btnSuKienLichSu;

    @FXML
    private Button btnTimKiem;

    @FXML
    private Button btnTimKiemLehoi;

    @FXML
    private Button btnTrangChu;

    @FXML
    private Button btnTrieuDai;

    @FXML
    private BorderPane contentLehoi;

    @FXML
    private GridPane contentTrangChu;

    @FXML
    private BorderPane contentTrieuDai;

    @FXML
    private TextField input;

    @FXML
    private TextField inputLehoi;

    @FXML
    private ListView<?> listviewTrieuDai;

    @FXML
    private ListView<?> listviewlehoi;

    @FXML
    void handleClicksSidebar(ActionEvent event) throws FileNotFoundException {
        if (event.getSource() == btnTrangChu) {
            resetVisible();
            contentTrangChu.setVisible(true);
        } else if (event.getSource() == btnTrieuDai) {
            resetVisible();
            contentTrieuDai.setVisible(true);

        }else if(event.getSource()==btnLeHoiVanHoa){
            resetVisible();
            contentLehoi.setVisible(true);
        }
    }

    void resetVisible() {
        contentTrangChu.setVisible(false);
        contentTrieuDai.setVisible(false);
        contentLehoi.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DynastyController dynastyController = new DynastyController(input, btnTimKiem, btnChiTiet, btnNVLQ, btnSKLQ, (ListView<Dynasty>) listviewTrieuDai);
            dynastyController.initialize();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
            FestivalController festivalController = new FestivalController(inputLehoi,btnTimKiemLehoi,btnChiTietLehoi,btnNVLQLehoi,btnSKLQLehoi,(ListView<Festival>) listviewlehoi);
            festivalController.initialize();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}








