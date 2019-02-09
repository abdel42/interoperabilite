import java.sql.SQLException;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {

        System.out.println("Hello World!");
        ParseurHTML parseur = new ParseurHTML("https://www.ville-lechambonsurlignon.fr/mairie/les-services-municipaux-3.html");
        ArrayList<Info> infoHTML;
        //infoHTML = parseur.parseur();

        try {
            ParseurBDD test = new ParseurBDD();
        }catch(SQLException e){

        }

    }
}
