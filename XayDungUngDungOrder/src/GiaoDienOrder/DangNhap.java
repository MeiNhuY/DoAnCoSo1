package GiaoDienOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.mysql.cj.protocol.Resultset;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JPasswordField passDN;
	private JTextField tfTenDN;
	static Connection con;
	static Statement stmt;
	private JTextField tfSDT;
	private JTextField tfMaCH1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void LayDuLieuDangNhap() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/app_order?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt= con.createStatement();
			String sql = "SELECT * FROM nhanvien where Ten=?  and maCH=? and matkhau=? and sdt=?";	
		    PreparedStatement ps = con.prepareStatement(sql);				
		    ps.setString(1, tfTenDN.getText());
		    ps.setString(2, tfMaCH1.getText());
		    ps.setString(3, passDN.getText());
		    ps.setString(4, tfSDT.getText());
		    ResultSet rs = ps.executeQuery();								  
		    
		    
		    if (tfTenDN.getText().equals("") |tfMaCH1.getText().equals("") |passDN.getText().equals("")|tfSDT.getText().equals("")) {
		    	JOptionPane.showMessageDialog(this, "Chưa nhập tên và mật khẩu và SDT");
		    } else if (rs.next()) {
		    	GiaoDienChinh giaodienchinh = new GiaoDienChinh();
		    	giaodienchinh.setVisible(true);
		    	JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
		    } else {
		    	JOptionPane.showMessageDialog(this, "Có thể tên hoặc mật khẩu không đúng. Vui lòng thử lại");
		    }	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void addPlaceholderStyles(JTextField textFiled) {
		Font font = textFiled.getFont();
		font = font.deriveFont(Font.ITALIC);
		textFiled.setFont(font);
		textFiled.setForeground(new Color(128, 128, 128));
	}
	
	public void removePlaceholderStyles(JTextField textFiled) {
		Font font = textFiled.getFont();
		font = font.deriveFont(Font.PLAIN|Font.BOLD);
		textFiled.setFont(font);
		textFiled.setForeground(Color.black);	
	}
	
	
	public DangNhap() {
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 518, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDANG_KY = new JLabel("ĐĂNG NHẬP");
		lblDANG_KY.setBounds(160, 111, 225, 60);
		lblDANG_KY.setForeground(new Color(189, 9, 45));
		lblDANG_KY.setFont(new Font("Calibri", Font.BOLD, 39));
		lblDANG_KY.setBackground(new Color(218, 165, 32));
		panel.add(lblDANG_KY);
		
		
		tfTenDN = new JTextField();
		tfTenDN.setText("Tên đăng nhập");
		tfTenDN.setBounds(146, 224, 273, 31);
		tfTenDN.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfTenDN.setOpaque(false); //trong suot
		tfTenDN.setBorder(null);
		panel.add(tfTenDN);
		tfTenDN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfTenDN.getText().equals("Tên đăng nhập")) {
					tfTenDN.setText(null);
					tfTenDN.requestFocus();
					removePlaceholderStyles(tfTenDN);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfTenDN.getText().length()==0) {
					addPlaceholderStyles(tfTenDN);
					tfTenDN.setText("Tên đăng nhập");
				}
			}
		});
		
		tfMaCH1 = new JTextField();
		tfMaCH1.setText("Mã cửa hàng: DN9***");
		tfMaCH1.setOpaque(false);
		tfMaCH1.setForeground(Color.GRAY);
		tfMaCH1.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfMaCH1.setBorder(null);
		tfMaCH1.setBounds(146, 285, 261, 36);
		panel.add(tfMaCH1);
		tfMaCH1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfMaCH1.getText().equals("Mã cửa hàng: DN9***")) {
				   tfMaCH1.setText(null);
				   tfMaCH1.requestFocus();
				   removePlaceholderStyles(tfMaCH1);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfMaCH1.getText().length()==0) {
				   addPlaceholderStyles(tfMaCH1);
				   tfMaCH1.setText("Mã cửa hàng: DN9***");
				   
				   String maCH = tfMaCH1.getText().trim();
	                if (!maCH.matches("DN9\\d{3}")) {
	                    JOptionPane.showMessageDialog(DangNhap.this, "Mã cửa hàng không hợp lệ! Vui lòng nhập theo mẫu DN9***", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                    tfMaCH1.requestFocus();
	                }
				}
			}
		});
		
		
		passDN = new JPasswordField();
		passDN.setForeground(new Color(128, 128, 128));
		passDN.setText("Mật khẩu");
		passDN.setEchoChar('\u0000');
		passDN.setBounds(146, 349, 266, 37);
		passDN.setFont(new Font("Calibri", Font.ITALIC, 17));
		passDN.setBorder(null);
		passDN.setOpaque(false);
		panel.add(passDN);
		passDN.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passDN.getPassword()).equals("Mật khẩu")) {
					passDN.setText(null);
					passDN.requestFocus();
					passDN.setEchoChar('\u25cf');
					removePlaceholderStyles(passDN);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passDN.getPassword()).length()==0) {
					addPlaceholderStyles(passDN);
					passDN.setText("Mật khẩu");
					passDN.setEchoChar('\u0000');
				}
			}
		});
		
		
		tfSDT = new JTextField();
		tfSDT.setForeground(new Color(128, 128, 128));
		tfSDT.setText("Số điện thoại");
		tfSDT.setOpaque(false);
		tfSDT.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfSDT.setBorder(null);
		tfSDT.setBounds(146, 415, 266, 37);
		panel.add(tfSDT);
		tfSDT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfSDT.getText().equals("Số điện thoại")) {
					tfSDT.setText(null);
					tfSDT.requestFocus();
					removePlaceholderStyles(tfSDT);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfSDT.getText().length()==0) {
					addPlaceholderStyles(tfSDT);
					tfSDT.setText("Số điện thoại");
				}
			}
		});
		
		

		JButton btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setContentAreaFilled(false);
		btnDangNhap.setBorderPainted(false);
		btnDangNhap.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDangNhap.setForeground(new Color(0, 0, 0));
		btnDangNhap.setFont(new Font("Calibri", Font.BOLD, 15));
		btnDangNhap.setBounds(206, 508, 122, 31);
		panel.add(btnDangNhap);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LayDuLieuDangNhap();
				
			}
		});
		
		JButton btnDKi = new JButton("Tạo Tài Khoản Mới");
		btnDKi.setIcon(new ImageIcon("D:\\ĐACS1\\muiten.png"));
		btnDKi.setBounds(175, 562, 160, 27);
		btnDKi.setForeground(new Color(255, 255, 255));
		btnDKi.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnDKi.setContentAreaFilled(false);
		btnDKi.setBorderPainted(false);
		btnDKi.setBorder(null);
		btnDKi.setBackground(new Color(245, 255, 250));
		panel.add(btnDKi);
		btnDKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangKi dangkigd = new DangKi();
				dangkigd.setVisible(true);
			}
		});
		
		
		JLabel lblAnhDN = new JLabel("");
		lblAnhDN.setForeground(new Color(255, 255, 255));
		lblAnhDN.setBounds(10, 0, 498, 669);
		lblAnhDN.setIcon(new ImageIcon("D:\\ĐACS1\\Dki&Dnhap.png"));
		panel.add(lblAnhDN);
		
		addPlaceholderStyles(tfTenDN);
		addPlaceholderStyles(passDN);
		addPlaceholderStyles(tfSDT);
	}
}