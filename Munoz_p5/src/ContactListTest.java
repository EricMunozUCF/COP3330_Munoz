import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            message = "" + list.getContactSize();
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            message = "" + list.getContactSize();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("2", message);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("", "", "", "");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: Contact needs at least 1 field filled out.", message);
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            list.editContact(2, "FirstName", "LastName", "111-111-1111", "FakeAddress@MailServer.dom");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that contact doesn't exist", message);
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            list.editContact(0, "", "LastName", "111-111-1111", "FakeAddress@MailServer.dom");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            list.editContact(0, "FirstName", "", "111-111-1111", "FakeAddress@MailServer.dom");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            list.editContact(0, "FirstName", "LastName", "", "FakeAddress@MailServer.dom");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList list = new ContactList();
        String message = "";

        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            list.editContact(0, "FirstName", "LastName", "111-111-1111", "FakeAddress@MailServer.dom");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("Completed Edit.", message);
    }

    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        String message = "";

        try {
            int size = list.getContactSize();
            if (size == 0)
                message = "" + size;
            else
                message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("0", message);
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        String message = "";
        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            message = "" + list.getContactSize();
            list.destroyContact(0);
            message = "" + list.getContactSize();
        }
        catch (Exception e){
            message = e.getMessage();
        }

        assertEquals("0", message);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        String message = "";
        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            message = "" + list.getContactSize();
            list.destroyContact(0);
            message = "" + list.getContactSize();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("0", message);
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList list = new ContactList();
        String message = "";
        try {
            list.createContact("First", "Last", "555-555-5555", "fake@main.dom");
            list.saveList("test.txt");

            ContactList newList = new ContactList();
            newList.loadList("test.txt");

            message = "Load Completed.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("Load Completed.", message);
    }
}
