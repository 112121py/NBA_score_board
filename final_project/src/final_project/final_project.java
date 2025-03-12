package final_project;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class final_project extends Application
{
	public crawl c = new crawl();
	public oddview odv = new oddview();
    public String date;
    public String datef;
    public int weight = 800;
	public int height = 500;
    private static Stage stg;
    
	public void start(Stage primaryStage)throws Exception
	{
		stg = primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("(沒有回應)");
        primaryStage.setScene(new Scene(root, weight, height));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

	
	public void changescene(String fxml) throws IOException
	{
		
//		Parent anipane = FXMLLoader.load(getClass().getResource("load.fxml"));
//		stg.getScene().setRoot(anipane);
        
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	
	public static void main(String[] args) throws IOException{
		launch(args);
	}
	
}
