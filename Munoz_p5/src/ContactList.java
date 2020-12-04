import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ContactList {
    private ArrayList<ContactItem> contactData;


    public ContactList()
    {
        contactData = new ArrayList<>();
    }


    public void readList()
    {
        contactData.forEach((n) -> {
                System.out.printf("\n%d) Name: %s %s\nPhone: %s\nEmail: %s", contactData.indexOf(n), n.getFirstName(), n.getLastName(), n.getPhoneNumber(), n.getEmailAddress());
        });
    }


    public void createContact(String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception
    {
        try {
            ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            contactData.add(contact);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void editContact(int index, String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception
    {
        try
        {
            ContactItem edittedContact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
            contactData.set(index, edittedContact);
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new Exception("WARNING: that contact doesn't exist");
        }
        catch (Exception e)
        {
            System.out.printf(e.getMessage());
        }
    }


    public void destroyContact(int index) throws Exception
    {
        try
        {
            contactData.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            throw new Exception("WARNING: that contact doesn't exist");
        }
    }


    public void saveList(String filename)
    {
        try (Formatter output = new Formatter(filename))
        {
            contactData.forEach((n) -> output.format("%s\n%s\n%s\n%s\n\n", n.getFirstName(), n.getLastName(), n.getPhoneNumber(), n.getEmailAddress()));
        }
        catch (SecurityException | FileNotFoundException | FormatterClosedException e)
        {
            e.printStackTrace();
        }
    }


    public void loadList(String filename)
    {
        String firstName, lastName, phoneNumber, emailAddress;
        try (Scanner input = new Scanner(Paths.get(filename))) {
            while (input.hasNext())
            {
                firstName = input.nextLine();
                lastName = input.nextLine();
                phoneNumber = input.nextLine();
                emailAddress = input.nextLine();
                input.nextLine();

                try {
                    createContact(firstName, lastName, phoneNumber, emailAddress);
                }
                catch (Exception e) {
                    System.out.printf(e.getMessage());
                }

            }
        }
        catch (IOException | NoSuchElementException | IllegalStateException e)
        {
            e.printStackTrace();
        }
    }


    // for JUnit Testing
    public ContactItem getContact(int index) throws Exception
    {
        try {
            return contactData.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            throw new Exception("WARNING: that contact doesn't exist");
        }
    }

    public int getContactSize()
    {
        return contactData.size();
    }
}
