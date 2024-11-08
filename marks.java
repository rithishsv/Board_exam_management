package Board;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;
public class marks  extends JFrame {

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
                    marks frame = new marks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* 
     Create the frame.
     */
    public marks() {
        setTitle("Marks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("MARKS");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(10, 10, 101, 17);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("English :");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 70, 58, 17);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Second Language :");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(10, 97, 118, 17);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Mathematics :");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(10, 124, 118, 17);
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Science :");
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(10, 151, 118, 17);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Social Science :");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_1.setBounds(10, 178, 118, 17);
        contentPane.add(lblNewLabel_1_1_1_1_1);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(216, 70, 80, 17);
        contentPane.add(textArea);
        
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(216, 124, 80, 17);
        contentPane.add(textArea_1);
        
        JTextArea textArea_2 = new JTextArea();
        textArea_2.setBounds(216, 97, 80, 17);
        contentPane.add(textArea_2);
        
        JTextArea textArea_3 = new JTextArea();
        textArea_3.setBounds(216, 151, 80, 17);
        contentPane.add(textArea_3);
        
        JTextArea textArea_4 = new JTextArea();
        textArea_4.setBounds(216, 178, 80, 17);
        contentPane.add(textArea_4);
        
        JButton btnNewButton = new JButton("Back");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StudentHome home = new StudentHome();
                home.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBackground(SystemColor.textInactiveText);
        btnNewButton.setBounds(296, 221, 101, 29);
        contentPane.add(btnNewButton);
    }
}
