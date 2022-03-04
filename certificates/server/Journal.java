import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Journal {
	private Map<String, String> entries;
	
	public Journal() {
		this.entries = new TreeMap<String, String>();
	}
	
	// Adds entry into journal
	public void newEntry(String info) {
		LocalDateTime timeNow = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = timeNow.format(formatter);
		entries.put(formatDateTime, info);
	}
	// Edits entry with certain dateTime
	public void editEntry(String dateTime, String info) {
		entries.replace(dateTime, info);
	}
	// Deletes entry with certain dateTime
	public void deleteEntry(String dateTime) {
		entries.remove(dateTime);
	}
	// Returns entry with certain dateTime
	public String getEntry(String dateTime) {
		return entries.get(dateTime);
	}
	// Deletes all entries from certain patient
	public void deleteAll() {
		entries.clear();
	}
	// Returns patient journal
	public String toString() {
		return entries.toString();
	}
	
	
}
