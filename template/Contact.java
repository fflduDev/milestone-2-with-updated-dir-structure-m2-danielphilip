package template;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Contact {
    private String name;
    private List<PhonebookEntry> phonebookEntries;

    public Contact(String name) {
        this.name = name;
        this.phonebookEntries = new ArrayList<>();
    }

    public void addPhonebookEntry(String number, String type) {
        phonebookEntries.add(new PhonebookEntry(number, type));
    }

    public String getName() {
        return name;
    }
    public List<PhonebookEntry> getPhonebookEntries() {
        return phonebookEntries;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contact contact = (Contact) obj;
        return Objects.equals(name, contact.name) && Objects.equals(phonebookEntries, contact.phonebookEntries);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, phonebookEntries);
    }
}
