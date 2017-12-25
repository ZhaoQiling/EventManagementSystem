package operations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemOperation {
	public static void insertItemRec(float itemCost, String itemReas, int eventId) {
		String insertSql = "INSERT INTO ITEM_TBL (ITEM_COST, ITEM_REAS, EVENT_ID) VALUES (?, ?, ?)";
		try(PreparedStatement prepsInsertItem = mainpro.ProjectMain.connection.prepareStatement(insertSql)){
			prepsInsertItem.setFloat(1, itemCost);
			prepsInsertItem.setString(2, itemReas);
			prepsInsertItem.setInt(3, eventId);
			
			prepsInsertItem.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> selectAllItemID(){
		ArrayList<Integer> ret = new ArrayList<>();
		String selectSql = "SELECT ITME_ID FROM ITEM_TBL";
		try(PreparedStatement prepsSelectAllItemID = mainpro.ProjectMain.connection.prepareStatement(selectSql)){
			ResultSet rs = prepsSelectAllItemID.executeQuery();
			while(rs.next()) {
				ret.add(rs.getInt("ITEM_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public static ArrayList<String> selectAllByItemID(Integer ItemID) {
		ArrayList<String> ret = new ArrayList<>();
		String selectSql = "select * from ITEM_TBL WHERE ITEM_ID = ?";
		try(PreparedStatement prepsSelectAllByItemID = mainpro.ProjectMain.connection.prepareStatement(selectSql)){
			prepsSelectAllByItemID.setInt(1, ItemID);
			ResultSet rs = prepsSelectAllByItemID.executeQuery();
			rs.next();
			ret.add(rs.getString("ITEM_ID"));
			ret.add(rs.getString("ITEM_COST"));
			ret.add(rs.getString("ITEM_REAS"));
			ret.add(rs.getString("EVENT_ID")); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	

}
