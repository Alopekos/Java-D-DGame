package personnages;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Guerrier extends Personnage {
    public Guerrier(String name) {
        super(name,
                "guerrier",
                ((int) ((Math.random() * 5) + 5)),
                ((int) ((Math.random() * 5) + 5)));
    }

    public String getMageDB(String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hero", "root", "password");
            System.out.println("Database connected");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from Hero");
            rs.first();
            return rs.getString(2);
        } catch (Exception e) {
            System.err.println("Something went wrong: " + e);
        }
        return "";
    }
}