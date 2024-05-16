package GiaoDienQuanLi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLayeredPane;

public class DangKi1 extends JFrame {

	private JPanel contentPane;

	static Connection con;
	static Statement stmt;
	private JTextField tfTen;
	private JPasswordField tfMatKhau;
	private JTextField tfSDT;
	private JTextField tfTenCuaHang;
	private JTextField tfMaCuaHang;
	private JTextField tfDiaChi;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKi1 frame = new DangKi1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void themDuLieuVaoCSDL() {
	    try {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_order?useUnicode=yes&characterEncoding=UTF-8", "root", "");
	        stmt = con.createStatement();

	        String sql = "INSERT INTO quanli (tenquanli, tencuahang, macuahang, matkhau, sdt, diachi) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, tfTen.getText());
	        ps.setString(2, tfTenCuaHang.getText());
	        ps.setString(3, tfMaCuaHang.getText());
	        ps.setString(4, tfMatKhau.getText());
	        ps.setString(5, tfSDT.getText());
	        ps.setString(6, tfDiaChi.getText());
	        
	 

	        // Kiểm tra xem các trường đã được nhập đầy đủ chưa
	        if (tfTen.getText().isEmpty() || tfMatKhau.getPassword().length == 0 || tfMaCuaHang.getText().isEmpty() || tfTenCuaHang.getText().isEmpty() || tfSDT.getText().isEmpty() || tfDiaChi.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Yêu cầu điền đầy đủ thông tin");
	        } else {
	            int n = ps.executeUpdate();
	            System.out.println("Thêm mới bản ghi thành công.");

	            if (n != 0) {
	                JOptionPane.showMessageDialog(this, "Đăng kí thành công");
	            } else {
	                JOptionPane.showMessageDialog(this, "Đăng kí thất bại");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	protected void resetForm() {
		tfDiaChi.setText("");
		tfMaCuaHang.setText("");
		tfMatKhau.setText("");
		tfSDT.setText("");
		tfTen.setText("");
		tfTenCuaHang.setText("");
	}
	
	
	
	public void addPlaceholderStyles(JTextField textFiled) {
		Font font = textFiled.getFont();
		font = font.deriveFont(Font.ITALIC);
		textFiled.setFont(font);
		textFiled.setForeground(Color.gray);
	}
	
	public void removePlaceholderStyles(JTextField textFiled) {
		Font font = textFiled.getFont();
		font = font.deriveFont(Font.PLAIN|Font.BOLD);
		textFiled.setFont(font);
		textFiled.setForeground(Color.black);	
	}
	
	
	
	
	public DangKi1() {
		
		setTitle("ĐĂNG KÍ tại đây ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 685, 387);
		contentPane.add(layeredPane);
		
		JLabel lblDANG_NHAP = new JLabel("ĐĂNG KÍ");
		lblDANG_NHAP.setForeground(new Color(189, 9, 45));
		lblDANG_NHAP.setFont(new Font("Calibri", Font.BOLD, 30));
		lblDANG_NHAP.setBackground(new Color(218, 165, 32));
		lblDANG_NHAP.setBounds(282, 10, 126, 38);
		layeredPane.add(lblDANG_NHAP);
		
		JLabel lblTaoMoi = new JLabel("OR   Bạn chưa có tài khoản mới ?");
		lblTaoMoi.setForeground(Color.WHITE);
		lblTaoMoi.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTaoMoi.setBounds(282, 48, 237, 27);
		layeredPane.add(lblTaoMoi);
		
		tfTen = new JTextField();
		tfTen.setText("Tên đăng kí");
		tfTen.setOpaque(false);
		tfTen.setForeground(new Color(128, 128, 128));
		tfTen.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfTen.setBorder(null);
		tfTen.setBounds(203, 85, 289, 27);
		layeredPane.add(tfTen);
		tfTen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfTen.getText().equals("Tên đăng kí")) {
					tfTen.setText(null);
					tfTen.requestFocus();
					removePlaceholderStyles(tfTen);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfTen.getText().length()==0) {
					addPlaceholderStyles(tfTen);
					tfTen.setText("Tên đăng kí");
				}
			}
		});
		
		
		tfMatKhau = new JPasswordField();
		tfMatKhau.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(tfMatKhau.getPassword()).equals("Mật khẩu")) {
					tfMatKhau.setText(null);
					tfMatKhau.requestFocus();
					tfMatKhau.setEchoChar('\u25cf');
					removePlaceholderStyles(tfMatKhau);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(tfMatKhau.getPassword()).length()==0) {
					addPlaceholderStyles(tfMatKhau);
					tfMatKhau.setText("Mật khẩu");
					tfMatKhau.setEchoChar('\u0000');
				}
			}
		});
		tfMatKhau.setText("Mật khẩu");
		tfMatKhau.setOpaque(false);
		tfMatKhau.setForeground(new Color(128, 128, 128));
		tfMatKhau.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfMatKhau.setEchoChar(' ');
		tfMatKhau.setBorder(null);
		tfMatKhau.setBounds(203, 174, 300, 27);
		layeredPane.add(tfMatKhau);
		
		tfSDT = new JTextField();
		tfSDT.addFocusListener(new FocusAdapter() {
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

		tfSDT.setText("Số điện thoại");
		tfSDT.setOpaque(false);
		tfSDT.setForeground(new Color(128, 128, 128));
		tfSDT.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfSDT.setBorder(null);
		tfSDT.setBounds(203, 216, 289, 23);
		layeredPane.add(tfSDT);
		
		JButton btnThoat = new JButton("Thoát\r\n\r\n....");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrangThai.TrangThai trangthai = new TrangThai.TrangThai();
				trangthai.setVisible(true);
			}
		});
		btnThoat.setOpaque(false);
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnThoat.setContentAreaFilled(false);
		btnThoat.setBorderPainted(false);
		btnThoat.setBorder(null);
		btnThoat.setBounds(429, 354, 90, 23);
		layeredPane.add(btnThoat);

		
		JButton btnDangKi = new JButton("ĐĂNG KÍ");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themDuLieuVaoCSDL();
			}
		});
		btnDangKi.setForeground(Color.BLACK);
		btnDangKi.setFont(new Font("Calibri", Font.BOLD, 18));
		btnDangKi.setContentAreaFilled(false);
		btnDangKi.setBorderPainted(false);
		btnDangKi.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDangKi.setBounds(200, 312, 292, 27);
		layeredPane.add(btnDangKi);
		
		JButton btnDN_ofDK = new JButton("Đăng nhập");
		btnDN_ofDK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DangNhap1 dn1 = new DangNhap1();
				dn1.setVisible(true);
			}
		});
		btnDN_ofDK.setOpaque(false);
		btnDN_ofDK.setForeground(Color.WHITE);
		btnDN_ofDK.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnDN_ofDK.setContentAreaFilled(false);
		btnDN_ofDK.setBorderPainted(false);
		btnDN_ofDK.setBorder(null);
		btnDN_ofDK.setBounds(183, 50, 107, 23);
		layeredPane.add(btnDN_ofDK);
		
		JButton btnReset = new JButton("");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		btnReset.setIcon(new ImageIcon("D:\\ĐACS1\\quaylai.png"));
		btnReset.setOpaque(false);
		btnReset.setContentAreaFilled(false);
		btnReset.setBorderPainted(false);
		btnReset.setBorder(null);
		btnReset.setBounds(0, 0, 25, 23);
		layeredPane.add(btnReset);
		
		JSeparator separator_password = new JSeparator();
		separator_password.setForeground(Color.WHITE);
		separator_password.setBackground(Color.WHITE);
		separator_password.setBounds(208, 71, 64, 15);
		layeredPane.add(separator_password);
		
		tfTenCuaHang = new JTextField();
		tfTenCuaHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfTenCuaHang.getText().equals("Tên cửa hàng")) {
					tfTenCuaHang.setText(null);
					tfTenCuaHang.requestFocus();
					removePlaceholderStyles(tfTenCuaHang);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfTenCuaHang.getText().length()==0) {
					addPlaceholderStyles(tfTenCuaHang);
					tfTenCuaHang.setText("Tên cửa hàng");
				}
			}
		});
		tfTenCuaHang.setText("Tên cửa hàng");
		tfTenCuaHang.setOpaque(false);
		tfTenCuaHang.setForeground(new Color(128, 128, 128));
		tfTenCuaHang.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfTenCuaHang.setBorder(null);
		tfTenCuaHang.setBounds(202, 130, 123, 23);
		layeredPane.add(tfTenCuaHang);
		
		
		
		tfMaCuaHang = new JTextField();
		tfMaCuaHang.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfMaCuaHang.getText().equals("Mã cửa hàng")) {
					tfMaCuaHang.setText(null);
					tfMaCuaHang.requestFocus();
					removePlaceholderStyles(tfMaCuaHang);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfMaCuaHang.getText().length()==0) {
					addPlaceholderStyles(tfMaCuaHang);
					tfMaCuaHang.setText("Mã cửa hàng");
				}
			}
		});
		tfMaCuaHang.setText("Mã cửa hàng");
		tfMaCuaHang.setOpaque(false);
		tfMaCuaHang.setForeground(new Color(128, 128, 128));
		tfMaCuaHang.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfMaCuaHang.setBorder(null);
		tfMaCuaHang.setBounds(358, 130, 133, 23);
		layeredPane.add(tfMaCuaHang);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setText("Địa chỉ");
		tfDiaChi.setOpaque(false);
		tfDiaChi.setForeground(Color.BLACK);
		tfDiaChi.setFont(new Font("Calibri", Font.ITALIC, 17));
		tfDiaChi.setBorder(null);
		tfDiaChi.setBounds(203, 259, 300, 23);
		layeredPane.add(tfDiaChi);
		tfDiaChi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfDiaChi.getText().equals("Địa chỉ")) {
					tfDiaChi.setText(null);
					tfDiaChi.requestFocus();
					removePlaceholderStyles(tfDiaChi);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfDiaChi.getText().length()==0) {
					addPlaceholderStyles(tfDiaChi);
					tfDiaChi.setText("Địa chỉ");
				}
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\ĐACS1\\1.png"));
		lblNewLabel.setBounds(0, 0, 705, 407);
		contentPane.add(lblNewLabel);
		
		addPlaceholderStyles(tfDiaChi);
		addPlaceholderStyles(tfMaCuaHang);
		addPlaceholderStyles(tfSDT);
		addPlaceholderStyles(tfTen);
		addPlaceholderStyles(tfTenCuaHang);
		addPlaceholderStyles(tfMatKhau);
		
	}
}