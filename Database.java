
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.math.*;

public class Database {

    public static void updateCharacter(String table, int id, String type, String name, int hp, int atk,
            String armeOuSort, String bouclier) {
                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + table, "root", "password");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            st.executeUpdate("UPDATE " + table + " SET Id = " + id);
            st.executeUpdate("UPDATE " + table + " SET Type = '" + type + "'");
            st.executeUpdate("UPDATE " + table + " SET Name = '" + name + "'");
            st.executeUpdate("UPDATE " + table + " SET NiveauVie = " + hp);
            st.executeUpdate("UPDATE " + table + " SET NiveauForce = " + atk);
            st.executeUpdate("UPDATE " + table + " SET ArmeOuSort = '" + armeOuSort + "'");
            st.executeUpdate("UPDATE " + table + " SET Bouclier = '" + bouclier + "'");
        } catch (Exception e) {
            System.err.println("Something went wrong: " + e);
        }
    }

}