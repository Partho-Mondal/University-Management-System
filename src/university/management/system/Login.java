package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel lblpasword = new JLabel("Password");
        lblpasword.setBounds(40, 70, 100, 20);
        add(lblpasword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image image2 = image1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "Select * from login where username='"+username+"' and password='"+password+"'";
            
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
                    setVisible(false);
                    Project project = new Project();
                    project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "Inavlid username or password");
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel) {
            setVisible(false);            
        }
    }
    
    public static void main(String[] args) {
        Login lFrame = new Login();
        lFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
