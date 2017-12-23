import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;  
public class Main {
	public static final String connectionString = 
//			"server=.\\SQLEXPRESS;uid=sa;pwd=sa;datebase=EMDB;";
			"jdbc:sqlserver://localhost:1433;"  
			+ "database=EMDB;"  
			+ "user=sa;"  
			+ "password=sa;";  
	public static void main(String[] args) {
        // Declare the JDBC objects.  
        Connection connection = null;  
        Statement statement = null;   
        ResultSet resultSet = null;  
        PreparedStatement prepsInsertProduct = null;  
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
	}

}
