import java.util.ArrayList;

public class Admin implements IAdmin{

    private static Admin adminInstance = new Admin();
    private static long ID = 1001;
    private static String password = "admin";

    private Queue<Application> applicationQueue = new Queue<>();
    private Queue<Interview> interviewQueue =  new Queue<>();
//    private Queue<InterviewResponse> responseQueue = new Queue<>();
//    private Queue<Interview> interviewQueue = new Queue<>();
    //list for the incoming interviews from hr??

    private Admin() { }

    public void setAdminInstance(Admin admin){
        adminInstance = admin;
    }

    public static Admin getInstance() {
        return adminInstance;
    }

    @Override
    public void sendToHR(Application application) {
        application.getHR().addToApps(application);
    }

    public Application nextApp() {
        if(adminInstance.applicationQueue.isEmpty()){
            return null;
        }
        return adminInstance.applicationQueue.dequeue();
    }

    public void saveAppForLater(Application application) {
        adminInstance.applicationQueue.enqueue(application);
    }

    @Override
    public void updateInterviewStatus(InterviewResponse response) {
        Interview interview = response.getInterview();
        if(response.isAccepted()) {
            interview.setStatus(InterviewStatus.ACCEPTED);
        } else {
            interview.setStatus(InterviewStatus.CANCELLED);
        }
    }

    public void updateInterviewStatus(Interview interview, InterviewStatus status) {
        interview.setStatus(status);
    }

    @Override
    public void addToApps(Application application) {
        adminInstance.applicationQueue.enqueue(application);
    }

    public void addToInterviews(Interview interview) {
        adminInstance.interviewQueue.enqueue(interview);
        JRSSystem.getInstance().saveInterview(interview);
    }

    @Override
    public void sendInterviewRequestToCandidate(ICandidate candidate, Interview interview) {
        JRSSystem.getInstance().saveInterview(interview);
        candidate.addInterviewRequest(interview);
    }

    @Override
    public long getID() {
        return ID;
    }

    public static void setID(long ID) {
        Admin.ID = ID;
    }

    public static void setPassword(String password) {
        Admin.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public LinkedSet<Job> recommendJob(ArrayList<Skills> skills) {
        LinkedSet<Job> answer = new LinkedSet<>();
        JobSorter jobSorter = JRSSystem.getInstance().getJobSorter();
        for (Skills s : skills) {
            LinkedSet<Job> partialAnswer = jobSorter.getJobsWithKeySkill(s);
            Job[] jobs = partialAnswer.toArray();
            for (int i = 0; i<partialAnswer.size(); i++) {
                answer.add(jobs[i]);
            }
        }
        return answer;
    }

}
