package ludo.main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registration extends JFrame {

    private JPanel contentPane;
    private JTextField txtRegistration;
    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registration frame = new Registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Registration() {
        setBackground(new Color(255, 255, 255));
        setTitle("LUDO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 582);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtRegistration = new JTextField();
        txtRegistration.setBackground(new Color(255, 255, 255));
        txtRegistration.setText("Registration");
        txtRegistration.setEditable(false);
        txtRegistration.setForeground(new Color(0, 0, 0));
        txtRegistration.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        txtRegistration.setBounds(330, 10, 167, 61);
        contentPane.add(txtRegistration);
        txtRegistration.setColumns(10);

        JLabel lblNewLabel = new JLabel("USERNAME:");
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel.setBounds(176, 126, 140, 34);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("E-MAIL: ");
        lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel_1.setBounds(224, 187, 92, 34);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("PASSWORD: ");
        lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel_2.setBounds(176, 258, 140, 34);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("CONFIRM PASSWORD: ");
        lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel_3.setBounds(70, 328, 246, 36);
        contentPane.add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(330, 126, 233, 32);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(330, 189, 233, 32);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("GENDER: ");
        lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel_4.setBounds(210, 392, 106, 32);
        contentPane.add(lblNewLabel_4);

        String[] gender = {"Female", "Male", "Others"};;
        JComboBox comboBox = new JComboBox(gender);
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setBounds(330, 393, 233, 32);
        contentPane.add(comboBox);

        JButton btnNewButton_1 = new JButton("LOGIN\r\n");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{
                    String password = passwordField.getText();
                    String password1 = passwordField_1.getText();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","Tanman1011");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                    if(textField.getText().equals("") && textField_1.getText().equals("") && passwordField.getText().equals("") && passwordField_1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fields Cannot Be Empty", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(password.equals(password1) == false) {
                        JOptionPane.showMessageDialog(null, "Both passwords should match!", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO one.register (id_num, username, email, password, gender) VALUES (?,?,?,?,?)");

                        ps.setInt(1,0);
                        ps.setString(2,textField.getText());
                        ps.setString(3,textField_1.getText());
                        ps.setString(4,passwordField.getText());
                        ps.setString(5,(String) comboBox.getItemAt(comboBox.getSelectedIndex()));
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Registered Successfully!");

                        Login login = new Login();
                        login.setVisible(true);
                        dispose();
                    }
                }
                catch(Exception e1) {
                    System.out.println(e1);

                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 25));
        btnNewButton_1.setBounds(470, 466, 140, 47);
        contentPane.add(btnNewButton_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(330, 258, 233, 32);
        contentPane.add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(330, 332, 233, 32);
        contentPane.add(passwordField_1);

        JButton btnNewButton_1_1 = new JButton("MENU");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                First f = new First();
                f.frmLudo.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1_1.setFont(new Font("Serif", Font.PLAIN, 25));
        btnNewButton_1_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton_1_1.setBounds(235, 466, 140, 47);
        contentPane.add(btnNewButton_1_1);


    }
}
