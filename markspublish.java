package Board;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class markspublish {

	JFrame frame;
	private JTextField IDtxt;
	private JTextField Titletxt;
	private JTextField URLtxt;
	private JTextField author_nametxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					markspublish window = new markspublish();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public markspublish() {
		initialize();
		Connect();
		table_load();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	
	public void Connect() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://Localhost:5432/Board examination","postgres","12345678");
		}
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
	}
	public void table_load(){
		  try{
		    pst = con.prepareStatement("select Id,subject_code,grade from results");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));

            
		  }catch (SQLException e){
		     e.printStackTrace();
		  }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Library");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(259, 10, 360, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Invention Registration", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 71, 317, 187);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 33, 39, 20);
		panel.add(lblNewLabel_2);
		
		Titletxt = new JTextField();
		Titletxt.setBounds(59, 33, 230, 19);
		panel.add(Titletxt);
		Titletxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("URL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 73, 39, 28);
		panel.add(lblNewLabel_3);
		
		URLtxt = new JTextField();
		URLtxt.setBounds(59, 80, 230, 19);
		panel.add(URLtxt);
		URLtxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 125, 45, 13);
		panel.add(lblNewLabel_4);
		
		author_nametxt = new JTextField();
		author_nametxt.setBounds(59, 124, 230, 19);
		panel.add(author_nametxt);
		author_nametxt.setColumns(10);
		
		JButton btnNewButton = new JButton("UPLOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Title,URL,Name;
				Title=Titletxt.getText();
				URL=URLtxt.getText();
				Name=author_nametxt.getText();
				try {
					pst = con.prepareStatement("Insert into results(id,subject_code,marks)values(?,?,?)");
					pst.setString(1, Title);
					pst.setString(2, URL);
					pst.setString(3, Name);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Your invention has been uploaded to the archive");
					table_load();
					Titletxt.setText("");
					URLtxt.setText("");
					author_nametxt.setText("");
					Titletxt.requestFocus();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(20, 269, 85, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(242, 268, 85, 37);
		frame.getContentPane().add(btnClear);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Updation", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 326, 317, 75);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Inv. ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(10, 10, 74, 55);
		panel_1.add(lblNewLabel_1);
		
		IDtxt = new JTextField();
		
		IDtxt.setBounds(76, 21, 130, 34);
		panel_1.add(IDtxt);
		IDtxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
		            String id = IDtxt.getText();
		            String example="select id,subject_code,marks from results where id="+id+";";
		            
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
		panel_1.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Title,URL,Name,ID;
				Title=Titletxt.getText();
				URL=URLtxt.getText();
				Name=author_nametxt.getText();
				ID=IDtxt.getText();
				try {
					String hello="update results set id= ?,subject_code= ?,grade= ? where employee_id ="+ID+";";
					pst = con.prepareStatement(hello);
					pst.setString(1, Title);
					pst.setString(2, URL);
					pst.setString(3, Name);
					pst.executeUpdate();
	                System.out.println("he");
					JOptionPane.showMessageDialog(null, "Your invention has been uploaded to the archive");
					table_load();
					Titletxt.setText("");
					URLtxt.setText("");
					author_nametxt.setText("");
					Titletxt.requestFocus();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		btnUpdate.setBounds(363, 332, 105, 51);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnClear_1_1 = new JButton("DELETE");
		btnClear_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID;
				ID=IDtxt.getText();
				try {
					String hello="delete from results where id ="+ID+";";
					pst = con.prepareStatement(hello);
					pst.executeUpdate();
	                System.out.println("he");
					JOptionPane.showMessageDialog(null, "DELETED");
					table_load();
					Titletxt.setText("");
					URLtxt.setText("");
					author_nametxt.setText("");
					Titletxt.requestFocus();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnClear_1_1.setBounds(514, 332, 105, 51);
		frame.getContentPane().add(btnClear_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Your Papers", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_2.setBounds(337, 71, 302, 251);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 282, 221);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}