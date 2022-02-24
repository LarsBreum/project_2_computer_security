
public class Patient extends Person {
	private Journal journal;
	private String division;
	
	public Patient(String name, String ssn, String role, String division) {		
		super(name, ssn, role);
		this.division = division;
		this.journal = new Journal();
	}
	
}
