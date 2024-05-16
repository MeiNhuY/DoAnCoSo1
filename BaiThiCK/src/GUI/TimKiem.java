
package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DBConTroller.quanlydoanhso;
import DBConTroller.Controller;
import java.awt.Toolkit;


public class TimKiem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableMode;
	Controller ctl= new Controller();
    DefaultTableModel dftb;
	List<quanlydoanhso> ds = new ArrayList<>();
    
	public DefaultTableModel getDftb() {
		return dftb;
	}

	public void setDftb(DefaultTableModel dftb) {
		this.dftb = dftb;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiem frame = new TimKiem("H01");
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
	
	public TimKiem(String MaHH) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\search.png"));
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 540, 340);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 151, 104));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Create Jlabel
		JLabel lblDalatFlowerStore = new JLabel("CỬA HÀNG HOA TƯƠI ĐÀ LẠT");
		lblDalatFlowerStore.setBounds(118, 5, 373, 23);
		lblDalatFlowerStore.setForeground(Color.BLACK);
		lblDalatFlowerStore.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblDalatFlowerStore);
		
		JLabel lbtimkiem = new JLabel(" KẾT QUẢ TÌM KIẾM");
		lbtimkiem.setBounds(164, 58, 196, 32);
		lbtimkiem.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lbtimkiem);
		
		JLabel lblAdress = new JLabel("Đc: 480 Trần Đại Nghĩa, Hòa Quý, Tp. Đà Nẵng");
		lblAdress.setBounds(149, 28, 209, 14);
		lblAdress.setForeground(new Color(0, 0, 0));
		lblAdress.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		contentPane.add(lblAdress);
		
		JLabel lblHotline_1 = new JLabel("Hotline: 0363489034");
		lblHotline_1.setBounds(194, 39, 114, 14);
		lblHotline_1.setForeground(new Color(0, 0, 0));
		lblHotline_1.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		contentPane.add(lblHotline_1);
		
		
		
		//Create Table
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 101, 504, 189);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
			new String[] {
				"MaHH", "TenHH", "GiaMua", "GiaBan", "TenKH", "NgayBan", "Lai"
			}
		));
		
		tableMode = (DefaultTableModel) table.getModel();
		try {
			ds = ctl.timkiem(MaHH);
			tableMode.setRowCount(0);
			for(quanlydoanhso qlds :ds) {
				tableMode.addRow(new Object[] {qlds.getMaHH(),qlds.getTenHH(),qlds.getGiaMua(),qlds.getGiaBan(),qlds.getTenKH(),qlds.getNgayBan(),qlds.getLai()});				
			}
		} catch (SQLException e) {
		//	 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//JLabel anh nen
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\d70eb0d0151c93ecbd6c08671e214ac4.jpg"));
		lblNewLabel.setBounds(0, 0, 524, 301);
		contentPane.add(lblNewLabel);
		
		
	}
}
