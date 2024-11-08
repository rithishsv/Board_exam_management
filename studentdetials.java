package ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
public class studentdetials extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
					studentdetials frame = new studentdetials();
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
	public studentdetials() {
		setTitle("Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONAL DETAILS");
		lblNewLabel.setBounds(10, 10, 202, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(20, 45, 61, 15);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID :");
		lblNewLabel_2.setBounds(20, 70, 91, 15);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone Number :");
		lblNewLabel_2_1.setBounds(20, 95, 105, 15);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("dob:");
		lblNewLabel_2_1_1.setBounds(20, 120, 91, 15);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(325, 224, 101, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentHome home = new StudentHome();
				home.setVisible(true);
			}
		});
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(135, 45, 143, 14);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(135, 70, 143, 14);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(135, 95, 143, 14);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(135, 120, 143, 14);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(135, 145, 143, 18);
		contentPane.add(textArea_4);
		
		JButton update_btn = new JButton("Update");
		update_btn.setBounds(325, 187, 101, 29);
		update_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		update_btn.setBackground(SystemColor.window);
		contentPane.add(update_btn);// edit the update button so the values are inserted
		
		JLabel lblNewLabel_3 = new JLabel("School Id :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(20, 146, 91, 17);
		contentPane.add(lblNewLabel_3);
		
		
	}
}


