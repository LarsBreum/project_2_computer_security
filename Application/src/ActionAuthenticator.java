import java.util.List;

public class ActionAuthenticator {
	private Logger logger;
	
	public void ActionAuthenticator(String filename) {
		logger = new Logger(filename);
		Patient alice = new Patient("Alice", "0001011234", "Patient", "ER");
		Nurse bob = new Nurse("Bob", "0102035678", "Nurse", "ER");
		Doctor phil = new Doctor("Phil", "9998979876", "Doctor", "ER");
		GovernmentRep sam = new GovernmentRep("Sam", "0127630000", "GovernmentRep");
	}
	
	//Only doctor can create new entry and the patient must be in the Doctors assocation list
	public boolean canCreate(Person p, Patient patient) {
		if(p instanceof Doctor) {
			if(((Doctor) p).getList().contains(patient)) {
				logger.log(p.getRole() + " " + p.getName() + " created a new record for patient " + patient.getName());
			}
			else {
				logger.log(p.getRole() + " " + p.getName() + " tried to create a new record for patient " + patient.getName() + " but was denied");
			}
			return ((Doctor) p).getList().contains(patient);
		}
		logger.log(p.getRole() + " " + p.getName() + " tried to create a new record for patient " + patient.getName() + " but was denied");
		return false;
	}
	
	public void canList(Person p) {
		String name = p.getName();
		String role = p.getRole();
	}
	
	public boolean canRead(Person p, Patient patient) {
		//Government can always read.
		if(p instanceof GovernmentRep) {
			return true;
		}	
		//If the patients ssn is the same as the ssn in the journal they can read. 
		if(p instanceof Patient) {		
			return p.getSsn() == patient.getSsn();
		}	
		//If the nurse is in the division return true 
		if(p instanceof Nurse) {
			return p.getDivision() == patient.getDivision();
		}		
		//Same as above but with doctor
		if(p instanceof Doctor) {
			return p.getDivision() == patient.getDivision();
		}		
		return false;
	}
	
	public boolean canWrite(Person p, Patient patient) {	
		//If the nurse has a patient in it's association list with the same ssn as the journal return true 
		if(p instanceof Nurse) {
			return ((Nurse) p).getList().contains(patient);
		}		
		//Same as above but with doctor
		if(p instanceof Doctor) {
			return ((Doctor) p).getList().contains(patient);
		}	
		//Patient and Government can NEVER write
		if(p instanceof Patient) {
			return false;
		}
		if(p instanceof GovernmentRep) {
			return false;
		}
		return false;
	}
	
	//Only Governemnt can delete
	public boolean canDelete(Person p) {
		if(p instanceof GovernmentRep) {
			return true;
		}
		else {
			return false;
		}
	}	
}
