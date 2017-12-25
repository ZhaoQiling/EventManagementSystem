package tools;

import java.util.ArrayList;

import operations.EventOperation;
import operations.GuestlistOperation;

public class GetItemSummary {
	public static String generatedAllSummary() {
		String ret = "";
		ArrayList<Integer> itemIDs = operations.ItemOperation.selectAllItemID();
		for(int i : itemIDs) {
			ArrayList<String> arrStr = operations.ItemOperation.selectAllByItemID(i);
			ret = ret + "Item's id is " + arrStr.get(0) +
					"\tItem's price is " + arrStr.get(1) + 
					"\tItem is for " + arrStr.get(2) +
					"\tItem is used in " + arrStr.get(3) + "\n";
		}
		return ret;
	}

}
