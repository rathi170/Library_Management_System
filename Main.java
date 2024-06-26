package LibraryManagement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		Library library=new Library();

		Books b1=new Books("Once upon a time","William",true);

		Books b2=new Books("calender","john",true);

		Books b3=new Books("little john ","henry",true);

		library.addBooks(b1);

		library.addBooks(b2);

		library.addBooks(b3);

		//library.PrintBooks();
		
		Student s1=new Student("Rathi","717821p342@kce.ac.in",342,312,"cse");
		Student s2=new Student("Chitu","717821p308@kce.ac.in",308,313,"It");
		Student s3=new Student("Moni","717821p332@kce.ac.in",332,314,"cse");
		Student s4=new Student("sahu","717821p344@kce.ac.in",344,315,"It");
		library.addUser(s1);
		library.addUser(s2);
		library.addUser(s3);
		library.addUser(s4);
		
		Librarian l1=new Librarian("raju","717821p789@kce.ac.in","91-977556677",789);
		Librarian l2=new Librarian("Chitu","717821p788@kce.ac.in","91-876566777",788);
		Librarian l3=new Librarian("mohan","717821p787@kce.ac.in","91-98766555",787);
		Librarian l4=new Librarian("saran","717821p786@kce.ac.in","91-8766544333",786);
		library.addIncharge(l1);
		library.addIncharge(l2);
		library.addIncharge(l3);
		library.addIncharge(l4);
		
		
	
	 
	  while(true) {
		  System.out.println("Enter your operation:");
		  System.out.println("*** 1 =>  search and collect u want a book  ***");
		  System.out.println("*** 2 =>  return the book ***");
		  System.out.println("*** 3 =>  books in library ***");
		  System.out.println("*** 4 =>  members in library ***");
		  System.out.println("*** 5 =>  Update library books ***");
		  System.out.println("*** 6 =>  new member in library ***");
		  System.out.println("*** 7 =>  Library incharge ***");
		  System.out.println("*** 8 =>  new Librarian join ***");
		  System.out.println("*** 9 =>  exit our library ***");
		  int ch=sc.nextInt();
		switch(ch) {
		
		case 1:{
		      String search=sc.nextLine();
		     if( library.searchBooks( search)) {
			   System.out.println("book is available.");
			      library.collectBook(search);
		       }
		     else {
			   System.out.println("Sorry! book is unavailable.");
		     } 
		      break;
		        }
	   case 2:
		    {
		    	 System.out.println("Enter the book u want to read:");
			    String search=sc.nextLine();
		        library.returnBook(search);
		        break;
		    }
	   case 3:
	       {
		       library.PrintBooks();
		       break;
	        }
	   case 4:
	       {
		      library.PrintUser();
		      break;
	        }
	   case 5:
	       {
	    	   System.out.println("Enter the new book_name:");
	    	  String name=sc.nextLine();
	    	  sc.nextLine();
	    	  System.out.println("Enter the Author_name of the book:");
	    	  String Author_name=sc.nextLine();
	    	  boolean b=true;
	    	  Books b4=new Books(name,Author_name,b);
		      library.addBooks(b4);
		      System.out.print("successfully added books");
		      break;
	        }
	   case 6:
          {
        	  System.out.println("welcome the library to join new member :)");
        	  System.out.println("Enter the name:");
    	    String name=sc.nextLine();
    	    sc.nextLine();
    	    System.out.println("Enter the mail_id:");
    	    String mail_id=sc.nextLine();
    	    System.out.println("Enter the roll_no:");
    	    int roll_no=sc.nextInt();
    	    System.out.println("Enter the member_id:");
    	    int mem_id=sc.nextInt();
    	    System.out.println("Enter the your dept:");
    	    String dept=sc.nextLine();
    	    Student s5=new Student(name,mail_id,roll_no,mem_id,dept);
	        library.addUser(s5);
	        System.out.print("Thank you for join member in my library!!");
	        break;
          }
	   case 7:
	     {
	    	  library.PrintLibrarian();
	    	 break;
	      }
	   case 8:
       {
    	   
    	   System.out.println("Welcome our library new employee :) ");
    	   System.out.println("Enter the you name:");
 	      String name=sc.nextLine();
 	      sc.nextLine();
 	   System.out.println("Enter the your email_id:");
 	    String mail_id=sc.nextLine();
 	   System.out.println("Enter the contact_no:");
 	    String cont_no=sc.nextLine();
 	   System.out.println("Enter the employee_id:");
 	    int emp_id=sc.nextInt();
 	   Librarian s5=new Librarian(name,mail_id,cont_no,emp_id);
	        library.addIncharge(s5);
	        System.out.print("Congratulation !!!");
	        break;
       }
	   case 9:
	   {
		   System.out.println("Thank you visiting our library!!!");
		   break;
	   }
	   default:
	   {
		   System.out.println("please check your option!!!");
	   }
	     
	     
		}
		
		if(ch==9 || ch> 9) {
			break;
		}
		
	  }
	}
	  
}
