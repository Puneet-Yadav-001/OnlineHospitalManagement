package OnlineHospitalManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class doctorDelete {
    JFrame frame;
    JLabel heading, logo, delete, userid, password;
    JTextField useridtf;
    JPasswordField pass;
    JButton show, register, cancel, reset, back;
    doctorDelete(){
        frame = new JFrame("Medical Center");

        logo = new JLabel(new ImageIcon("C:\\Users\\punee\\IdeaProjects\\OnlineHospitalManagement\\src\\OnlineHospitalManagement\\assest\\logo.jpg"));
        logo.setBounds(150, 10, 100, 70);
        frame.add(logo);

        heading = new JLabel("Welcome to Medical Center");
        heading.setBounds(280, 33, 450, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(heading);

        delete = new JLabel("Inactive Account");
        delete.setBounds(350, 73, 450, 40);
        delete.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(delete);

        userid = new JLabel("Doctor Id");
        userid.setBounds(150, 150, 200, 40);
        userid.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(userid);

        password = new JLabel("Password");
        password.setBounds(150, 200, 200, 40);
        password.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(password);

        useridtf = new JTextField();
        useridtf.setBounds(350, 150, 270, 30);
        useridtf.setFont(new Font("Arial", Font.PLAIN, 20));
        useridtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(useridtf);

        pass  = new JPasswordField();
        pass.setBounds(350, 200, 270, 30);
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(pass);

        register = new JButton("Inactive Account");
        register.setBounds(325, 250, 250, 30);
        register.setFont(new Font("Arial", Font.PLAIN, 20));
        register.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        register.setBackground(Color.green);
        frame.add(register);

        reset = new JButton("Reset");
        reset.setBounds(325, 300, 120, 30);
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        reset.setBackground(Color.green);
        frame.add(reset);

        cancel = new JButton("Cancel");
        cancel.setBounds(455, 300, 120, 30);
        cancel.setFont(new Font("Arial", Font.PLAIN, 20));
        cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        back = new JButton("Back");
        back.setBounds(325, 350, 250, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        back.setBackground(Color.green);
        frame.add(back);

        show = new JButton("Show");
        show.setBounds(650, 200, 100, 30);
        show.setFont(new Font("Arial", Font.PLAIN, 20));
        show.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        show.setBackground(Color.green);
        frame.add(show);

        useridtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    useridtf.setEditable(true);
                } else {
                    useridtf.setEditable(false);
                }
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (useridtf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Doctor Id is required");
                    return;
                } else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password is required");
                    return;
                }
                try{
                    conn c = new conn();
                    String query1 = "UPDATE `doctorhistory` SET `active`='no' where `doctorid` = " + useridtf.getText() + " and `password` = '" + pass.getText() + "'";
                    String query2 = "UPDATE `login` SET `active`='no' where `userid` = " + useridtf.getText() + " and `password` = '" + pass.getText() + "' and `type` = 'Doctor'";
                    System.out.println(query1);
                    c.s.execute(query1);
                    System.out.println(query2);
                    c.s.execute(query2);
                } catch (Exception ae){
                    ae.printStackTrace();
                }

                frame.dispose();
                new basePage();
                return;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useridtf.setText("");
                pass.setText("");
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
                new basePage();
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

        useridtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        pass.addKeyListener(new KeyAdapter() {
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

        back.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back.doClick();
                }
            }
        });

        show.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    show.doClick();
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
