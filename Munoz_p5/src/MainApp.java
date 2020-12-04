import java.util.Scanner;

public class MainApp {
    public static void main(String[] args)
    {
        mainMenuLoop();
    }

    public static void mainMenuLoop()
    {
        int mainMenuChoice;

        while (true)
        {
            System.out.printf("\nSelect Your Application" + "\n---------\n" + "\n1) task list"
                    + "\n2) contact list" + "\n3) quit");

            mainMenuChoice = menuInput();

            switch (mainMenuChoice) {
                case 1:    // create new list
                    TaskApp.taskMenuLoop();
                    break;
                case 2:   // load existing list
                    ContactApp.contactMenuLoop();
                    break;
                case 3:    // quit app
                    return;
            }
        }
    }


    public static int menuInput()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\n\n> ");

        return scanner.nextInt();
    }
}


