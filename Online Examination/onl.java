
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


class onl extends JFrame implements ActionListener {
    JLabel jL1, jL2;
    JRadioButton[] jb = new JRadioButton[6];
    JButton jButton1, jButton2;
    ButtonGroup buttonGroup;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    Timer timer;

    onl(String s) {
        super(s);
        jL1 = new JLabel();
        jL2 = new JLabel();
        add(jL1);
        add(jL2);
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            buttonGroup.add(jb[i]);
        }
        jButton1 = new JButton("Save and Next");
        jButton2 = new JButton("Save for later");
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        add(jButton1);
        add(jButton2);
        set();
        jL1.setBounds(30, 40, 450, 20);
        jL2.setBounds(20, 20, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        jButton1.setBounds(95, 240, 140, 30);
        jButton2.setBounds(270, 240, 150, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

        final int[] timeLeft = {120}; // 2 minutes in seconds

        TimerTask task = new TimerTask() {
            public void run() {
                timeLeft[0]--;
                if (timeLeft[0] >= 0) {
                    jL2.setText("Time left: " + timeLeft[0] + " sec.");
                } else {
                    timer.cancel();
                    jL2.setText(" Given Time is completed");
                }
            }
        };

        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton1) {
            if (check()) {
                count++;
            }
            current++;
            set();
            if (current == 9) {
                jButton1.setEnabled(false);
                jButton2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Save for later")) {
            JButton bk = new JButton("Review" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) {
                jButton2.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) {

            if (e.getActionCommand().equals("Review" + y)) {
                if (check()) {
                    count++;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }

            if(e.getActionCommand().equals("Result"))
            {
                if(check())
                    count += 1;
                current++;
                JOptionPane.showMessageDialog(this,"Score = "+count);
                System.exit(0);
            }
        }

    }

    // Define the questions, answer choices, and correct answers as arrays
    String[] questions = {
            "What is the term used to describe the study of how individuals and societies allocate limited resources to satisfy their unlimited wants and needs?",
            "Which of the following is NOT one of the factors of production??",
            "Which of the following is an example of a regressive tax?",
            "The Gross Domestic Product (GDP) measures:",
            "Which of the following is a characteristic of a perfectly competitive market?\r\n"
            + "",
            "Inflation can be defined as:",
            "The World Trade Organization (WTO) was established to:\r\n"
            + "",
            "Which of the following is an example of a public good?",
            "Which of the following is an example of a monopoly?",
            "Which of the following is NOT a component of the Consumer Price Index (CPI)?"
    };
    String[][] choices = {
            { "Microeconomics","Microeconomics", "Econometrics", "Game theory"},
            {"Land", "Labour", "Capital", "Demand"},
            {"Sales Tax", "Income Tax", "Estate Tax", "Property Tax"},
            {" The total value of all goods and services produced within a country in a given period of time", "The total value of all goods and services consumed within a country in a given period of time", "The total value of all goods and services exported from a country in a given period of time", "The total value of all goods and services imported into a country in a given period of time"},
            {"High barriers to entry", "Few buyers and sellers", " Limited product differentiation", "Limited price competition"},
            {"A decrease in the general level of prices over time", " An increase in the general level of prices over time", "A decrease in the unemployment rate over time", "An increase in the unemployment rate over time"},
            {"Promote free trade among member countries", "Regulate international financial markets", "Promote regional economic integration", "All of the above"},
            {"Healthcare services", "Education services", " All of the above", "None"},
            {"The market for smartphones", "The market for fast food restaurants", "The market for gasoline", "None"},
            {"Food and beverages", "Housing", " Stock prices", "abstract"}
    };
    int[] answers = {0, 3, 0, 0, 2, 0, 0, 2, 3, 3};

    // Refactor the set() method to use the arrays
    void set() {
        jb[4].setSelected(true);
        jL1.setText(questions[current]);
        for (int i = 0; i < 4; i++) {
            jb[i].setText(choices[current][i]);
        }
        jL1.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++) {
            jb[j].setBounds(50, 80 + i, 200, 20);
        }
    }

    // Refactor the check() method to use the arrays
    boolean check() {
        return jb[answers[current]].isSelected();
    }

}
