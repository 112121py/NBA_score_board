package java_oddview;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class ori_oddview {
	public static boolean namecheckchinese(String a[],String b) {
		for(int i=0;i<a.length;i++) {
			if (a[i].equals(b)) return true;
		}
		return false;
	}
	public static int paychoose(int a) {
		if (a==1 || a==4) return 1;
		else if (a==2 || a==5) return 2;
		else return 4;
	}
	
	static Scanner s=new Scanner (System.in);
	public static void moneycount() {
		System.out.println("1.單買 2.串關");
		int func=s.nextInt();
		if (func==1) {
			int finalmoney=0,moneyiused=0;
			while (true) {
				System.out.println("請選擇對局");
				for(int i=0;i<finalteamrec.size();i++) {
					System.out.println((i+1)+". "+finalteamrec.get(i)[0]+" "+finalteamrec.get(i)[1]);
				}
				int gamechoose=s.nextInt();
				System.out.println("1.客讓分勝 2.客不讓分勝 3.大分");
				System.out.println("4.主讓分勝 5.主不讓分勝 6.小分");
				int temp=s.nextInt();
				System.out.println("輸入下注金額: ");
				int money=s.nextInt();
				moneyiused+=money;
				int cc;
				cc=paychoose(temp);
				finalmoney+=money*(finaloddrec.get(gamechoose-1)[(int)(temp/4)][cc]-1);
				System.out.println("1.繼續下注 2.退出");
				if (s.nextInt()==2) break;
			}
			System.out.println("投注總金額: "+moneyiused);
			System.out.println("最高獲利: "+finalmoney);
		}
		else {
			System.out.println("請輸入要玩幾種 (2 or 3)");

			double finalmoney=0;
			int choo=s.nextInt();
			for(int i=0;i<choo;i++) {
				System.out.println("請選擇對局");
				
				for(int j=0;j<finalteamrec.size();j++) {
					System.out.println((j+1)+". "+finalteamrec.get(j)[0]+" "+finalteamrec.get(j)[1]);
				}
				int gamechoose=s.nextInt();
				System.out.println("1.客讓分勝 2.客不讓分勝 3.大分");
				System.out.println("4.主讓分勝 5.主不讓分勝 6.小分");
				int t=s.nextInt();
				int cc=paychoose(t);
				finalmoney+=finaloddrec.get(gamechoose-1)[(int)(t/4)][cc]-1;
			}
			System.out.println("請輸入投注金額");
			int money=s.nextInt();
			System.out.println("最高獲利: "+money*finalmoney);
		}
	}
	@SuppressWarnings("finally")
	public static double oddToDouble(String a) {
		String temp="";
		boolean point=false;
		try {
			return Double.parseDouble(a);
		}
		finally{
			for(int i=0;i<a.length();i++) {
				if (a.charAt(i)==',') point=true;
				else if (point=true && a.charAt(i)!=' ') {
					temp+=a.charAt(i);
				}
			}
			//System.out.println("this time"+ temp);
			return Double.parseDouble(temp);
		}
	}
	static ArrayList <double[][]> finaloddrec=new ArrayList <double[][]>();
	static ArrayList <String []> finalteamrec=new ArrayList <String []>();
	public static void main(String[] args) throws IOException{
		String url="https://www.playsport.cc/predictgame.php?action=scale&allianceid=3&gametime=20230511&sid=0";
		Document doc=Jsoup.connect(url).get();
		String title =doc.title();
		Elements links=doc.select("a[href]");
		Elements elements = doc.body().getAllElements();
		Pattern pattern = Pattern.compile("\\d+\\.\\d+");
		int gamecnt=1;
		int cnt=0;
		double [][]oddsrec= {{0,0,0,0,0},{0,0,0,0,0}};
		ArrayList<Integer> thisIsOdds = new ArrayList<>(List.of(3, 5, 7,8));
		String []teamrec= {"",""};
		String []nbateamchinese={"波士頓塞爾提克","布魯克林籃網","紐約尼克","多倫多暴龍","費城76人"
				,"芝加哥公牛","克里夫蘭騎士","底特律活塞","印第安那溜馬","密爾瓦基公鹿"
				,"亞特蘭大老鷹","金州勇士","洛杉磯湖人","洛杉磯快艇","沙加緬度國王"
				,"鳳凰城太陽","休士頓火箭","聖安東尼奧馬刺","達拉斯獨行俠","曼斐斯灰熊"
				,"紐奧良鵜鶘","猶他爵士","奧克拉荷馬雷霆","波特蘭拓荒者","丹佛金塊"
				,"明尼蘇達灰狼","邁阿密熱火","奧蘭多魔術" ,"華盛頓巫師","夏洛特黃蜂"       								
		};
		for (Element element : elements) {
            String text = element.ownText();
            if (namecheckchinese(nbateamchinese,text)) {
            	cnt=1;
            	//System.out.println("met the team "+text);
            	if (gamecnt==1) {
            		teamrec[0]=text;
            	}
            	else {
            		teamrec[1]=text;
            	}
            	gamecnt*=-1;
            }
            else if (cnt==1 && (text.contains("+") || text.contains("-"))) {
            	cnt=2;
            	//System.out.println("cnt1 case "+text+" "+cnt+" "+gamecnt);
            	if (gamecnt==-1) {
            		oddsrec[0][0]=Double.parseDouble(text);
            	}
            	else {
            		oddsrec[1][0]=Double.parseDouble(text);
            	}
            }
            else if (cnt>=2 && !text.isEmpty() && text.matches(".*\\d+.*") &&!text.contains("%")) {
            	cnt++;
            	//System.out.println(text+" cnt:"+cnt);
            	if (thisIsOdds.contains(cnt)) {
            		//System.out.println("now in "+text+" cnt: "+cnt);
	            	if (gamecnt==-1) {
	            		oddsrec[0][thisIsOdds.indexOf(cnt)+1]=oddToDouble(text);
	            		//System.out.println("this is the time");
	            	}
	            	else{
	            		oddsrec[1][thisIsOdds.indexOf(cnt)+1]=oddToDouble(text);
	            		if (cnt==8) {
	            			finaloddrec.add(oddsrec);
	            			finalteamrec.add(teamrec);
		            		//System.out.println("this is special case");
	            			for(int i=0;i<2;i++) {
	            				System.out.println(teamrec[i]);
	            				for(int j=0;j<5;j++) {
	            					System.out.print(oddsrec[i][j]+" ");
	            				}
	            				System.out.println();
	            			}
	            		}
	            	}
            	}
            }
           
		}
		System.out.println("endddd");
		moneycount();
		
	}

}