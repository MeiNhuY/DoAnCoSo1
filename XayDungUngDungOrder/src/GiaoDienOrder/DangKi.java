package GiaoDienOrder;

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

public class DangKi extends JFrame {

    private JPanel contentPane;
    private JTextField tfTenDK;
    private JPasswordField passDK;
    private JTextField tfSDT;

    static Connection con;
    static Statement stmt;
    private JTextField tfMaCH;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DangKi frame = new DangKi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    


    
    public DangKi() {

        setTitle("ĐĂNG KÍ tại đây ");
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

        JLabel lblDANG_KY = new JLabel("ĐĂNG KÍ");
        lblDANG_KY.setBounds(196, 89, 172, 60);
        lblDANG_KY.setForeground(new Color(189, 9, 45));
        lblDANG_KY.setFont(new Font("Calibri", Font.BOLD, 39));
        lblDANG_KY.setBackground(new Color(218, 165, 32));
        panel.add(lblDANG_KY);

        JButton btnExit = new JButton("Exit");
        btnExit.setOpaque(false);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Calibri", Font.PLAIN, 15));
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setBorder(null);
        btnExit.setBounds(371, 576, 73, 23);
        panel.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TrangThai.TrangThai trangthai = new TrangThai.TrangThai();
                trangthai.setVisible(true);
            }
        });
       

        tfTenDK = new JTextField();
        tfTenDK.setText("Tên đăng kí");
        tfTenDK.setForeground(new Color(128, 128, 128));
        tfTenDK.setBounds(149, 219, 261, 36);
        tfTenDK.setOpaque(false);
        tfTenDK.setFont(new Font("Calibri", Font.ITALIC, 17));
        tfTenDK.setBorder(null);
        panel.add(tfTenDK);
        tfTenDK.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e) {
                if (tfTenDK.getText().equals("Tên đăng kí")) {
                    tfTenDK.setText(null);
                    tfTenDK.requestFocus();
                    removePlaceholderStyles(tfTenDK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (tfTenDK.getText().length() == 0) {
                    addPlaceholderStyles(tfTenDK);
                    tfTenDK.setText("Tên đăng kí");
                }
            }
        });

        tfMaCH = new JTextField();
        tfMaCH.setText("Mã cửa hàng: DN9***");
        tfMaCH.setOpaque(false);
        tfMaCH.setForeground(new Color(128, 128, 128));
        tfMaCH.setFont(new Font("Calibri", Font.ITALIC, 17));
        tfMaCH.setBorder(null);
        tfMaCH.setBounds(149, 285, 261, 36);
        panel.add(tfMaCH);
        tfMaCH.addFocusListener(new FocusAdapter() {
        	
            public void focusGained(FocusEvent e) {
                if (tfMaCH.getText().equals("Mã cửa hàng: DN9***")) {
                    tfMaCH.setText(null);
                    tfMaCH.requestFocus();
                    removePlaceholderStyles(tfMaCH);
                }
            }

            public void focusLost(FocusEvent e) {
                if (tfMaCH.getText().length() == 0) {
                    addPlaceholderStyles(tfMaCH);
                    tfMaCH.setText("Mã cửa hàng: DN9***");
                }
                
                String maCH = tfMaCH.getText().trim();
                if (!maCH.matches("DN9\\d{3}")) {
                    JOptionPane.showMessageDialog(DangKi.this, "Mã cửa hàng không hợp lệ! Vui lòng nhập theo mẫu DN9***", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    tfMaCH.requestFocus();
                }
            }
        });

        passDK = new JPasswordField();
        passDK.setText("Mật khẩu");
        passDK.setEchoChar('\u0000');
        passDK.setForeground(new Color(128, 128, 128));
        passDK.setBounds(149, 351, 261, 36);
        passDK.setOpaque(false);
        passDK.setFont(new Font("Calibri", Font.ITALIC, 17));
        passDK.setBorder(null);
        panel.add(passDK);
        passDK.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e) {
                if (String.valueOf(passDK.getPassword()).equals("Mật khẩu")) {
                    passDK.setText(null);
                    passDK.requestFocus();
                    passDK.setEchoChar('\u25cf');
                    removePlaceholderStyles(passDK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (String.valueOf(passDK.getPassword()).length() == 0) {
                    addPlaceholderStyles(passDK);
                    passDK.setText("Mật khẩu");
                    passDK.setEchoChar('\u0000');
                }
            }
        });

        tfSDT = new JTextField();
        tfSDT.setText("Số điện thoại");
        tfSDT.setForeground(new Color(128, 128, 128));
        tfSDT.setBounds(149, 416, 261, 36);
        tfSDT.setOpaque(false);
        tfSDT.setFont(new Font("Calibri", Font.ITALIC, 17));
        tfSDT.setBorder(null);
        panel.add(tfSDT);
        tfSDT.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (tfSDT.getText().equals("Số điện thoại")) {
                    tfSDT.setText(null);
                    tfSDT.requestFocus();
                    removePlaceholderStyles(tfSDT);
                }
            }

            public void focusLost(FocusEvent e) {
                if (tfSDT.getText().length() == 0) {
                    addPlaceholderStyles(tfSDT);
                    tfSDT.setText("Số điện thoại");
                }
            }
        });

        JButton btnDangKi = new JButton("ĐĂNG KÍ");
        btnDangKi.setContentAreaFilled(false);
        btnDangKi.setBorderPainted(false);
        btnDangKi.setBounds(118, 506, 292, 36);
        btnDangKi.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        btnDangKi.setFont(new Font("Calibri", Font.BOLD, 18));
        btnDangKi.setForeground(new Color(0, 0, 0));
        panel.add(btnDangKi);
        btnDangKi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                themDuLieuVaoCSDL();

                tfTenDK.setText("Tên đăng kí");
                tfMaCH.setText("Mã cửa hàng: DN9***");
                passDK.setText("Mật khẩu");
                passDK.setEchoChar('\u0000');
                tfSDT.setText("Số điện thoại");

                addPlaceholderStyles(tfTenDK);
                addPlaceholderStyles(passDK);
                addPlaceholderStyles(tfSDT);
                addPlaceholderStyles(tfMaCH);
            }
        });

        JButton btnDN_ofDK = new JButton("Đăng nhập");
        btnDN_ofDK.setIcon(new ImageIcon("D:\\ĐACS1\\muiten.png"));
        btnDN_ofDK.setBounds(206, 144, 107, 23);
        btnDN_ofDK.setBorder(null);
        btnDN_ofDK.setForeground(new Color(255, 255, 255));
        btnDN_ofDK.setContentAreaFilled(false);
        btnDN_ofDK.setBorderPainted(false);
        btnDN_ofDK.setOpaque(false); // trong suốt
        btnDN_ofDK.setFont(new Font("Calibri", Font.PLAIN, 15));
        panel.add(btnDN_ofDK);
        btnDN_ofDK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                DangNhap dangnhapgd = new DangNhap();
                dangnhapgd.setVisible(true);
            }
        });

        JLabel lblAnhDK = new JLabel("");
        lblAnhDK.setForeground(new Color(255, 255, 255));
        lblAnhDK.setBounds(10, 0, 498, 669);
        lblAnhDK.setIcon(new ImageIcon("D:\\ĐACS1\\Dki&Dnhap.png"));
        panel.add(lblAnhDK);
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

            String sql = "INSERT INTO nhanvien (ten, maCH, matkhau, sdt) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tfTenDK.getText());
            ps.setString(2, tfMaCH.getText());
            ps.setString(3, new String(passDK.getPassword()));
            ps.setString(4, tfSDT.getText());

          
            if (tfTenDK.getText().isEmpty() || tfTenDK.getText().equals("Tên đăng kí") ||
                tfMaCH.getText().isEmpty() || tfMaCH.getText().equals("Mã cửa hàng: DN9***") ||
                passDK.getPassword().length == 0 || new String(passDK.getPassword()).equals("Mật khẩu") ||
                tfSDT.getText().isEmpty() || tfSDT.getText().equals("Số điện thoại")) {
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

    
    public void addPlaceholderStyles(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }

    public void removePlaceholderStyles(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }
    
    
}
