import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseurHTML {

    private String url;

    public ParseurHTML(String url) {
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void parseur(){
        String url = this.getUrl();
        try {
            Document doc = Jsoup.connect(url).get();
           // doc.select("style").remove();
           // doc.select("xml").remove();
            Element niveau1 = doc.selectFirst("div#content_size > div");
            System.out.println(niveau1.toString());
            String test = niveau1.toString();
            String test2 = Jsoup.parse(test).text();
            System.out.println("\n\n"+test2);
            String[] infoBrut = test2.split(" - ");
            for(int i = 0; i<infoBrut.length; i++){
                System.out.println(infoBrut[i]);
            }
            /**
             * Nous avons ici les infos nécessaire en brut
             * il faut remplir les objetInfo apres avoir separer les infos brutes
             */





        }catch (IOException e){
            System.out.println("Erreur IOException ! \n"+e);
        }
    }

}
