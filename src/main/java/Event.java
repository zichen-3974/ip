public class Event extends Task{

    protected String from;
    protected String to;
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String printTask() {
        return String.format("[E]%s (from: %s to: %S)", super.printTask(), this.from, this.to);
    }

    @Override
    public String formatForFile() {
        return String.format("%s|%s|%s|%s", "E", super.formatForFile(), this.from, this.to);
    }
}
