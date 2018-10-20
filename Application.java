import java.util.Date;

public class Application {

    private Job job;
    private Candidate candidate;
    private Date date;

    public Application(Job job, Candidate candidate) {
        this.job = job;
        this.candidate = candidate;
        date = new Date();
    }

    public Job getJob() {
        return job;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return "Candidate: "+ candidate.getName() + "\n" + "Applied for the job: "
                + job.toString() + "\n" + "Time stamp: " + date.toString();
    }

    public HR getHR() {
        return job.getHr();
    }

    public Resume getResume() {
        return candidate.getResume();
    }
}
