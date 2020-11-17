import java.util.Scanner;

public class App {


    public static void main(String[] args)
    {
        mainMenuLoop();
    }


    public static void mainMenuLoop()
    {
        int mainMenuChoice;

        while (true)
        {
            System.out.printf("\nMain Menu" + "\n---------\n" + "\n1) create a new list"
                    + "\n2) load an existing list" + "\n3) quit");

            mainMenuChoice = menuInput();

            switch (mainMenuChoice) {
                case 1:    // create new list
                    initializeList();
                    break;
                case 2:   // load existing list
                    break;
                case 3:    // quit app
                    return;
            }
        }
    }


    public static void initializeList()
    {
        TaskList taskData = new TaskList();
        System.out.printf("new task list has been created");
        listOpMenuLoop(taskData);
    }


    public static void listOpMenuLoop(TaskList taskData)
    {
        int listOpMenuChoice;

        while (true)
        {
            System.out.printf("\n\nList Operation Menu" + "\n---------\n" + "\n1) view the list" + "\n2) add an item"
                            + "\n3) edit an item" + "\n4) remove an item" + "\n5) mark an item as completed"
                            + "\n6) unmark an item as completed" + "\n7) save the current list" + "\n8) quit to the main menu");

            listOpMenuChoice = menuInput();

            switch (listOpMenuChoice)
            {
                case 1:    // view the list
                    viewList(taskData);
                    break;
                case 2:   // add an item
                    addTask(taskData);
                    break;
                case 3:   // edit an item
                    editTask(taskData);
                    break;
                case 4:   // remove an item
                    break;
                case 5:   // mark an item as completed
                    break;
                case 6:   // unmark an item as completed
                    break;
                case 7:   // save the current list
                    saveList(taskData);
                    break;
                case 8:    // quit app
                    return;
            }
        }
    }


    public static int menuInput()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\n\n> ");
        int input = scanner.nextInt();

        return input;
    }


    public static void viewList(TaskList taskData)  // 1
    {
        System.out.printf("Current Tasks" + "\n-------------\n");
        taskData.readList();
        System.out.printf("\n");

    }


    public static void addTask(TaskList taskData)   // 2
    {
        Scanner scanner = new Scanner(System.in);
        String title, description, dueDate = "";

        System.out.printf("Task title: ");
        title = scanner.nextLine();
        System.out.printf("Task description: ");
        description = scanner.nextLine();
        System.out.printf("Task due date (YYYY-MM-DD): ");
        dueDate = scanner.nextLine();

        /*
        try {
            Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            dueDateStr = dueDate.toString();
        } catch (ParseException e) {
            System.out.printf("WARNING: invalid due date; task not created");
        }
        */

        if (title == "")
        {
            System.out.printf("WARNING: title must be at least 1 character long; task not created");
            return;
        } else if (dueDate == "")
        {
            System.out.printf("WARNING: invalid due date; task not created");
        }

        taskData.createTask(title, description, dueDate);
    }


    public static void editTask(TaskList taskData)  // 3
    {
        viewList(taskData);
    }


    public static void saveList(TaskList taskData)  // 7
    {
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.printf("Enter the filename to save as: ");
        filename = scanner.nextLine();
        taskData.saveList(filename);

        System.out.printf("task list has been saved");
    }
}
