<<<<<<< HEAD

=======
>>>>>>> 617d7d779f281250cdd3b422608f11cf2774ec64
package narss_gs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connect {
    
    public static void connect(){
        Connection conn=null;
        try{
<<<<<<< HEAD
            //String url = "jdbc:sqlite:C:\\Users\\Wallid Samy\\Desktop\\project\\groundsubsystem.sqlite";
            String url = "jdbc:sqlite:src\\narss_gs.sqlite";
=======
            String url = "jdbc:sqlite:src\\groundsubsystem.sqlite";
>>>>>>> 617d7d779f281250cdd3b422608f11cf2774ec64
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established."); 
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 617d7d779f281250cdd3b422608f11cf2774ec64
