package ludo.main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First {

    JFrame frmLudo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    First window = new First();
                    window.frmLudo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public First() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLudo = new JFrame();
        frmLudo.getContentPane().setBackground(new Color(255, 255, 255));
        frmLudo.setTitle("LUDO");
        frmLudo.setBounds(100, 100, 818, 528);
        frmLudo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLudo.getContentPane().setLayout(null);

        JLabel b = new JLabel(new ImageIcon("front.png"));
        b.setBounds(0,0,800,400);
        frmLudo.getContentPane().add(b);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                frmLudo.dispose();
            }
        });
        btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(230, 230, 250));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        btnNewButton.setBounds(180, 414, 137, 42);
        frmLudo.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Register");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registration register = new Registration();
                register.setVisible(true);
                frmLudo.dispose();
            }
        });
        btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton_1.setBackground(new Color(230, 230, 250));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
        btnNewButton_1.setBounds(416, 414, 137, 42);
        frmLudo.getContentPane().add(btnNewButton_1);

    }
}
