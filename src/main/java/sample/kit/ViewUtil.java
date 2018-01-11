package sample.kit;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by chenli on 2018/1/11 0011.
 */
public class ViewUtil {
    public static void center(Scene scene, Stage stage){
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        double y = (height - scene.getHeight())/2;
        double x = (width - scene.getWidth())/2;
        System.out.println("width:"+width+",height:"+height+",x:"+x+",y"+y);
        stage.setX(x);
        stage.setY(y);
    }
}
