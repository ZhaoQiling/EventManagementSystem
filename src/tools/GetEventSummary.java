package tools;

import java.util.ArrayList;

import operations.EventOperation;
import operations.GuestlistOperation;

public class GetEventSummary {
	private static String generatedSummary(Integer eventID) {
		String ret = null;
		ArrayList<String> arrStr = EventOperation.selectAllByEventID(eventID);
		ret = "Event's id is " + arrStr.get(0) +
				"\tEvent's name is " + arrStr.get(1) + 
				"\tEvent's begintime is " + arrStr.get(2) + 
				"\tEvent's endtime is " + arrStr.get(3);
		ret = ret + "\tGuest's number is " + GuestlistOperation.selectGuestAmoByEventID(eventID).toString();
		return ret;
	}
	public static String getSummaryByDate(String beginTime, String endTime) {
		String ret = "";
		ArrayList<Integer> eventIDs = EventOperation.selectEventIDByDate(beginTime, endTime);

		for(int id : eventIDs) {
			ret = ret + generatedSummary(id) + "\n";
		}
		return ret;
	}
	public static String getSummaryByGuestAmo(Integer left, Integer right) {
		String ret = "";
		ArrayList<Integer> eventIDs = GuestlistOperation.selectEventIDByGuestAmo(left, right);
		
		for(int id : eventIDs) {
			ret = ret + generatedSummary(id) + "\n";
		}
		return ret;
	}
	public static String getSummaryByKeyWord(String keyWord) {
		String ret = "";
		ArrayList<Integer> eventIDs = EventOperation.selectEventIDByName(keyWord);
		
		for(int id : eventIDs) {
			ret = ret + generatedSummary(id) + "\n";
		}
		return ret;
	}
	public static String getSummaryOfAllEvents() {
		String ret = "";
		ArrayList<Integer> eventIDs = EventOperation.selectAllEventID();
		
		for(int id : eventIDs) {
			ret = ret + generatedSummary(id) + "\n";
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
