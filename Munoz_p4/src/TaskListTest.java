import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {        // TODO make JUnit work with reading the console
        TaskList list = new TaskList();
        list.createTask("title", "", "2020-01-01");
        list.createTask("title", "", "2020-01-01");
        list.readList();

        //assertEquals("0) [2020-01-01] title: ", out.toString());
        fail();
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "", "2020-01-01");
            message = list.getItem(0).getCompleted().toString();
            list.markTask(0);
            message = list.getItem(0).getCompleted().toString();
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
            message = list.getItem(0).getCompleted().toString();
            list.markTask(2);
            message = list.getItem(0).getCompleted().toString();
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
            didItChange = list.getItem(0).getTitle();
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
            didItChange = list.getItem(0).getDescription();
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
            didItChange = list.getItem(0).getDescription();
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
            didItChange = list.getItem(0).getDueDate();
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
            didItChange = list.getItem(0).getDueDate();
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
            didItChange = list.getItem(0).getTitle();
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
            didItChange = list.getItem(0).getTitle();
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
            message = list.getItem(2).getDescription();
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
            message = list.getItem(0).getDescription();
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
            message = list.getItem(2).getDueDate();
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
            message = list.getItem(0).getDueDate();
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
            message = list.getItem(2).getTitle();
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
            message = list.getItem(0).getTitle();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("title", message);
    }

    @Test
    public void newTaskListIsEmpty() {        // TODO make JUnit work with reading the console
        TaskList list = new TaskList();
        list.readList();
        fail();
    }

    @Test
    public void removingTaskItemsDecreasesSize() {        // TODO make JUnit work with reading the console
        try {
            TaskList list = new TaskList();

            list.createTask("title", "description", "2020-01-01");
            list.createTask("Brand New Title", "A Very Well Written Description", "2039-05-06");
            list.readList();

            list.destroyTask(0);
            list.readList();
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        fail();
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {        // TODO make JUnit work with reading the console
        try {
            TaskList list = new TaskList();

            list.createTask("title", "description", "2020-01-01");
            list.createTask("Brand New Title", "A Very Well Written Description", "2039-05-06");
            list.readList();

            list.destroyTask(5);
            list.readList();
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        fail();
    }

    @Test
    public void savedTaskListCanBeLoaded() {        // TODO make JUnit work with reading the console
        TaskList list = new TaskList();
        list.loadList("test.txt");
        list.readList();
        fail();
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        String message = "";

        try {
            list.createTask("title", "", "2020-01-01");
            message = list.getItem(0).getCompleted().toString();
            list.markTask(0);
            list.unMarkTask(0);
            message = list.getItem(0).getCompleted().toString();
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
            message = list.getItem(0).getCompleted().toString();
            list.markTask(0);
            list.unMarkTask(2);
            message = list.getItem(0).getCompleted().toString();
        }
        catch (Exception e) {
            message = e.getMessage();
        }

        assertEquals("WARNING: that task doesn't exist", message);
    }
}
