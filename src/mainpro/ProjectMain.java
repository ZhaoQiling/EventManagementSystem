package mainpro;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import operations.EventOperation;
import operations.GuestlistOperation;
import operations.GusetOperation;  
public class ProjectMain {
	public static final String connectionString = 
			"jdbc:sqlserver://localhost:1433;"  
			+ "database=EMDB;"  
			+ "user=sa;"  
			+ "password=sa;";
	public static Connection connection = null;
	public static Connection getConnection() {
		Connection connection = null;  
        // Declare the JDBC objects.  
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			connection = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connection;
	}
	public static void main(String[] args) {
		connection = getConnection();
//		EventOperation.insertEventRec("world", "2016-1-2", "2016-2-1");
//		GusetOperation.insertGuestRec("zhao71", "qilingzhao8@gmail.com", "Tsingdao");
//		System.out.println(GusetOperation.getGusetList());
//		GuestlistOperation.insertGuestlistRec(2, 2);
//		System.out.println(EventOperation.selectEventIDByName("wor"));
//		System.out.println(EventOperation.selectEventIDByGuestAmo(1, 1));
	}

}
