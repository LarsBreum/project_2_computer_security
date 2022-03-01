import java.util.List;

public class Doctor extends Person {
	private List<Patient> list;
	
	public Doctor( String name, String ssn, String role, String division) {
		super(name, ssn, role, division);
	}
	
	public void createAsso(Patient patient, Nurse nurse) {
		nurse.addAsso(patient);
		list.add(patient);
	}
	
	public List<Patient> getList() {
		return list;
	}
}
