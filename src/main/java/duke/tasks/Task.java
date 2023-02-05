package duke.tasks;

/**
 * Represents a task.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String printTask() {
        return String.format("[%s] %s", getStatusIcon(), this.description);
    }

    /**
     * Marks a task as done.
     * @param silent True if printing for user is not required, else false.
     * @return Response to user.
     */
    public String markTaskDone(boolean silent) {
        String output = "";
        //task already marked done
        if (this.isDone) {
            output += "Move on already, you've marked this.";
        } else {
            this.isDone = true;
            if (!silent) {
                output += "WOW you got something done! A miracle!! "
                         + "I've marked this task as done now, ur wlcm :)\n";
                output += printTask();
            }
        }
        return output;
    }

    /**
     * Marks a task undone.
     * @return Response to user.
     */
    public String markTaskUndone() {
        String output = "";
        if (!this.isDone) {
            output += "You didn't even do it in the first place >:/";
        } else {
            this.isDone = false;
            output += "Ugh fine, this task is now marked undone. >:/\n";
            output += printTask();
        }
        return output;
    }

    /**
     * Formats the task for saving to storage.
     * @return A formatted string of the task.
     */
    public String formatForFile() {
        //status|desc
        return String.format("%s|%s", this.isDone ? "X" : "O", this.description);
    }


    /**
     * Checks if task description contains a given keyword.
     * @param keyword The given keyword.
     * @return True if task description contains keyword, else false.
     */
    public boolean containsKeyword(String keyword) {
        return this.description.contains(keyword);
    }
}
