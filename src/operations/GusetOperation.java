package operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GusetOperation {
	
	public static ResultSet getGusetList(){
		ResultSet ret = null;
		String selectSql = "select * from GUEST_TBL";
		try(PreparedStatement prepsSelectGuest = mainpro.ProjectMain.connection.prepareStatement(selectSql);){
			ret = prepsSelectGuest.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void insertGuestRec(String guestName, String guestConn, String guestAddr) {
		String insertSql = "INSERT INTO GUEST_TBL(GUEST_NAME, GUEST_CONN, GUEST_ADDR)values(?, ?, ?)";
		try(PreparedStatement prepsInsertGuest = mainpro.ProjectMain.connection.prepareStatement(insertSql)){
			prepsInsertGuest.setString(1, guestName);
			prepsInsertGuest.setString(2, guestConn);
			prepsInsertGuest.setString(3, guestAddr);
			prepsInsertGuest.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
