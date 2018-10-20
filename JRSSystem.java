public class JRSSystem {

    private static JRSSystem instance = new JRSSystem();

    private static Map<Long, Candidate> candidateMap = new Map<>();
    private Map<Long, HR> HRMap = new Map<>();
    private Map<Long, Interview> interviewMap = new Map<>();
    private Map<Long, Job> jobMap = new Map<>();
    private Admin admin = Admin.getInstance();
    private JobSorter jobSorter = new JobSorter();

    private JRSSystem() { }

    public static JRSSystem getInstance() {
        return instance;
    }

    public void saveInterview(Interview interview) {
        instance.interviewMap.put(interview.getID(), interview);
    }

    public void saveCandidate(Candidate candidate) {
        instance.candidateMap.put(candidate.getID(), candidate);
    }

    public void saveHR(HR hr) {
        instance.HRMap.put(hr.getID(), hr);
    }

    public void saveJob(Job job) {
        instance.jobMap.put(job.getID(), job);
        instance.jobSorter.addJob(job);
    }

    public Candidate getCandidate(long ID) {
        return instance.candidateMap.get(ID);
    }

    public Admin getAdmin() {
        return admin;
    }

    public HR getHR(long ID) {
        return instance.HRMap.get(ID);
    }

    public JobSorter getJobSorter() {
        return jobSorter;
    }
}
