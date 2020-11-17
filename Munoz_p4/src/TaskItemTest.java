import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","", "");
            message = item.getDueDate();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("WARNING: invalid due date; task not created", message);
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("","", "");
            message = item.getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("WARNING: title must be at least 1 character long; task not created", message);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
            message = item.getDueDate();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("2020-01-01", message);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
            message = item.getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("Title", message);
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
            item.setDueDate("");
            message = item.getDueDate();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("WARNING: invalid due date; task not created", message);
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
            item.setDueDate("2034-05-06");
            message = item.getDueDate();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("2034-05-06", message);
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
            item.setTitle("");
            message = item.getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("WARNING: title must be at least 1 character long; task not created", message);
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
            item.setTitle("New Title");
            message = item.getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("New Title", message);
    }
}
