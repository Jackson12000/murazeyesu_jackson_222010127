package BusinessInformationTechnology;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.awt.event.ActionEvent;

public class Payment {

	 JFrame frame;
	private JTextField pmtxf;
	private JTextField patxf;
	private JTextField pdtxf;
	private JTextField tetxf;
	private JTable table;
	private JTextField ttetxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
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
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PAYMENT      FORM    IN   TOURISM MANAGEMENT    SYSTEM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 938, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT FORM IS HERE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(198, -7, 383, 72);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel_1.setBounds(741, 9, 195, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel pmlb = new JLabel("PaymentMethod");
		pmlb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		pmlb.setBounds(20, 125, 226, 39);
		frame.getContentPane().add(pmlb);
		
		pmtxf = new JTextField();
		pmtxf.setColumns(10);
		pmtxf.setBounds(20, 162, 362, 39);
		frame.getContentPane().add(pmtxf);
		
		JLabel palb = new JLabel("PaymentAmount");
		palb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		palb.setBounds(20, 200, 226, 39);
		frame.getContentPane().add(palb);
		
		patxf = new JTextField();
		patxf.setColumns(10);
		patxf.setBounds(20, 239, 362, 39);
		frame.getContentPane().add(patxf);
		
		JLabel pdlb = new JLabel("PaymentDate");
		pdlb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		pdlb.setBounds(20, 272, 226, 39);
		frame.getContentPane().add(pdlb);
		
		pdtxf = new JTextField();
		pdtxf.setColumns(10);
		pdtxf.setBounds(20, 311, 362, 39);
		frame.getContentPane().add(pdtxf);
		
		JLabel telb = new JLabel("TouristEmail");
		telb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		telb.setBounds(20, 348, 226, 39);
		frame.getContentPane().add(telb);
		
		tetxf = new JTextField();
		tetxf.setColumns(10);
		tetxf.setBounds(20, 387, 362, 39);
		frame.getContentPane().add(tetxf);
		
		JButton sendbtn = new JButton("SEND");
		sendbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
				String sql="INSERT INTO payment(payment_method,payment_amount,payment_date,tourist_emaail,tourist_name) VALUES(?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			
			st.setString(1, pmtxf.getText());
			st.setString(2, patxf.getText());
			st.setString(3, pdtxf.getText());
			st.setString(4, tetxf.getText());
			st.setString(5, ttetxf.getText());
			JOptionPane.showMessageDialog(sendbtn, "has been paid all service!!");
			st.executeUpdate();
			con.close();
			st.close();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		sendbtn.setBackground(new Color(255, 255, 128));
		sendbtn.setForeground(new Color(0, 128, 255));
		sendbtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		sendbtn.setBounds(20, 518, 117, 44);
		frame.getContentPane().add(sendbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");		
				String sql="SELECT * FROM payment";
				
				java.sql.Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				java.sql.ResultSetMetaData rsdm=rs.getMetaData();
				
			DefaultTableModel model=(DefaultTableModel)table.getModel();
			int cols=rsdm.getColumnCount();
			String[]colName=new String[cols];
			for(int i=0;i<cols;i++)
				colName[i]=rsdm.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			String paymentID,PaymentMethod,PaymentAmount,PaymentDate,TouristEmail,TouristName;
			while(rs.next())
			{
				
			paymentID=rs.getString(1);
			PaymentMethod=rs.getString(2);
			PaymentAmount=rs.getString(3);
			PaymentDate=rs.getString(4);
			TouristEmail=rs.getString(5);
			TouristName=rs.getString(6);
			String[]row= {paymentID,PaymentMethod,PaymentAmount,PaymentDate,TouristEmail,TouristName};
			model.addRow(row);
				
				
				
				
				
				
				
				
				
				
			}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
			}
		});
		Viewbtn.setForeground(new Color(0, 128, 255));
		Viewbtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.setBounds(141, 518, 117, 44);
		frame.getContentPane().add(Viewbtn);
		
		JButton Exitbtn = new JButton("EXIT");
		Exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			pmtxf.setText(null);
			patxf.setText(null);
			pdtxf.setText(null);
			tetxf.setText(null);
			ttetxf.setText(null);
				
			}
		});
		Exitbtn.setForeground(new Color(0, 128, 255));
		Exitbtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Exitbtn.setBackground(new Color(255, 255, 128));
		Exitbtn.setBounds(265, 518, 117, 44);
		frame.getContentPane().add(Exitbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 88, 522, 474);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JLabel ttelb = new JLabel("TouristtName");
		ttelb.setFont(new Font("Tahoma", Font.ITALIC, 30));
		ttelb.setBounds(20, 430, 294, 39);
		frame.getContentPane().add(ttelb);
		
		ttetxf = new JTextField();
		ttetxf.setColumns(10);
		ttetxf.setBounds(20, 469, 362, 39);
		frame.getContentPane().add(ttetxf);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard dash=new DashBoard();
				dash.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(new Color(0, 128, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(0, 0, 117, 37);
		frame.getContentPane().add(btnBack);
	}
}
