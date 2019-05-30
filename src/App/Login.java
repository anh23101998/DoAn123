package App;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login {

	private JFrame frame3;
	private JTextField Login;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(); 
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/1.png")));
		frame3.setAlwaysOnTop(true);
		frame3.setBounds(100, 100, 702, 435);
		frame3.setLocationRelativeTo(null);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(242, 13, 199, 52);
		frame3.getContentPane().add(lblNewLabel);
		
		Login = new JTextField();
		Login.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Login.setBounds(284, 103, 266, 48);
		frame3.getContentPane().add(Login);
		Login.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(75, 102, 139, 44);
		frame3.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(75, 184, 139, 44);
		frame3.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(284, 280, 139, 52);
		frame3.getContentPane().add(btnNewButton);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Password.setBounds(284, 185, 266, 44);
		frame3.getContentPane().add(Password);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String UserName = Login.getText();
				@SuppressWarnings("deprecation")
				String PassWord = Password.getText();
				if(UserName.equals("") || PassWord.equals("") ) {
					JOptionPane.showMessageDialog(frame3, "Chưa nhập tài khoản hoặc mật khẩu");
				}
				else {
					if (PassWord.contains("123456") && UserName.contains("admin")) {			
				
						AppView app = new AppView();
						app.frame.setVisible(true);
						frame3.setVisible(false);		
				    }
				    else {
					JOptionPane.showMessageDialog(frame3, "Đăng nhập thất bại");
				    }
				}
			}
		});
	}
}