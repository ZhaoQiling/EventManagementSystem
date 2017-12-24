package operations;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuestlistOperation {
	public static void insertGuestlistRec(Integer guestId, Integer eventId) {
		String insertSql = "INSERT INTO GUESTLIST (GUEST_ID, EVENT_ID) values(?, ?)";
		try(PreparedStatement prepsInsertGuestlist = mainpro.ProjectMain.connection.prepareStatement(insertSql)){
			prepsInsertGuestlist.setInt(1, guestId);
			prepsInsertGuestlist.setInt(2, eventId);
			
			prepsInsertGuestlist.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
