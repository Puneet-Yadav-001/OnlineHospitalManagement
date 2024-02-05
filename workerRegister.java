package OnlineHospitalManagement;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class workerRegister {
    JFrame frame;
    JLabel heading, logo, signup, name, email, father, phone, password, gender, work, dob, state;
    JTextField uname, emailadd, phoneno, fname;
    JPasswordField pass;
    JRadioButton male, female;
    JButton show, register, cancel, reset, back;
    ButtonGroup b1;
    JComboBox statetf, worktf;
    String[] states = {"Select state", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",
            "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra",
            "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu",
            "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh",
            "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Puducherry"};
    String[] works = {"Select work type", "Sweeper", "Pharmacist", "Nurse", "Biller", "Manager", "Ward Boy", "Recruiter",
            "Medical assistant"};
    JDateChooser dobtf;
    workerRegister(){
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

        name = new JLabel("Name");
        name.setBounds(150, 150, 200, 40);
        name.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(name);

        father = new JLabel("Father's Name");
        father.setBounds(150, 200, 200, 40);
        father.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(father);

        gender = new JLabel("Gender");
        gender.setBounds(150, 250, 200, 40);
        gender.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(gender);

        email = new JLabel("Email");
        email.setBounds(150, 300, 200, 40);
        email.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(email);

        phone = new JLabel("Phone No.");
        phone.setBounds(150, 350, 200, 40);
        phone.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(phone);

        password = new JLabel("Password");
        password.setBounds(150, 400, 200, 40);
        password.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(password);

        dob = new JLabel("Date of Birth");
        dob.setBounds(150, 450, 200, 40);
        dob.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(dob);

        state = new JLabel("State");
        state.setBounds(150, 500, 200, 40);
        state.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(state);

        work = new JLabel("Work");
        work.setBounds(150, 550, 200, 40);
        work.setFont(new Font("Arial", Font.PLAIN, 25));
        frame.add(work);

        uname = new JTextField();
        uname.setBounds(350, 150, 270, 30);
        uname.setFont(new Font("Arial", Font.PLAIN, 20));
        uname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(uname);

        fname  = new JTextField();
        fname.setBounds(350, 200, 270, 30);
        fname.setFont(new Font("Arial", Font.PLAIN, 20));
        fname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(fname);

        male = new JRadioButton("Male");
        male.setBounds(350, 250, 120, 30);
        male.setFont(new Font("Arial", Font.PLAIN, 20));
        male.setBackground(Color.white);

        female = new JRadioButton("Female");
        female.setBounds(510, 250, 125, 30);
        female.setFont(new Font("Arial", Font.PLAIN, 20));
        female.setBackground(Color.white);

        b1 = new ButtonGroup();
        b1.add(male);
        b1.add(female);

        frame.add(male);
        frame.add(female);

        emailadd = new JTextField();
        emailadd.setBounds(350, 300, 270, 30);
        emailadd.setFont(new Font("Arial", Font.PLAIN, 20));
        emailadd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(emailadd);

        phoneno = new JTextField();
        phoneno.setBounds(350, 350, 270, 30);
        phoneno.setFont(new Font("Arial", Font.PLAIN, 20));
        phoneno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(phoneno);

        pass = new JPasswordField();
        pass.setBounds(350, 400, 270, 30);
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(pass);

        dobtf = new JDateChooser();
        dobtf.setBounds(350, 450, 270, 30);
        dobtf.setFont(new Font("Arial", Font.PLAIN, 16));
        dobtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(dobtf);

        statetf = new JComboBox(states);
        statetf.setBounds(350, 500, 270, 30);
        statetf.setFont(new Font("Arial", Font.PLAIN, 20));
        statetf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(statetf);

        worktf = new JComboBox(works);
        worktf.setBounds(350, 550, 270, 30);
        worktf.setFont(new Font("Arial", Font.PLAIN, 20));
        worktf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        frame.add(worktf);

        register = new JButton("Register");
        register.setBounds(325, 600, 250, 30);
        register.setFont(new Font("Arial", Font.PLAIN, 20));
        register.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        register.setBackground(Color.green);
        frame.add(register);

        reset = new JButton("Reset");
        reset.setBounds(325, 650, 120, 30);
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        reset.setBackground(Color.green);
        frame.add(reset);

        cancel = new JButton("Cancel");
        cancel.setBounds(455, 650, 120, 30);
        cancel.setFont(new Font("Arial", Font.PLAIN, 20));
        cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cancel.setBackground(Color.green);
        frame.add(cancel);

        back = new JButton("Back");
        back.setBounds(325, 700, 250, 30);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        back.setBackground(Color.green);
        frame.add(back);

        show = new JButton("Show");
        show.setBounds(650, 400, 100, 30);
        show.setFont(new Font("Arial", Font.PLAIN, 20));
        show.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        show.setBackground(Color.green);
        frame.add(show);

        uname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    uname.setEditable(true);
                } else {
                    uname.setEditable(false);
                }
            }
        });

        fname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
                    fname.setEditable(true);
                } else {
                    fname.setEditable(false);
                }
            }
        });

        phoneno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c)){
                    if(phoneno.getText().length()<10){
                        phoneno.setEditable(true);
                    } else {
                        phoneno.setEditable(false);
                        if(Character.isISOControl(c)){
                            phoneno.setEditable(true);
                            phoneno.setText(phoneno.getText().substring(0, 9));
                        }
                    }
                } else {
                    phoneno.setEditable(false);
                }
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arr = new String[9];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (uname.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Name is required");
                    return;
                } else if (fname.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Father's Name is required");
                    return;
                } else if (!b1.isSelected(male.getModel()) && !b1.isSelected(female.getModel())) {
                    JOptionPane.showMessageDialog(null, "Gender is required");
                    return;
                } else if (emailadd.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email Address is required");
                    return;
                } else if (phoneno.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Phone Number is required");
                    return;
                } else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password is required");
                    return;
                } else if (dobtf.getDate().equals("")) {
                    JOptionPane.showMessageDialog(null, "Date of Birth is required");
                    return;
                } else if (statetf.getSelectedItem().equals("Select state")) {
                    JOptionPane.showMessageDialog(null, "State is required");
                    return;
                } else if (worktf.getSelectedItem().equals("Select dieases type")) {
                    JOptionPane.showMessageDialog(null, "Dieases Type is required");
                    return;
                } else if (!emailadd.getText().contains("@")){
                    JOptionPane.showMessageDialog(null, "Enter valid Email Address");
                    return;
                } else if (!emailadd.getText().contains(".com")){
                    JOptionPane.showMessageDialog(null, "Enter valid Email Address");
                    return;
                } else if (phoneno.getText().length() != 10){
                    JOptionPane.showMessageDialog(null, "Mobile number must be 10 digit");
                    return;
                }
                arr[0] = uname.getText();
                arr[1] = fname.getText();
                if (male.isSelected())
                    arr[2] = "Male";
                else if (female.isSelected())
                    arr[2] = "Female";
                arr[3] = emailadd.getText();
                arr[4] = phoneno.getText();
                arr[5] = pass.getText();
                arr[6] = sdf.format(dobtf.getDate());
                arr[7] = (String) statetf.getSelectedItem();
                arr[8] = (String) worktf.getSelectedItem();

                try{
                    conn c = new conn();
                    String query1 = "select workerid from workerhistory where username = '" + arr[0] + "' and fathername = '" + arr[1] + "' and gender = '" + arr[2] + "' and email = '" + arr[3] + "' and phone = " + arr[4] + " and password = '" + arr[5] + "' and dob = '" + arr[6] + "' and state = '" + arr[7] + "' and work = '" + arr[8] + "' and active = 'yes'";
                    ResultSet rs = c.s.executeQuery(query1);
                    while(rs.next()){
                        JOptionPane.showMessageDialog(null, "Worker with same details already exist.");
                        return;
                    }
                    String query2 = "INSERT INTO `workerhistory`(`username`, `fathername`, `gender`, `email`, `phone`, `password`, `dob`, `state`, `work`, `active`, `joinDate`) VALUES ('" + arr[0] + "','" + arr[1] + "','" + arr[2] + "','" + arr[3] + "'," + arr[4] + ",'" + arr[5] + "','" + arr[6] + "','" + arr[7] + "','" + arr[8] + "', 'yes', '" + java.time.LocalDate.now() + "')";
                    c.s.execute(query2);
                    String query3 = "select workerid from workerhistory where username = '" + arr[0] + "' and fathername = '" + arr[1] + "' and gender = '" + arr[2] + "' and email = '" + arr[3] + "' and phone = " + arr[4] + " and password = '" + arr[5] + "' and dob = '" + arr[6] + "' and state = '" + arr[7] + "' and work = '" + arr[8] + "' and active = 'yes'";
                    ResultSet rs1 = c.s.executeQuery(query3);
                    while(rs1.next()){
                        JOptionPane.showMessageDialog(null, "Worker id is " + rs1.getString(1));
                        String query4 = "INSERT INTO `login`(`userid`, `username`, `password`, `type`, `active`) VALUES ('" + rs1.getString(1) + "','" + arr[0] + "','" + arr[5] + "','Worker', 'yes')";
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
                uname.setText("");
                fname.setText("");
                dobtf.setDate(new Date(""));
                emailadd.setText("");
                worktf.setSelectedIndex(0);
                phoneno.setText("");
                pass.setText("");
                statetf.setSelectedIndex(0);
                b1.clearSelection();
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

        uname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        fname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        gender.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        emailadd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        phoneno.addKeyListener(new KeyAdapter() {
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

        dobtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        worktf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    register.doClick();
                }
            }
        });

        statetf.addKeyListener(new KeyAdapter() {
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
        frame.setSize(800, 800);
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
