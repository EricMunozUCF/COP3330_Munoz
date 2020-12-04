import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("", "", "", "");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("WARNING: Contact needs at least 1 field filled out.", message);
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Creation.", message);
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("", "Last", "555-555-5555", "fake@main.dom");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Creation.", message);
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "", "555-555-5555", "fake@main.dom");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Creation.", message);
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "", "fake@main.dom");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Creation.", message);
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Creation.", message);
    }

    @Test
    public void editingFailsWithAllBlankValues()    // TODO
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            message = "Completed Creation.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        fail();
        //assertEquals("Completed Creation.", message);
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            item.setEmailAddress("");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            item.setFirstName("");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            item.setLastName("");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            item.setPhoneNumber("");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Edit.", message);
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            item.setEmailAddress("FakeAddress@MailServer.dom");
            message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Completed Edit.", message);
    }

    @Test
    public void testToString()
    {
        String message = "";
        try {
            ContactItem item = new ContactItem("First", "Last", "555-555-5555", "fake@main.dom");
            message = item.toString();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("First Last 555-555-5555 fake@main.dom", message);
    }
}