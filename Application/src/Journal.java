import java.util.Map;
import java.util.TreeMap;

public class Journal {
	private Map<String, String> entries;
	private String ssnOfOwner;
	
	public Journal() {
		this.entries = new TreeMap<String, String>();
		this.ssnOfOwner =  "";
	}
	
	public void newEntry(String dateTime, String nurse) {
		
	}
	
	public void editEntry(String dateTime, String newString) {
		
	}
	
	public void deleteEntry(String date) {
		
	}
	
	public String getEntry(String dateTime) {
		return entries.get(dateTime);
	}
	
	public void enterSsn(String ssn) {
		ssnOfOwner = ssn;
	}
	
	public String getSsn() {
		return ssnOfOwner;
	}
}
