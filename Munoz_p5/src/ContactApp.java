import java.util.Scanner;

public class ContactApp {

    public static void contactMenuLoop()
    {
        int contactMenuChoice;

        while (true)
        {
            System.out.printf("\nMain Menu" + "\n---------\n" + "\n1) create a new list"
                    + "\n2) load an existing list" + "\n3) quit");

            contactMenuChoice = MainApp.menuInput();

            switch (contactMenuChoice) {
                case 1:    // create new list
                    initializeList();
                    break;
                case 2:   // load existing list
                    existingList();
                    break;
                case 3:    // quit app
                    return;
            }
        }
    }


    private static void initializeList()
    {
        ContactList contactData = new ContactList();
        System.out.printf("new contact list has been created");
        listOpMenuLoop(contactData);
    }

    private static void existingList()
    {
        ContactList contactData = new ContactList();
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.printf("Enter the filename to load: ");
        filename = scanner.nextLine();
        contactData.loadList(filename);

        System.out.printf("contact list has been loaded");
        listOpMenuLoop(contactData);
    }


    private static void listOpMenuLoop(ContactList contactData)
    {
        int listOpMenuChoice;

        while (true)
        {
            System.out.printf("\n\nList Operation Menu" + "\n---------\n" + "\n1) view the list" + "\n2) add an item"
                    + "\n3) edit an item" + "\n4) remove an item" + "\n5) save the current list" + "\n6) quit to the main menu");

            listOpMenuChoice = MainApp.menuInput();

            switch (listOpMenuChoice)
            {
                case 1:    // view the list
                    viewList(contactData);
                    break;
                case 2:   // add an item
                    addContact(contactData);
                    break;
                case 3:   // edit an item
                    modifyList(contactData);
                    break;
                case 4:   // remove an item
                    removeContact(contactData);
                    break;
                case 5:   // save the current list
                    saveList(contactData);
                    break;
                case 6:    // quit app
                    return;
            }
        }
    }


    private static void viewList(ContactList contactData)  // 1
    {
        System.out.printf("Current Tasks" + "\n-------------\n");
        contactData.readList();
        System.out.printf("\n");

    }


    private static void addContact(ContactList contactData)   // 2
    {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName, phoneNumber, emailAddress;

        System.out.printf("First Name: ");
        firstName = scanner.nextLine();
        System.out.printf("Last Name: ");
        lastName = scanner.nextLine();
        System.out.printf("Phone Number (xxx-xxx-xxxx): ");
        phoneNumber = scanner.nextLine();
        System.out.printf("Email Address (x@y.z): ");
        emailAddress = scanner.nextLine();


        try {
            contactData.createContact(firstName, lastName, phoneNumber, emailAddress);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void modifyList(ContactList contactData)    // 3
    {
        Scanner scanner = new Scanner(System.in);
        int chosenTask;
        String firstName, lastName, phoneNumber, emailAddress;
        viewList(contactData);

        System.out.printf("\nWhich task will you edit? ");
        chosenTask = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Enter a new first name for task %d: ", chosenTask);
        firstName = scanner.nextLine();
        System.out.printf("Enter a new last name for task %d: ", chosenTask);
        lastName = scanner.nextLine();
        System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for task %d: ", chosenTask);
        phoneNumber = scanner.nextLine();
        System.out.printf("Enter a new email address (x@y.z) for task %d: ", chosenTask);
        emailAddress = scanner.nextLine();

        try {
            contactData.editContact(chosenTask, firstName, lastName, phoneNumber, emailAddress);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void removeContact(ContactList contactData)    // 4
    {
        Scanner scanner = new Scanner(System.in);
        int chosenContact;
        viewList(contactData);

        System.out.printf("\nWhich contact will you remove? ");
        chosenContact = scanner.nextInt();

        try {
            contactData.destroyContact(chosenContact);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void saveList(ContactList contactData)  // 7
    {
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.printf("Enter the filename to save as: ");
        filename = scanner.nextLine();
        contactData.saveList(filename);

        System.out.printf("contact list has been saved");
    }
}
