package DBConTroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class Controller {
     
	
	static Connection con;
	static Statement stmt;
	
	//CONNECT
	public Controller(){
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/doanhsobanhang?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static List<quanlydoanhso>SelectAll() {
		List<quanlydoanhso> ds = new ArrayList<>();
		
		try {
		System.out.println("Ket noi duoc");
		String sql= "Select * from quanlydoanhso";
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			quanlydoanhso qlds = new quanlydoanhso(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getString(5),rs.getString(6),rs.getFloat(7));
			ds.add(qlds);
		}
		
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;	
	}
	
	
	
	// ADD - C
	public void insertquanlydoanhso(quanlydoanhso x) {
	    String sql = "INSERT INTO quanlydoanhso (MaHH, TenHH, GiaMua, GiaBan, TenKH, NgayBan, Lai) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	        pstmt.setString(1, x.getMaHH());
	        pstmt.setString(2, x.getTenHH());
	        pstmt.setFloat(3, x.getGiaMua());
	        pstmt.setFloat(4, x.getGiaBan());
	        pstmt.setString(5, x.getTenKH());
	        pstmt.setString(6, x.getNgayBan());
	        pstmt.setFloat(7, x.getLai());

	       
	        pstmt.executeUpdate();
	        
	        System.out.println("Thêm mới bản ghi thành công.");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//EDIT (UPDATE) 
	public void edit(String MaHH, String newTenHH, float newGiaMua, float newGiaBan, String newTenKH) {
	    String sql = "UPDATE quanlydoanhso SET TenHH = ?, GiaMua = ?, GiaBan = ?, TenKH = ? WHERE MaHH = ?";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	      
	        pstmt.setString(1, newTenHH);
	        pstmt.setFloat(2, newGiaMua);
	        pstmt.setFloat(3, newGiaBan);
	        pstmt.setString(4, newTenKH);
	        
	        pstmt.setString(5, MaHH);

	        int rowsAffected = pstmt.executeUpdate();

	       
	        if (rowsAffected > 0) {
	            System.out.println("Cập nhật bản ghi thành công.");
	        } else {
	            System.out.println("Không tìm thấy bản ghi cho MaHH: " + MaHH);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	
	// DELETE 
	public void deleteBYTenKH(String TenKH) {
	    String sql = "DELETE FROM quanlydoanhso WHERE TenKH LIKE ?";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	    	
	        pstmt.setString(1, TenKH);

	        
	        pstmt.executeUpdate();
	        System.out.println("Xóa bản ghi thành công.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	

	// SEARCH 
	public static List<quanlydoanhso> timkiem(String MaHH) throws SQLException {
	    List<quanlydoanhso> ds = new ArrayList<>();
	    try {
	        System.out.println("Ket noi ");
	        String sql = "SELECT * FROM quanlydoanhso WHERE MaHH LIKE ?";
	        
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	           
	            pstmt.setString(1, MaHH);

	           
	            ResultSet rs = pstmt.executeQuery();

	          
	            while (rs.next()) {
	                quanlydoanhso qlds = new quanlydoanhso(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getFloat(7));
	                ds.add(qlds);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ds;
	}

	
	
	
	public Object getConection() {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement preparedStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
