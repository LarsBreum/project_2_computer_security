import java.util.HashSet;

public class Person {
	String name;
	String ssn;
	String role;
	String division;
	HashSet<String> patients;
	
	public Person(String name, String ssn, String role, String division) {
		this.name = name;
		this.ssn = ssn;
		this.role = role;
		this.division = division;
		patients = new HashSet<>();
	}
	// Returns person name
	public String getName() {
		return name;
	}
	// Returns person social security number
	public String getSsn() {
		return ssn;
	}
	// Returns person role
	public String getRole() {
		return role;
	}
	// Returns person division
	public String getDivision() {
		return division;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		Person p = (Person) o;
		return name.equals(p.getName());
	}
	public String toString() {
		return "Role: "+ role + "Name: " + name + ", ssn: " + ssn;
	}
	
}
