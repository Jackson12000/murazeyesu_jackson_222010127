package BusinessInformationTechnology;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
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
import javax.swing.ButtonGroup;

public class Accommodation {

	 JFrame frame;
	private JTextField retxf;
	private JTextField tetxf;
	private JTextField getxf;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accommodation window = new Accommodation();
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
	public Accommodation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ACCOMMODATION           FORM    IN  TOURISM    SYSTEM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1061, 672);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOMMODATION FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 0, 843, 62);
		frame.getContentPane().add(lblNewLabel);
		
		retxf = new JTextField();
		retxf.setColumns(10);
		retxf.setBounds(10, 243, 433, 43);
		frame.getContentPane().add(retxf);
		
		JLabel relb = new JLabel("Residental");
		relb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		relb.setBounds(10, 198, 219, 35);
		frame.getContentPane().add(relb);
		
		tetxf = new JTextField();
		tetxf.setColumns(10);
		tetxf.setBounds(10, 335, 433, 43);
		frame.getContentPane().add(tetxf);
		
		JLabel telb = new JLabel("TouristEmail");
		telb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		telb.setBounds(10, 290, 219, 35);
		frame.getContentPane().add(telb);
		
		getxf = new JTextField();
		getxf.setColumns(10);
		getxf.setBounds(10, 428, 433, 43);
		frame.getContentPane().add(getxf);
		
		JLabel gelb = new JLabel("Gender");
		gelb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		gelb.setBounds(10, 383, 219, 35);
		frame.getContentPane().add(gelb);
		
		JLabel rolb = new JLabel("Room");
		rolb.setFont(new Font("Tahoma", Font.ITALIC, 25));
		rolb.setBounds(10, 472, 219, 35);
		frame.getContentPane().add(rolb);
		
		JRadioButton flowonebtn = new JRadioButton("Flow One");
		buttonGroup.add(flowonebtn);
		flowonebtn.setBackground(new Color(0, 128, 255));
		flowonebtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		flowonebtn.setBounds(6, 520, 210, 35);
		frame.getContentPane().add(flowonebtn);
		
		JRadioButton flowtwobtn = new JRadioButton("Flow Two");
		buttonGroup.add(flowtwobtn);
		flowtwobtn.setBackground(new Color(0, 128, 255));
		flowtwobtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		flowtwobtn.setBounds(233, 520, 210, 35);
		frame.getContentPane().add(flowtwobtn);
		
		JButton addbtn = new JButton("ADD");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard das=new DashBoard();
				das.setVisible(true);
				frame.dispose();
				
				
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
				String sql="INSERT INTO accommodation(residental,tourist_email,gender,room)  VALUES(?,?,?,?) ";
				PreparedStatement st=con.prepareStatement(sql);
				
				st.setString(1, retxf.getText());
				st.setString(2, tetxf.getText());
				st.setString(3, getxf.getText());
				 if(flowonebtn.isSelected())
					 st.setString(4, flowonebtn.getText());
				 else
					 st.setString(4, flowtwobtn.getText());
				 st.executeUpdate();
				JOptionPane.showMessageDialog(addbtn, "data saved!!");
				
				
				
				st.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
			}
		});
		addbtn.setBackground(new Color(255, 255, 128));
		addbtn.setForeground(new Color(0, 128, 255));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		addbtn.setBounds(7, 573, 91, 52);
		frame.getContentPane().add(addbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM accommodation";
				
				ResultSet rs=st.executeQuery(query);
				java.sql.ResultSetMetaData rsdm=rs.getMetaData();
				
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsdm.getColumnCount();
			String[]colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsdm.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			String ID,residental,touristEmail,gender,room;
			while(rs.next()) 
			{
			ID=rs.getString(1);
		residental=rs.getString(2);
			touristEmail=rs.getString(3);
		gender=rs.getString(4);
		room=rs.getString(5);
			String[]row= {ID,residental,touristEmail,gender,room};
			model.addRow(row);
				
				
				
			}
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.setForeground(new Color(0, 128, 255));
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		Viewbtn.setBounds(103, 573, 91, 52);
		frame.getContentPane().add(Viewbtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.setBackground(new Color(255, 255, 128));
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		Deletebtn.setBounds(319, 573, 124, 52);
		frame.getContentPane().add(Deletebtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.setBackground(new Color(255, 255, 128));
		Updatebtn.setForeground(new Color(0, 128, 255));
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		Updatebtn.setBounds(198, 573, 116, 52);
		frame.getContentPane().add(Updatebtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(614, 81, 433, 544);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\PHOTOSHOP ACTIONS\\edited finishing photo\\1629313408-49-kigali-city-tower.jpg"));
		lblNewLabel_1.setBounds(293, 72, 600, 551);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DashBoard dash=new DashBoard();
				dash.setVisible(true);
				frame.dispose();
				
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(0, 0, 107, 52);
		frame.getContentPane().add(btnBack);
	}
}
