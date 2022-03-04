import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Journal {
	private Map<String, String> entries;
	
	public Journal() {
		this.entries = new TreeMap<String, String>();
	}
	
	public void newEntry(String info) {
		LocalDateTime timeNow = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = timeNow.format(formatter);
		entries.put(formatDateTime, info);
	}
	
	public void editEntry(String dateTime, String info) {
		entries.replace(dateTime, info);
	}
	
	public void deleteEntry(String dateTime) {
		entries.remove(dateTime);
	}
	
	public String getEntry(String dateTime) {
		return entries.get(dateTime);
	}
	
	public void deleteAll() {
		entries.clear();
	}
	
	public String toString() {
		return entries.toString();
	}
	
	
}
