package BusinessInformationTechnology;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Employees {

	 JFrame frame;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField potxf;
	private JTextField pntxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees window = new Employees();
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
	public Employees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("EMPLOYEES        FORM    IN TOURISM MANAGEMENT SYSTEM  ");
			frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1065, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOME FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 21, 667, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setFont(new Font("Dialog", Font.ITALIC, 35));
		fnlb.setBounds(13, 165, 272, 39);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setFont(new Font("Dialog", Font.ITALIC, 35));
		lnlb.setBounds(15, 246, 270, 39);
		frame.getContentPane().add(lnlb);
		
		fntxf = new JTextField();
		fntxf.setFont(new Font("Dialog", Font.ITALIC, 30));
		fntxf.setColumns(10);
		fntxf.setBounds(13, 204, 363, 45);
		frame.getContentPane().add(fntxf);
		
		lntxf = new JTextField();
		lntxf.setFont(new Font("Dialog", Font.ITALIC, 30));
		lntxf.setColumns(10);
		lntxf.setBounds(15, 286, 363, 45);
		frame.getContentPane().add(lntxf);
		
		JLabel emalb = new JLabel("Email");
		emalb.setFont(new Font("Dialog", Font.ITALIC, 35));
		emalb.setBounds(13, 333, 272, 39);
		frame.getContentPane().add(emalb);
		
		ematxf = new JTextField();
		ematxf.setFont(new Font("Dialog", Font.ITALIC, 30));
		ematxf.setColumns(10);
		ematxf.setBounds(13, 375, 363, 49);
		frame.getContentPane().add(ematxf);
		
		JLabel polb = new JLabel("Position");
		polb.setFont(new Font("Dialog", Font.ITALIC, 35));
		polb.setBounds(12, 431, 273, 39);
		frame.getContentPane().add(polb);
		
		potxf = new JTextField();
		potxf.setFont(new Font("Dialog", Font.ITALIC, 30));
		potxf.setColumns(10);
		potxf.setBounds(13, 474, 363, 45);
		frame.getContentPane().add(potxf);
		
		JLabel pnlb = new JLabel("PhoneNumber");
		pnlb.setFont(new Font("Dialog", Font.ITALIC, 35));
		pnlb.setBounds(10, 520, 275, 39);
		frame.getContentPane().add(pnlb);
		
		pntxf = new JTextField();
		pntxf.setFont(new Font("Dialog", Font.ITALIC, 30));
		pntxf.setColumns(10);
		pntxf.setBounds(10, 566, 363, 45);
		frame.getContentPane().add(pntxf);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");	
				String sql="INSERT INTO employees(first_name,last_name,email,position,phone_number) VALUES(?,?,?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, fntxf.getText());
				st.setString(2, lntxf.getText());
				st.setString(3, ematxf.getText());
				st.setString(4, potxf.getText());
				st.setString(5, pntxf.getText());
				
				st.executeUpdate();
				JOptionPane.showMessageDialog(addbtn, "information saved!!");
				con.close();
				st.close();
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
			}
		});
		addbtn.setForeground(new Color(0, 128, 255));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		addbtn.setBackground(new Color(255, 255, 128));
		addbtn.setBounds(393, 121, 169, 45);
		frame.getContentPane().add(addbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
			java.sql.Statement st=con.createStatement();
			String query="SELECT * FROM employees";
			
			ResultSet rs=st.executeQuery(query);
			java.sql.ResultSetMetaData rsdm=rs.getMetaData();
			
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int cols=rsdm.getColumnCount();
		String[]colName=new String[cols];
		for(int i=0;i<cols;i++)
			colName[i]=rsdm.getColumnName(i+1);
			
		model.setColumnIdentifiers(colName);
		String ID,FirstName,LastName,Email,Position,phoneNumber;
		while(rs.next()) 
		{
		ID=rs.getString(1);
		FirstName=rs.getString(2);
		LastName=rs.getString(3);
		Email=rs.getString(4);
		Position=rs.getString(5);
		phoneNumber=rs.getString(6);
		String[]row= {ID,FirstName,LastName,Email,Position,phoneNumber};
		model.addRow(row);
			
			
			
		}
			
			
			
			
			
			
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}		
				
				
				
				
				
			}
		});
		Viewbtn.setForeground(new Color(0, 128, 255));
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.setBounds(393, 182, 169, 45);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
					String sql="UPDATE employees SET first_name=?,last_name=?,email=?,position=?,phone_number=? WHERE id=?";	
					PreparedStatement st=con.prepareStatement(sql);
					st.setString(1, fntxf.getText());
					st.setString(2, lntxf.getText());
					st.setString(3, ematxf.getText());
					st.setString(4, potxf.getText());
					st.setString(5, pntxf.getText());
					
					st.executeUpdate();
					JOptionPane.showMessageDialog(Updatebtn, "data saved!!");
					con.close();
					st.close();
					
					
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Updatebtn.setForeground(new Color(0, 128, 255));
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setBounds(393, 237, 169, 48);
		frame.getContentPane().add(Updatebtn);
		
		JButton Searchbtn = new JButton("SEARCH");
		Searchbtn.setForeground(new Color(0, 128, 255));
		Searchbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Searchbtn.setBackground(new Color(255, 255, 128));
		Searchbtn.setBounds(393, 292, 169, 51);
		frame.getContentPane().add(Searchbtn);
		
		JButton Resetbtn = new JButton("RESET");
		Resetbtn.setForeground(new Color(0, 128, 255));
		Resetbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		Resetbtn.setBackground(new Color(255, 255, 128));
		Resetbtn.setBounds(393, 353, 169, 45);
		frame.getContentPane().add(Resetbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(572, 117, 479, 524);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\PHOTOSHOP ACTIONS\\edited finishing photo\\IMG-20240130-WA0040.jpg"));
		lblNewLabel_1.setBounds(282, 118, 291, 523);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(785, 31, 256, 58);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\PHOTOSHOP ACTIONS\\edited finishing photo\\IMG-20240131-WA0024.jpg"));
		lblNewLabel_3.setBounds(769, 0, 282, 115);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard dash=new DashBoard();
				dash.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(0, 0, 123, 51);
		frame.getContentPane().add(btnBack);
	}
}
