
import java.util.Date;

public class Interview {

    private InterviewStatus status;
    private Date date;
    private Candidate candidate;
    private long ID;

    private static long lastID = 0;


    public Interview(Candidate candidate, Date date) {
        this.candidate = candidate;
        this.date = date;
        this.ID = lastID+1;
        lastID++;
    }

    public Interview(long ID, InterviewStatus status, Date date, Candidate candidate) {
        this.status = status;
        this.date = date;
        this.candidate = candidate;
        this.ID = ID;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    public void setStatus(InterviewStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public long getID() {
        return ID;
    }

    public String toString() {
        String message = "";
        return "ID " + ID + "Status " + status + "Date " + date.toString() + "Candidate " + candidate.getID();
    }
}
