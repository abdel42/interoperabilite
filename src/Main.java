import java.sql.SQLException;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) {

        /**
         * Déclarations des listes pour stocker les infos trouvées
         * Une liste par source
         */
        ArrayList<Info> infoBDD = null;
        ArrayList<Info> infoHTML = null;
        ArrayList<Info> infoCSV = null;


        ParseurBDD bdd = new ParseurBDD();
        /**
         * Instanciation du parseur HTML avec l'URL a traitée
         */
        ParseurHTML parseur = new ParseurHTML("https://www.ville-lechambonsurlignon.fr/mairie/les-services-municipaux-3.html");
        ParseurCSV csv = new ParseurCSV();


        System.out.println("Hello World!");


        infoHTML = parseur.parseur();
        System.out.println("\n");
        infoCSV = csv.ParseurCSV();
        System.out.println("\n");
        try {
            infoBDD = bdd.ParseurBDD();
        } catch (SQLException e) {
            System.out.println("Erreur base de donnée !");
            e.printStackTrace();
        }


        ArrayList<Info> infos = new ArrayList<Info>(infoBDD);
        infos.addAll(infoCSV);
        infos.addAll(infoHTML);
        //
        System.out.println("\n");

        System.out.println("Traitement terminé ! \n" +
                "Informations trouvées : "+infos.size()+"\n" +
                "Détails : \n" +
                "Base de donnée : " +infoBDD.size()+"\n"+
                "CSV : " +infoCSV.size()+"\n"+
                "HTML : "+infoHTML.size()+"\n");
    }
}
