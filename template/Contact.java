package template;

import java.util.*;

/**
 * model a Contact 
 * Contact has a name & list of phonebook entries
 * 
 * Support adding phonebookEntry to a contact
 * 
 * @Override hashCode and equals
 * 
 */

class Contact {
    private String name;
    private List<PhonebookEntry> phonebookEntries;

    public Contact (String name) {
        this.name = name;
        this.phonebookEntries = new ArrayList<>();
    }

    public void addPhonebookEntry(PhonebookEntry phonebookEntry) {
        this.phonebookEntries.add(phonebookEntry);
    }

    public void addPhonebookEntries(String phoneNumber, String type) {
        PhonebookEntry entry = new PhonebookEntry(phoneNumber, type);
        this.phonebookEntries.add(entry);
    }

    public List<PhonebookEntry> getPhonebookEntries() {
        return phonebookEntries;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false; 
        if (getClass() != obj.getClass()) return false;
        Contact other = (Contact) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        if (name == null) {
            return 0;
        } else {
            return name.hashCode();
        }
    }
        
}
