package GiaoDienQuanLi;

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
import javax.swing.SwingConstants;

public class GiaoDienChinh1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	static Connection con;
	static Statement stmt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDienChinh1 frame = new GiaoDienChinh1();
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

	public GiaoDienChinh1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 785, 494);
		contentPane.add(layeredPane);
		
		JButton btnCapNhat = new JButton("Cập nhật sản phẩm");
		btnCapNhat.setBorder(null);
		btnCapNhat.setBounds(163, 147, 226, 50);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CapNhatSanPham capnhat = new CapNhatSanPham();
				capnhat.setVisible(true);
				napDuLieuTuCSDL();
			}
		});
		layeredPane.setLayout(null);
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnCapNhat.setContentAreaFilled(false);
		btnCapNhat.setBorderPainted(false);
		layeredPane.add(btnCapNhat);
		
		JLabel lblTieuDe = new JLabel("TRANG CHỦ");
		lblTieuDe.setBounds(307, 11, 260, 74);
		lblTieuDe.setForeground(new Color(255, 128, 64));
		lblTieuDe.setFont(new Font("Segoe UI Black", Font.BOLD, 40));
		layeredPane.add(lblTieuDe);
		
		JButton btnQuanLi = new JButton("Quản lí đơn hàng");
		btnQuanLi.setBounds(151, 245, 238, 50);
		btnQuanLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				QuanLiDonHang quanli = new QuanLiDonHang();
				quanli.napDuLieuTuCSDL();
				quanli.setVisible(true);
			}
		});
		btnQuanLi.setForeground(Color.WHITE);
		btnQuanLi.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
		btnQuanLi.setContentAreaFilled(false);
		btnQuanLi.setBorderPainted(false);
		layeredPane.add(btnQuanLi);
		
		JButton btnDoanhThu = new JButton("Doanh thu");
		btnDoanhThu.setBounds(122, 336, 238, 50);
		btnDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoanhThu1 doanhthu = new DoanhThu1();
				doanhthu.setVisible(true);
			}
		});
		
		btnDoanhThu.setForeground(Color.WHITE);
		btnDoanhThu.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
		btnDoanhThu.setContentAreaFilled(false);
		btnDoanhThu.setBorderPainted(false);
		layeredPane.add(btnDoanhThu);
		
		JLabel lblAnh = new JLabel("");
		lblAnh.setBounds(0, 0, 785, 494);
		contentPane.add(lblAnh);
		lblAnh.setIcon(new ImageIcon("D:\\ĐACS1\\GiaodienchinhQL.png"));
		
		
		
	}

	protected void napDuLieuTuCSDL() {
		// TODO Auto-generated method stub
		
	}
	 }


	