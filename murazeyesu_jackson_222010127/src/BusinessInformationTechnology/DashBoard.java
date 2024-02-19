package BusinessInformationTechnology;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashBoard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
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
	public DashBoard() {
		setTitle("WE    ARE   APPRICIATED     TO   ACCESS    OUR    DASHBOARD     DEAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 663);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME OUR DASHBOARD");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 713, 75);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("EMPLOYEES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					Employees emp=new Employees();
					emp.frame.setVisible(true);
					dispose();
				} catch (Exception e2) {
					
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(2, 386, 307, 65);
		contentPane.add(btnNewButton);
		
		JButton btnAccommodation = new JButton("ACCOMMODATION");
		btnAccommodation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Accommodation acco= new Accommodation();
			acco.frame.setVisible(true);
			dispose();
				
				
				
				
				
				
				
				
			}
		});
		btnAccommodation.setForeground(new Color(0, 128, 255));
		btnAccommodation.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAccommodation.setBackground(new Color(255, 255, 128));
		btnAccommodation.setBounds(2, 237, 307, 75);
		contentPane.add(btnAccommodation);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1.setBounds(800, 498, 114, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Logout");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount acc=new CreateAccount();
				acc.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1_1.setBounds(763, 10, 151, 65);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnPayment = new JButton("PAYMENT");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment pa=new Payment();
				pa.frame.setVisible(true);
				dispose();
				
			}
		});
		btnPayment.setForeground(new Color(0, 128, 255));
		btnPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPayment.setBackground(new Color(255, 255, 128));
		btnPayment.setBounds(2, 310, 307, 75);
		contentPane.add(btnPayment);
		
		JButton btnTransport = new JButton("TRANSPORT");
		btnTransport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transport tr=new Transport();
				tr.frame.setVisible(true);
				dispose();
			}
		});
		btnTransport.setForeground(new Color(0, 128, 255));
		btnTransport.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnTransport.setBackground(new Color(255, 255, 128));
		btnTransport.setBounds(2, 162, 307, 75);
		contentPane.add(btnTransport);
		
		JButton btnTourist = new JButton("TOURIST");
		btnTourist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tourist to=new Tourist();
				to.frame.setVisible(true);
				dispose();
			}
		});
		btnTourist.setForeground(new Color(0, 128, 255));
		btnTourist.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnTourist.setBackground(new Color(255, 255, 128));
		btnTourist.setBounds(2, 88, 307, 75);
		contentPane.add(btnTourist);
	}
}
