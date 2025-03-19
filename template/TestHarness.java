package template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestHarness {

	// Contact overrides hashcode && equals.  Observe collision here.
	private static Map<Contact, List<PhonebookEntry>> phonebook = new HashMap<>();
	private static Contact p1, p2, p3, p4, p5;
	private static PhonebookHandler phonebookHander;


	public static void main(String[] args) throws InterruptedException {
		init();
		
		// Test equals with non-equal contacts
		System.out.println("Testing non-equal contacts:");
		TEST_Equals(p1, p2);  // Jan vs Stan - should be false
		
		// Test equals with same contact
		System.out.println("Testing equal contacts:");
		TEST_Equals(p3, p3);  // Juan vs Juan - should be true
		
		// Test hashcode for non-collision
		System.out.println("Testing non-collision hashcodes:");
		TEST_hashcode(p1, p3);  // Jan vs Juan - different hashcodes
		
		// Test hashcode for collision
		System.out.println("Testing collision hashcodes:");
		TEST_hashcode(p2, p3);  // Stan vs Juan - same hashcode
		
		// Create the phonebook handler
		phonebookHander = new PhonebookHandler(phonebook);
		
		// Test sorting
		List<Contact> sortedContacts = TEST_Sort(phonebookHander);
		TEST_Display(sortedContacts);
		
		// Test successful search
		TEST_Search(phonebookHander, sortedContacts, "Juan");  // Should find entries
		
		// Test unsuccessful search
		TEST_Search(phonebookHander, sortedContacts, "Bob");   // Should show not found
	}

	// 
	public static List<Contact> TEST_Sort(PhonebookHandler phonebookHandler) {
		System.out.println("\nSorting contacts...");
		// Call phonebookHandler to sort the contacts
		List<Contact> sortedContacts = phonebookHandler.sortByName();
		return sortedContacts;
	}

	
	public static void TEST_Search(PhonebookHandler phonebookHandler, List<Contact> sortedContacts, String name) {
		System.out.println("\n -- Search results for " + name + " -- ");
		List<PhonebookEntry> selectedEntries = phonebookHandler.binarySearch(sortedContacts, name);
		
		if (selectedEntries.isEmpty()) {
			System.out.println("No entries found for contact: " + name);
		} else {
			for (PhonebookEntry entry : selectedEntries) {
				System.out.println("Entries for " + name + " " + entry.getType() + " " + entry.getPhoneNumber());
			}
		}
	}
	
	public static void TEST_Display(List<Contact> sortedContacts) {
		phonebookHander.display(sortedContacts);
	}

	public static void TEST_Equals(Contact r1, Contact r2) {
		System.out.println("Checking r1.equals(r2) for:");
		System.out.println("Name: " + r1.getName() + ", Phone Number(s): " + r1.getPhonebookEntries());
		System.out.println("Name: " + r2.getName() + ", Phone Number(s): " + r2.getPhonebookEntries());
		System.out.println(r1.equals(r2));
		System.out.println();
	}

	public static void TEST_hashcode(Contact r1, Contact r2) {
		System.out.println("Checking r1.hashcode = r2.hashcode for:");
		System.out.println("Name: " + r1.getName() + ", Phone Number(s): " + r1.getPhonebookEntries());
		System.out.println("Name: " + r2.getName() + ", Phone Number(s): " + r2.getPhonebookEntries());
		
		if (r1.hashCode() == r2.hashCode()) {
			System.out.println("Hash matches - we're in the same bucket ( collision!): " + r1.hashCode());
		} else {
			System.out.println("NO hash match: " + r1.hashCode() + " / " + r2.hashCode());
		}
		System.out.println();
	}
 

	/** TODO
	 * 
	 * Build 5 contacts
	 * Add 1-3 phonebook entries per contact.   Some must have > 1.
	 * 'Put' into the phonebook map key-value pairs of the form contact, List<PhonebookEntries>
	 * 
	 * Feel free to update 
	 * 
	 * @throws InterruptedException
	 */
	public static void init() throws InterruptedException {

		System.out.println("Building Contacts ....");
		TimeUnit.SECONDS.sleep(1);

		p1 = new Contact("Jan");
		p2 = new Contact("Stan");
		p3 = new Contact("Juan");
		p4 = new Contact("Mun");
		p5 = new Contact("Ran");

		System.out.println("Building Phonebook Entries ....");
		TimeUnit.SECONDS.sleep(1);

		p1.addPhonebookEntries("2034032233", "Home");
		p1.addPhonebookEntries("5532233322", "Cell");
		p1.addPhonebookEntries("1120092829", "Work");

		p2.addPhonebookEntries("1034032233", "Home");
		p2.addPhonebookEntries("2532233322", "Cell");
		p2.addPhonebookEntries("3120092829", "Work");

		p3.addPhonebookEntries("4034032233", "Home");
		p3.addPhonebookEntries("5532233322", "Cell");
		p3.addPhonebookEntries("6120092829", "Work");

		p4.addPhonebookEntries("6034032233", "Home");
		p4.addPhonebookEntries("3532233322", "Cell");
		p4.addPhonebookEntries("1120092829", "Work");

		p5.addPhonebookEntries("0034032233", "Home");
		p5.addPhonebookEntries("0532233322", "Cell");
		p5.addPhonebookEntries("0120092829", "Work");

		System.out.println("Adding Entries to the phonebook ....\n");
		TimeUnit.SECONDS.sleep(1);

		phonebook.put(p1, p1.getPhonebookEntries()); // put ultimately calls overriden hashCode
		phonebook.put(p2, p2.getPhonebookEntries());
		phonebook.put(p3, p3.getPhonebookEntries());
		phonebook.put(p4, p4.getPhonebookEntries());
		phonebook.put(p5, p5.getPhonebookEntries());

	}

}
