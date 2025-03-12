package final_project;


import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class multi_ctrl
{
	public final_project main = new final_project();
	public int count = 1;
    @FXML
    private Button back;
    @FXML
    private Button backhome;
    @FXML
    private ChoiceBox<String> choose6;
    @FXML
    private ChoiceBox<String> choosegame;
    @FXML
    private Button dateok;
    @FXML
    private DatePicker datepicker;
    @FXML
    private Button gameok1;
    @FXML
    private TextField input;
    @FXML
    private TextField mode;
    @FXML
    private Button modeok;
    @FXML
    private Button next;
    @FXML
    private Button ok;
    @FXML
    private Button typeok;
    
    private void restart()
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
    private void display(double total)
    {
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
    	window.setMinWidth(300);
    	window.setMinHeight(250);
    	
    	BigDecimal decimal = BigDecimal.valueOf(main.odv.totalmoney);
    	BigDecimal rounded = decimal.setScale(2, RoundingMode.HALF_UP).stripTrailingZeros();


    	
    	Label title = new Label("總賠率: " + rounded);
    	title.setFont(new Font(15));
    	Label totalearn = new Label("最高獲利: " + (int)total + "");
    	totalearn.setFont(new Font(20));
    	Button close = new Button("got it");
    	close.setOnAction(e -> window.close());
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
    	v.getChildren().addAll(title, totalearn, meme, close);
    	v.setAlignment(Pos.CENTER);
    	
    	window.setScene(new Scene(v));
    	window.showAndWait();
    	gobackg();
    }

    public void setchoicebox()
    {
    	choose6.getItems().addAll("1. 客讓分勝",  "2. 客不讓分勝",  "3. 大分", "4. 主讓分勝",  "5. 主不讓分勝",  "6. 小分");
    	choose6.setValue("1. 客讓分勝");
    	String[] choose = new String[main.odv.finalteamrec.size()];
    	int k=0;
    	for(int j=0;j<main.odv.finalteamrec.size();j++)
    	{
    		choose[k++] = ((j+1)+". "+main.odv.finalteamrec.get(j)[0]+" "+main.odv.finalteamrec.get(j)[1]);
			System.out.println((j+1)+". "+main.odv.finalteamrec.get(j)[0]+" "+main.odv.finalteamrec.get(j)[1]);
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

    private void gogetmode()
    {
    	main.odv.cho = Integer.valueOf(mode.getText());
    	System.out.println("mode u choose: " + main.odv.cho);
    }
    @FXML
    void getdate(ActionEvent event)
    {
    	gogetdate();
    	getinform();
    	setchoicebox();
    }

    @FXML
    void getgame(ActionEvent event)
    {
    	main.odv.gamechose = Integer.valueOf(choosegame.getValue().charAt(0))-48;
    	// System.out.println("you choose game : " + choosegame.getValue().charAt(0));
    	System.out.println("you choose game : " + main.odv.gamechose);
    }

    @FXML
    void getmode(ActionEvent event)
    {
    	gogetmode();
    	
    }

    @FXML
    void getmoney(ActionEvent event)
    {
    	main.odv.yourmoney = Integer.valueOf(input.getText());
    	System.out.println("your $$ : " + main.odv.yourmoney);
    	System.out.println("最高獲利: "+ main.odv.yourmoney * main.odv.totalmoney);
    	display((int)main.odv.yourmoney * main.odv.totalmoney);
    }

    @FXML
    void gettype(ActionEvent event)
    {
    	main.odv.temp2 = Integer.valueOf(choose6.getValue().charAt(0))-48;
    	System.out.println("you choose type : " + main.odv.temp2);
    	main.odv.moneycount2();
    }

    @FXML
    void gotonext(ActionEvent event)
    {
    	count ++;
    	choosegame.setValue("");
    	choose6.setValue("1. 客讓分勝");
    	if(count == main.odv.cho)
    	{
    		next.setVisible(false);
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
    	gobackg();
    }

}