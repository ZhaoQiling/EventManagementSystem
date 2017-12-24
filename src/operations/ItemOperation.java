package operations;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
