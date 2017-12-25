package operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public static ArrayList<Integer> selectEventIDByGuestAmo(Integer left, Integer right){
		ArrayList<Integer> ret = new ArrayList<>();
		String selectSql = "SELECT EVENT_ID FROM GUESTLIST GROUP BY EVENT_ID HAVING COUNT(GUEST_ID) BETWEEN ? AND ?";
		try(PreparedStatement prepsSelectEventIDByGuestAmo = mainpro.ProjectMain.connection.prepareStatement(selectSql)){
			prepsSelectEventIDByGuestAmo.setInt(1, left);
			prepsSelectEventIDByGuestAmo.setInt(2, right);
			ResultSet rs = prepsSelectEventIDByGuestAmo.executeQuery();
			while(rs.next()) {
				ret.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public static Integer selectGuestAmoByEventID(Integer EventID) {
		String selectSql = "SELECT COUNTGUEST = COUNT(GUEST_ID) FROM  GUESTLIST WHERE EVENT_ID = ?  GROUP BY EVENT_ID";
		Integer ret = null;
		try(PreparedStatement selectGuestAmoByEventID = mainpro.ProjectMain.connection.prepareStatement(selectSql);){
			selectGuestAmoByEventID.setInt(1, EventID);
			ResultSet rs = selectGuestAmoByEventID.executeQuery();
			rs.next();
			ret = rs.findColumn("COUNTGUEST");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
