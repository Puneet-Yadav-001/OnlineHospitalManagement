package OnlineHospitalManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Objects;

public class doctorRegister1 {
    JFrame frame;
    JLabel heading, logo, signup, expertize, university, education, experience;
    JTextField unitf;
    JButton register, cancel, reset, back;
    JComboBox expertizetf, educationtf, experiencetf;
    String[] expertizes = {"Select dieases type", "Colon and Rectal Surgeons", "Hematologists", "Internists", "Medical Geneticists",
            "Osteopaths", "Pathologists", "Physiatrists", "Plastic Surgeons", "Podiatrists", "Anesthesiologists",
            "Cardiac surgeons", "Orthopedic surgeons", "General surgeons", "Rheumatologists", "Radiologists", "Oncologists",
            "Psychiatrists", "Neurologists", "Otolaryngologists", "Pulmonologists", "Urologists", "Nephrologists",
            "Gastroenterologists", "Endocrinologists", "Cardiologists", "Obstetrician/gynecologists", "Ophthalmologists",
            "Dermatologists", "Allergists", "Geriatric doctor", "Pediatricians"};
    String[] educations = {"Select Degree", "MBBS", "MS", "MD", "BAMS", "BHMS", "BPT", "BUMS", "BSMS", "BNYS"};
    String[] experiences = {"Select Experience", "Fresher(0-1year)", "2-5 years", "5-7 years", "7-10 years", "10+ years"};
    doctorRegister1(String[] arr) {
        frame = new JFrame("Medical Center");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee\\IdeaProjects\\OnlineHospitalManagement\\src\\OnlineHospitalManagement\\assest\\logo.jpg"));
        logo.setBounds(150, 10, 100, 70);
        frame.add(logo);

        heading = new JLabel("Welcome to Medical Center");
        heading.setBounds(280, 33, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        signup = new JLabel("SignUp");
        signup.setBounds(350, 73, 450, 40);
        signup.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(signup);

        expertize = new JLabel("Expertize");
        expertize.setBounds(150, 150, 200, 40);
        expertize.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(expertize);

        education = new JLabel("Degree");
        education.setBounds(150, 200, 200, 40);
        education.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(education);

        university = new JLabel("University");
        university.setBounds(150, 250, 200, 40);
        university.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(university);

        experience = new JLabel("Experience");
        experience.setBounds(150, 300, 200, 40);
        experience.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(experience);

        expertizetf = new JComboBox(expertizes);
        expertizetf.setBounds(350, 150, 270, 30);
        expertizetf.setFont(new Font("Arial", Font.PLAIN, 20));
        expertizetf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(expertizetf);

        educationtf = new JComboBox(educations);
        educationtf.setBounds(350, 200, 270, 30);
        educationtf.setFont(new Font("Arial", Font.PLAIN, 20));
        educationtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(educationtf);

        unitf = new JTextField();
        unitf.setBounds(350, 250, 270, 30);
        unitf.setFont(new Font("Arial", Font.PLAIN, 20));
        unitf.setBackground(Color.white);
        frame.add(unitf);

        experiencetf = new JComboBox(experiences);
        experiencetf.setBounds(350, 300, 270, 30);
        experiencetf.setFont(new Font("Arial", Font.PLAIN, 20));
        experiencetf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(experiencetf);

        register = new JButton("Register");
        register.setBounds(325, 350, 250, 30);
        register.setFont(new Font("Arial", Font.PLAIN, 20));
        register.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        register.setBackground(Color.green);
        frame.add(register);

        reset = new JButton("Reset");
        reset.setBounds(325, 400, 120, 30);
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        reset.setBackground(Color.green);
        frame.add(reset);

        cancel = new JButton("Cancel");
        cancel.setBounds(455, 400, 120, 30);
        cancel.setFont(new Font("Arial", Font.PLAIN, 20));
        cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        back = new JButton("Back");
        back.setBounds(325, 450, 250, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        back.setBackground(Color.green);
        frame.add(back);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(expertizetf.getSelectedItem(), "Select Expertise type")) {
                    JOptionPane.showMessageDialog(null, "Expertise is required");
                    return;
                } else if (Objects.equals(educationtf.getSelectedItem(), "Select Degree")) {
                    JOptionPane.showMessageDialog(null, "Degree is required");
                    return;
                } else if (unitf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "University is required.");
                    return;
                } else if (Objects.equals(experiencetf.getSelectedItem(), "Select Experience")) {
                    JOptionPane.showMessageDialog(null, "Experience is required.");
                    return;
                }

                arr[8] = (String) expertizetf.getSelectedItem();
                arr[9] = (String) educationtf.getSelectedItem();
                arr[10] = unitf.getText();
                arr[11] = (String) experiencetf.getSelectedItem();

                try{
                    conn c = new conn();
                    String query1 = "select doctorid from doctorhistory where username = '" + arr[0] + "' and fathername = '" + arr[1] + "' and gender = '" + arr[2] + "' and email = '" + arr[3] + "' and phone = " + arr[4] + " and password = '" + arr[5] + "' and dob = '" + arr[6] + "' and state = '" + arr[7] + "' and expertise = '" + arr[8] + "' and education = '" + arr[9] + "' and university = '" + arr[10] + "' and experience = '" + arr[11] + "' and active = 'yes'";
                    ResultSet rs = c.s.executeQuery(query1);
                    while(rs.next()){
                        JOptionPane.showMessageDialog(null, "Doctor with same details already exist.");
                        new doctorRegister();
                        return;
                    }
                    String query2 = "INSERT INTO `doctorhistory`(`username`, `fathername`, `gender`, `email`, `phone`, `password`, `dob`, `state`, `expertise`, `education`, `university`, `experience`, `active`, `joinDate`) VALUES ('" + arr[0] + "','" + arr[1] + "','" + arr[2] + "','" + arr[3] + "'," + arr[4] + ",'" + arr[5] + "','" + arr[6] + "','" + arr[7] + "','" + arr[8] + "','" + arr[9] + "','" + arr[10] + "','" + arr[11] + "', 'yes', '" + java.time.LocalDate.now() + "')";
                    c.s.execute(query2);
                    String query3 = "select doctorid from doctorhistory where username = '" + arr[0] + "' and fathername = '" + arr[1] + "' and gender = '" + arr[2] + "' and email = '" + arr[3] + "' and phone = " + arr[4] + " and password = '" + arr[5] + "' and dob = '" + arr[6] + "' and state = '" + arr[7] + "' and expertise = '" + arr[8] + "' and education = '" + arr[9] + "' and university = '" + arr[10] + "' and experience = '" + arr[11] + "' and active = 'yes'";
                    ResultSet rs1 = c.s.executeQuery(query3);
                    while(rs1.next()){
                        JOptionPane.showMessageDialog(null, "Doctor id is " + rs1.getString(1));
                        String query4 = "INSERT INTO `login`(`userid`, `username`, `password`, `type`, `active`) VALUES ('" + rs1.getString(1) + "','" + arr[0] + "','" + arr[5] + "','Doctor', 'yes')";
                        c.s.execute(query4);
                        break;
                    }
                } catch (Exception ae){
                    ae.printStackTrace();
                }

                frame.dispose();
                new login();
                return;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertizetf.setSelectedIndex(0);
                educationtf.setSelectedIndex(0);
                unitf.setText("");
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new doctorRegister();
            }
        });

        expertizetf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        educationtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        unitf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        experiencetf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        register.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        cancel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    cancel.doClick();
                }
            }
        });

        reset.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    reset.doClick();
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
        frame.setSize(800, 500);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
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
