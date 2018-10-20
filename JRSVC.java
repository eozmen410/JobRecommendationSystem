import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRSVC extends JFrame {

    private LoginOptions loginOptions;
    private LoginDialog loginDialog;
    private JRSSystem system;
    private JPanel content;
    private JButton bt;

    public final int ADMIN = 0;
    public final int CANDIDATE = 1;
    public final int HR = 2;



    public  JRSVC() {
        system = JRSSystem.getInstance();
        content = new JPanel();
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setLayout(new GridLayout());
    }

    public void run() {
        bt = new JButton("Click to begin.");
        this.add(bt);
        loginOptions = new LoginOptions(this);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginOptions.setVisible(true);

                int profileType = loginOptions.getResult();
                if(loginOptions.isAuthenticated()) {
                    if (profileType == CANDIDATE) {
                        Candidate candidate = JRSSystem.getInstance().getCandidate(loginDialog.getID());
                        CandidateVC vc = new CandidateVC(candidate);
                        vc.setVisible(true);
                    }
                }
            }
        });



    }

}
