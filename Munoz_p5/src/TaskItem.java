import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskItem {
    private String title, description, dueDate;
    private Boolean completed;

    public TaskItem(String title, String description, String dueDate) throws Exception {
        if (title.isBlank()) // title error catch
        {
            throw new Exception("WARNING: title must be at least 1 character long; task not created");
        }
        try
        {
            new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
        }
        catch (ParseException e)
        {
            throw new Exception("WARNING: invalid due date; task not created");
        }

        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if (title.isBlank()) // title error catch
        {
            throw new Exception("WARNING: title must be at least 1 character long; task not created");
        }

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) throws Exception {
        try
        {
            new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
        }
        catch (ParseException e)
        {
            throw new Exception("WARNING: invalid due date; task not created");
        }

        this.dueDate = dueDate;

    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
