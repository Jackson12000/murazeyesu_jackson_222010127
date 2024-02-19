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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Tourist {

	 JFrame frame;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField teletxf;
	private JTextField natxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tourist window = new Tourist();
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
	public Tourist() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Felix Titling", Font.BOLD | Font.ITALIC, 10));
		frame.setTitle("TOURIST           FORM       IN   TOURISM        MANAGEMENT      SYSTEM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 980, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOURIST FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 636, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("FirstName");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 34));
		lblNewLabel_1_1.setBounds(10, 178, 171, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(209, 174, 339, 45);
		frame.getContentPane().add(fntxf);
		
		JLabel lblNewLabel_1_2 = new JLabel("LastName");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 34));
		lblNewLabel_1_2.setBounds(10, 233, 171, 31);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(209, 228, 339, 44);
		frame.getContentPane().add(lntxf);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 34));
		lblNewLabel_1_3.setBounds(10, 290, 171, 31);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(209, 285, 339, 44);
		frame.getContentPane().add(ematxf);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telephone");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 34));
		lblNewLabel_1_4.setBounds(10, 356, 171, 31);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		teletxf = new JTextField();
		teletxf.setColumns(10);
		teletxf.setBounds(209, 352, 339, 44);
		frame.getContentPane().add(teletxf);
		
		JLabel lblNewLabel_1_5 = new JLabel("Nationality");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.ITALIC, 34));
		lblNewLabel_1_5.setBounds(10, 416, 171, 31);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		natxf = new JTextField();
		natxf.setColumns(10);
		natxf.setBounds(209, 412, 339, 44);
		frame.getContentPane().add(natxf);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(128, 255, 255));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblWelcome.setBounds(720, 55, 246, 43);
		frame.getContentPane().add(lblWelcome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(571, 118, 395, 472);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
				String sql="INSERT INTO tourist(first_name,last_name,email,phone,nationality) VALUES(?,?,?,?,?)";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, fntxf.getText());
				st.setString(2, lntxf.getText());
				st.setString(3, ematxf.getText());
				st.setString(4, teletxf.getText());
				st.setString(5, natxf.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(addbtn, "data saved!!!");
				con.close();
				st.close();
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
			}
		});
		addbtn.setBackground(new Color(255, 255, 128));
		addbtn.setForeground(new Color(0, 0, 255));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 40));
		addbtn.setBounds(121, 469, 201, 54);
		frame.getContentPane().add(addbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM tourist";
				
				ResultSet rs=st.executeQuery(query);
				java.sql.ResultSetMetaData rsdm=rs.getMetaData();
				
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsdm.getColumnCount();
			String[]colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsdm.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			String ID,FirstName,LastName,Email,PhoneNumber,Nationality;
			while(rs.next()) 
			{
			ID=rs.getString(1);
			FirstName=rs.getString(2);
			LastName=rs.getString(3);
			Email=rs.getString(4);
			PhoneNumber=rs.getString(5);
			Nationality=rs.getString(6);
			String[]row= {ID,FirstName,LastName,Email,PhoneNumber,Nationality};
			model.addRow(row);
				
				
				
			}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
			}
		});
		Viewbtn.setForeground(Color.BLUE);
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 40));
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.setBounds(353, 469, 195, 54);
		frame.getContentPane().add(Viewbtn);
		
		JButton Changebtn = new JButton("CHANGE");
		Changebtn.setForeground(Color.BLUE);
		Changebtn.setFont(new Font("Tahoma", Font.BOLD, 35));
		Changebtn.setBackground(new Color(255, 255, 128));
		Changebtn.setBounds(121, 533, 201, 57);
		frame.getContentPane().add(Changebtn);
		
		JButton Exitbtn = new JButton("EXIT");
		Exitbtn.setForeground(Color.BLUE);
		Exitbtn.setFont(new Font("Tahoma", Font.BOLD, 40));
		Exitbtn.setBackground(new Color(255, 255, 128));
		Exitbtn.setBounds(353, 529, 195, 61);
		frame.getContentPane().add(Exitbtn);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\red flower.png"));
		lblNewLabel_2.setBounds(646, -3, 320, 258);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard acc=new DashBoard();
				acc.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(-82, 512, 195, 54);
		frame.getContentPane().add(btnBack);
	}
}
