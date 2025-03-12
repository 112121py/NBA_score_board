package final_project;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
public class home_ctrl
{
	public final_project main = new final_project();
	@FXML
    private Button button;


    @FXML
    public void start_search(ActionEvent event) throws IOException
    {
    	main.changescene("twogame.fxml");
    }
    

}
