package constructors;

public class Reader {

	// Creating a reader object:
	private int userID;
	private String userFirstName;
	private String userLastName;
	private String userAddress;

	// This method is called when reading 'users.txt', as the ID already exists:
	public Reader(int userID, String userFirstName, String userLastName, String userAddress) {
		this.userID = userID;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
	}

	// This method is called when the employee registers a new user, and an ID will
	// be created:
	public Reader(String userFirstName, String userLastName, String userAddress) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
	}

	// Getting user ID:
	public int getUserID() {
		return userID;
	}

	// Setting user ID:
	public void setUserID(int userID) {
		this.userID = userID;
	}

	// Getting user first name:
	public String getUserFirstName() {
		return userFirstName;
	}

	// Setting user first name:
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	// Getting user last name:
	public String getUserLastName() {
		return userLastName;
	}

	// Setting user last name:
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	// Getting user address:
	public String getUserAddress() {
		return userAddress;
	}

	// Setting user address:
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	// Printing the users:
	@Override
	public String toString() {
		return "ID= " + userID + ", Name= " + userFirstName + " " + userLastName + ", Address= " + userAddress;
	}

}
