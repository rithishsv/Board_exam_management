package Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtLogin;

	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/Board examination";
        String username = "postgres";
        String password = "12345678";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
        Connection con = DriverManager.getConnection(jdbcURL, username, password);
        System.out.print("Connected");
		
        }
        catch(SQLException e) {
        System.out.println("Error in connection");
        e.printStackTrace();
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Student", "Examiner", "School"}));
		comboBox.setMaximumRowCount(6);
		comboBox.setBounds(155, 68, 202, 22);
		contentPane.add(comboBox);
		
		JTextArea txtrEnterUsername = new JTextArea();
		txtrEnterUsername.setBounds(155, 98, 192, 22);
		contentPane.add(txtrEnterUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 131, 192, 20);
		contentPane.add(passwordField);

		JButton login_btn = new JButton("Login");
		login_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String opt=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
			Statement stmt = con.createstatement();
		        String sql="select userid,password from users where userid =? && password=? "+opt ;
		
						
						
					   
						String uid = txtrEnterUsername.getText();
						String pass = passwordField.getText();
						String sql = "Select * from login where Username = '"+"' and Password ='"+"';";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, " Login Successfull...");
							
						WelcomePage WelcomePage = new WelcomePage();
						WelcomePage.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect Ussrname and password...");
					con.close();
						if (uid.equals("AD001")&&pass.equals("admin"))
						{
							JOptionPane.showMessageDialog(login_btn,"Login Successful");
							examinationcellhome home = new examinationcellhome();
							home.setVisible(true);
						}
						else if (uid.equals("SC001")&&pass.equals("school"))
						{
							JOptionPane.showMessageDialog(login_btn,"Login Successful");
							schoolhome home = new schoolhome();
							home.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(login_btn,"Invalid Username or Password");
						}
					}
					
		
               
			}
			
		);
		login_btn.setBounds(180, 180, 89, 23);
		contentPane.add(login_btn);

        JLabel username_label = new JLabel("User ID ");
		username_label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		username_label.setForeground(Color.BLACK);
		username_label.setBounds(82, 101, 83, 17);
		contentPane.add(username_label);
		
		JLabel password_label = new JLabel("Password");
		password_label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		password_label.setForeground(Color.BLACK);
		password_label.setBounds(82, 129, 83, 17);
		contentPane.add(password_label);

        txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		txtLogin.setForeground(new Color(0, 0, 0));
		txtLogin.setText("LOGIN");
		txtLogin.setBounds(169, 24, 94, 23);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

        JLabel lblNewLabel = new JLabel("Role");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(102, 67, 69, 22);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(325, 224, 101, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home();
				home.setVisible(true);
			}
		});
		/*btnNewButton.setBackground(SystemColor.window);*/
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		
	}
}