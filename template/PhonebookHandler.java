package template;

import java.util.*;

public class PhonebookHandler implements iPhonebookHander {

    private Map<Contact, List<PhonebookEntry>> phonebook;
	
    public PhonebookHandler(Map<Contact, List<PhonebookEntry>> phonebook) {
        this.phonebook = phonebook;
    }

    @Override
    public List<Contact> sortByName() {
        List<Contact> contacts = new ArrayList<>(phonebook.keySet());
        contacts.sort(Comparator.comparing(Contact::getName));
        return contacts;
    }

    @Override
    public List<PhonebookEntry> binarySearch(List<Contact> sortedContacts, String name) {
        int index = Collections.binarySearch(sortedContacts, new Contact(name), Comparator.comparing(Contact::getName));
        if (index >= 0) {
            return sortedContacts.get(index).getPhonebookEntries();
        }
        return new ArrayList<>();
    }

    @Override
    public void display(List<Contact> sortedContacts) {
        for (Contact contact : sortedContacts) {
            System.out.println("Contact: " + contact.getName());
            for (PhonebookEntry entry : contact.getPhonebookEntries()) {
                System.out.println("  " + entry.getType() + ": " + entry.getPhoneNumber());
            }
        }
    }
}
