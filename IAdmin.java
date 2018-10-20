import java.util.ArrayList;

public interface IAdmin {

    void sendToHR(Application application);
    void updateInterviewStatus(InterviewResponse response);
    void updateInterviewStatus(Interview interview, InterviewStatus status);
    void addToApps(Application application);
    void sendInterviewRequestToCandidate(ICandidate candidate, Interview interview);
    long getID();
    String getPassword();
    LinkedSet<Job> recommendJob(ArrayList<Skills> skills);
}
