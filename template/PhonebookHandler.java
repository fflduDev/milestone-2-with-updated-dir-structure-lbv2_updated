package template;

import java.util.*;

/**
 * PhonebookHandler - supports 
 * Phonebook operations
 * 
 * Use a map to build the Phonebook
 * key: Contact
 * value: List<phonebookEntries>
 */

public class PhonebookHandler implements iPhonebookHander{

	private Map<Contact, List<PhonebookEntry>> phonebook;

	public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {
		this.phonebook = phonebook; 
	}

	@Override
	public List<Contact> sortByName() {
		List<Contact> contacts = new ArrayList<>(phonebook.keySet());

		int n = contacts.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (contacts.get(j).getName().compareTo(contacts.get(j + 1).getName()) > 0) {
					Contact temp = contacts.get(j);
					contacts.set(j, contacts.get(j + 1));
					contacts.set(j + 1, temp);
				}
			}
		}
		return contacts;
	}

	@Override
	public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
		int left = 0;
		int right = sortedContacts.size() - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			String midName = sortedContacts.get(mid).getName();

			if (midName.equals(name)) {
				return phonebook.get(sortedContacts.get(mid));
			}

			if (midName.compareTo(name) > 0) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return new ArrayList<>(); //empty list if contact is not found 
	}

	@Override
	public void display(List<Contact> sortedContacts) {
		System.out.println("Bubble Sort Phonebook: ");
		for (Contact contact : sortedContacts) {
			System.out.println(contact.getName());
		}
	}
}
