package GiaoDienOrder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JTextField;


public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSoLuong;
	private JComboBox comboxTenMon;
	private String tfTongCong;
	private JTextField tfmasanpham;

    static Connection con;
    static Statement stmt;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) { 
					e.printStackTrace();
				}
			}
		});
	}

	
	public Menu() {
		setTitle("Bạn có thể chọn món tại đây");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 388);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 294, 349);
		contentPane.add(layeredPane);
		

		JLabel lblTenMon = new JLabel("Tên món");
		lblTenMon.setBackground(new Color(0, 0, 0));
		lblTenMon.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblTenMon.setForeground(new Color(0, 0, 0));
		lblTenMon.setBounds(21, 101, 77, 27);
		layeredPane.add(lblTenMon);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setForeground(Color.BLACK);
		lblSoLuong.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblSoLuong.setBackground(Color.BLACK);
		lblSoLuong.setBounds(21, 214, 77, 27);
		layeredPane.add(lblSoLuong);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Calibri Light", Font.PLAIN, 25));
		lblMenu.setBounds(118, 22, 77, 27);
		layeredPane.add(lblMenu);

		JLabel lblAnhgdMenu = new JLabel("");
		lblAnhgdMenu.setBounds(0, -72, 308, 443);
		lblAnhgdMenu.setIcon(new ImageIcon("D:\\ĐACS1\\menu.png"));
		contentPane.add(lblAnhgdMenu);
		
		JLabel lblMaSanPham = new JLabel("Mã sản phẩm");
		lblMaSanPham.setForeground(Color.BLACK);
		lblMaSanPham.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblMaSanPham.setBackground(Color.BLACK);
		lblMaSanPham.setBounds(21, 156, 100, 27);
		layeredPane.add(lblMaSanPham);
		
		tfSoLuong = new JTextField();
		tfSoLuong.setBounds(123, 216, 84, 19);
		layeredPane.add(tfSoLuong);
		tfSoLuong.setColumns(10);
		
		tfmasanpham = new JTextField();
		tfmasanpham.setColumns(10);
		tfmasanpham.setBounds(123, 157, 84, 19);
		layeredPane.add(tfmasanpham);


		comboxTenMon = new JComboBox();
		comboxTenMon.setModel(new DefaultComboBoxModel(new String[] {"Cà phê sữa phin/máy", "Cà phê đen phin/ máy", "Cà phê sữa Sài Gòn", "Cà phê đen Sài Gòn", "Cà phê muối", "Trà gừng mật ong", "Trà gừng thảo mộc", "Trà lipton", "Trà ÔLong", "Trà Matcha", "Trà Sữa Truyền Thống ", "Sữa tươi Trân châu đường đen", "Sữa chua Dâu", "Sữa chua Xoài", "Sữa chua Trái cây", "Nước ép Cam", "Nước ép Dứa", "Nước ép cóc", "Nước ép Dưa hấu", "Nước ép Ổi", "Kem Dâu", "Kem Xoài", "Kem Trái Cây", "Kem Dưa Hấu"}));
		comboxTenMon.setToolTipText("");
		comboxTenMon.setBounds(118, 102, 148, 21);
		layeredPane.add(comboxTenMon);
		comboxTenMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenmon = (String) comboxTenMon.getSelectedItem();
		        String masanpham = layMaSanPham(tenmon);
		        tfmasanpham.setText(masanpham);
			}
		});
		
		
		JButton btnOK = new JButton("OK");
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setBounds(118, 285, 77, 36);
		btnOK.setBorderPainted(false);
		btnOK.setContentAreaFilled(false);
		layeredPane.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soluong = Integer.parseInt(tfSoLuong.getText());
				if (soluong == 0) {
		            JOptionPane.showMessageDialog(contentPane, "Số lượng không được bằng 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
	  
				} else {
		        	dispose();
		        	ChuyenDuLieuQuaBan1();	  
			        Ban1 ban1 = new Ban1();
			        ban1.napDuLieuTuCSDL();
		            ban1.setVisible(true);
		        }
			}
		});
		
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setContentAreaFilled(false);
		btnThoat.setBorderPainted(false);
		btnThoat.setIcon(new ImageIcon("D:\\ĐACS1\\quaylai.png"));
		btnThoat.setBounds(0, 0, 98, 21);
		layeredPane.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ban1 ban1 = new Ban1();
				ban1.napDuLieuTuCSDL();
				ban1.setVisible(true);
			}
		});
	}
	

	private double LayDonGia(String tenmon) {
		switch(tenmon) {
		case "Cà phê sữa phin/máy": 
			return 25000;
		case "Cà phê đen phin/ máy": 
			return 26000;
		case "Cà phê sữa Sài Gòn": 
			return 27500;
		case "Cà phê đen Sài Gòn":
			return 27560;
		case "Cà phê muối":
			return 35000;
		case "Trà gừng mật ong":
			return 20000;
		case "Trà gừng thảo mộc":
			return 29000;
		case "Trà lipton":
			return 17000;
		case "Trà ÔLong":
			return 21000;
		case "Trà Matcha-10":
			return 24000;
		case "Trad Sữa Truyền Thống":
			return 15000;
		case "Sữa tươi Trân châu đường đen":
			return 25000;
		case "Sữa chua Dâu":
			return 20000;
		case "Sữa chua xoài":
			return 20000;
		case "Sữa chua Trái cây":
			return 26000;
		case "Nước ép Cam":
			return 28000;
		case "Nước ép Dứa":
			return 22500;
		case "Nước ép cóc":
			return 18000;
		case "Nước ép Dưa hấu":
			return 23000;
		case "Nước ép Ổi":
			return 23000;
		case "Kem Dâu":
			return 12000;
		case "Kem Xoài":
			return 12000;
		case "Kem Trái Cây":
			return 16000;
		case "Kem Dưa Hấu":
			return 17000;
		default:
			return 0;
		}
	}
	
	
	protected String layMaSanPham(String masanpham) {
		switch(masanpham) {
		case "Cà phê sữa phin/máy": 
			return "CF001";
		case "Cà phê đen phin/ máy": 
			return "CF002";
		case "Cà phê sữa Sài Gòn": 
			return "CF003";
		case "Cà phê đen Sài Gòn":
			return "CF004";
		case "Cà phê muối":
			return "CF005";
		case "Trà gừng mật ong":
			return "T011";
		case "Trà gừng thảo mộc":
			return "T012";
		case "Trà lipton":
			return "T013";
		case "Trà ÔLong":
			return "T014";
		case "Trà Matcha-10":
			return "T015";
		case "Trad Sữa Truyền Thống":
			return "S055";
		case "Sữa tươi Trân châu đường đen":
			return "S066";
		case "Sữa chua Dâu":
			return "SC520";
		case "Sữa chua Xoài":
			return "SC521";
		case "Sữa chua Trái cây":
			return "SC522";
		case "Nước ép Cam":
			return "N00E";
		case "Nước ép Dứa":
			return "N01E";
		case "Nước ép cóc":
			return "N02E";
		case "Nước ép Dưa hấu":
			return "N03E";
		case "Nước ép Ổi":
			return "N04E";
		case "Kem Dâu":
			return "K11E";
		case "Kem Xoài":
			return "K22E";
		case "Kem Trái Cây":
			return "K33E";
		case "Kem Dưa Hấu":
			return "K44E";
		default:
			return "!";
		}
	}
	
	
	
	//Xử lí sự kiện 
	public void ChuyenDuLieuQuaBan1() {
		 	String tenmon = (String) comboxTenMon.getSelectedItem();
	        int soluong = Integer.parseInt(tfSoLuong.getText());
	        double dongia = LayDonGia(tenmon);
	        String masanpham = tfmasanpham.getText();
	     // Kiểm tra món đã tồn tại trong đơn hàng chưa
	        if (kiemTraMonTonTai(masanpham)) {
	            JOptionPane.showMessageDialog(contentPane, "Món này đã chọn trước đó, Vui lòng thoát trang và chỉnh sửa số lượng!", "Thông Báo"
	            		+ "", JOptionPane.WARNING_MESSAGE);
	        } else {
	            double thanhtien = soluong * dongia;
	            themDuLieuVaoCSDL(masanpham, tenmon, soluong, dongia, thanhtien);
	        }
    }
	

	
	 public static Connection ketNoiCSDL() {
   	  
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_order?useUnicode=yes&characterEncoding=UTF-8", "root", "");
	            stmt = con.createStatement();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return con; 
	    }


	private void themDuLieuVaoCSDL(String masanpham, String tenmon, int soluong, double dongia, double thanhtien) {
		
		try {
			con = ketNoiCSDL();
			
	        String sql = "INSERT INTO danhsach (masanpham, tenmon, soluong, dongia, thanhtien) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, masanpham);
	        ps.setString(2, tenmon);
	        ps.setInt(3, soluong);
	        ps.setDouble(4, dongia);
	        ps.setDouble(5, thanhtien);
	        
	        ps.executeUpdate();
	       
	        con.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	
	private boolean kiemTraMonTonTai(String masanpham) {
	    try {
	        con = ketNoiCSDL();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM danhsach WHERE masanpham = ?");
	        ps.setString(1, masanpham);
	        ResultSet rs = ps.executeQuery();
	        boolean tonTai = rs.next(); // Kiểm tra xem có kết quả trả về từ câu truy vấn không
	        con.close();
	        return tonTai;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false; // Trả về false nếu có lỗi xảy ra
	    }
	}

	
	
	
	
}