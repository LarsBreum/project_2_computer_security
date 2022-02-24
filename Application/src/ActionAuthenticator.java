import java.util.List;

public class ActionAuthenticator {
	private Logger logger;
	
	public void ActionAuthenticator(String filename) {
		logger = new Logger(filename);
	}
	
	public boolean canCreate(Person p) {
		if(p instanceof  Doctor) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void canList(Person p) {
		String name = p.getName();
		String role = p.getRole();
	}
	
	public boolean canRead(Person p, Journal j, Division d) {
		//Government can always read.
		if(p instanceof GovernmentRep) {
			return true;
		}	
		//If the patients ssn is the same as the ssn in the journal they can read. 
		if(p instanceof Patient) {
			if(p.getSsn() == j.getSsn()) {
			return true;
			}
			return false;
		}	
		//If the nurse is in the division return true 
		if(p instanceof Nurse) {
			return d.getMembers().contains(p);
		}		
		//Same as above but with doctor
		if(p instanceof Doctor) {
			return d.getMembers().contains(p);
		}		
		return false;
	}
	
	public boolean canWrite(Person p, Journal j) {
		
		//If the nurse has a patient in it's association list with the same ssn as the journal return true 
		if(p instanceof Nurse) {
			for(Patient patient : ((Nurse) p).getList()) {
				if(patient.getSsn() == j.getSsn()) {
					return true;
				}
			}
			return false;
		}		
		//Same as above but with doctor
		if(p instanceof Doctor) {
			for(Patient patient : ((Doctor) p).getList()) {
				if(patient.getSsn() == j.getSsn()) {
					return true;
				}
			}
			return false;
		}
		
		//Patient and Government can NEVER read
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
