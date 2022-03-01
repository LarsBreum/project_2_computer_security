public class Application {
	ActionAuthenticator auth;
	public Application() {
		auth = new ActionAuthenticator();
		Patient alice = new Patient("Alice", "0001011234", "Patient", "ER");
		Nurse bob = new Nurse("Bob", "0102035678", "Nurse", "ER");
		Doctor phil = new Doctor("Phil", "9998979876", "Doctor", "ER");
		GovernmentRep sam = new GovernmentRep("Sam", "0127630000", "GovernmentRep");
	}
}
