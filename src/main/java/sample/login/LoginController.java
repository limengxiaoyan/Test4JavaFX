package sample.login;

import com.sun.javafx.robot.impl.FXRobotHelper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sample.Interface;
import sample.kit.ResponseData;
import sample.kit.ViewUtil;

import java.io.IOException;

public class LoginController {
    Log log = LogFactory.getLog("登录界面");
    @FXML
    private Text actiontarget;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        try {
            ResponseData login = Interface.login(userName.getText(), passwordField.getText());
            if (0 == login.getCode()) {
                actiontarget.setText("login success");
                ObservableList<Stage> stage = FXRobotHelper.getStages();
                Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("index/index.fxml")));
                stage.get(0).setScene(scene);
                stage.get(0).setTitle("index");
                ViewUtil.center(scene,stage.get(0));
            } else {
                actiontarget.setText("Incorrect username or password");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
