package appPack;

public class Users {

	private String name;
	private String surname;
	private int age;
	private boolean statu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public Users(String name, String surname, int age, boolean statu) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.statu = statu;
	}
	
	
	
}
