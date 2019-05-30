package App;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Number {

	private JFrame frame4;
	private JTextField textField;
	private JTextField txtSLng;
	
	final static String url = "jdbc:mysql://localhost:3306/baixe?useSSL=false";
	final static String user = "root";
	final static String password = "anh23101998";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Number window = new Number();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static String a;
	public static int b;
	
	public static String ten() {
		Connection con=null;
		Statement stmt=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			try {		
				stmt = con.createStatement();
				String query = "SELECT COUNT(*) FROM new_table";
				ResultSet rs=stmt.executeQuery(query);							
				while(rs.next()){
				    System.out.println("Số xe là : "+rs.getInt("COUNT(*)"));	
				    b = rs.getInt("COUNT(*)");
				    a = String.valueOf(b);
				  }	
				rs.close();			
			} catch(SQLException s){						
				s.printStackTrace();
			 }
		} catch (Exception e){
			e.printStackTrace();
		 }
		return a;
	}

	/**
	 * Create the application.
	 */
	public Number() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame4 = new JFrame();
		frame4.setIconImage(Toolkit.getDefaultToolkit().getImage(Number.class.getResource("/image/1.png")));
		frame4.setType(Type.POPUP);
		frame4.setTitle("Số lượng xe trong bãi");
		frame4.setBounds(100, 100, 625, 400);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		
		txtSLng = new JTextField();
		txtSLng.setEditable(false);
		txtSLng.setText("Số lượng");
		txtSLng.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLng.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(ten());
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame4.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(txtSLng, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(247)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField)
						.addComponent(txtSLng, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(58)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		frame4.getContentPane().setLayout(groupLayout);
	}

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Number window = new Number();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
