public class Consultation {
    private String date;
    private String time;
    private int cost;
    private String notes;

    public Consultation(String date, String time, int cost, String notes) {
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String SavedDetails () {
        return (String.format("%s %s %4d %s", this.date, this.time, this.cost, this.notes));
    }
}
