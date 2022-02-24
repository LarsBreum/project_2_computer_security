import java.util.List;

public class Nurse extends Person{
	private String division;
	private List<Patient> list;
	
	public Nurse(String division, String name, String ssn, String role) {
		super(name, ssn, role);
		this.division = division;
	}
	
	public void addAsso(Patient patient) {
		list.add(patient);
	}
	
	public List<Patient> getList() {
		return list;
	}
}
