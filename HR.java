import java.util.Date;

public class HR implements IHR{

    private Queue<Application> applicationQueue;
    private String companyName;
    private long ID;
    private String password;

    private static long lastID = 0;


    public HR (String companyName){
        applicationQueue = new Queue<>();
        this.companyName = companyName;
        ID = lastID +1;
        lastID++;
    }

    public HR(long ID, String companyName) {
        this.companyName = companyName;
        applicationQueue = new Queue<>();
        this.ID = ID;
    }

    public HR(long ID, String companyName, Queue<Application> applicationQueue, String password) {
        this.applicationQueue = applicationQueue;
        this.companyName = companyName;
        this.ID = ID;
        this.password = password;
    }

    @Override
    public long getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public Interview scheduleInterview(Candidate candidate, Date date) {
        Interview interview = new Interview(candidate, date);
        Admin.getInstance().addToInterviews(interview);
        return  interview;
    }

    @Override
    public void createJob(HR hr, String description, Area area, int monthlyPay) {
        Job job = new Job(this, description, area, monthlyPay);
        JRSSystem.getInstance().saveJob(job);
    }

    @Override
    public void addToApps(Application application) {
        applicationQueue.enqueue(application);
    }

    public Queue<Application> getApplicationQueue() {
        return applicationQueue;
    }

    public Application nextApplication() {
        if(applicationQueue.isEmpty()) {
            return null;
        }
        return applicationQueue.dequeue();
    }

    public void saveAppForLater(Application application) {
        applicationQueue.enqueue(application);
    }

    public String toString() {
        return ID + " " + companyName + " " + applicationQueue.toString();
    }

    public String getCompanyName() {
        return companyName;
    }
}
