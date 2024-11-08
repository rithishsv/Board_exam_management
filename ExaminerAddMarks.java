package Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExaminerAddMarks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
					ExaminerAddMarks frame = new ExaminerAddMarks();
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
	public ExaminerAddMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Subject Code :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 11, 102, 32);
		contentPane.add(lblNewLabel);
		
		/*JRadioButton rdbtnNewRadioButton = new JRadioButton("ENG");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(46, 53, 66, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("HIN");
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(46, 79, 66, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("MAT");
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(46, 105, 66, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("SCI");
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton_3.setBounds(46, 131, 66, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("SOC");
		rdbtnNewRadioButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton_4.setBounds(46, 157, 66, 23);
		contentPane.add(rdbtnNewRadioButton_4);*/
		JLabel lblNewLabel_3 = new JLabel("Student ID :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(155, 120, 124, 23);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(240, 120, 124, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Paper ID :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(162, 53, 68, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(240, 55, 124, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mark :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(183, 84, 68, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 84, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		ButtonGroup bg= new ButtonGroup();
		/*bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		bg.add(rdbtnNewRadioButton_4);*/
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				markspublish gotoschedule = new markspublish();
				gotoschedule.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(46, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD MARK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				markspublish gotoschedule = new markspublish();
				gotoschedule.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(283, 211, 112, 23);
		contentPane.add(btnNewButton_1);
	}
}

