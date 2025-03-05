package template;

import java.util.List;

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

    public Contact(String name) {
        this.name = name;
    }

    public void addPhonebookEntry(String number, String type){

    }

    public List<PhonebookEntry> getPhonebookEntries() {
        //TODO implement
        return null;
    }
}
