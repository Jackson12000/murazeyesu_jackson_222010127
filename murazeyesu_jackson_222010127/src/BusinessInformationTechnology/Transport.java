package BusinessInformationTechnology;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
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

public class Transport {

	 JFrame frame;
	private JTextField totetxf;
	private JTextField tetxf;
	private JTextField trtxf;
	private JTextField tatxf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transport window = new Transport();
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
	public Transport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("TRANSPORT FORM    IN TOURISM SYSTEM ");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 924, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSPORT  HERE IN SYSTEM");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 878, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel totelb = new JLabel("TouristTelephone");
		totelb.setFont(new Font("Tahoma", Font.ITALIC, 35));
		totelb.setBounds(6, 173, 402, 37);
		frame.getContentPane().add(totelb);
		
		totetxf = new JTextField();
		totetxf.setColumns(10);
		totetxf.setBounds(11, 220, 397, 37);
		frame.getContentPane().add(totetxf);
		
		JLabel telb = new JLabel("TouristEmail");
		telb.setFont(new Font("Tahoma", Font.ITALIC, 35));
		telb.setBounds(6, 262, 402, 37);
		frame.getContentPane().add(telb);
		
		tetxf = new JTextField();
		tetxf.setColumns(10);
		tetxf.setBounds(11, 309, 397, 37);
		frame.getContentPane().add(tetxf);
		
		JLabel trlb = new JLabel("TouristResidental");
		trlb.setFont(new Font("Tahoma", Font.ITALIC, 35));
		trlb.setBounds(6, 349, 402, 37);
		frame.getContentPane().add(trlb);
		
		trtxf = new JTextField();
		trtxf.setColumns(10);
		trtxf.setBounds(11, 396, 397, 37);
		frame.getContentPane().add(trtxf);
		
		JLabel tcnlb = new JLabel("TransportCompanyName");
		tcnlb.setFont(new Font("Tahoma", Font.ITALIC, 35));
		tcnlb.setBounds(6, 443, 402, 37);
		frame.getContentPane().add(tcnlb);
		
		JRadioButton horizon = new JRadioButton("HORIZON");
		horizon.setBackground(new Color(255, 255, 128));
		buttonGroup.add(horizon);
		horizon.setForeground(new Color(0, 128, 255));
		horizon.setFont(new Font("Tahoma", Font.BOLD, 26));
		horizon.setBounds(11, 493, 165, 36);
		frame.getContentPane().add(horizon);
		
		JRadioButton volcano = new JRadioButton("VOLCANO");
		volcano.setBackground(new Color(255, 255, 128));
		buttonGroup.add(volcano);
		volcano.setForeground(new Color(0, 128, 255));
		volcano.setFont(new Font("Tahoma", Font.BOLD, 26));
		volcano.setBounds(225, 493, 183, 36);
		frame.getContentPane().add(volcano);
		
		JLabel lblNewLabel_1_4 = new JLabel("TimeArrival");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 35));
		lblNewLabel_1_4.setBounds(6, 533, 402, 37);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		tatxf = new JTextField();
		tatxf.setColumns(10);
		tatxf.setBounds(11, 580, 397, 37);
		frame.getContentPane().add(tatxf);
		
		JButton booking = new JButton("BOOKING");
		booking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
				String sql="INSERT INTO transport(tourist_telephone,tourist_email,tourist_residental,transport_comyany_name,time_arrival)  VALUES(?,?,?,?,?) ";
				PreparedStatement st=con.prepareStatement(sql);
				st.setString(1, totetxf.getText());
				st.setString(2, tetxf.getText());
				st.setString(3, trtxf.getText());
				if(horizon.isSelected())
					st.setString(4, horizon.getText());
				else
					st.setString(4, volcano.getText());
				st.setString(5, tatxf.getText());
				 st.executeUpdate();
				JOptionPane.showMessageDialog(booking, "data saved!!");
				st.close();
				con.close();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		booking.setBackground(new Color(255, 255, 128));
		booking.setForeground(new Color(0, 128, 255));
		booking.setFont(new Font("Tahoma", Font.BOLD, 20));
		booking.setBounds(415, 131, 145, 42);
		frame.getContentPane().add(booking);
		
		JButton view = new JButton("VIEW");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism_management_system","root","");
			java.sql.Statement st=con.createStatement();
			String query="SELECT * FROM transport";
			
			ResultSet rs=st.executeQuery(query);
			java.sql.ResultSetMetaData rsdm=rs.getMetaData();
			
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		int cols=rsdm.getColumnCount();
		String[]colName=new String[cols];
		for(int i=0;i<cols;i++)
			colName[i]=rsdm.getColumnName(i+1);
			
		model.setColumnIdentifiers(colName);
		String TansportID,TouristTelephone,TouristEmail,TouristResidental,TransportCompanyName,TimeArrival;
		while(rs.next()) 
		{
		TansportID=rs.getString(1);
		TouristTelephone=rs.getString(2);
		TouristEmail=rs.getString(3);
		TouristResidental=rs.getString(4);
		TransportCompanyName=rs.getString(5);
		TimeArrival=rs.getString(6);
		String[]row= {TansportID,TouristTelephone,TouristEmail,TouristResidental,TransportCompanyName,TimeArrival};
		model.addRow(row);
			
			
			
		}
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}		
				
				
				
				
				
				
				
				
				
				
			}
		});
		view.setForeground(new Color(0, 128, 255));
		view.setFont(new Font("Tahoma", Font.BOLD, 23));
		view.setBackground(new Color(255, 255, 128));
		view.setBounds(415, 174, 145, 42);
		frame.getContentPane().add(view);
		
		JButton change = new JButton("CHANGE");
		change.setForeground(new Color(0, 128, 255));
		change.setFont(new Font("Tahoma", Font.BOLD, 23));
		change.setBackground(new Color(255, 255, 128));
		change.setBounds(415, 219, 145, 42);
		frame.getContentPane().add(change);
		
		JButton reset = new JButton("RESET");
		reset.setForeground(new Color(0, 128, 255));
		reset.setFont(new Font("Tahoma", Font.BOLD, 23));
		reset.setBackground(new Color(255, 255, 128));
		reset.setBounds(415, 264, 145, 42);
		frame.getContentPane().add(reset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(418, 309, 492, 314);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\A330-300_Rwandair.jpg"));
		lblNewLabel_1.setBounds(368, 62, 542, 374);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
