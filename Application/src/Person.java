
public class Person {
	String name;
	String ssn;
	String role;
	
	public Person(String name, String ssn, String role) {
		this.name = name;
		this.ssn = ssn;
		this.role = role;
		
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
	
	public String toString() {
		//StringBuilder sb = new StringBuilder();
		return "Role: "+ role + "Name: " + name + ", ssn: " + ssn;
	}
	
}
