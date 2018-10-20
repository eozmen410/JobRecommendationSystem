import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CandidateVC extends JFrame {

    private JPanel content;
    private Candidate model;
    private JComboBox<Skills> skillsJComboBox;
    private JButton addSkill, getJobs;
    private JList<Job> jobs, interviews;
    private JLabel jobLb, interviewLb;


    public CandidateVC(Candidate model) {
        this.model = model;
        content = new JPanel();
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setLayout(new GridLayout(32,0));
        this.setSize(600,600);
        initializeComponents();
    }

    private void initializeComponents() {
        Skills[] skillsArray = {Skills.MARKETING, Skills.MICROSOFT_OFFICE, Skills.PROGRAMMING, Skills.PUBLIC_SPEAKING};
        skillsJComboBox = new JComboBox<>(skillsArray);
        this.add(skillsJComboBox);

        addSkill = new JButton("Add Skill");
        this.add(addSkill);

        getJobs = new JButton("Get Job Recommendations");
        this.add(getJobs);

        jobLb = new JLabel("Jobs:");
        this.add(jobLb);

        jobs = new JList<>();
        getJobs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobs = new JList<>(model.getRecommendations());
            }
        });
        this.add(jobs);

        interviewLb = new JLabel("Interview");





    }
}
