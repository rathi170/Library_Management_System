package LibraryManagement;

public class Librarian extends People{
	private String contact_no;

	private int employ_id;

	

	public Librarian(String name, String email,String contact_no,int employ_id) {

		super(name, email);

		this.contact_no=contact_no;

		this.employ_id=employ_id;

	}



	public String getContact_no() {

		return contact_no;

	}



	public void setContact_no(String contact_no) {

		this.contact_no = contact_no;

	}



	public int getEmploy_id() {

		return employ_id;

	}



	public void setEmploy_id(int employ_id) {

		this.employ_id = employ_id;

	}

	public  void showInfo() {

		System.out.println("Name "+getName()+" Email "+getEmail()+" contact_no "+contact_no+

				"employ_id "+employ_id);

	}






}
