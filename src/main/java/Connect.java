import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Connect {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/simpledb";
        Connection con = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "123456");
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next())
                System.out.println(rs.getString("name"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


