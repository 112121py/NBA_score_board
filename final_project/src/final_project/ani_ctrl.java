package final_project;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class ani_ctrl
{

    @FXML
    private Arc arc;
    @FXML
    private ImageView huh;
    
// // create a Stack pane
//    Group g = new Group();
//
//    
//    g.getChildren().add(huh);
//    
//    
// // Create a scene and add it to the stage
//    Scene scene = new Scene(g, 800, 500);
//    primaryStage.setScene(scene);
//    primaryStage.show();
//   
//    Rotate rotate = new Rotate(0,400, 250);
//    g.getTransforms().add(rotate);
//    
//    
//    Rotate rotate = new Rotate(0,400, 250);
//    Timeline timeline = new Timeline(
//    		new KeyFrame(Duration.ZERO,new KeyValue(rotate.angleProperty(), 0)),
//            new KeyFrame(Duration.millis(500), new KeyValue(rotate.angleProperty(), 180)),
//            new KeyFrame(Duration.millis(1500), new KeyValue(rotate.angleProperty(), 360))
//    );
//    timeline.setCycleCount(2);
//    timeline.play();
//    
//    FadeTransition fade = new FadeTransition(Duration.millis(1000), arc);
//    fade.setFromValue(1.0);
//    fade.setToValue(0.1);
//    fade.setAutoReverse(true);
//    fade.setCycleCount(2);
//    fade.play();

}