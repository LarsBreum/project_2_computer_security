
public class Patient extends Person {
	private Journal journal;
	
	public Patient(String name, String ssn, String role, String division) {
		super(name, ssn, role, division);
		this.journal = new Journal();
	}
	// Returns patient journal
	public Journal getJournal() {
		return this.journal;
	}
	
	
}
