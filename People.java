package LibraryManagement;

public abstract class People {
	 private String name;

     private String email;

     

     

     public People(String name,String email) {

    	 this.name=name;

    	 this.email=email;

     }

     

     public abstract void showInfo();



	public String getName() {

		return name;

	}



	public void setName(String name) {

		this.name = name;

	}



	public String getEmail() {

		return email;

	}



	public void setEmail(String email) {

		this.email = email;

	}
}
