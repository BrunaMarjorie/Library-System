package constructors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import searching.Sorting;

public class ReadersContacts {

	// Creating a collection of the object Reader:
	private ArrayList<Reader> contacts = new ArrayList<Reader>();

	// Method to add a new reader to the collection:
	public void addUser(Reader user) {
		// Checking if the userID already exists(in case it is reading 'users.txt'):
		int ID = user.getUserID();

		// If there is no userID, it generates a new one:
		if (ID == 0) {
			int lastID = contacts.get(contacts.size()-1).getUserID(); //Getting the ID of the last reader inserted;
			ID = lastID + 1;
			user.setUserID(ID);
		}
		contacts.add(user);
	}

	// Getting the collection of readers:
	public ArrayList<Reader> getReaders() {
		return contacts;
	}

	// Getting reader using ID as parameter:
	public Reader getReaderByID(int ID) {
		for (Reader rc : contacts) {
			if (rc.getUserID() == ID) {
				return rc;
			}
		}

		return null;
	}

	// Deleting user from the collection:
	public void deleteUser(Reader user) {
		contacts.remove(user);
	}

	// Checking the number of readers in the collection:
	public int numUsers() {
		return contacts.size();
	}

	// Sorting all the reader by name:
	public Sorting listUsersByName() {
		ArrayList<String> list = new ArrayList<>();
		
		System.out.println("Users in the system: \n");

		for (int i = 0; i < contacts.size(); i++) {
			list.add(contacts.get(i).getUserFirstName() + " " + contacts.get(i).getUserLastName() + " (ID: "
					+ contacts.get(i).getUserID() + "), Address: " + contacts.get(i).getUserAddress() + "\n");
		}

		Sorting sort = new Sorting();
		sort.sort(list);

		return sort;
	}

	// Printing the collection of users:
	public void printContacts() {
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println(contacts.get(i));
		}
		System.out.println();
	}

	// Method to update the 'users.txt' file:
	public void publish() {
		try {
			FileWriter fw = new FileWriter("users.txt");

			BufferedWriter bw = new BufferedWriter(fw);

			// Creating the string to be written:
			for (int i = 0; i < contacts.size(); i++) {
				String output = Integer.toString(contacts.get(i).getUserID()) + ":" + contacts.get(i).getUserFirstName()
						+ ":" + contacts.get(i).getUserLastName() + ":" + contacts.get(i).getUserAddress();

				// Writing the string on the file:
				try {
					bw.write(output);
					bw.newLine();

					// Checking for errors when writing:
				} catch (IOException e) {
					System.out.println("An error has occured");
					e.printStackTrace();
				}
			}

			bw.close();

			// Checking for errors when finding the file:
		} catch (IOException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
}
