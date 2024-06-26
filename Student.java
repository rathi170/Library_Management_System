package LibraryManagement;

public class Student extends People{
	 private int roll_no;

	   private int member_id;

	   private String dept;

	   

	public Student(String name, String email,int roll_no,int member_id,String dept) {

		super(name, email);

		  this.roll_no=roll_no;

		  this.member_id=member_id;

		  this.dept=dept;

	}



	public int getRoll_no() {

		return roll_no;

	}



	public void setRoll_no(int roll_no) {

		this.roll_no = roll_no;

	}



	public int getMember_id() {

		return member_id;

	}



	public void setMember_id(int member_id) {

		this.member_id = member_id;

	}

	public String getDept() {

		return dept;

	}



	public void setDept(String dept) {

		this.dept = dept;

	}

	public  void showInfo() {

		System.out.println("Name:- "+getName()+" roll_no:- "+roll_no+

				" Email:- "+getEmail()+" contact_no:- "+member_id+" employ_id:- "+dept);

	}


}
