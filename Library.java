package LibraryManagement;

import java.util.ArrayList;

public class Library  {
	
		// TODO Auto-generated constructor stub
	

	 ArrayList<Books> books=new ArrayList<>();

    ArrayList<Student> user=new ArrayList<>();

    ArrayList<Librarian> incharge=new ArrayList<>();

     public void addBooks(Books book) {

   	  books.add(book);

      }

   public void addUser(Student users) {

   	user.add(users);

   }
   public void addIncharge(Librarian incharges) {

	   incharge.add(incharges);

	   }
   public void PrintBooks() {

   	for(Books b:books) {

   	    b.showInfo();
   	    
   		System.out.println();

   	}

   }

   public void PrintUser() {

   	for(Student s:user) {

   		s.showInfo();

   		System.out.println();

   	}

   }
   public void PrintLibrarian() {

	   	for(Librarian l:incharge) {

	   		l.showInfo();

	   		System.out.println();

	   	}

	   }

   public boolean searchBooks(String title) {

    	for(Books b:books) {

   		if(b.getBook_name().equals(title) && b.isAvailable()) {
   			return true;

   		}

   	}
   	return false;
   }
   public void collectBook(String title) {
	   for(Books b:books) {

	   		if(b.getBook_name().equals(title) && b.isAvailable()) {
	             b.setAvailable(false);
	   		}
	   }
   }
   public void returnBook(String title) {
	   for(Books b:books) {

	   		if(b.getBook_name().equals(title)) {
	             b.setAvailable(true);
       System.out.println(b.getBook_name()+" has been returned.");
       return;
	   		}
	   		
   }
	   System.out.print("This  is not my Library book");
	   
}
}
