package template;

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

    public Contact (String name) {
        this.name = name;
    }

    public void addPhonebookEntry(PhonebookEntry phonebookEntry) {
        this.phonebookEntries.add(phonebookEntry);
    }

    public List<PhonebookEntry> getPhonebookEntries() {
        return phonebookEntries;
    }

}
