import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.io.FileNotFoundException;

public class TaskList {
    private ArrayList<TaskItem> taskData, tasksCompleted, tasksInComplete;

    public TaskList()
    {
        taskData = new ArrayList<TaskItem>();
        tasksCompleted = new ArrayList<TaskItem>();
        tasksInComplete = new ArrayList<TaskItem>();
    }

    public void readList()
    {
        taskData.forEach((n) -> {
            if (n.getCompleted() == true)
                System.out.printf("\n%d) *** [%s] %s: %s", taskData.indexOf(n), n.getDueDate(), n.getTitle(), n.getDescription());
            else
                System.out.printf("\n%d) [%s] %s: %s", taskData.indexOf(n), n.getDueDate(), n.getTitle(), n.getDescription());
        });
    }

    public void readCompletedList()
    {
        tasksCompleted.clear();

        taskData.forEach((n) -> {
            if (n.getCompleted())
                tasksCompleted.add(n);
        });
        tasksCompleted.forEach((n) -> System.out.printf("\n%d) [%s] %s: %s", tasksCompleted.indexOf(n), n.getDueDate(), n.getTitle(), n.getDescription()));
    }

    public void readInCompleteList()
    {
        tasksInComplete.clear();

        taskData.forEach((n) -> {
            if (!n.getCompleted())
                tasksInComplete.add(n);
        });
        tasksInComplete.forEach((n) -> System.out.printf("\n%d) [%s] %s: %s", tasksInComplete.indexOf(n), n.getDueDate(), n.getTitle(), n.getDescription()));
    }

    public void createTask(String title, String description, String dueDate)
    {
        try {
            TaskItem task = new TaskItem(title, description, dueDate);
            taskData.add(task);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
            return;
        }
    }

    public void editTask(int index, String title, String description, String dueDate)
    {
        try
        {
            TaskItem taskToEdit = taskData.get(index);

            taskToEdit.setTitle(title);
            taskToEdit.setDescription(description);
            taskToEdit.setDueDate(dueDate);

            taskData.set(index, taskToEdit);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.printf("WARNING: that task doesn't exist");
        }
        catch (Exception e)
        {
            System.out.printf(e.getMessage());
        }
    }

    public void destroyTask(int index)
    {
        try
        {
            taskData.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.printf("WARNING: that task doesn't exist");
        }
    }

    public void markTask(int index)
    {
        try
        {
            TaskItem taskToMark = taskData.get(index);
            taskToMark.setCompleted(true);
            taskData.set(index, taskToMark);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.printf("WARNING: that task doesn't exist");
        }
    }

    public void unMarkTask(int index)
    {
        try
        {
            TaskItem taskToUnMark = taskData.get(index);
            taskToUnMark.setCompleted(false);
            taskData.set(index, taskToUnMark);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.printf("WARNING: that task doesn't exist");
        }
    }

    public void saveList(String filename)
    {
        try (Formatter output = new Formatter(filename))
        {
            taskData.forEach((n) -> {
                output.format("%s\n%s\n%s\n\n", n.getTitle(), n.getDescription(), n.getDueDate());
            });
        }
        catch (SecurityException | FileNotFoundException | FormatterClosedException e)
        {
            e.printStackTrace();
        }
    }

    public void loadList(String filename)
    {
        String title, description, dueDate;
        try (Scanner input = new Scanner(Paths.get(filename))) {
            while (input.hasNext())
            {
                title = input.nextLine();
                description = input.nextLine();
                dueDate = input.nextLine();
                input.nextLine();
                createTask(title, description, dueDate);
            }
        }
        catch (IOException | NoSuchElementException | IllegalStateException e)
        {
            e.printStackTrace();
        }
    }
}
