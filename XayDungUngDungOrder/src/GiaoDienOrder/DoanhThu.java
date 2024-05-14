package GiaoDienOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;

public class DoanhThu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanhThu frame = new DoanhThu();
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
	public DoanhThu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 395, 447);
		contentPane.add(layeredPane);
		
		JButton btnOK = new JButton("OK");
		btnOK.setForeground(new Color(0, 0, 0));
		btnOK.setFont(new Font("Calibri Light", Font.BOLD, 21));
		btnOK.setContentAreaFilled(false);
		btnOK.setBorderPainted(false);
		btnOK.setBounds(153, 377, 97, 32);
		layeredPane.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienChinh main = new GiaoDienChinh();
				main.setVisible(true);
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 142, 309, 106);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Ngày","Doanh thu"
			}
		));
		
		
		textField = new JTextField();
		textField.setBounds(183, 297, 169, 20);
		textField.setColumns(10);
		layeredPane.add(textField);
		
		JLabel lblDoanhThu = new JLabel("Doanh Thu");
		lblDoanhThu.setForeground(new Color(236, 112, 19));
		lblDoanhThu.setFont(new Font("Segoe UI Black", Font.PLAIN, 31));
		lblDoanhThu.setBounds(135, 23, 169, 45);
		layeredPane.add(lblDoanhThu);
		
		JLabel lblTongDoanhThu = new JLabel("Tổng Doanh thu:");
		lblTongDoanhThu.setForeground(new Color(255, 255, 255));
		lblTongDoanhThu.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblTongDoanhThu.setBounds(43, 292, 130, 32);
		layeredPane.add(lblTongDoanhThu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 395, 447);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\ĐACS1\\doanhthu.png"));
	}
}