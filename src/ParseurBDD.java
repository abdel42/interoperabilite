import java.sql.*;


public class ParseurBDD {

    public Statement st;
    public Connection c;
    public ResultSet rs ;
    public ParseurBDD() throws SQLException {
        //on charge le driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Bloc catch gÃ©nÃ©rÃ© automatiquement
            e.printStackTrace();
        }
        //connexion
        //String url = "jdbc:mysql://mira2.univ-st-etienne.fr/ba02996q";
        String url = "jdbc:mysql://localhost/interop";
        String identifiant = "root";
        String mdp = "4ag2ncarnot";
        c = DriverManager.getConnection(url, identifiant, mdp);
        c.setAutoCommit(false);
        st = c.createStatement();


        try {
            st = c.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            rs = st.executeQuery("SELECT * FROM elu WHERE DPT=43 AND CODECOM =51");
            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            for(int i=1;i<=columnsNumber;i++) {
                Object alpha = rsmd.getColumnName(i);
                System.out.print(alpha+" | ");
            }
            System.out.println("\n");
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print("  |  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);

                }
                System.out.println("");
            }

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }



    public void afficherRes(ResultSet rs) throws SQLException {
        int i;
        ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();
        int nbColonne = meta.getColumnCount();
        System.out.println("Il y a "+nbColonne+" colonnes dans ce ResultSet");

        for(i=1;i<=nbColonne;i++) {
            Object alpha = meta.getColumnName(i);
            System.out.print(" | "+alpha+" | ");
        }
        System.out.println();

        while(rs.next()) {
            for(i=1;i<=nbColonne;i++) {
                Object alpha = rs.getObject(i);
                System.out.print(" | "+alpha+" | ");
            }
            System.out.println();

        }

    }




}
