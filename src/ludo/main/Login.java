package ludo.main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {
    static String player_name = "";
    private JPanel contentPane;
    private JTextField txtLogin;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setTitle("LUDO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 430);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtLogin = new JTextField();
        txtLogin.setBackground(new Color(255, 255, 255));
        txtLogin.setEditable(false);
        txtLogin.setText("Login");
        txtLogin.setForeground(Color.BLACK);
        txtLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        txtLogin.setColumns(10);
        txtLogin.setBounds(351, 10, 88, 61);
        contentPane.add(txtLogin);

        JLabel lblNewLabel = new JLabel("USERNAME:");
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel.setBounds(147, 126, 140, 34);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("PASSWORD: ");
        lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel_2.setBounds(147, 196, 140, 34);
        contentPane.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(313, 126, 233, 32);
        contentPane.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(313, 198, 233, 32);
        contentPane.add(passwordField);

        JButton btnNewButton_1 =  new JButton("START");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String username = textField.getText();
                    String password = passwordField.getText();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","Tanman1011");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                    if(textField.getText().equals("") && passwordField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Fields Cannot Be Empty", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(textField.getText().equals("admin") && passwordField.getText().equals("qwerty")) {
                        JOptionPane.showMessageDialog(null, "Login Successfull!");
                        Sqltable a = new Sqltable();
                        a.setVisible(true);
                        dispose();
                    }
                    else {
                        String sql = "SELECT * FROM one.register WHERE username = '"+ username + "' and password = '"+ password +"';";
                        ResultSet rs  = stmt.executeQuery(sql);
                        if(rs.next()) {
                            JOptionPane.showMessageDialog(null, "Login Successfull!");

                            player_name = username;
                            GameScreen game = new GameScreen();
                            dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Incorrect Login Details!", "Warning!!!", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                catch(Exception e1) {
                    System.out.println(e1);

                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 25));
        btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton_1.setBounds(433, 294, 140, 47);
        contentPane.add(btnNewButton_1);

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
        btnNewButton_1_1.setBounds(204, 294, 140, 47);
        contentPane.add(btnNewButton_1_1);
    }

}
