package BusinessInformationTechnology;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CreateAccount {

	 JFrame frame;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField untxf;
	private JPasswordField passtxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(" CREATE YOUR ACCOUNT PLEASE DO NOT  FORGET  USER NAME AND PASSWORD FOR THOSE FORM IN TOURISM SYSTEM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 951, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT FORM");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 917, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		fnlb.setBounds(3, 142, 264, 65);
		frame.getContentPane().add(fnlb);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(270, 142, 362, 65);
		frame.getContentPane().add(fntxf);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		lnlb.setBounds(3, 223, 264, 67);
		frame.getContentPane().add(lnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(270, 223, 362, 67);
		frame.getContentPane().add(lntxf);
		
		JLabel unlb = new JLabel("UserName");
		unlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		unlb.setBounds(3, 303, 264, 67);
		frame.getContentPane().add(unlb);
		
		untxf = new JTextField();
		untxf.setColumns(10);
		untxf.setBounds(270, 303, 362, 67);
		frame.getContentPane().add(untxf);
		
		JLabel passlb = new JLabel("PassWord");
		passlb.setFont(new Font("Tahoma", Font.ITALIC, 55));
		passlb.setBounds(3, 378, 264, 64);
		frame.getContentPane().add(passlb);
		
		JButton signupbtn = new JButton("SIGNUP");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");	
			String sql="INSERT INTO siginup(first_name,last_name,user_name,pass_word) VALUES(?,?,?,?)";	
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, fntxf.getText());
			st.setString(2, lntxf.getText());
			st.setString(3, untxf.getText());
			st.setString(4, passtxf.getText());
			
					
			JOptionPane.showMessageDialog(signupbtn, "data saved");			
			st.executeUpdate();
			
			
			con.close();
			st.close();
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
				
			}
		});
		signupbtn.setForeground(new Color(0, 128, 255));
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		signupbtn.setBounds(214, 473, 115, 62);
		frame.getContentPane().add(signupbtn);
		
		JButton Cancelbtn = new JButton("CANCEL");
		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			fntxf.setText(null);
			lntxf.setText(null);
			untxf.setText(null);
			passtxf.setText(null);
				
				
			}
		});
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Cancelbtn.setBounds(454, 473, 115, 62);
		frame.getContentPane().add(Cancelbtn);
		
		passtxf = new JPasswordField();
		passtxf.setBounds(270, 381, 362, 61);
		frame.getContentPane().add(passtxf);
		
		JButton viewbtn = new JButton("VIEW");
		viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
			java.sql.Statement st=con.createStatement();
			String query="SELECT * FROM siginup";
			
			ResultSet rs=st.executeQuery(query);
			java.sql.ResultSetMetaData rsdm=rs.getMetaData();
			
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int cols=rsdm.getColumnCount();
		String[]colName=new String[cols];
		for(int i=0;i<cols;i++)
			colName[i]=rsdm.getColumnName(i+1);
			
		model.setColumnIdentifiers(colName);
		String ID,FirstName,LastName,UserName,passWord;
		while(rs.next()) 
		{
		ID=rs.getString(1);
		FirstName=rs.getString(2);
		LastName=rs.getString(3);
		UserName=rs.getString(4);
		passWord=rs.getString(5);
		String[]row= {ID,FirstName,LastName,UserName,passWord};
		model.addRow(row);
			
			
			
		}
		
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}		
				
				
				
				
			}
		});
		viewbtn.setForeground(new Color(0, 128, 255));
		viewbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		viewbtn.setBounds(335, 473, 115, 62);
		frame.getContentPane().add(viewbtn);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(642, 138, 285, 397);
		frame.getContentPane().add(table);
		
		JLabel lblPleaseDoNot = new JLabel("PLEASE DO NOT FORGET USERNAME AND PASSWORD");
		lblPleaseDoNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseDoNot.setForeground(new Color(255, 0, 0));
		lblPleaseDoNot.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 28));
		lblPleaseDoNot.setBounds(0, 76, 917, 56);
		frame.getContentPane().add(lblPleaseDoNot);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logins lo=new logins();
				lo.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(852, 0, 85, 35);
		frame.getContentPane().add(btnNewButton);
	}
}
