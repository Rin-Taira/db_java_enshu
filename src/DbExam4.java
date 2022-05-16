import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbExam4 {
    public static void main(String[] args) {
        // parameter
        int param = 101;
        String param2 = "地球儀";
        
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // confirm
            System.out.println(" --- before connection --- ");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

            // confirm
            System.out.println(" --- after connection --- ");

            // SQL query string
            String sql = "SELECT * FROM products WHERE product_id = ? OR product_name = ?";

            // create statement
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, param);
            stmt.setString(2, param2);

            // execute
            ResultSet rs = stmt.executeQuery();

            // output
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int price = rs.getInt("price");

                String result = "";
                result += "product_id:" + id;
                result += ", product_name:" + name;
                result += ", price:" + price;
                
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
