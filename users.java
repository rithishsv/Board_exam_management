package Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class users extends JFrame {

    private JPanel contentPane;
    private JTextField txtRegistration;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    users frame = new users();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public users() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        txtRegistration = new JTextField();
        txtRegistration.setHorizontalAlignment(SwingConstants.CENTER);
        txtRegistration.setFont(new Font("Verdana", Font.BOLD, 16));
        txtRegistration.setText("REGISTRATION");
        txtRegistration.setBounds(54, 11, 314, 32);
        contentPane.add(txtRegistration);
        txtRegistration.setColumns(10);
        
        JTextArea username_textArea = new JTextArea();
        username_textArea.setBounds(207, 72, 161, 22);
        contentPane.add(username_textArea);
        
        JTextArea email_textArea = new JTextArea();
        email_textArea.setBounds(207, 105, 161, 22);
        contentPane.add(email_textArea);
        
        JTextArea password_textArea = new JTextArea();
        password_textArea.setBounds(207, 138, 161, 22);
        contentPane.add(password_textArea);
        
        JLabel username_label = new JLabel("Enter User ID ");
        username_label.setForeground(Color.BLACK);
        username_label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
        username_label.setBounds(90, 77, 94, 14);
        contentPane.add(username_label);
        
        JLabel password_label = new JLabel("Enter Password");
        password_label.setBackground(Color.BLACK);
        password_label.setForeground(Color.BLACK);
        password_label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
        password_label.setBounds(90, 142, 94, 14);
        contentPane.add(password_label);
        
        JLabel email_label = new JLabel("Enter Email ID");
        email_label.setBackground(Color.BLACK);
        email_label.setForeground(Color.BLACK);
        email_label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
        email_label.setBounds(90, 110, 81, 14);
        contentPane.add(email_label);
        
        JButton register_btn = new JButton("Register");
        register_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        register_btn.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		String jdbcURL = "jdbc:postgresql://localhost:5432/Board examination";
                String username = "postgres";
                String password = "12345678";
        		String sql = "INSERT INTO users VALUES (?,?,?,?)";
        		Connection connection = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(jdbcURL, username, password);
                    System.out.println("Connected To Database\n\n");
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, username_textArea.getText());
                    pst.setString(2, email_textArea.getText());
                    pst.setString(3, password_textArea.getText());
                    
                    pst.executeUpdate();
                } catch (Exception k) {
                    k.printStackTrace();
                }
                
        	}
        });
        register_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(register_btn,"Registration Successful. You may login now.");
                users login = new users();
                login.setVisible(true);
            }
        });
        register_btn.setBounds(155, 186, 89, 23);
        contentPane.add(register_btn);

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
