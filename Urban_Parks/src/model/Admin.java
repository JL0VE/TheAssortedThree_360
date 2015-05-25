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
import java.util.Map;
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
		//To store the found volunteers
		ArrayList<Volunteer> foundVolunteer = new ArrayList<Volunteer>();
		//To deserialize the data
		Cereal readUserList = new Cereal(0);
		
		//UserList list = new UserList();
		HashMap<Integer, Object> map = ((UserList) readUserList.deSerialize()).getMap();
		
		java.util.Iterator<Entry<Integer, Object>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
			//This checks value[1] to equal the given last name and checks to see if its a volunteer
			//Make sure to check instance not just volunteer? maybe it will break the code
			if (pair.getValue() instanceof Volunteer) {	
				if (((Volunteer)(pair.getValue())).getMyLast().toLowerCase().equals(theLastName.toLowerCase())) {
					foundVolunteer.add((Volunteer)(pair.getValue()));
				}
			}
			itr.remove();
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
