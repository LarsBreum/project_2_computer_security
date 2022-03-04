import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person{
	private List<Patient> list;
	
	public Nurse(String name, String ssn, String role, String division) {
		super(name, ssn, role, division);
		list = new ArrayList<>();
		this.division = division;
	}
	
	// Adds patient into nurse list of associations
	public void addAsso(Patient patient) {
		list.add(patient);
	}
	
	// Returns list of patient associations of Nurse
	public List<Patient> getList() {
		return list;
	}
}
