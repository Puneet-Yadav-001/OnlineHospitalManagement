package OnlineHospitalManagement;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login {
    JFrame frame;
    JLabel heading, logo, username, password, type;
    JTextField uname;
    JPasswordField pass;
    JButton login, signup, cancel, show;
    JRadioButton patient, doctor, worker;
    ButtonGroup b1;
    login(){
        frame = new JFrame("Online Hospital Management");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee\\IdeaProjects\\OnlineHospitalManagement\\src\\OnlineHospitalManagement\\assest\\logo.jpg"));
        logo.setBounds(150, 50, 100, 70);
        frame.add(logo);

        heading = new JLabel("Welcome to Medical Center");
        heading.setBounds(280, 73, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        username = new JLabel("User Id");
        username.setBounds(175, 150, 100, 30);
        username.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(username);

        password = new JLabel("Password");
        password.setBounds(175, 200, 100, 30);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(password);

        uname = new JTextField();
        uname.setBounds(300, 150, 250, 30);
        uname.setFont(new Font("Arial", Font.PLAIN, 16));
        Border border = BorderFactory.createCompoundBorder(uname.getBorder(), BorderFactory.createEmptyBorder(1, 2, 1, 0));
        uname.setBorder(border);
        frame.add(uname);

        pass = new JPasswordField();
        pass.setBounds(300, 200, 250, 30);
        pass.setFont(new Font("Arial", Font.PLAIN, 16));
        pass.setBorder(border);
        frame.add(pass);

        type = new JLabel("Type");
        type.setBounds(175, 250, 100, 30);
        type.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(type);

        patient = new JRadioButton("Patient");
        patient.setBounds(300, 250, 100, 30);
        patient.setFont(new Font("Arial", Font.BOLD, 20));
        patient.setBackground(Color.WHITE);

        doctor = new JRadioButton("Doctor");
        doctor.setBounds(430, 250, 100, 30);
        doctor.setFont(new Font("Arial", Font.BOLD, 20));
        doctor.setBackground(Color.WHITE);

        worker = new JRadioButton("Worker");
        worker.setBounds(560, 250, 100, 30);
        worker.setFont(new Font("Arial", Font.BOLD, 20));
        worker.setBackground(Color.WHITE);

        patient.setActionCommand("Patient");
        doctor.setActionCommand("Doctor");
        worker.setActionCommand("Worker");

        b1 = new ButtonGroup();
        b1.add(patient);
        b1.add(doctor);
        b1.add(worker);

        frame.add(patient);
        frame.add(doctor);
        frame.add(worker);

        login = new JButton("Login");
        login.setBounds(300, 300, 250, 30);
        login.setFont(new Font("Arial", Font.BOLD, 20));
        login.setBackground(Color.green);
        frame.add(login);

        signup = new JButton("Base Page");
        signup.setBounds(300, 350, 250, 30);
        signup.setFont(new Font("Arial", Font.BOLD, 20));
        signup.setBackground(Color.green);
        frame.add(signup);

        cancel = new JButton("Exit");
        cancel.setBounds(375, 400, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        show = new JButton("Show");
        show.setBounds(580, 200, 100, 30);
        show.setFont(new Font("Arial", Font.BOLD, 20));
        show.setBackground(Color.green);
        frame.add(show);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(uname.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "User Id is required");
                    return;
                } else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password is required");
                    return;
                } else if (!b1.isSelected(patient.getModel()) && !b1.isSelected(doctor.getModel()) && !b1.isSelected(worker.getModel())) {
                    JOptionPane.showMessageDialog(null, "Type is required");
                    return;
                } else {
                    try{
                        conn c = new conn();
                        String query2 = "Select * from login where userid = '" + uname.getText() + "'";
                        ResultSet rs = c.s.executeQuery(query2);
                        while (rs.next()){
                            if(rs.getString(5).equals("no")){
                                JOptionPane.showMessageDialog(null, "Please activate account by register again.");
                                return;
                            }
                            if(rs.getString(3).equals(pass.getText()) && rs.getString(4).equals(b1.getSelection().getActionCommand())){
                                JOptionPane.showMessageDialog(null, "Login Successfully");
                                frame.dispose();
                                new basePage();
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Invalid Credential");
                    } catch (Exception ae){
                        ae.printStackTrace();
                    }
                }
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new basePage();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(show.getText().equals("Show")){
                    pass.setEchoChar((char) 0);
                    show.setText("Hide");
                } else if (show.getText().equals("Hide")) {
                    pass.setEchoChar('●');
                    show.setText("Show");
                }
            }
        });

        uname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick();
                }
            }
        });

        pass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick();
                }
            }
        });

        type.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login.doClick();
                }
            }
        });

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800, 500);
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