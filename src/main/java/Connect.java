import org.example.User;

import java.sql.*;
import java.util.ArrayList;
public class Connect {

    public static void main(String[] args) {

        String conString = "jdbc:postgresql://localhost:5432/simpledb";
        Connection con = null;
        ResultSet rs = null;
        Statement statement = null;
        ArrayList<User> users = new ArrayList<User>();
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(conString, "postgres", "123456");
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Boolean gender = rs.getBoolean("gender");
                int age = rs.getInt("age");

                User user = new User(id,age, name, surname, gender);
                users.add(user);
            }
        }
        catch (SQLException | ClassNotFoundException e){
            System.out.println("Connection error " + e.getMessage());
        }
        finally {
            try{
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if(con != null) {
                    con.close();
                }
            }
            catch(SQLException e) {
                System.out.println("could not close connection: " + e.getMessage());
            }
        }
        for(User user : users) {System.out.println(user);}
    }
}


