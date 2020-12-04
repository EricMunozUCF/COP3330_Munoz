import java.util.Scanner;

public class TaskApp {


    /*
    public static void main(String[] args)
    {
        taskMenuLoop();
    }
    */


    public static void taskMenuLoop()
    {
        int taskMenuChoice;

        while (true)
        {
            System.out.printf("\nMain Menu" + "\n---------\n" + "\n1) create a new list"
                    + "\n2) load an existing list" + "\n3) quit");

            taskMenuChoice = MainApp.menuInput();

            switch (taskMenuChoice) {
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
        TaskList taskData = new TaskList();
        System.out.printf("new task list has been created");
        listOpMenuLoop(taskData);
    }

    private static void existingList()
    {
        TaskList taskData = new TaskList();
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.printf("Enter the filename to load: ");
        filename = scanner.nextLine();
        taskData.loadList(filename);

        System.out.printf("task list has been loaded");
        listOpMenuLoop(taskData);
    }

    private static void listOpMenuLoop(TaskList taskData)
    {
        int listOpMenuChoice;

        while (true)
        {
            System.out.printf("\n\nList Operation Menu" + "\n---------\n" + "\n1) view the list" + "\n2) add an item"
                    + "\n3) edit an item" + "\n4) remove an item" + "\n5) mark an item as completed"
                    + "\n6) unmark an item as completed" + "\n7) save the current list" + "\n8) quit to the main menu");

            listOpMenuChoice = MainApp.menuInput();

            switch (listOpMenuChoice)
            {
                case 1:    // view the list
                    viewList(taskData);
                    break;
                case 2:   // add an item
                    addTask(taskData);
                    break;
                case 3:   // edit an item
                    modifyList(taskData);
                    break;
                case 4:   // remove an item
                    removeTask(taskData);
                    break;
                case 5:   // mark an item as completed
                    markTask(taskData);
                    break;
                case 6:   // unmark an item as completed
                    unMarkTask(taskData);
                    break;
                case 7:   // save the current list
                    saveList(taskData);
                    break;
                case 8:    // quit app
                    return;
            }
        }
    }


    private static void viewList(TaskList taskData)  // 1
    {
        System.out.printf("Current Tasks" + "\n-------------\n");
        taskData.readList();
        System.out.printf("\n");

    }


    private static void addTask(TaskList taskData)   // 2
    {
        Scanner scanner = new Scanner(System.in);
        String title, description, dueDate;

        System.out.printf("Task title: ");
        title = scanner.nextLine();
        System.out.printf("Task description: ");
        description = scanner.nextLine();
        System.out.printf("Task due date (YYYY-MM-DD): ");
        dueDate = scanner.nextLine();

        taskData.createTask(title, description, dueDate);
    }


    private static void modifyList(TaskList taskData)    // 3
    {
        Scanner scanner = new Scanner(System.in);
        int chosenTask;
        String title, description, dueDate;
        viewList(taskData);

        System.out.printf("\nWhich task will you edit? ");
        chosenTask = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Enter a new title for task %d: ", chosenTask);
        title = scanner.nextLine();
        System.out.printf("Enter a new description for task %d: ", chosenTask);
        description = scanner.nextLine();
        System.out.printf("Enter a new due date (YYYY-MM-DD) for task %d: ", chosenTask);
        dueDate = scanner.nextLine();

        try {
            taskData.editTask(chosenTask, title, description, dueDate);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void removeTask(TaskList taskData)    // 4
    {
        Scanner scanner = new Scanner(System.in);
        int chosenTask;
        viewList(taskData);

        System.out.printf("\nWhich task will you remove? ");
        chosenTask = scanner.nextInt();

        try {
            taskData.destroyTask(chosenTask);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void markTask(TaskList taskData)  // 5
    {
        Scanner scanner = new Scanner(System.in);
        int chosenTask;

        System.out.printf("Uncompleted Tasks" + "\n-------------\n");
        taskData.readInCompleteList();
        System.out.printf("\n\nWhich task will you mark as completed? ");
        chosenTask = scanner.nextInt();
        scanner.nextLine();

        try {
            taskData.markTask(chosenTask);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void unMarkTask(TaskList taskData) // 6
    {
        Scanner scanner = new Scanner(System.in);
        int chosenTask;

        System.out.printf("Completed Tasks" + "\n-------------\n");
        taskData.readCompletedList();
        System.out.printf("\n\nWhich task will you unmark as completed? ");
        chosenTask = scanner.nextInt();
        scanner.nextLine();

        try {
            taskData.unMarkTask(chosenTask);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }


    private static void saveList(TaskList taskData)  // 7
    {
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.printf("Enter the filename to save as: ");
        filename = scanner.nextLine();
        taskData.saveList(filename);

        System.out.printf("task list has been saved");
    }
}
