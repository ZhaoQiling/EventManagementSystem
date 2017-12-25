package operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GusetOperation {
	
	public static String selectAllGuestMess(){
		String ret = "";
		String selectSql = "select * from GUEST_TBL";
		try(PreparedStatement prepsSelectGuest = mainpro.ProjectMain.connection.prepareStatement(selectSql);){
			//NOT FINISHHHHHHHHHHHH
			ResultSet rs = prepsSelectGuest.executeQuery();
			while(rs.next()) {
				ret = ret + "Guest's ID is " + rs.getInt(1) + 
						"\tGuest's name is " + rs.getString(2) +
						"\tGuest's connection is " + rs.getString(3) +
						"\tGuest's address is " + rs.getString(4) + "\n";
			}
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
