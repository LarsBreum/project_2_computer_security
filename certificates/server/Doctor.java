import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
	private List<Patient> list;
	
	public Doctor( String name, String ssn, String role, String division) {
		super(name, ssn, role, division);
		list = new ArrayList<>();
	}
	
	// Adds patient association to Doctor
	public void createAsso(Patient patient) {
		list.add(patient);
	}
	
	// Adds patient association to Nurse
	public void createAssoForNurse(Patient patient, Nurse nurse) {
		nurse.addAsso(patient);
	}
	
	// Returns list of patient associations of Doctor
	public List<Patient> getList() {
		return list;
	}
}
