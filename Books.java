package LibraryManagement;

public class Books {
	 private  String book_name;

	    private  String author_name;

	     private  boolean available;

		public Books(String book_name, String author_name, boolean available) {

			super();

			this.book_name = book_name;

			this.author_name = author_name;

			this.available = available;

		}

		public String getBook_name() {

			return book_name;

		}

		public void setBook_name(String book_name) {

			this.book_name = book_name;

		}

		public String getAuthor_name() {

			return author_name;

		}

		public void setAuthor_name(String author_name) {

			this.author_name = author_name;

		}

		public boolean isAvailable() {

			return available;

		}

		public void setAvailable(boolean available) {

			this.available = available;

		}
		public void  showInfo() {
			System.out.print("Book_name:- "+book_name+" author_name:- "+author_name+"available:- "+available);
		}
		

		  
}
