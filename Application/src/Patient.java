
public class Patient extends Person {
	private Journal journal;
	
	public Patient(String name, String ssn, String role) {		
		super(name, ssn, role);
		this.journal = new Journal();
	}
	
}
