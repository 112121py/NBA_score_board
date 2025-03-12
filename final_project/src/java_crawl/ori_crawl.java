package java_crawl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ori_crawl {
	public String date;
	public static String nbatitle;
	public static boolean namecheck(String []a,String b) {
		for(int i=0;i<a.length;i++) {
			if (a[i].equals(b)) return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		Document doc = Jsoup.connect("https://www.espn.com/nba/scoreboard/_/date/20230520").get();
        nbatitle = doc.title();
        System.out.println("Title: " + nbatitle);

        Elements elements = doc.body().getAllElements();
        String []nbateam={"Celtics","Nets","Knicks","Raptors","76ers"
        		,"Bulls","Cavaliers","Pistons","Pacers","Bucks"
        		,"Hawks","Warriors","Lakers","Clippers","Kings"
        		,"Suns","Rockets","Spurs","Mavericks","Grizzlies"
        		,"Pelicans","Jazz","Thunder","Blazers","Nuggets"
        		,"Timberwolves","Heat","Magic","Wizards","Hornets"
        };
        
        int cnt=0,score=0,gamecnt=1;
        int []scorerec= {0,0};
        String []namerec={"",""};
        List<Integer> thisIsScore = List.of( 4, 5, 6, 7);
        for (Element element : elements) {
            String text = element.ownText();
            ArrayList<String> temp = new ArrayList();
            
            if (text.matches(".*\\d+.*") || namecheck(nbateam,text) &&text!="" ) {
            	
            	if (namecheck(nbateam,text)) {
            		cnt=1; score=0; gamecnt*=-1;
            		System.out.println();
            		if (gamecnt==-1) {
            			namerec[0]=text;
            			// temp.add("--------------");
            			System.out.println("--------------");
            		}
            		else namerec[1]=text;
            	}
            	else if (cnt>=1) {
            		cnt++;
            		cnt%=9;
            		if (cnt==8 &&score!=Integer.parseInt(text)) {
            			cnt-=1;
            		}
            	}
            	if (thisIsScore.contains(cnt) ||cnt==1) {
            		if (thisIsScore.contains(cnt)) score+=Integer.parseInt(text);
            		System.out.print(text+" ");
            	}
            	else if (cnt==2) {
            		System.out.println("record: "+text);
            	}
            	else if (cnt==8) {
            		System.out.print("score: "+text);
            		
            		if (gamecnt==1) {
            			scorerec[1]=score;
            			System.out.println();
            			System.out.println(scorerec[0]+" : "+scorerec[1]);
            			//System.out.println(scorerec.get(0).name+" "+scorerec.get(1).name);
            			if (scorerec[0]>scorerec[1]) {
            				System.out.println(namerec[0]+" wins");
            			}
            			else {
            				System.out.println(namerec[1]+" wins");
            			}
            			System.out.println("--------------");
            		}
            		else scorerec[0]=score;
            	}
            }
        }
        
	}
}
