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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
public class Home extends JFrame {
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
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        System.out.print("Connected");
        }
        catch(SQLException e) {
        System.out.println("Error in connection");
        e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }});
    }
    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        JButton login_btn = new JButton("Login");
		login_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        login_btn.setBounds(160, 100, 89, 23);
         login_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login log = new login();
                log.setVisible(true);
			}
        });
        contentPane.add(login_btn);
        JButton register_btn = new JButton("Register");
		register_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        register_btn.setBounds(160, 140, 89, 23);
        register_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				users user = new users();
                user.setVisible(true);
			}
        });
        contentPane.add(register_btn);

       


    }
}
