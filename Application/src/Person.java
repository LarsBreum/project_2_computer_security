
public class Person {
	String name;
	String ssn;
	String role;
	String division;
	
	public Person(String name, String ssn, String role, String division) {
		this.name = name;
		this.ssn = ssn;
		this.role = role;
		this.division = division;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getDivision() {
		return division;
	}
	
	public String toString() {
		//StringBuilder sb = new StringBuilder();
		return "Role: "+ role + "Name: " + name + ", ssn: " + ssn;
	}
	
}
