import java.util.List;

public class Nurse extends Person{
	private List<Patient> list;
	
	public Nurse(String name, String ssn, String role, String division) {
		super(name, ssn, role, division);
		this.division = division;
	}
	
	public void addAsso(Patient patient) {
		list.add(patient);
	}
	
	public List<Patient> getList() {
		return list;
	}
}
