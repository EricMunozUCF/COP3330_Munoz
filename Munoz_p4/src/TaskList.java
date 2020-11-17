import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> taskData;

    public TaskList() {
        taskData = new ArrayList<TaskItem>();
    }

    public void readList()
    {
        taskData.forEach((n) -> System.out.printf("\n" + taskData.indexOf(n) + ") [" + n.getDueDate() + "] " + n.getTitle() + ": " + n.getDescription()));
    }

    public void createTask(String title, String description, String dueDate) {
        TaskItem task = new TaskItem(title, description, dueDate);
        taskData.add(task);
    }

    public void saveList(String filename)
    {

    }
}
