package OnlineHospitalManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class basePage {
    JFrame frame;
    JLabel heading, logo, rgheading, dtheading, dltheading;
    JButton login, rgpatient, rgdoctor, rgworker, dtpatient, dtdoctor, dtworker, dltpatient, dltdoctor, dltworker;
    basePage(){
        frame = new JFrame("Medical Center");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee\\IdeaProjects\\OnlineHospitalManagement\\src\\OnlineHospitalManagement\\assest\\logo.jpg"));
        logo.setBounds(150, 30, 100, 70);
        frame.add(logo);

        heading = new JLabel("Welcome to Medical Center");
        heading.setBounds(280, 53, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        login = new JButton("Login");
        login.setBounds(650, 73, 100, 40);
        login.setFont(new Font("Arial", Font.ITALIC, 25));
        login.setBackground(Color.green);
        frame.add(login);

        rgheading = new JLabel("Register Details", SwingConstants.CENTER);
        rgheading.setBounds(0, 133, 800, 40);
        rgheading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(rgheading);

        rgpatient = new JButton("Patient");
        rgpatient.setBounds(150, 173, 130, 40);
        rgpatient.setFont(new Font("Arial", Font.BOLD, 20));
        rgpatient.setBackground(Color.green);
        frame.add(rgpatient);

        rgdoctor = new JButton("Doctor");
        rgdoctor.setBounds(350, 173, 130, 40);
        rgdoctor.setFont(new Font("Arial", Font.BOLD, 20));
        rgdoctor.setBackground(Color.green);
        frame.add(rgdoctor);

        rgworker = new JButton("Worker");
        rgworker.setBounds(550, 173, 130, 40);
        rgworker.setFont(new Font("Arial", Font.BOLD, 20));
        rgworker.setBackground(Color.green);
        frame.add(rgworker);

        dtheading = new JLabel("Show Details", SwingConstants.CENTER);
        dtheading.setBounds(0, 233, 800, 40);
        dtheading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(dtheading);

        dtpatient = new JButton("Patient");
        dtpatient.setBounds(150, 273, 130, 40);
        dtpatient.setFont(new Font("Arial", Font.BOLD, 20));
        dtpatient.setBackground(Color.green);
        frame.add(dtpatient);

        dtdoctor = new JButton("Doctor");
        dtdoctor.setBounds(350, 273, 130, 40);
        dtdoctor.setFont(new Font("Arial", Font.BOLD, 20));
        dtdoctor.setBackground(Color.green);
        frame.add(dtdoctor);

        dtworker = new JButton("Worker");
        dtworker.setBounds(550, 273, 130, 40);
        dtworker.setFont(new Font("Arial", Font.BOLD, 20));
        dtworker.setBackground(Color.green);
        frame.add(dtworker);

        dltheading = new JLabel("Delete Details", SwingConstants.CENTER);
        dltheading.setBounds(0, 333, 800, 40);
        dltheading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(dltheading);

        dltpatient = new JButton("Patient");
        dltpatient.setBounds(150, 373, 130, 40);
        dltpatient.setFont(new Font("Arial", Font.BOLD, 20));
        dltpatient.setBackground(Color.green);
        frame.add(dltpatient);

        dltdoctor = new JButton("Doctor");
        dltdoctor.setBounds(350, 373, 130, 40);
        dltdoctor.setFont(new Font("Arial", Font.BOLD, 20));
        dltdoctor.setBackground(Color.green);
        frame.add(dltdoctor);

        dltworker = new JButton("Worker");
        dltworker.setBounds(550, 373, 130, 40);
        dltworker.setFont(new Font("Arial", Font.BOLD, 20));
        dltworker.setBackground(Color.green);
        frame.add(dltworker);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new login();
            }
        });

        rgpatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new patientRegister();
            }
        });

        rgdoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new doctorRegister();
            }
        });

        rgworker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new workerRegister();
            }
        });

        dtpatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new patientDetail();
            }
        });

        dtdoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new doctorDetail();
            }
        });

        dtworker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new workerDetail();
            }
        });

        dltpatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new patientDelete();
            }
        });

        dltdoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new doctorDelete();
            }
        });

        dltworker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new workerDelete();
            }
        });


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800, 600);
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
