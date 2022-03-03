import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
	private List<Patient> list;
	
	public Doctor( String name, String ssn, String role, String division) {
		super(name, ssn, role, division);
		list = new ArrayList<>();
	}
	
	public void createAsso(Patient patient) {
		list.add(patient);
	}
	
	public void createAssoForNurse(Patient patient, Nurse nurse) {
		nurse.addAsso(patient);
	}
	
	public List<Patient> getList() {
		return list;
	}
}
