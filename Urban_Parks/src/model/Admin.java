package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Creates an Administrator 
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class Admin implements Serializable{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -5892491024213894664L;

	private String myFirst;

	private String myLast;

	private String myEmail;

	private String myPassword;

	private String myAddress;


	/**
	 * Constructor for default admin
	 */
	public Admin() {
		myFirst = "John";
		myLast = "Doe";
		myEmail = "johndoe@gmail.com";
		myAddress = "";
		myPassword = "password";
	}

	/**
	 * Constructor for input administrator
	 * 
	 * @param theFirst, String
	 * @param theLast, String
	 * @param theEmail, String
	 * @param thePassword, String
	 */
	public Admin(String theFirst, String theLast, String theEmail, String theAddress, String thePassword) {
		myFirst = theFirst;
		myLast = theLast;
		myEmail = theEmail;
		myAddress = theAddress;
		myPassword = thePassword;
	}


	/**
	 * Searches through the database for the input lastname and return
	 * a arraylist of userid if found or return null if nothing was found
	 * 
	 * @param theLastName the last name of the Volunteer
	 * @return ArrayList<Integer>, List of user id with the given last name
	 */
	public ArrayList<Volunteer> getVolunteer(String theLastName) {
		ArrayList<Volunteer> foundVolunteer = new ArrayList<Volunteer>(); //Initialized found volunteers

		Cereal readUserList = new Cereal(0); //Grabs data

		HashMap<Integer, Object> map = ((UserList) readUserList.deSerialize()).getMap(); //Grabs a map of the user list
		
		for (Entry<Integer, Object> pair : map.entrySet()) { //Iterate through the map
			if (pair.getValue() instanceof Volunteer) { 
				Volunteer aVolunteer = (Volunteer) pair.getValue();
				if (aVolunteer.getMyLast().toLowerCase().equals(theLastName.toLowerCase())) { //Case insensitive
					foundVolunteer.add(aVolunteer);
				}
			}
		}

		return foundVolunteer;
	}

	/**
	 * Getters and Setters for First Name
	 */
	public String getMyFirst() {
		String returnFirstName = myFirst;
		return returnFirstName;
	}

	public void setMyFirst(String theFirstName) {
		myFirst = theFirstName;
	}


	/**
	 * Getters and Setters for Last Name
	 */
	public String getMyLast() {
		String returnLastName = myLast;
		return returnLastName;
	}

	public void setMyLast(String theLastName) {
		myLast = theLastName;
	}


	/**
	 * Getters and Setters for Email
	 */
	public String getMyEmail() {
		String returnEmail = myEmail;
		return returnEmail;
	}

	public void setMyEmail(String theEmail) {
		myEmail = theEmail;
	}


	/**
	 * Getters and Setters for Password
	 */
	public String getMyPassword() {
		String returnPassword = myPassword;
		return returnPassword;
	}

	public void setMyPassword(String thePassword) {
		myPassword = thePassword;
	}


	/**
	 * Getters and Setters for Address
	 */
	public String getMyAddress() {
		String returnAddress = myAddress;
		return returnAddress;
	}

	public void setMyAddress(String theAddress) {
		myAddress = theAddress;
	}

	/**
	 * Returns all the info of the Administrator
	 * 
	 * @return a string of the Administrators information
	 */
	public String toString(){
		return myFirst + " " + myLast + "\n" + myEmail + "\n" + "Status: Admin";
	}
}
