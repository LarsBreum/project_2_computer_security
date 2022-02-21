public class ActionAuthenticator {
	private Logger logger;
	
	public Authenticator(String filename) {
		logger = new Logger(filename);
	}
	
	public canCreate() {
	
	}
	
	public canList(Person p) {
		String name = p.getName();
		String role = p.getRole();
	}
	
	public canRead() {
	
	}
	
	public canWrite() {
	
	}
	
	public canDelete() {
	
	}
}
