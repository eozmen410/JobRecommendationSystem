import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Candidate  implements ICandidate  {

    private static long lastID = 0;

    private String name;
    private ArrayList<Skills> keySkills;
    private Area focusArea;
    private long ID;
    private Resume resume;

    private Queue<Interview> interviewQueue;
    private Queue<Application> appQueue;

    private String password;

    public Candidate(String name) {
        this.name = name;
        ID = lastID+1;
        lastID++;
        resume = null;
        interviewQueue = new Queue<>();
        keySkills = new ArrayList<>();
        appQueue = new Queue<>();
    }

    public Candidate(String name, ArrayList<Skills> keySkills, Area focusArea, String password) {
        this.name = name;
        this.keySkills = keySkills;
        this.focusArea = focusArea;
        this.password = password;
        ID = lastID+1;
        lastID++;
    }

    public Candidate(long ID, String name, ArrayList<Skills> keySkills, Area focusArea,
                      Queue<Interview> interviewQueue, Queue<Application> appQueue, String password) {
        this.name = name;
        this.keySkills = keySkills;
        this.focusArea = focusArea;
        this.ID = ID;
        resume = null;
        this.interviewQueue = interviewQueue;
        this.appQueue = appQueue;
        this.password = password;
    }

    public String toString() {
        return "ID " + this.ID + "\n" + "Name " + this.name + "\n"+ "KeySkills " + this.keySkillsString()
                + "\n" + "Area " + focusArea  + "\n" + "Password " + password;
    }

    public void uploadResume(String fileName) {
        try {
            resume = new Resume(fileName);
        } catch (FileNotFoundException e) {

        }
    }

    @Override
    public void apply(Job job) {
        if (resume == null) {
            throw new IllegalArgumentException("A resume needs to be uploaded to apply.");
        }
        Application app = new Application(job, this);
        appQueue.enqueue(app);
        Admin.getInstance().addToApps(app);
    }

    @Override
    public void respondToInterview(boolean attending, Interview interview) {
        InterviewResponse response = new InterviewResponse(interview, this, attending);
        Admin.getInstance().updateInterviewStatus(response);
    }

    @Override
    public void addKeySkill(Skills skill) {
        keySkills.add(skill);
    }

    public void addInterviewRequest(Interview interview) {
        interviewQueue.enqueue(interview);
    }

    public Queue<Interview> getInterviewQueue() {
        return interviewQueue;
    }

    public Queue<Application> getAppQueue() {
        return appQueue;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Skills> getKeySkills() {
        return keySkills;
    }

    public Area getFocusArea() {
        return focusArea;
    }

    public long getID() {
        return ID;
    }

    public Resume getResume() {
        return resume;
    }


    private String keySkillsString() {
        String skillString = "";
        for(Skills s: keySkills) {
            if(skillString.equals("")) {
                skillString = skillString + s;
            } else {
                skillString = skillString + " " + s;
            }
        }
        return skillString;
    }

    public Job[] getRecommendations() {
        return Admin.getInstance().recommendJob(keySkills).toArray();
    }
}
