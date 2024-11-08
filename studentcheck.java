package Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class studentcheck extends JFrame {

    private JPanel contentPane;
    private JTextField txtStudentSchedule;
    private JTable table;

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
                    studentcheck frame = new studentcheck();
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
    public studentcheck() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                schoolhome home = new schoolhome();
                home.setVisible(true);
            }
        });
        btnNewButton.setBounds(38, 212, 77, 21);
        contentPane.add(btnNewButton);
        
        txtStudentSchedule = new JTextField();
        txtStudentSchedule.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtStudentSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        txtStudentSchedule.setText("Student Details");
        txtStudentSchedule.setBounds(128, 22, 178, 27);
        contentPane.add(txtStudentSchedule);
        txtStudentSchedule.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 77, 353, 116);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null},
                {null, null},
            },
            new String[] {
                "ID", "School ID"
            }
        ));
        scrollPane.setViewportView(table);
    }
}


