import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","", "");
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
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("", message);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        String message = "";
        try {
            TaskItem item = new TaskItem("Title","Description", "2020-01-01");
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("", message);
    }
}
