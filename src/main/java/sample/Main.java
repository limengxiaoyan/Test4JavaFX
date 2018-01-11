package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.kit.ViewUtil;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login/login.fxml"));
        primaryStage.setTitle("Login");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        ViewUtil.center(scene,primaryStage);
        primaryStage.getIcons().add(new Image(getClass().getClassLoader().getResource("asset/image/webdev__128x128_72px.png").openStream()));
//        primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
