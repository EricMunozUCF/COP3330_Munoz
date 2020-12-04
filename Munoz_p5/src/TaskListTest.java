import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        int size;
        list.createTask("title", "", "2020-01-01");
        size = list.getTaskSize();
        list.createTask("title", "", "2020-01-01");
        size = list.getTaskSize();

        assertEquals(2, size);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "", "2020-01-01");
            message = list.getTaskItem(0).getCompleted().toString();
            list.markTask(0);
            message = list.getTaskItem(0).getCompleted().toString();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("true", message);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "", "2020-01-01");
            message = list.getTaskItem(0).getCompleted().toString();
            list.markTask(2);
            message = list.getTaskItem(0).getCompleted().toString();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", message);
    }

    @Test
    public void editingTaskItemChangesValues() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(0, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getTitle();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("Brand New Title", didItChange);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(0, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getDescription();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("A Very Well Written Description", didItChange);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(2, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getDescription();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", didItChange);
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(0, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getDueDate();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("2039-05-06", didItChange);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(2, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getDueDate();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", didItChange);
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(0, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getTitle();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("Brand New Title", didItChange);
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String didItChange = "";

        list.createTask("title", "", "2020-01-01");
        try {
            list.editTask(2, "Brand New Title", "A Very Well Written Description", "2039-05-06");
            didItChange = list.getTaskItem(0).getTitle();
        }
        catch (Exception e) {
            didItChange = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", didItChange);
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String message = "";

        list.createTask("title", "description", "2020-01-01");
        try {
            message = list.getTaskItem(2).getDescription();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", message);
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        String message = "";

        list.createTask("title", "description", "2020-01-01");
        try {
            message = list.getTaskItem(0).getDescription();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("description", message);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String message = "";

        list.createTask("title", "description", "2020-01-01");
        try {
            message = list.getTaskItem(2).getDueDate();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", message);
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        String message = "";

        list.createTask("title", "description", "2020-01-01");
        try {
            message = list.getTaskItem(0).getDueDate();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("2020-01-01", message);
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String message = "";

        list.createTask("title", "description", "2020-01-01");
        try {
            message = list.getTaskItem(2).getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", message);
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        String message = "";

        list.createTask("title", "description", "2020-01-01");
        try {
            message = list.getTaskItem(0).getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("title", message);
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        String message = "";

        try {
            int size = list.getTaskSize();
            if (size == 0)
                message = "" + size;
            else
                message = "Completed Edit.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("0", message);
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskList list = new TaskList();
        String message = "";
        try {
            list.createTask("title", "description", "2020-01-01");
            message = "" + list.getTaskSize();
            list.destroyTask(0);
            message = "" + list.getTaskSize();
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }

        assertEquals("0", message);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "description", "2020-01-01");
            list.createTask("Brand New Title", "A Very Well Written Description", "2039-05-06");
            list.destroyTask(5);
        }
        catch (Exception e) {
            message = e.getMessage();
        }
        assertEquals("WARNING: that task doesn't exist", message);
    }

    @Test
    public void savedTaskListCanBeLoaded() {
        TaskList list = new TaskList();
        String message = "";
        try {
            list.createTask("title", "description", "2020-01-01");
            list.saveList("test.txt");

            TaskList newList = new TaskList();
            newList.loadList("test.txt");

            message = "Load Completed.";
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("Load Completed.", message);
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "", "2020-01-01");
            message = list.getTaskItem(0).getCompleted().toString();
            list.markTask(0);
            list.unMarkTask(0);
            message = list.getTaskItem(0).getCompleted().toString();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("false", message);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "", "2020-01-01");
            message = list.getTaskItem(0).getCompleted().toString();
            list.markTask(0);
            list.unMarkTask(2);
            message = list.getTaskItem(0).getCompleted().toString();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", message);
    }
}
