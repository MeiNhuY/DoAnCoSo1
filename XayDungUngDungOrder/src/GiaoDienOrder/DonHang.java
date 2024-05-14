package GiaoDienOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
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
import java.sql.Timestamp;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;

public class DonHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	static Connection con;
	static Statement stmt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonHang frame = new DonHang();
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
//	public DonHang(int soBan, double tongTien, Timestamp thoiGian) {
//        // Khởi tạo frame DonHang
//        initialize();
//        // Thêm dữ liệu vào bảng
//        AddDataTable(soBan, tongTien, thoiGian);
//    }
//	
//	
//	
//	private void initialize() {
//		// TODO Auto-generated method stub
//		
//	}

	public DonHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 10, 387, 437);
		contentPane.add(layeredPane);
		
		JButton btnThem = new JButton("Thêm ");
		btnThem.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienChinh main = new GiaoDienChinh();
				main.setVisible(true);
			}
		});
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBounds(55, 393, 89, 44);
		btnThem.setBorderPainted(false);
		btnThem.setContentAreaFilled(false);
		layeredPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();
		        if (selectedRow >= 0) {
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            Timestamp thoigian =  (Timestamp) model.getValueAt(selectedRow, 2);

					// Xóa dữ liệu khỏi CSDL
		            xoaDuLieuTrenCSDL(thoigian);
		            
		            // Xóa hàng khỏi bảng
		            model.removeRow(selectedRow);
	
		        } else {
		            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        }
				
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		btnXoa.setContentAreaFilled(false);
		btnXoa.setBorderPainted(false);
		btnXoa.setBounds(163, 393, 89, 44);
		layeredPane.add(btnXoa);
		
//		JButton btnThanhToan = new JButton("Doanh Thu");
//		btnThanhToan.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				
//			}
//		});
//		btnThanhToan.setForeground(Color.WHITE);
//		btnThanhToan.setFont(new Font("Calibri Light", Font.PLAIN, 18));
//		btnThanhToan.setContentAreaFilled(false);
//		btnThanhToan.setBorderPainted(false);
//		btnThanhToan.setBounds(262, 390, 141, 51);
//		layeredPane.add(btnThanhToan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 138, 334, 134);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "S\u1ED1 B\u00E0n", "T\u1ED5ng Ti\u1EC1n", "Th\u1EDDi Gian"
			}
		));
		table.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		
		JButton btnThoatton = new JButton(".");
		btnThoatton.setContentAreaFilled(false);
		btnThoatton.setBorderPainted(false);
		btnThoatton.setForeground(new Color(255, 255, 255));
		btnThoatton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienChinh main = new GiaoDienChinh();
				main.setVisible(true);
			}
		});
		btnThoatton.setBounds(10, 0, 53, 24);
		layeredPane.add(btnThoatton);
		
		JLabel lblNewLabel_1 = new JLabel("Đơn hàng");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(145, 20, 135, 45);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 400, 460);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\ĐACS1\\donhang.png"));
		
		
		
		napDuLieuTuCSDL();
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
	
	
	public void napDuLieuTuCSDL() {

        con = ketNoiCSDL(); 
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM donhang");
            DefaultTableModel model = (DefaultTableModel) table.getModel();   
            model.setRowCount(0);

            while (rs.next()) {
                int soban = rs.getInt("soban");
                double tongtien = rs.getDouble("tongtien");
                Timestamp thoigian = rs.getTimestamp("thoigian");
              
                model.addRow(new Object[]{soban, tongtien, thoigian});
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	public void xoaDuLieuTrenCSDL(Timestamp thoigian) {
        try {
            // Kết nối CSDL
            Connection con = ketNoiCSDL();
            
            // Tạo truy vấn xóa dữ liệu
            String sql = "DELETE FROM donhang WHERE thoigian=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, thoigian);
            
            // Thực thi truy vấn
            ps.executeUpdate();
            
            // Đóng kết nối
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
	
	
	
	 }




	