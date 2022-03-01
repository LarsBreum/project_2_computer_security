import java.util.ArrayList;
import java.util.List;

public class Division {
	private String name;
	private List<Person> members;
	
	public Division(String name) {
		this.name = name;
		members = new ArrayList<>();
	}
	
	public void addMembers(Person p){
		members.add(p);
	}
	
	public List<Person> getMembers(){
		return members;
	}
	
	public String getName() {
		return name;
	}
	
}
