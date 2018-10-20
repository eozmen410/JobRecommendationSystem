import java.io.File;

public interface ICandidate {

    void apply(Job job);
    void respondToInterview(boolean attending, Interview interview);
    void addKeySkill(Skills skill);
    void addInterviewRequest(Interview interview);
    void uploadResume(String fileName);
    long getID();
    String getPassword();
}
