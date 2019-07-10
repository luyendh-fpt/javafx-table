package netcafe.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import netcafe.entity.Member;
import netcafe.model.MemberModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberFormController implements Initializable {

    private static MemberModel memberModel;

    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnClose;

    @FXML
    private JFXTextField txtRemainTime;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXButton btnReset;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    void doSave(ActionEvent event) {
        Member member = new Member();
        member.setUsername(txtUsername.getText());
        member.setPassword(txtPassword.getText());
        member.setRemainTime(Long.valueOf(txtRemainTime.getText()));
        member.setFullName(txtFullName.getText());
        member.setAvatar(txtAvatar.getText());


        memberModel.save(member);

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/MemberManager.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void doClose(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/MemberManager.fxml")));
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(memberModel == null){
            memberModel = new MemberModel();
        }
    }
}
