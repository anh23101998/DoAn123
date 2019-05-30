package App;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import databaseConnection.DTBConn;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Color;

public class AppView {

	JFrame frame;
	private JTable table;
	private JTextField txtMaXe1;
	private JTextField textField_1;
	
	Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int month1 = month + 1;
    int day = c.get(Calendar.DAY_OF_MONTH);
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);
    int second = c.get(Calendar.SECOND);
    int millis = c.get(Calendar.MILLISECOND);
    static int count = 1;
    private JTable table_1;
    private JTextField txtMaXe2;
    private JTextField textField_3;
    private JTextField txtNote;
    private JTextField textField_2;
	protected Object frame3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView window = new AppView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}
		});
	}
	
	static java.sql.Connection connection = null;

	/**
	 * Create the application.
	 */
	public AppView() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connection = DTBConn.getDTBConn();
		
		frame = new JFrame();
		frame.setTitle("Parking");
		frame.setResizable(false);
		frame.setForeground(Color.YELLOW);
		frame.setFont(new Font("Arial", Font.BOLD, 23));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(AppView.class.getResource("/image/1.png")));
		frame.setBounds(100, 100, 1216, 778);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setFont(new Font("French Script MT", Font.BOLD, 25));
		menuBar.setToolTipText("");
		frame.setJMenuBar(menuBar);
		
		// Tạo các menuItem như File, Customer, Check, Help.
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnFile); 
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnCustomer = new JMenu("Customer");
		mnCustomer.setFont(new Font("Arial", Font.PLAIN, 18));
		mnCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnCustomer);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmAdd.setHorizontalAlignment(SwingConstants.CENTER);
		mnCustomer.add(mntmAdd);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete.NewScreen();
			}
		});
		
		mntmDelete.setHorizontalAlignment(SwingConstants.CENTER);
		mnCustomer.add(mntmDelete);
		
		JMenu mnCheck = new JMenu("Check");
		mnCheck.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnCheck);
		
		JMenuItem mntmCheckData = new JMenuItem("CheckData");
		mntmCheckData.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmCheckData.setHorizontalAlignment(SwingConstants.CENTER);
		
		mnCheck.add(mntmCheckData);
		
		JMenuItem mntmNumber = new JMenuItem("Number");
		mntmNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Number.NewScreen();
			}
		});
		mntmNumber.setHorizontalAlignment(SwingConstants.CENTER);
		mnCheck.add(mntmNumber);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ShowData");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select MaXe, Time, Date, Note From `baixe`.`new_table`";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
                 } catch (Exception ex) {
					ex.printStackTrace();
				 }}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnCheck.add(mntmNewMenuItem_1);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setHorizontalAlignment(SwingConstants.CENTER);
		mnHelp.setFont(new Font("Arial", Font.PLAIN, 18));
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Infomation");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "Đây là sản phẩm của nhóm HAH");
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		mnHelp.add(mntmNewMenuItem);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtMaXe1 = new JTextField();
		txtMaXe1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaXe1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaXe1.setEditable(false);
		txtMaXe1.setText("Mã Xe");
		txtMaXe1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã xe", "Time", "Date", "Note"
			}
		));
		
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		txtMaXe2 = new JTextField();
		txtMaXe2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaXe2.setText("Mã Xe");
		txtMaXe2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaXe2.setEditable(false);
		txtMaXe2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		
		// Tạo button Image1
		JButton btnImage1 = new JButton("Image1");
		btnImage1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnImage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lblNewLabel = new JLabel(" ");
				Object [] fina = new Object[5];
				String localDir = System.getProperty("user.dir");
				if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Chưa nhập mã xe");
				}
				else {
					fina = DTBConn.GetData(textField_3.getText()); 
					if(fina[0]==null)
					{
						JOptionPane.showMessageDialog(frame, "Mã xe không tồn tại");
					}
					 else {
					JFrame frameImagi = new JFrame(" 1 ");				
					fina = DTBConn.GetData(textField_3.getText());			
					lblNewLabel.setIcon(new ImageIcon(localDir + fina[0]));			
					frameImagi.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
					frameImagi.pack();
					frameImagi.setLocationRelativeTo(null);
					frameImagi.setVisible(true);
				}
				}
			}
		}); 
		
		// Tạo button Image2
		JButton btnImage2 = new JButton("Image2");
		btnImage2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnImage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lblNewLabel_1 = new JLabel(" ");
				Object [] fina = new Object[5];
				String localDir = System.getProperty("user.dir");
				if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Chưa nhập mã xe");
				}
				else {
					fina = DTBConn.GetData(textField_3.getText());
					if(fina[0]==null)
					{
						JOptionPane.showMessageDialog(frame, "Mã xe không tồn tại");
					}
					 else {
					JFrame frameImagi = new JFrame(" 2 ");				
					fina = DTBConn.GetData(textField_3.getText());				
            		lblNewLabel_1.setIcon(new ImageIcon(localDir + fina[1]));		
					frameImagi.getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
					frameImagi.pack();
					frameImagi.setLocationRelativeTo(null);
					frameImagi.setVisible(true);
				}
				}				
			}
		});
		
		txtNote = new JTextField();
		txtNote.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNote.setEditable(false);
		txtNote.setText("Note");
		txtNote.setHorizontalAlignment(SwingConstants.CENTER);
		txtNote.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("1");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("2");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtMaXe2)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtNote)
							.addComponent(txtMaXe1)
							.addComponent(btnImage2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnImage1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField_1)
							.addComponent(textField_3, Alignment.LEADING)))
					.addGap(152)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1)
								.addComponent(txtMaXe1, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_2)
								.addComponent(txtNote, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtMaXe2)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
							.addGap(48)
							.addComponent(btnImage1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(btnImage2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
					.addGap(69))
		);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Arial", Font.PLAIN, 16));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Time", "Date", "Note"
			}
		));
		scrollPane_1.setViewportView(table_1);
		frame.getContentPane().setLayout(groupLayout);
			
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int NumCols = table.getModel().getColumnCount();
				Object [] fina = new Object[NumCols];
				Object [] fin = new Object[6];
				String img1 = "/image/font" +textField_1.getText()+".png";
				String img2 = "/image/back" +textField_1.getText()+".png";
				if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Chưa nhập mã xe");
				}
				else {
					if(Integer.parseInt(textField_1.getText())< 100){
						fina[0] = textField_1.getText();
						fina[1] = hour +":"+ minute +":"+ second ;
						fina[2] = year +"-"+ month1 +"-"+ day;
						fina[3] = textField_2.getText();
						
						fin[0] = fina[0];
						fin[1] = img1;
						fin[2] = img2;
						fin[3] = hour +":"+ minute +":"+ second;
						fin[4] = year +"-"+ month1 +"-"+ day;
						fin[5] = fina[3];
						
						DTBConn.InsertData(fin);
						((DefaultTableModel) table.getModel()).addRow(fina);
					}					
					else{
						JOptionPane.showMessageDialog(frame, "Mã xe không hợp lệ");
					}
				}
			}
		});	
		
		mntmCheckData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object [] fina = new Object[5];
				Object [] fin = new Object[3];
				String localDir = System.getProperty("user.dir");
				if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Chưa nhập mã xe");
				}
				else {
					fina = DTBConn.GetData(textField_3.getText());
					if(fina[0]==null)
					{
						JOptionPane.showMessageDialog(frame, "Mã xe không tồn tại");
					}
					 else { 
					fina = DTBConn.GetData(textField_3.getText());	
					fin[0] = fina[2];
					fin[1] = fina[3];
					lblNewLabel_2.setIcon(new ImageIcon(localDir + fina[0]));
					lblNewLabel_3.setIcon(new ImageIcon(localDir + fina[1]));
					((DefaultTableModel) table_1.getModel()).addRow(fin);		
				     }
			     }
			}	
		});
	}
}
