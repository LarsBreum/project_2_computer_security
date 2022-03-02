import java.util.Map;
import java.util.TreeMap;

public class Journal {
	private Map<String, String> entries;
	
	public Journal() {
		this.entries = new TreeMap<String, String>();
	}
	
	public void newEntry(String dateTime, String nurse) {
		entries.put(dateTime, nurse);
	}
	
	public void editEntry(String dateTime, String newString) {
		entries.replace(dateTime, newString);
	}
	
	public void deleteEntry(String date) {
		entries.remove(date);
	}
	
	public String getEntry(String dateTime) {
		return entries.get(dateTime);
	}
	
	public String toString() {
		return "Hej här är en journal!";
	}
	
}
