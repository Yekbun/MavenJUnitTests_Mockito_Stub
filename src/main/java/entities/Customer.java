package entities;

public class Customer {
	public Customer() {
		super();
	}
	
	int Id;
	String Name;
	String Surname;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public Customer(int id, String name, String surname) {
		super();
		Id = id;
		Name = name;
		Surname = surname;
	}
}
