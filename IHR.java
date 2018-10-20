import java.util.Date;

public interface IHR {

    Interview scheduleInterview (Candidate candidate, Date date);
    void createJob (HR hr, String description, Area area, int monthlyPay);
    void addToApps(Application application);
    long getID();
    String getPassword();

}
