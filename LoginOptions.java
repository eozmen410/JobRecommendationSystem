import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginOptions extends JDialog {

    private ButtonGroup buttonGroup;
    private JLabel label;
    private JRadioButton adminBt, candidateBt, hrBt;
    private JButton okayBt;
    private int optionSelected;
    private LoginDialog dialog;

    public final int ADMIN = 0;
    public final int CANDIDATE = 1;
    public final int HR = 2;
    public final int NEW_PROFILE = 3;

    public LoginOptions(JFrame parent) {

        super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());


        label = new JLabel("Select user type", SwingConstants.CENTER);
        adminBt = new JRadioButton("Admin");
        hrBt = new JRadioButton("HR");
        candidateBt = new JRadioButton("Candidate");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(candidateBt);
        buttonGroup.add(hrBt);
        buttonGroup.add(adminBt);

        okayBt = new JButton("Done");
        okayBt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(candidateBt.isSelected()) {
                    optionSelected = CANDIDATE;
                } else if (hrBt.isSelected()) {
                    optionSelected = HR;
                } else if(adminBt.isSelected()){
                    optionSelected = ADMIN;
                }

                dialog = new LoginDialog(parent, optionSelected);
                dialog.setVisible(true);



                dispose();

            }
        });

        JPanel bp = new JPanel();
        bp.add(label);
        bp.add(adminBt);
        bp.add(hrBt);
        bp.add(candidateBt);
        bp.add(okayBt);


        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public int getResult() {
        return optionSelected;
    }

    public long getID() {
        return dialog.getID();
    }

    public boolean isAuthenticated() {
        return dialog.isAuthenticated();
    }
}
