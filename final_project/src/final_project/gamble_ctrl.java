package final_project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class gamble_ctrl
{
	public final_project main = new final_project();

    @FXML
    private Button back;
    @FXML
    private Button backhome;
    @FXML
    private Button multi;
    @FXML
    private Button single;
    
    private void gobackhome()
    {
    	try
    	{
			main.changescene("home.fxml");
		}
    	catch(IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void gobackpage()
    {
    	try
    	{
			main.changescene("twogame.fxml");
		}
    	catch(IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void gotosingle()
    {
    	try
    	{
			main.changescene("single.fxml");
		}
    	catch(IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void gotomulti()
    {
    	try
    	{
			main.changescene("multi.fxml");
		}
    	catch(IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void backhome(ActionEvent event) throws IOException
    {
    	gobackhome();
    }

    @FXML
    void goback(ActionEvent event) throws IOException
    {
    	gobackpage();
    }
    
 
    @FXML
    void gomulti(ActionEvent event) throws IOException
    {
    	gotomulti();
    }

    @FXML
    void gosingle(ActionEvent event) throws IOException
    {
    	gotosingle();
    }


}