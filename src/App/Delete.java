package App;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import databaseConnection.DTBConn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Delete {

	private JFrame frame1;
	private JTextField txtMXe;
	private JTextField textField_1;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {		
			@Override
			public void run() {
				try
				{
				Delete window = new Delete();
				window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage(Delete.class.getResource("/image/1.png")));
		frame1.setBounds(100, 100, 600, 400);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtMXe = new JTextField();
		txtMXe.setBounds(50, 54, 145, 68);
		txtMXe.setEditable(false);
		txtMXe.setHorizontalAlignment(SwingConstants.CENTER);
		txtMXe.setText("Mã xe");
		txtMXe.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(366, 54, 144, 68);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		frame1.getContentPane().setLayout(null);
		frame1.getContentPane().add(txtMXe);
		frame1.getContentPane().add(textField_1);
		
		
		// Tạo lệnh của button Delete
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DTBConn.DeleteData(textField_1.getText());
				textField_1.setText("");
				JOptionPane.showMessageDialog(frame1, "Xóa thành công");
			}		 
		});
				  
		btnNewButton.setBounds(217, 193, 123, 68);
		frame1.getContentPane().add(btnNewButton);
	}
}
