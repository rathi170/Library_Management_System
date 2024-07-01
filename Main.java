package LibraryManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		 String url = "jdbc:mysql://localhost:3306/dbms";
		   String user_name="root";
		   String password="root";
		  // Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection(url,user_name,password);
		 
	  while(true) {
		  System.out.println();
		  System.out.println("Enter your operation:");
		  System.out.println("*** 1 =>  search and collect u want a book  ***");
		  System.out.println("*** 2 =>  return the book ***");
		  System.out.println("*** 3 =>  books in library ***");
		  System.out.println("*** 4 =>  members in library ***");
		  System.out.println("*** 5 =>  Update library books ***");
		  System.out.println("*** 6 =>  Library incharge ***");
		  System.out.println("*** 7 =>  new member in library ***");
		  System.out.println("*** 8 =>  new Librarian join ***");
		  System.out.println("*** 9 =>  exit our library ***");
		  int ch=sc.nextInt();
		  sc.nextLine();
		switch(ch) {
		
		case 1: {
		    String search = sc.nextLine();
		   // sc.nextLine();
		    PreparedStatement pst = null;
		    ResultSet rs = null;
		    
		        String selectQuery = "SELECT * FROM Books WHERE title = ?";
		        pst = con.prepareStatement(selectQuery);
		        pst.setString(1, search);
		        rs = pst.executeQuery();

		        if (rs.next()) {
		            boolean available = rs.getBoolean("Available");
		            
		            if (available) {
		                System.out.println("Book is available.");
		                
		                // Update availability
		                String updateQuery = "UPDATE Books SET Available = false WHERE title = ?";
		                pst = con.prepareStatement(updateQuery);
		                pst.setString(1, search);
		                int rowsAffected = pst.executeUpdate();
		                
		                System.out.println(rowsAffected + " row(s) updated.");
		            } else {
		                System.out.println("Sorry! Book is unavailable.");
		            }
		        } else {
		            System.out.println("Book not found.");
		        }
		    
		      break;
		        }
		case 2: {
		    String return_book = sc.nextLine();
		   // sc.nextLine();
		    PreparedStatement pst = null;
		    ResultSet rs = null;
		    
		        String selectQuery = "SELECT * FROM Books WHERE title = ?";
		        pst = con.prepareStatement(selectQuery);
		        pst.setString(1, return_book );
		        rs = pst.executeQuery();

		        if (rs.next()) {
		            boolean available = rs.getBoolean("Available");
		            
		            if (!available) {
		                System.out.println("Successfully return the book!!!");
		                
		                // Update availability
		                String updateQuery = "UPDATE Books SET Available = true WHERE title = ?";
		                pst = con.prepareStatement(updateQuery);
		                pst.setString(1, return_book);
		                int rowsAffected = pst.executeUpdate();
		                
		                System.out.println(rowsAffected + " row(s) updated.");
		            } else {
		                System.out.println("Sorry! Book is not my library.");
		            }
		        } else {
		            System.out.println("Book not found.");
		        }
		    
		      break;
		        }

		case 3:
		{
			Statement st=con.createStatement();
			String query="select * from Books";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.print("The book_name is :"+rs.getString(1));
				System.out.print("  -- The book_Author is :"+rs.getString(2));
				System.out.print("  -- The Availability of book :"+rs.getBoolean(3));
				System.out.println();
			}
			break;
		}
		case 4:{
			Statement st=con.createStatement();
			String query="select s.member_id,s.roll_no,s.name,s.email,s.dept  from Student s right join Library l using(member_id)";
			ResultSet rs=st.executeQuery(query);
			System.out.println("            *************************************************                ");
			while(rs.next()) {
				System.out.print("The Memeber_id is :"+rs.getInt(1));
				System.out.print("  || The Roll_no is :"+rs.getInt(2));
				System.out.print("  || The name of student :"+rs.getString(3));
				System.out.print("  || Email-id :"+rs.getString(4));
				System.out.print("  || dept of student :"+rs.getString(5));
				System.out.println();
			}
			System.out.println("            *************************************************                ");
			break;
		}
		case 5:
		{
			String title=sc.nextLine();
			String Author=sc.nextLine();
			Boolean Available=true;
			String query="insert into Books values (?,?,?) ";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, title);
			pst.setString(2, Author);
			pst.setBoolean(3,Available);
			 int rowsAffected = pst.executeUpdate();
             
             System.out.println(rowsAffected + " row(s) updated.");
             break;
		}
		
		case 6:
		{
			Statement st=con.createStatement();
			String query="select * from Librarian";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.print("The Librarian_name is :"+rs.getString(1));
				System.out.print(" || Email-id :"+rs.getString(2));
				System.out.print(" || Contact-no :"+rs.getString(3));
				System.out.print(" || emp_id :"+rs.getInt(4));
				System.out.println();
			}
			break;
		}
		
		case 7:
		{
			int member_id=sc.nextInt();
			String  title="";
			Date  borrow_date=null;
			Date   return_date=null;
			//Boolean Available=true;
			String query="       INSERT INTO Library (title, member_id, borrow_date, return_date)\r\n"
					+ "VALUES (?, ?, ?, ?); ";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,title);
			pst.setInt(2, member_id);
			pst.setDate(3,borrow_date);
			pst.setDate(4, return_date);
			 int rowsAffected = pst.executeUpdate();
             
             System.out.println(rowsAffected + " row(s) updated.");
             break;
		}
		case 8:
		{
			
			String  name=sc.nextLine();
			String  email=sc.nextLine();
			String  cont_no =sc.nextLine();
			int emp_id=sc.nextInt();
			//Boolean Available=true;
			String query="INSERT INTO Librarian VALUES (?, ?, ?, ?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,cont_no);
			pst.setInt(4, emp_id);
			 int rowsAffected = pst.executeUpdate();
             
             System.out.println(rowsAffected + " row(s) updated.");
             break;
		}
	   case 9:
	   {
		   System.out.println("Thank you visiting our library!!!");
		   break;
	   }
	   default:
	   {
		   System.out.println("please check your operation!!!");
	   }
	     
	     
		}
		
		
		
		if(ch==9 || ch> 9) {
			break;
		}
		
	  }
	}
	  
}
