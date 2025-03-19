package template;

/**
 *   model a PhonebookEntry 
 *   
 *   PhonebookEntry has a phoneNumber and type
 *   
 *   
 *   
 */
class PhonebookEntry{

    private String phoneNumber;
    private String type; 

    public PhonebookEntry(String phoneNumber, String type) {
        this.phoneNumber = phoneNumber;
        this.type = type; 
    }

    public String getType() {
        return type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
	