import java.util.Map;
import java.util.TreeMap;

public class Journal {
	Map<String, String> entries;
	
	
	public Journal() {
		this.entries = new TreeMap<String, String>();
	}
	
	public void newEntry(String dateTime, String nurse) {
		
	}
	
	public void editEntry(String dateTime, String newString) {
		
	}
	
	public void deleteEntry(String date) {
		
	}
	
	public String getEntry(String dateTime) {
		return dateTime;
	}
}
