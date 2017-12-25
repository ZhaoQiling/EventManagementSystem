package mainpro;
import java.sql.*;
import java.util.Scanner;

import com.microsoft.sqlserver.jdbc.*;

import operations.EventOperation;
import operations.GuestlistOperation;
import operations.GusetOperation;
import tools.GetEventSummary;  
public class ProjectMain {
	public static final String connectionString = 
			"jdbc:sqlserver://localhost:1433;"  
			+ "database=EMDB;"  
			+ "user=sa;"  
			+ "password=sa;";
	public static Connection connection = null;
	public static Connection getConnection() {
		Connection connection = null;  
        // Declare the JDBC objects.  
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
        return connection;
	}
	private static void printMainMenu() {
		System.out.println("1. Eventlist");
		System.out.println("2. Guestlist");
		System.out.println("3. Itemlist");
		System.out.println("4. Associate GuestID with EventID");
		System.out.println("0. Quit");
		System.out.print("Please input the number of what you want to do: ");
	}
	
	private static void printEventMenu() {
		System.out.println("1. View all events");
		System.out.println("2. Sreach events (by date, number of guests or keyword)");
		System.out.println("3. Create an Event");
		System.out.print("Please input the number of what you want to do: ");
	}
	private static void printEventSearchMenu() {
		System.out.println("1. Search events by Date");
		System.out.println("2. Search events by the number of guests");
		System.out.println("3. Search events by keyword");
		System.out.print("Please input the number of what you want to do: ");
	}
	
	private static void printGuestMenu() {
		System.out.println("1. view the list of guests");
		System.out.println("2. create a new guest");
		System.out.print("Please input the number of what you want to do: ");
	}
	private static void printItemMenu() {
		System.out.println("1. view the itemlist");
		System.out.println("2. insert a item");
		System.out.print("Please input the number of what you want to do: ");
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to use  Event Management System");
		connection = getConnection();
		Integer cmd = null;
		Scanner in = new Scanner(System.in);
		while(true) {
			printMainMenu();
			cmd = in.nextInt();
			if(cmd == 1) {
				printEventMenu();
				cmd = in.nextInt();
				//1. View all events
				if(cmd == 1) {
					System.out.println(tools.GetEventSummary.getSummaryOfAllEvents());
				}
				//2. Sreach events (by date, number of guests or keyword)
				else if(cmd == 2) {
					printEventSearchMenu();
					cmd = in.nextInt();
					//1. Search events by Date
					if(cmd == 1) {
						System.out.print("Please input begindate and endate (like 1970-1-1): ");
						String beginDate = in.next(); String endDate = in.next();
						System.out.println(tools.GetEventSummary.getSummaryByDate(beginDate, endDate));
					}
					//2. Search events by the number of guests
					else if(cmd == 2) {
						System.out.print("Please input the bound of the number of guests: ");
						Integer left = in.nextInt(); Integer right = in.nextInt();
						System.out.println(tools.GetEventSummary.getSummaryByGuestAmo(left, right));
					}
					//3. Search events by keyword
					else if(cmd == 3) {
						System.out.print("Please input your keyword: ");
						String keyword = in.next();
						System.out.println(tools.GetEventSummary.getSummaryByKeyWord(keyword));
					}
				}
				//3. Create an Event
				else if(cmd == 3) {
					System.out.println("Please input the Event's name begindate and enddate(like 1970-1-1) in order:");
					String name = in.next(); String bt = in.next(); String et = in.next();
					EventOperation.insertEventRec(name, bt, et);
				}
			}
			else if(cmd == 2) {
				printGuestMenu();
				cmd = in.nextInt();
				//1. view the list of guests
				if(cmd == 1) {
					System.out.println(operations.GusetOperation.selectAllGuestMess());
				}
				//2. create a new guest
				else if(cmd == 2) {
					System.out.println("Please input the new guest's name, connection, address in order");
					String name = in.next(); String cn = in.next(); String addr = in.next();
					operations.GusetOperation.insertGuestRec(name, cn, addr);
				}
			}
			else if(cmd == 3) {
				printItemMenu();
				cmd = in.nextInt();
				//1. view the itemlist
				if(cmd == 1) {
					System.out.println(tools.GetItemSummary.generatedAllSummary());
				}
				//2. insert a item
				else if(cmd == 2) {
					System.out.println("Please input the new item's cost, reason and its eventid in order");
					Float co = in.nextFloat();  String res = in.next(); Integer eid = in.nextInt();
					operations.ItemOperation.insertItemRec(co, res, eid);
				}
			}
			else if(cmd == 4) {
				System.out.println("Please input the eventid and the guestid in order: ");
				int eid = in.nextInt(); int gid = in.nextInt();
				operations.GuestlistOperation.insertGuestlistRec(gid, eid);
			}
			else if(cmd == 0) {
				break;
			}
				
		}
	}

}
