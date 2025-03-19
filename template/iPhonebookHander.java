package template;
import java.util.List;

/**
 * Interface defining the core operations for a phonebook handler
 */
public interface iPhonebookHander {
	
	/**
	 * Sorts the contacts by name using bubble sort algorithm.
	 * This method implements a basic bubble sort to order contacts alphabetically by name.
	 * 
	 * @return List<Contact> sorted list of contacts by name
	 */
	public List<Contact> sortByName();
	
	
	
	/*
	 * To implement searchByName using binary search, we need to make sure that the
	 * phonebook is sorted by names. Here's the modified sortByKeys method using
	 * Merge Sort, followed by the implementation of searchByName using binary
	 * search:
	 */
	/**
	 * Performs a binary search on the sorted contacts list to find a contact by name.
	 * Note: The contacts list must be sorted before using this method.
	 * 
	 * @param sortedContacts the pre-sorted list of contacts to search through
	 * @param name the name of the contact to search for
	 * @return List<PhonebookEntry> the phone entries for the found contact, or empty list if not found
	 */
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name);

	/**
	 * Displays the contacts in their current order.
	 * This method simply iterates over the contacts and prints their information.
	 * 
	 * @param sortedContacts the list of contacts to display
	 */
	public void display(List<Contact> sortedContacts);
}
