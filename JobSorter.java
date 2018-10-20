import java.util.ArrayList;

public class JobSorter {

    private LinkedSet<Job> publicSpeaking, microsoftOffice, programming, marketing;

    public JobSorter() {
        publicSpeaking = new LinkedSet<>();
        microsoftOffice = new LinkedSet<>();
        programming = new LinkedSet<>();
        marketing = new LinkedSet<>();
    }

    public void addJob(Job job) {
        categorizeSkills(job);
    }

    private void categorizeSkills(Job job) {
        ArrayList<Skills> skillsArrayList = job.getSkills();
        for(Skills skill : skillsArrayList) {
            if(skill == Skills.MARKETING) {
                marketing.add(job);
            } else if (skill == Skills.MICROSOFT_OFFICE) {
                microsoftOffice.add(job);
            } else if (skill == Skills.PROGRAMMING) {
                programming.add(job);
            } else if (skill == Skills.PUBLIC_SPEAKING) {
                publicSpeaking.add(job);
            }
        }
    }

    public LinkedSet<Job> getJobsWithKeySkill(Skills skill) {
        if(skill == Skills.MARKETING) {
            return marketing;
        } else if (skill == Skills.MICROSOFT_OFFICE) {
            return microsoftOffice;
        } else if (skill == Skills.PROGRAMMING) {
            return programming;
        } else if (skill == Skills.PUBLIC_SPEAKING) {
            return publicSpeaking;
        }
        return null;
    }

}
