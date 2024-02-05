package OnlineHospitalManagement;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;

public class workerDetail {
    JFrame frame;
    JLabel heading, logo, head, name, work, age, gender, joindate;
    JTextField search;
    JButton go, back;
    workerDetail(){
        frame = new JFrame("Online Hospital Management");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee\\IdeaProjects\\OnlineHospitalManagement\\src\\OnlineHospitalManagement\\assest\\logo.jpg"));
        logo.setBounds(250, 10, 100, 70);
        frame.add(logo);

        heading = new JLabel("Welcome to Medical Center");
        heading.setBounds(400, 33, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        search = new JTextField();
        search.setBounds(150, 100, 450, 30);
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        Border border = BorderFactory.createCompoundBorder(search.getBorder(), BorderFactory.createEmptyBorder(1, 2, 1, 0));
        frame.add(search);

        go = new JButton("Go");
        go.setBounds(620, 100, 100, 30);
        go.setFont(new Font("Arial", Font.PLAIN, 20));
        go.setBackground(Color.green);
        frame.add(go);

        back = new JButton("Back");
        back.setBounds(730, 100, 100, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setBackground(Color.green);
        frame.add(back);

        head = new JLabel("Worker Details");
        head.setBounds(400, 140, 200, 30);
        head.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(head);

        name = new JLabel("Name");
        name.setBounds(80, 180, 250, 30);
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(name);

        age = new JLabel("Age");
        age.setBounds(350, 180, 100, 30);
        age.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(age);

        gender = new JLabel("Gender");
        gender.setBounds(460, 180, 100, 30);
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(gender);

        work = new JLabel("Work");
        work.setBounds(570, 180, 200, 30);
        work.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(work);

        joindate = new JLabel("Joining Date");
        joindate.setBounds(790, 180, 200, 30);
        joindate.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(joindate);

        JLabel names = new JLabel();
        JLabel ages = new JLabel();
        JLabel genders = new JLabel();
        JLabel works = new JLabel();
        JLabel joiningDates = new JLabel();

        names.setBounds(80, 220, 250, 30);
        names.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(names);

        ages.setBounds(350, 220, 100, 30);
        ages.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(ages);

        genders.setBounds(460, 220, 100, 30);
        genders.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(genders);

        works.setBounds(570, 220, 200, 30);
        works.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(works);

        joiningDates.setBounds(790, 220, 200, 30);
        joiningDates.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(joiningDates);

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String n = search.getText();
                    String query1 = "select * from workerhistory where username = '" + n + "'";
                    ResultSet rs = c.s.executeQuery(query1);
                    while(rs.next()){
                        names.setText(rs.getString(2));
                        Period diff = Period.between(LocalDate.parse(rs.getString(8)), java.time.LocalDate.now());
                        ages.setText(String.valueOf(diff.getYears()));
                        genders.setText(rs.getString(4));
                        works.setText(rs.getString(10));
                        joiningDates.setText(rs.getString(12));
                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new basePage();
            }
        });

        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    go.doClick();
                }
            }
        });

        go.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    go.doClick();
                }
            }
        });

        back.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back.doClick();
                }
            }
        });


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1000, 400);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}