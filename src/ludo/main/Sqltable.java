package ludo.main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

public class Sqltable extends JFrame {

    private JPanel contentPane;
    private JTextField txtSqlTable;
    private JTextField textField;
    private JTable table;
    private JButton btnNewButton;
    private JButton btnNewButton_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sqltable frame = new Sqltable();
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
    public Sqltable() {
        setTitle("LUDO");
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 871, 556);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtSqlTable = new JTextField();
        txtSqlTable.setText("User Database");
        txtSqlTable.setForeground(Color.BLACK);
        txtSqlTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        txtSqlTable.setEditable(false);
        txtSqlTable.setColumns(10);
        txtSqlTable.setBackground(Color.WHITE);
        txtSqlTable.setBounds(297, 10, 191, 61);
        contentPane.add(txtSqlTable);

        JLabel lblNewLabel = new JLabel("Enter username:");
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 23));
        lblNewLabel.setBounds(100, 108, 166, 41);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(276, 113, 259, 41);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Search");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","Tanman1011");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

                    Vector rows = new Vector();
                    if(textField.getText().equals("")) {
                        ResultSet rs = stmt.executeQuery("select * from one.register;");
                        while(rs.next()) {
                            Vector one_row = new Vector();
                            one_row.add(rs.getString(1));
                            one_row.add(rs.getString(2));
                            one_row.add(rs.getString(3));
                            one_row.add(rs.getString(4));
                            one_row.add(rs.getString(5));
                            rows.add(one_row);
                        }
                        DefaultTableModel dm = (DefaultTableModel)table.getModel();
                        Iterator i = rows.iterator();
                        int count = 0;
                        while(i.hasNext()) {
                            dm.insertRow(count, (Vector)i.next());
                            count++;
                        }
                    }
                    else {
                        int r = 0;
                        int rec = 0;
                        ResultSet rs = stmt.executeQuery("select * from one.register where username = '" + textField.getText() + "';" );
                        DefaultTableModel dm = (DefaultTableModel)table.getModel();
                        while(rs.next()) {

                            dm.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
                            rec = 1;
                        }
                        if(rec == 0) {
                            JOptionPane.showMessageDialog(null,"Not any user available by given username","Dialog",JOptionPane.WARNING_MESSAGE);
                        }

                    }
                }
                catch(Exception e1) {
                    System.out.println(e1);

                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Serif", Font.PLAIN, 25));
        btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton_1.setBounds(614, 108, 140, 47);
        contentPane.add(btnNewButton_1);

        JScrollPane scrollPane;
        scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(255, 255, 255));
        scrollPane.setFont(new Font("Serif", Font.PLAIN, 20));
        scrollPane.setBounds(29, 187, 759, 224);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "id_num", "username", "email", "password", "gender"
                }
        ));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setBounds(116, 210, 0, 0);
        scrollPane.setViewportView(table);

        btnNewButton = new JButton("Clear");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                DefaultTableModel dm = (DefaultTableModel)table.getModel();
                while(dm.getRowCount() > 0)
                {
                    dm.removeRow(0);
                }
            }
        });
        btnNewButton.setFont(new Font("Serif", Font.PLAIN, 25));
        btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(226, 437, 140, 47);
        contentPane.add(btnNewButton);

        btnNewButton_2 = new JButton("Back");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        btnNewButton_2.setFont(new Font("Serif", Font.PLAIN, 25));
        btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226), new Color(138, 43, 226)));
        btnNewButton_2.setBackground(Color.WHITE);
        btnNewButton_2.setBounds(489, 437, 140, 47);
        contentPane.add(btnNewButton_2);
    }
}
