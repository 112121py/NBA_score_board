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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class single_ctrl
{
	public final_project main = new final_project();

    @FXML
    private Button back;
    @FXML
    private Button backhome;
    @FXML
    private DatePicker datepicker;
    @FXML
    private ChoiceBox<String> choosegame;
    @FXML
    private Button ok;
    @FXML
    private Button result;
    @FXML
    private Button conti;
    @FXML
    private TextField input;
    @FXML
    private Button dateok;
    @FXML
    private Button gameok1;
    @FXML
    private ChoiceBox<String> choose6;
    @FXML
    private Button typeok;


    private void restart()
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
    private void errormes()
    {
    	String[] pic = new String[] { "error02.jpg", "error03.jpg", "error04.jpg"};
    	
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setMinWidth(600);
    	window.setMinHeight(400);
    	
    	Label alert = new Label(main.datef + " 甚麼都沒有OAO");
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
    private void display(int cost, double total, String[] rate)
    {
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setMinWidth(350);
    	window.setMinHeight(450);
    	
    	Label allcost = new Label("投注總金額: " + cost + "");
    	allcost.setFont(new Font(20));
    	Label totalearn = new Label("最高獲利: " + total + "");
    	totalearn.setFont(new Font(20));
    	Button close = new Button("got it");
    	close.setOnAction(e -> window.close());
    	
    	Label team1 = new Label(rate[0]);
    	Label set1 = new Label("讓分         不讓分         大小");
    	Label rate01 = new Label(rate[1] + ",  " + rate[2] + "       " + rate[3] + "       " +rate[4] + ",  " + rate[5]);
    	Label team2 = new Label(rate[6]);
    	Label set2 = new Label("讓分         不讓分         大小");
    	Label rate02 = new Label(rate[7] + ",  " + rate[8] + "       " + rate[9] + "       " +rate[10] + ",  " + rate[11]);
    	
    	ImageView meme = new ImageView();
    	if(total > 0)
    	{
    		meme.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\pic\\ya.png"));
    	}
    	else
    	{
    		meme.setImage(new Image("C:\\Users\\patty\\OneDrive\\桌面\\final_project\\pic\\no.png"));
    	}
    	
    	VBox v = new VBox(20);
    	VBox therate = new VBox(5);
    	therate.getChildren().addAll(team1, set1, rate01, team2, set2, rate02);
    	therate.setAlignment(Pos.CENTER);
    	v.getChildren().addAll(therate, allcost, totalearn, meme, close);
    	v.setAlignment(Pos.CENTER);//();
    	
    	window.setScene(new Scene(v));
    	window.showAndWait();
    	gobackg();
    }
    public void setchoicebox()
    {
    	choose6.getItems().addAll("1. 客讓分勝",  "2. 客不讓分勝",  "3. 大分", "4. 主讓分勝",  "5. 主不讓分勝",  "6. 小分");
    	choose6.setValue("1. 客讓分勝");
    	String[] choose = new String[main.odv.gaming.size()/2];
    	int k=0;
    	for(int j=0;j<main.odv.gaming.size()/2;j++)
    	{
    		choose[k++] = ((j+1)+". " + main.odv.gaming.get(j)+ " " + main.odv.gaming.get(j+1));
			System.out.println((j+1)+". "+main.odv.gaming.get(j)+ " " + main.odv.gaming.get(j+1));
		}
    	for(int i=0;i<k;i++)
    	{
    		System.out.println(choose[i]);
    	}
    	choosegame.getItems().addAll(choose);
    	// choosegame.getItems().add("test");
    }

    private void getinform()
    {
    	main.odv.date = main.datef;
        //下面不知道什麼但感覺很猛
        try
        {
			main.odv.main();
		}
        catch(IOException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int count = 0;
        for (ArrayList<String> innerList : main.odv.inform)
        {
            for (String data : innerList)
            {
            	count ++;
            }
        }
        if(count == 0)
        {
        	errormes();
        }
    }
    
    private void gogetdate()
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    	main.datef = datepicker.getValue().format(formatter);
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
    
    private void gobackg()
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
    
    
    @FXML
    void gettype(ActionEvent event) throws IOException
    {
    	main.odv.temp2 = Integer.valueOf(choose6.getValue().charAt(0))-48;
    	System.out.println("you choose type : " + main.odv.temp2);
    }
    @FXML
    void getgame(ActionEvent event) throws IOException
    {
    	main.odv.gamechose = Integer.valueOf(choosegame.getValue().charAt(0))-48;
    	// System.out.println("you choose game : " + choosegame.getValue().charAt(0));
    	System.out.println("you choose game : " + main.odv.gamechose);
    }
    @FXML
    void seeresult(ActionEvent event) throws IOException
    {
    	// main.odv.isclick = true;
    	// main.odv.moneycount1();
    	int count=0, k=0;
    	
    	System.out.println("投注總金額: " + main.odv.allyourmoney);
		System.out.println("最高獲利: " + main.odv.totalmoney);
		for (ArrayList<String> innerList : main.odv.inform)
        {
            for (String data : innerList)
            {
            	count ++;
            	System.out.println("odv賠存的 " + data);
            }
        }
		String[] rate = new String[count];
		for (ArrayList<String> innerList : main.odv.inform)
        {
            for (String data : innerList)
            {
            	rate[k++] = data;
            }
        }
		display(main.odv.allyourmoney, main.odv.totalmoney, rate);
		
    }
    @FXML
    void conti(ActionEvent event) throws IOException
    {
    	choosegame.setValue("");
    	choose6.setValue("1. 客讓分勝");
    	input.clear();
    }
    @FXML
    void getmoney(ActionEvent event) throws IOException
    {
    	main.odv.yourmoney = Integer.valueOf(input.getText());
    	System.out.println("your $$ : " + main.odv.yourmoney);
    	main.odv.moneycount1();
    }
    @FXML
    public void backhome(ActionEvent event) throws IOException
    {
    	gobackhome();
    }
    
    @FXML
    public void getdate(ActionEvent event) throws IOException
    {
    	choosegame.getItems().clear();
    	choose6.getItems().clear();
    	input.clear();
    	// main.odv.finalteamrec.clear();
    	gogetdate();
    	getinform();
    	setchoicebox();
    }

    @FXML
    public void goback(ActionEvent event) throws IOException
    {
    	gobackg();
    }

}
