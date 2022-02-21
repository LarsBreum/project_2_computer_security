import java.util.List;

public class Doctor extends Person {
	private String division;
	private List<Patient> list;
	
	public Doctor(String division, String name, String ssn, String role) {
		super(name, ssn, role);
		this.division = division;
	}
	
	public void createAsso(Patient patient, Nurse nurse) {
		nurse.addAsso(patient);
		list.add(patient);
	}
}
