package GiaoDienQuanLi;

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

public class DoanhThu1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtDoanhThu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanhThu1 frame = new DoanhThu1();
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
	public DoanhThu1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 10, 387, 437);
		contentPane.add(layeredPane);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GiaoDienChinh1 main = new GiaoDienChinh1();
				main.setVisible(true);
			}
		});
		btnOK.setForeground(new Color(0, 0, 0));
		btnOK.setFont(new Font("Calibri Light", Font.PLAIN, 21));
		btnOK.setContentAreaFilled(false);
		btnOK.setBorderPainted(false);
		btnOK.setBounds(153, 376, 97, 32);
		layeredPane.add(btnOK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 103, 262, 116);
		layeredPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ng\u00E0y", "Doanh thu"
			}
		));
		table.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Doanh Thu");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(121, 21, 169, 45);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng Doanh thu:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblNewLabel_2.setBounds(67, 292, 133, 32);
		layeredPane.add(lblNewLabel_2);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setCaretColor(new Color(0, 0, 0));
		txtDoanhThu.setBorder(null);
		txtDoanhThu.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		txtDoanhThu.setForeground(new Color(255, 255, 255));
		txtDoanhThu.setBounds(186, 293, 169, 32);
		txtDoanhThu.setBackground(new java.awt.Color(0, 0, 0, 1));
		layeredPane.add(txtDoanhThu);
		txtDoanhThu.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 400, 460);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\ĐACS1\\Doanhthu.png"));
	}
}