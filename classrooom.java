package Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class classrooom  extends JFrame {

    private JPanel contentPane;
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
                    classrooom frame = new classrooom();
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
    public classrooom() {
        Connection con;
	PreparedStatement pst;
	ResultSet rs;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Classroom Allotment");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setBounds(20, 11, 143, 35);
        contentPane.add(lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 44, 385, 170);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null},
                {null, null},
                {null, null},
            },
            new String[] {
                "Classroom_no", "School_id"
            }
        ));
        table.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        scrollPane.setViewportView(table);

        JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
		            String id = IDtxt.getText();
		            String example="select class_no,school from centre;";
		            
		                pst = con.prepareStatement(example);
		                
		                
		                ResultSet rs = pst.executeQuery();
		                if(rs.next()==true)
			            {
			              
			                String Title = rs.getString(1);
			                String Invention_url = rs.getString(2);
			                String Author_Name = rs.getString(3);
			                
			                Titletxt.setText(Title);
			                URLtxt.setText(Invention_url);
			                author_nametxt.setText(Author_Name);
			                
			                
			            }   
			            else
			            {
			            	Titletxt.setText("");
			            	URLtxt.setText("");
			            	author_nametxt.setText("");
			            	
			                 
			            }
			            


		        } 
			
				catch (SQLException ep) {
				}
			}
		});
		btnNewButton_1.setBounds(222, 21, 85, 31);
		contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                schoolhome backhome = new schoolhome();
                backhome.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBounds(322, 225, 89, 23);
        contentPane.add(btnNewButton);
    }
}


