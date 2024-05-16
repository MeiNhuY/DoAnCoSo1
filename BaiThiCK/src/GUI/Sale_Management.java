package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DBConTroller.Controller;
import DBConTroller.quanlydoanhso;
import GUI.TimKiem;
import java.awt.Toolkit;

public class Sale_Management extends JFrame {

	Controller ctl= new Controller();
	private JPanel JpnMain;
	private JTextField tfMaHH;
	private JTextField tfTenHH;
	private JTextField tfGiaMua;
	private JTextField tfGiaBan;
	private JTextField tfTenKH;
	private JTextField  tfNgayBan;
	private JTable table;
	private DefaultTableModel tableMode;
	private JTextField tfDoanhso;
	private JTextField tfDaBan;
	private Float daban=(float)0;
	static Float tongdoanhthu = (float) 0;
	List<quanlydoanhso> ds = new ArrayList<>();
	private JComboBox comboBox;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale_Management frame = new Sale_Management();
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
	public Sale_Management() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Pictures\\Screenshot 2024-01-24 120632.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 780, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		//Create MENU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 780, 30);
		menuBar.setBackground(new Color(193, 151, 104));
		panel.add(menuBar);
		
		
		JMenu save = new JMenu("SAVE");
		save.setFont(new Font("Segoe UI", Font.BOLD, 15));
		save.setForeground(new Color(0, 0, 0));
		menuBar.add(save);
		JMenuItem ADD = new JMenuItem("SAVE");
		ADD.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		ADD.setForeground(new Color(64, 0, 0));
		save.add(ADD);
		
		
		JMenu edit = new JMenu("EDIT");
		edit.setForeground(new Color(0, 0, 0));
		edit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(edit);
		JMenuItem UPDATE = new JMenuItem("UPDATE");
		UPDATE.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		edit.add(UPDATE);
		
		
		JMenu delete = new JMenu("DELETE");
		delete.setFont(new Font("Segoe UI", Font.BOLD, 15));
		delete.setForeground(new Color(0, 0, 0));
		menuBar.add(delete);
		JMenuItem DELETE = new JMenuItem("DELETE");
		DELETE.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		delete.add(DELETE);
		
		
		JMenu search = new JMenu("SEARCH");
		search.setFont(new Font("Segoe UI", Font.BOLD, 15));
		search.setForeground(new Color(0, 0, 0));
		menuBar.add(search);
		JMenuItem SEARCH = new JMenuItem("SEARCH");
		SEARCH.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		search.add(SEARCH);
		
		
		JMenu reset = new JMenu("RESET");
		reset.setFont(new Font("Segoe UI", Font.BOLD, 15));
		reset.setForeground(new Color(0, 0, 0));
		menuBar.add(reset);
		JMenuItem RESET = new JMenuItem("RESET");
		RESET.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		reset.add(RESET);
		
		
		
		// JLabel
		JLabel lblMahh = new JLabel("MaHH");
		lblMahh.setBounds(9, 154, 50, 22);
		lblMahh.setForeground(new Color(0, 0, 0));
		lblMahh.setFont(new Font("Garamond", Font.BOLD, 13));
		panel.add(lblMahh);
		
		JLabel lblTenhh = new JLabel("TenHH");
		lblTenhh.setBounds(9, 190, 52, 22);
		lblTenhh.setForeground(new Color(0, 0, 0));
		lblTenhh.setFont(new Font("Garamond", Font.BOLD, 13));
		panel.add(lblTenhh);
		
		JLabel lblGiamua = new JLabel("GiaMua");
		lblGiamua.setBounds(11, 227, 50, 14);
		lblGiamua.setForeground(new Color(0, 0, 0));
		lblGiamua.setFont(new Font("Garamond", Font.BOLD, 13));
		panel.add(lblGiamua);
		
		JLabel lblGiaban = new JLabel("GiaBan");
		lblGiaban.setBounds(10, 259, 59, 14);
		lblGiaban.setForeground(new Color(0, 0, 0));
		lblGiaban.setFont(new Font("Garamond", Font.BOLD, 13));
		panel.add(lblGiaban);
		
		JLabel lblTenkh = new JLabel("TenKH");
		lblTenkh.setBounds(9, 288, 44, 22);
		lblTenkh.setForeground(new Color(0, 0, 0));
		lblTenkh.setFont(new Font("Garamond", Font.BOLD, 13));
		panel.add(lblTenkh);
		
		JLabel lblNgayban = new JLabel("NgayBan");
		lblNgayban.setBounds(10, 326, 56, 22);
		lblNgayban.setForeground(new Color(0, 0, 0));
		lblNgayban.setVerticalAlignment(SwingConstants.TOP);
		lblNgayban.setFont(new Font("Garamond", Font.BOLD, 13));
		panel.add(lblNgayban);
		
		JLabel lblSaleManagement = new JLabel("QUẢN LÍ DOANH SỐ");
		lblSaleManagement.setBounds(408, 114, 138, 34);
		lblSaleManagement.setForeground(new Color(0, 0, 0));
		lblSaleManagement.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		panel.add(lblSaleManagement);
		
		JLabel lblDalatFlowerStore = new JLabel("CỬA HÀNG HOA TƯƠI ĐÀ LẠT");
		lblDalatFlowerStore.setBounds(204, 37, 373, 40);
		lblDalatFlowerStore.setForeground(Color.BLACK);
		lblDalatFlowerStore.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblDalatFlowerStore);
		
		JLabel lblDaban = new JLabel("Đã Bán:");
		lblDaban.setBounds(9, 386, 88, 34);
		lblDaban.setForeground(new Color(0, 0, 0));
		lblDaban.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDaban.setBackground(new Color(0, 0, 0));
		panel.add(lblDaban);
		
		JLabel lblDoanhso = new JLabel("Doanh Số: ");
		lblDoanhso.setBounds(476, 386, 100, 45);
		lblDoanhso.setForeground(new Color(0, 0, 0));
		lblDoanhso.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoanhso.setBackground(new Color(0, 0, 0));
		panel.add(lblDoanhso);
		
		JLabel lblAdress = new JLabel("Đc: 480 Trần Đại Nghĩa, Hòa Quý, Tp. Đà Nẵng");
		lblAdress.setBounds(254, 75, 270, 14);
		lblAdress.setForeground(new Color(0, 0, 0));
		lblAdress.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblAdress);
		
		JLabel lblHotline_1 = new JLabel("Hotline: 0363489034");
		lblHotline_1.setBounds(308, 89, 144, 14);
		lblHotline_1.setForeground(new Color(0, 0, 0));
		lblHotline_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblHotline_1);
		
		
		
		//Create TextField
		comboBox = new JComboBox();
		comboBox.setBounds(65, 148, 125, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10", "H11", "H12", "H13", "H14", "H15"}));
		panel.add(comboBox);

		tfMaHH = new JTextField();
		tfMaHH.setBounds(65, 153, 125, 17);
		tfMaHH.setForeground(Color.BLACK);
		tfMaHH.setColumns(10);
		tfMaHH.setBorder(null);
		tfMaHH.setBackground(new Color(255, 255, 255));
		panel.add(tfMaHH);
		
		tfTenHH = new JTextField();
		tfTenHH.setBounds(64, 187, 125, 17);
		tfTenHH.setForeground(Color.BLACK);
		tfTenHH.setColumns(10);
		tfTenHH.setBorder(null);
		tfTenHH.setBackground(new Color(255, 255, 255));
		panel.add(tfTenHH);
		
		tfTenKH = new JTextField();
		tfTenKH.setBounds(65, 289, 124, 17);
		tfTenKH.setForeground(new Color(0, 0, 0));
		tfTenKH.setBackground(new Color(255, 255, 255));
		tfTenKH.setBorder(null);
		tfTenKH.setColumns(10);
		panel.add(tfTenKH);
		
		tfGiaBan = new JTextField();
		tfGiaBan.setBounds(65, 259, 125, 15);
		tfGiaBan.setForeground(new Color(0, 0, 0));
		tfGiaBan.setBackground(new Color(255, 255, 255));
		tfGiaBan.setBorder(null);
		tfGiaBan.setColumns(10);
		panel.add(tfGiaBan);
		
		tfGiaMua = new JTextField();
		tfGiaMua.setBounds(66, 221, 125, 17);
		tfGiaMua.setForeground(new Color(0, 0, 0));
		tfGiaMua.setBackground(new Color(255, 255, 255));
		tfGiaMua.setBorder(null);
		tfGiaMua.setColumns(10);
		panel.add(tfGiaMua);
		
		tfNgayBan = new JTextField();
		tfNgayBan.setBounds(65, 324, 125, 17);
		tfNgayBan.setForeground(new Color(0, 0, 0));
		tfNgayBan.setBackground(new Color(255, 255, 255));
		tfNgayBan.setBorder(null);
		tfNgayBan.setColumns(10);
		panel.add(tfNgayBan);
		
		tfDoanhso = new JTextField();
		tfDoanhso.setBounds(575, 386, 194, 39);
		tfDoanhso.setText(" 0.0 VND");
		tfDoanhso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfDoanhso.setColumns(10);
		panel.add(tfDoanhso);
		
	    tfDaBan = new JTextField();
	    tfDaBan.setBounds(88, 387, 174, 36);
		tfDaBan.setText(" 0.0 VND");
		tfDaBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tfDaBan.setColumns(10);
		panel.add(tfDaBan);
		
		
		
		// Create JSeparator
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(65, 169, 125, 2);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.BLACK);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(64, 204, 126, 8);
		separator_2.setBorder(null);
		separator_2.setBackground(Color.BLACK);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(66, 237, 125, 8);
		separator_3.setBorder(null);
		separator_3.setBackground(Color.BLACK);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(65, 273, 125, 8);
		separator_4.setBorder(null);
		separator_4.setBackground(Color.BLACK);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(64, 305, 125, 8);
		separator_5.setBorder(null);
		separator_5.setBackground(Color.BLACK);
		panel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(65, 340, 125, 8);
		separator_6.setBorder(null);
		separator_6.setBackground(Color.BLACK);
		panel.add(separator_6);
		
		

		//Create TABLE
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 148, 566, 212);
		panel.add(scrollPane);
		
		JTable table = new JTable();
		//scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"     MaHH", "     TenHH", "     GiaMua", "     GiaBan", "     TenKH", "     NgayBan"
			}
		));
		
		scrollPane.setViewportView(table);
		tableMode = (DefaultTableModel) table.getModel();
		hienthidulieu();
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				  int Row=table.getSelectedRow();
				   
				   String MaHH=(String) table.getValueAt(Row, 0);
				   String TenHH=(String) table.getValueAt(Row, 1);
				   String GiaMua=String.valueOf( table.getValueAt(Row, 2));
				   String GiaBan=String.valueOf( table.getValueAt(Row, 3));
				   String TenKH=(String) table.getValueAt(Row, 4);
				   String NgayBan=(String) table.getValueAt(Row, 5);
				
				   comboBox.setSelectedItem(MaHH);
				   tfTenHH.setText(TenHH);
				   tfGiaMua.setText(GiaMua);
				   tfGiaBan.setText(GiaBan);
				   tfTenKH.setText(TenKH);
				   tfNgayBan.setText(NgayBan);
				  
			}
		});
	
		
		//Label anh nen
		JLabel lblAnh = new JLabel("");
		lblAnh.setBounds(0, 28, 780, 414);
		lblAnh.setIcon(new ImageIcon("C:\\Users\\DELL\\Pictures\\Screenshot 2024-01-15 011429.png"));
		panel.add(lblAnh);

		
		
		
		
		//XỬ LÍ SỰ KIỆN
		
		ADD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String MaHH = comboBox.getSelectedItem()+"";
				String TenHH= tfTenHH.getText();
				float  GiaMua=Float.parseFloat(tfGiaMua.getText());
				float  GiaBan=Float.parseFloat(tfGiaBan.getText());
				String TenKH = tfTenKH.getText();
				String NgayBan = tfNgayBan.getText();
				float  Lai=Float.parseFloat(tfGiaBan.getText())-Float.parseFloat(tfGiaMua.getText());
				quanlydoanhso x = new quanlydoanhso(MaHH, TenHH, GiaMua, GiaBan, TenKH, NgayBan, Lai);
				ctl.insertquanlydoanhso(x);
				hienthidulieu();
				xoaform();
				
			}
		
		});
		
		
		// DELETE 
		DELETE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int luachon=JOptionPane.showConfirmDialog( JpnMain, "Ban co chan chan muon xoa khong?");
				if(luachon==JOptionPane.YES_OPTION) {
					String TenKH=tfTenKH.getText();
					ctl.deleteBYTenKH(TenKH);
					   JOptionPane.showMessageDialog(JpnMain, "Bạn đã xóa thành công");
				}
				hienthidulieu();
				 xoaform();
			}
		});
	  
		
	  
		// EDIT (UPDATE)
		UPDATE.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // TODO Auto-generated method stub
		        String MaHH = comboBox.getSelectedItem() + "";
		        String TenHH = tfTenHH.getText().trim();
		        String GiaMuaStr = tfGiaMua.getText().trim();
		        String GiaBanStr = tfGiaBan.getText().trim();
		        String TenKH = tfTenKH.getText().trim();
		        String NgayBan = tfNgayBan.getText().trim();

		        if (TenHH.isEmpty() || GiaMuaStr.isEmpty() || GiaBanStr.isEmpty() || TenKH.isEmpty() || NgayBan.isEmpty()) {
		           
		            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin", "ERROR", JOptionPane.ERROR_MESSAGE);
		        } else {
		            try {
		                float GiaMua = Float.parseFloat(GiaMuaStr);
		                float GiaBan = Float.parseFloat(GiaBanStr);
		                float Lai = GiaBan - GiaMua;

		                quanlydoanhso x = new quanlydoanhso(MaHH, TenHH, GiaMua, GiaBan, TenKH, NgayBan, Lai);
		                ctl.edit(MaHH, TenHH, GiaMua, GiaBan, TenKH);
		                hienthidulieu();
		                xoaform();
		            } catch (NumberFormatException ex) {
		                
		                JOptionPane.showMessageDialog(null, "Lỗi: Nhập số không hợp lệ", "ERROR", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }
		});

	   
	   
		
	   RESET.addActionListener(new ActionListener() {
		
		@Override
		  public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			xoaform();
		  }
	    });
	
	   
	   
	   SEARCH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timkiem();			
			
			}
		});
	
	}

	
	
	//SEARCH
   	protected void timkiem() {       
		// TODO Auto-generated method stub
   		String input = JOptionPane.showInputDialog(JpnMain, "Nhập vào Mã hàng hóa bạn muốn tìm kiếm");
		if(input!=null && input.length()>0)
		{
			TimKiem SEARCH = new TimKiem(input);
			SEARCH.setVisible(true);	
			
		}
		else  JOptionPane.showMessageDialog(null,
                "Không có dữ liệu "
                ,
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
	}

   	
   	
   	// RESET
	protected void xoaform() {
	
		// TODO Auto-generated method stub
		comboBox.setSelectedItem(null);;
		tfTenHH.setText("");
		tfGiaMua.setText("");
		tfGiaBan.setText("");
		tfTenKH.setText("");
		tfNgayBan.setText("");
	}

	
	

	public void hienthidulieu()
	{
   			ds=DBConTroller.Controller.SelectAll();
   			tableMode.setRowCount(0);
   			
   			tongdoanhthu = (float) 0;
   			daban = (float) 0;
   			
   			for(quanlydoanhso qlds:ds)
   			{
   				tableMode.addRow(new Object[] {qlds.getMaHH(),qlds.getTenHH(),qlds.getGiaMua(),qlds.getGiaBan(),qlds.getTenKH(),qlds.getNgayBan(),qlds.getLai()});
   				float a= qlds.getLai();
   				tongdoanhthu+=a;
   				float b=qlds.getGiaBan();
   				daban+=b;
   				
   			}
   			tfDoanhso.setText(""+tongdoanhthu+"VND");
   			tfDaBan.setText(""+daban+"VND");

	}
	
	
	private Object setText(String string) {
		// TODO Auto-generated method stub
		return null;
	

		  
	}
}
