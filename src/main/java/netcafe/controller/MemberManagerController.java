package netcafe.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import netcafe.entity.Member;
import netcafe.model.MemberModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MemberManagerController implements Initializable {

    private static MemberModel memberModel;

    @FXML
    private TableView<Member> tableMember;

    @FXML
    private TableColumn<Member, ImageView> tableColumnAvatar;

    @FXML
    private TableColumn<Member, String> tableColumnUsername;

    @FXML
    private TableColumn<Member, String> tableColumnTime;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnEdit;


    @FXML
    void addMember(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/MemberForm.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableColumnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("remainTime"));
        this.tableColumnAvatar.setCellValueFactory(new PropertyValueFactory<>("avatarImage"));
        if(memberModel == null){
            this.memberModel = new MemberModel();
        }
        this.tableMember.setItems(prepareListMember());

    }

    private ObservableList<Member> prepareListMember() {
        ArrayList<Member> memberArrayList = memberModel.getList();
        ObservableList<Member> observableList = FXCollections.observableArrayList();
        observableList.addAll(memberArrayList);
        return observableList;
    }
}
