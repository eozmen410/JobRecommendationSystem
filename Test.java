import java.util.Date;

public class Test {

    public static void main(String[] args) {
        JRSSystem system = JRSSystem.getInstance();
        Admin admin = Admin.getInstance();
        Candidate c = new Candidate("Joe");
        c.addKeySkill(Skills.PUBLIC_SPEAKING);
        c.addKeySkill(Skills.PROGRAMMING);

        HR appleHR = new HR("Apple");
        Job j = new Job(appleHR, "Consultant", Area.TECHNOLOGY, 3500);
        j.addSkill(Skills.PUBLIC_SPEAKING);

        Job j1 = new Job(appleHR, "Software", Area.TECHNOLOGY, 2500);
        j1.addSkill(Skills.PROGRAMMING);

        system.saveJob(j);
        system.saveJob(j1);
        system.saveHR(appleHR);

        c.uploadResume("resume.txt");
        c.apply(j1);

        System.out.println(c.getAppQueue()); separator();

        Application app = c.getAppQueue().dequeue();
        c.getAppQueue().enqueue(app);

        admin.sendToHR(app);

        System.out.println("Apple HR apps: \n" + appleHR.getApplicationQueue()); separator();

        Interview interview = appleHR.scheduleInterview(c, new Date(2018, 10, 11));

        admin.sendInterviewRequestToCandidate(c, interview);

        System.out.println("Interviews for c: \n" + c.getInterviewQueue()); separator();

        admin.updateInterviewStatus(interview, InterviewStatus.ACCEPTED);

        System.out.println("Updated Interview: \n" + c.getInterviewQueue()); separator();

        c.respondToInterview(false, interview);

        System.out.println("Responded Interview: \n" + interview); separator();


    }

    public static void separator() {
        System.out.println("-------------------------------------------------------------------");
    }
}
