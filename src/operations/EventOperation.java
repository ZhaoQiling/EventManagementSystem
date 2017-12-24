package operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventOperation {
	public static void insertEventRec(String name, String beginTime, String endTime) {
		
		String insertSql = "INSERT INTO EVENT_TBL(EVENT_NAME, BEGIN_TIME, END_TIME)values(?, ?, ?)";
		try(PreparedStatement prepsInsertEvent = mainpro.ProjectMain.connection.prepareStatement(insertSql);){
			prepsInsertEvent.setString(1, name);
			prepsInsertEvent.setDate(2, java.sql.Date.valueOf(beginTime));
			prepsInsertEvent.setDate(3, java.sql.Date.valueOf(endTime));
			
			prepsInsertEvent.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Integer> selectEventIDByDate(String beginTime, String endTime) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		String selectSql = "SELECT EVENT_ID FROM EVENT_TBL WHERE (BEGIN_TIME >= ?) AND (END_TIME <= ?)";
		try(PreparedStatement prepsSelectByDate = mainpro.ProjectMain.connection.prepareStatement(selectSql)){
			prepsSelectByDate.setString(1, beginTime);
			prepsSelectByDate.setString(2, endTime);
			ResultSet rs = prepsSelectByDate.executeQuery();
			while(rs.next()) {
				ret.add(rs.getInt("EVENT_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public static ArrayList<Integer> selectEventIDByName(String name) {
		ArrayList<Integer> ret = new ArrayList<>();
		String selectSql = "SELECT EVENT_ID FROM EVENT_TBL WHERE EVENT_NAME LIKE ?";
		try(PreparedStatement prepsSelectByDate = mainpro.ProjectMain.connection.prepareStatement(selectSql)){
			prepsSelectByDate.setString(1, "%" + name + "%");
			ResultSet rs = prepsSelectByDate.executeQuery();
			while(rs.next()) {
				ret.add(rs.getInt("EVENT_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
