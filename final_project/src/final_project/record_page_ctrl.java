package final_project;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class record_page_ctrl
{
	public final_project main = new final_project();
	
	@FXML
    private Button gamble;
	@FXML
    private ScrollPane scrollpane;
    @FXML
    private Button backhome;
    @FXML
    private DatePicker datepicker2;
    @FXML
    private Button search2;
    @FXML
    private Label record1;
    @FXML
    private Label record2;
    @FXML
    private Label record3;
    @FXML
    private Label record4;
    @FXML
    private Label record5;
    @FXML
    private Label record6;
    @FXML
    private Label team1;
    @FXML
    private Label team2;
    @FXML
    private Label team1q1;
    @FXML
    private Label team1q2;
    @FXML
    private Label team1q3;
    @FXML
    private Label team1q4;
    @FXML
    private Label team1score;
    @FXML
    private Label team2q1;
    @FXML
    private Label team2q2;
    @FXML
    private Label team2q3;
    @FXML
    private Label team2q4;
    @FXML
    private Label team2score;
    @FXML
    private Label team3;
    @FXML
    private Label team3q1;
    @FXML
    private Label team3q2;
    @FXML
    private Label team3q3;
    @FXML
    private Label team3q4;
    @FXML
    private Label team3score;
    @FXML
    private Label team4;
    @FXML
    private Label team4q1;
    @FXML
    private Label team4q2;
    @FXML
    private Label team4q3;
    @FXML
    private Label team4q4;
    @FXML
    private Label team4score;
    @FXML
    private Label team5;
    @FXML
    private Label team5q1;
    @FXML
    private Label team5q2;
    @FXML
    private Label team5q3;
    @FXML
    private Label team5q4;
    @FXML
    private Label team5score;
    @FXML
    private Label team6;
    @FXML
    private Label team6q1;
    @FXML
    private Label team6q2;
    @FXML
    private Label team6q3;
    @FXML
    private Label team6q4;
    @FXML
    private Label team6score;
    @FXML
    private ImageView logo1;
    @FXML
    private ImageView logo2;
    @FXML
    private ImageView logo3;
    @FXML
    private ImageView logo4;
    @FXML
    private ImageView logo5;
    @FXML
    private ImageView logo6;

    private void pay()
    {
    	String[] p = new String[] {"pay01.jpg", "pay02.jpg", "lpay03.jpg"};
    	
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setMinWidth(600);
    	window.setMinHeight(400);
    	
    	Label alert = new Label("付費解鎖查詢一天三場以上戰績的功能ouo");
    	alert.setFont(new Font(20));
    	Button close = new Button("請支援收銀");
    	close.setOnAction(e -> window.close());
    	
    	ImageView meme = new ImageView();
    	Random r = new Random();
    	meme.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\pic\\" + p[r.nextInt(3)]));
    	
    	VBox v = new VBox(20);
    	v.getChildren().addAll(alert, meme, close);
    	v.setAlignment(Pos.CENTER);//();
    	
    	window.setScene(new Scene(v));
    	window.showAndWait();
    	restart();
    }
    
    private void lakerlose()
    {
    	String[] p = new String[] {"lk01.jpg", "lk02.jpg", "lk03.jpg", "lk04.jpg"};
    	
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setMinWidth(600);
    	window.setMinHeight(400);
    	
    	Label alert = new Label("腿詹又輸了嗚嗚嗚嗚嗚");
    	alert.setFont(new Font(20));
    	Button close = new Button("don't pressed");
    	close.setOnAction(e -> window.close());
    	
    	ImageView meme = new ImageView();
    	Random r = new Random();
    	meme.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\pic\\" + p[r.nextInt(4)]));
    	
    	VBox v = new VBox(20);
    	v.getChildren().addAll(alert, meme, close);
    	v.setAlignment(Pos.CENTER);//();
    	
    	window.setScene(new Scene(v));
    	window.showAndWait();
    }

    private void restart()
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
    private void errormes()
    {
    	String[] pic = new String[] { "error02.jpg", "error03.jpg", "error04.jpg"};
    	
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setMinWidth(600);
    	window.setMinHeight(400);
    	
    	Label alert = new Label(main.date + " 甚麼都沒有OAO");
    	alert.setFont(new Font(20));
    	Button close = new Button("don't pressed");
    	close.setOnAction(e -> window.close());
    	
    	ImageView meme = new ImageView();
    	Random r = new Random();
    	meme.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\pic\\" + pic[r.nextInt(3)]));
    	
    	VBox v = new VBox(20);
    	v.getChildren().addAll(alert, meme, close);
    	v.setAlignment(Pos.CENTER);//();
    	
    	window.setScene(new Scene(v));
    	window.showAndWait();
    	restart();
    }
    private void setlogo1(String teamname)
    {
        logo1.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\nba_team\\" + teamname + ".png"));
    }
    private void setlogo2(String teamname)
    {
        logo2.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\nba_team\\" + teamname + ".png"));
    }
    private void setlogo3(String teamname)
    {
        logo3.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\nba_team\\" + teamname + ".png"));
    }
    private void setlogo4(String teamname)
    {
        logo4.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\nba_team\\" + teamname + ".png"));
    }
    private void setlogo5(String teamname)
    {
        logo5.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\nba_team\\" + teamname + ".png"));
    }
    private void setlogo6(String teamname)
    {
        logo6.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\nba_team\\" + teamname + ".png"));
    }
    
    private void setdata16(String[] data)
    {
    	team1.setText(data[0]);
    	setlogo1(data[0]);
    	record1.setText(data[1]);
    	team1q1.setText(data[2]);
    	team1q2.setText(data[3]);
    	team1q3.setText(data[4]);
    	team1q4.setText(data[5]);
    	team2.setText(data[7]);
    	setlogo2(data[7]);
    	record2.setText(data[8]);
    	team2q1.setText(data[9]);
    	team2q2.setText(data[10]);
    	team2q3.setText(data[11]);
    	team2q4.setText(data[12]);
    	team1score.setText(data[6]);
    	team2score.setText(data[13]);
    	
    	if(data[0].equals("Lakers") || data[7].equals("Lakers"))
    	{
    		if(!data[15].equals("Lakers wins"))
    		{
    			lakerlose();
    		}
    	}
    }
    
    private void setdata32(String[] data)
    {
    	team1.setText(data[0]);
    	setlogo1(data[0]);
    	record1.setText(data[1]);
    	team1q1.setText(data[2]);
    	team1q2.setText(data[3]);
    	team1q3.setText(data[4]);
    	team1q4.setText(data[5]);
    	team2.setText(data[7]);
    	setlogo2(data[7]);
    	record2.setText(data[8]);
    	team2q1.setText(data[9]);
    	team2q2.setText(data[10]);
    	team2q3.setText(data[11]);
    	team2q4.setText(data[12]);
    	team1score.setText(data[6]);
    	team2score.setText(data[13]);
    	
    	
    	team3.setText(data[16]);
    	setlogo3(data[16]);
    	record3.setText(data[17]);
    	team3q1.setText(data[18]);
    	team3q2.setText(data[19]);
    	team3q3.setText(data[20]);
    	team3q4.setText(data[21]);
    	team4.setText(data[23]);
    	setlogo4(data[23]);
    	record4.setText(data[24]);
    	team4q1.setText(data[25]);
    	team4q2.setText(data[26]);
    	team4q3.setText(data[27]);
    	team4q4.setText(data[28]);
    	team3score.setText(data[22]);
    	team4score.setText(data[29]);
    	if(data[0].equals("Lakers") || data[7].equals("Lakers"))
    	{
    		if(!data[15].equals("Lakers wins"))
    		{
    			lakerlose();
    		}
    	}
    	if(data[16].equals("Lakers") || data[23].equals("Lakers"))
    	{
    		if(!data[31].equals("Lakers wins"))
    		{
    			lakerlose();
    		}
    	}
    }
    private void setdata48(String[] data)
    {
    	team1.setText(data[0]);
    	setlogo1(data[0]);
    	record1.setText(data[1]);
    	team1q1.setText(data[2]);
    	team1q2.setText(data[3]);
    	team1q3.setText(data[4]);
    	team1q4.setText(data[5]);
    	team2.setText(data[7]);
    	setlogo2(data[7]);
    	record2.setText(data[8]);
    	team2q1.setText(data[9]);
    	team2q2.setText(data[10]);
    	team2q3.setText(data[11]);
    	team2q4.setText(data[12]);
    	team1score.setText(data[6]);
    	team2score.setText(data[13]);
    	
    	
    	team3.setText(data[16]);
    	setlogo3(data[16]);
    	record3.setText(data[17]);
    	team3q1.setText(data[18]);
    	team3q2.setText(data[19]);
    	team3q3.setText(data[20]);
    	team3q4.setText(data[21]);
    	team4.setText(data[23]);
    	setlogo4(data[23]);
    	record4.setText(data[24]);
    	team4q1.setText(data[25]);
    	team4q2.setText(data[26]);
    	team4q3.setText(data[27]);
    	team4q4.setText(data[28]);
    	team3score.setText(data[22]);
    	team4score.setText(data[29]);
    	
    	
    	team5.setText(data[32]);
    	setlogo5(data[32]);
    	record5.setText(data[33]);
    	team5q1.setText(data[34]);
    	team5q2.setText(data[35]);
    	team5q3.setText(data[36]);
    	team5q4.setText(data[37]);
    	team6.setText(data[39]);
    	setlogo6(data[39]);
    	record6.setText(data[40]);
    	team6q1.setText(data[41]);
    	team6q2.setText(data[42]);
    	team6q3.setText(data[43]);
    	team6q4.setText(data[44]);
    	team5score.setText(data[38]);
    	team6score.setText(data[45]);
    	if(data[0].equals("Lakers") || data[7].equals("Lakers"))
    	{
    		if(!data[15].equals("Lakers wins"))
    		{
    			lakerlose();
    		}
    	}
    	if(data[16].equals("Lakers") || data[23].equals("Lakers"))
    	{
    		if(!data[31].equals("Lakers wins"))
    		{
    			lakerlose();
    		}
    	}
    	if(data[32].equals("Lakers") || data[39].equals("Lakers"))
    	{
    		if(!data[47].equals("Lakers wins"))
    		{
    			lakerlose();
    		}
    	}
    }
    private void gogamblepage()
    {
    	try
    	{
			main.changescene("gamble.fxml");
		}
    	catch(IOException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void gogetdate()
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	main.date = datepicker2.getValue().format(formatter);
    }
    
    private void getinform()
    {
    	// main = new final_project();
    	main.c.date = main.date;
        //下面不知道什麼但感覺很猛
        try
        {
			main.c.main();
		}
        catch(IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int count = 0;
        for (ArrayList<String> innerList : main.c.inform)
        {
            for (String data : innerList)
            {
            	count ++;
            	System.out.println("the data in getdata : " + data);
                // System.out.println(data);
            }
            	
        }
        System.out.println(count);
        String[] data = new String[count];
        int c=0;
        for (ArrayList<String> innerList : main.c.inform)
        {
            for (String datain : innerList)
            {
            	data[c++] = datain;
            }
        }
        for(int i=0;i<count;i++)
        {
        	System.out.println("the data in data : " + data[i]);
        }
        if(count == 0)
        {
        	errormes();
        }
        else if(count == 16)
        {
        	setdata16(data);
        	scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        }
        else if(count == 32)
        {
        	setdata32(data);
        	scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        }
        else if(count == 48)
        {
        	setdata48(data);
        	scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        }
        else 
        {
        	pay();
        }
    }

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
    @FXML
    public void backhome(ActionEvent event) throws IOException
    {
    	gobackhome();
    }
    
    @FXML
    public void getdate2(ActionEvent event) throws IOException
    {
    	// restart();
    	gogetdate();
    }

    @FXML
    public void search2(ActionEvent event) throws IOException
    {
    	//restart();
    	getinform();
    }

    @FXML
    public void gogamble(ActionEvent event) throws IOException
    {
    	gogamblepage();
    }
}