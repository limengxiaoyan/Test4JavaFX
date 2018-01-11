package sample.index;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.naming.InitialContext;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by chenli on 2018/1/10 0010.
 */
public class IndexController implements Initializable{
    @FXML public WebView webview;
    @FXML private ListView menuList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList menuListItems = FXCollections.observableArrayList();
        Label item1 = new Label();
        item1.setText("item 1");
        /*设置点击打开浏览器并访问网页*/
        item1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.baidu.com"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        menuListItems.add(item1);

        Label item2 = new Label();
        item2.setText("item 2");
        /*设置点击打开浏览器并访问网页*/
        item2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    final WebEngine webEngine = webview.getEngine();
                    webEngine.load("http://www.baidu.com");
            }
        });
        menuListItems.add(item2);
        menuListItems.add("item 3");
        menuListItems.add("item 4");
        menuList.setItems(menuListItems);
    }
}
