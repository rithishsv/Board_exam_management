package Board;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class examinationcellhome extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    examinationcellhome frame = new examinationcellhome();
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
    public examinationcellhome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("WELCOME EXAMINER !!!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setBounds(61, 49, 293, 68);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("student Details");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                studentcheck gotopd = new studentcheck();
                gotopd.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBounds(266, 127, 133, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton(" Publish MARKS");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                markspublish gotomarks = new markspublish();
                gotomarks.setVisible(true);
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_1.setBounds(266, 161, 133, 23);
        contentPane.add(btnNewButton_1);
        
       /* *JButton btnNewButton_2 = new JButton("EXAM DUTY");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ExaminerPersonalSchedule gotoschedule = new ExaminerPersonalSchedule();
                gotoschedule.setVisible(true);
            }
        });
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_2.setBounds(265, 195, 134, 23);
        contentPane.add(btnNewButton_2);*/
        
        JButton btnNewButton_3 = new JButton("EXIT");
        btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_3.setBounds(266, 227, 133, 23);
        contentPane.add(btnNewButton_3);
    }
}


