package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Log_in extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JTextField txtPassword;
	private JPasswordField pwdPassWord;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in frame = new Log_in();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Log_in() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Pictures\\Screenshot 2024-01-24 120455.png"));
		setFont(new Font("Cambria Math", Font.PLAIN, 15));
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 151, 104));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 388);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		
		
		
		
		txtPassword = new JTextField();
		txtPassword.setBorder(null);
		txtPassword.setBounds(364, 170, 134, 20);
		txtPassword.setBackground(new Color(193, 151, 104));
		txtPassword.setForeground(new Color(0, 0, 0));
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(0, 0, 0));
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(193, 151, 104));
		txtUsername.setBounds(364, 139, 134, 20);
		contentPane.add(txtUsername);
	
		
		pwdPassWord = new JPasswordField();
		pwdPassWord.setText("Pass word");
		pwdPassWord.setBorder(null);
		pwdPassWord.setBounds(375, 170, 123, 20);
		pwdPassWord.setToolTipText("\r\n");
		pwdPassWord.setBackground(new Color(193, 151, 104));
		contentPane.add(pwdPassWord);
		
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(204, 166, 132));
		separator.setBounds(364, 159, 134, 10);
		separator.setBackground(new Color(0, 0, 0));
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(204, 166, 132));
		separator_1.setBounds(364, 191, 134, 10);
		separator_1.setBackground(Color.BLACK);
		contentPane.add(separator_1);
		
		
		
		JButton JButtonLogin = new JButton("Login");
		JButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButtonLogin.setBackground(new Color(131, 162, 243));
		JButtonLogin.setForeground(new Color(0, 0, 0));
		JButtonLogin.setBounds(357, 224, 73, 20);
		contentPane.add(JButtonLogin);
		panel.setLayout(null);
		
		JLabel lblFlowerStore = new JLabel("FLOWER STORE");
		lblFlowerStore.setBounds(42, 30, 177, 60);
		lblFlowerStore.setForeground(new Color(0, 0, 0));
		lblFlowerStore.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 23));
		panel.add(lblFlowerStore);
		
		JLabel lblDalat = new JLabel("DALAT");
		lblDalat.setBounds(92, 11, 79, 49);
		lblDalat.setForeground(Color.BLACK);
		lblDalat.setFont(new Font("Yu Gothic Light", Font.PLAIN, 24));
		panel.add(lblDalat);
		
		JLabel lblAdress = new JLabel("480 Tran Dai Nghia, Hoa Quy, Da Nang City");
		lblAdress.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblAdress.setBounds(25, 349, 239, 14);
		panel.add(lblAdress);
		
		JLabel lblHotline = new JLabel("Hotline: 0363489034");
		lblHotline.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblHotline.setBounds(73, 363, 181, 14);
		panel.add(lblHotline);
		
		JLabel lblAnh = new JLabel("");
		lblAnh.setBounds(0, 0, 264, 388);
		lblAnh.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Screenshot 2024-01-14 002102.png"));
		panel.add(lblAnh);
		
		JLabel lblSaleManagement = new JLabel("SALES MANAGEMENT");
		lblSaleManagement.setBackground(new Color(255, 0, 128));
		lblSaleManagement.setForeground(new Color(0, 0, 0));
		lblSaleManagement.setToolTipText("");
		lblSaleManagement.setFont(new Font("Garamond", Font.BOLD, 20));
		lblSaleManagement.setBorder(null);
		lblSaleManagement.setBounds(289, 94, 223, 34);
		contentPane.add(lblSaleManagement);
		
		JLabel lblUsername = new JLabel("User Name: ");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBackground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Garamond", Font.PLAIN, 14));
		lblUsername.setBounds(289, 142, 88, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Pass word: ");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Garamond", Font.PLAIN, 14));
		lblPassword.setBounds(290, 173, 87, 14);
		contentPane.add(lblPassword);
		
	
		JButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUsername.getText();
				String pass = txtPassword.getText();
				
				if(user.equals("nhuy") && pass.equals("999")) {
					JOptionPane.showConfirmDialog(null,"DANG NHAP THANH CONG",
			    			null,JOptionPane.CLOSED_OPTION);
					
					Sale_Management Sales_Management = new Sale_Management();
					Sales_Management .setVisible(true);
					
				
				}
				else 
			              JOptionPane.showMessageDialog(null,
	                "Có thể username hoặc password của bạn không đúng"
	                ,
	                "ERROR",
	                JOptionPane.ERROR_MESSAGE);
			}
		});

		
	}
}



