package DBConTroller;

public class quanlydoanhso {
	 private String MaHH;
	 private String TenHH;
	 private float GiaMua;
	 private float GiaBan;
	 private String TenKH;
	 private String NgayBan;
	 private float Lai;
	 
	//"   ID", "FlowerName", "PurchasePrice",
		 //"Sell Price", "CustomerName", "SellDate"
		
	
	 public quanlydoanhso(String maHH, String tenHH, float giaMua, float giaBan, String tenKH, String ngayBan,
			float lai) {
		
		MaHH = maHH;
		TenHH = tenHH;
		GiaMua = giaMua;
		GiaBan = giaBan;
		TenKH = tenKH;
		NgayBan = ngayBan;
		Lai = lai;
	}
	public String getMaHH() {
		return MaHH;
	}
	public void setMaHH(String maHH) {
		MaHH = maHH;
	}
	public String getTenHH() {
		return TenHH;
	}
	public void setTenHH(String tenHH) {
		TenHH = tenHH;
	}
	public float getGiaMua() {
		return GiaMua;
	}
	public void setGiaMua(float giaMua) {
		GiaMua = giaMua;
	}
	public float getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(float giaBan) {
		GiaBan = giaBan;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getNgayBan() {
		return NgayBan;
	}
	public void setNgayBan(String ngayBan) {
		NgayBan = ngayBan;
	}
	public float getLai() {
		return Lai;
	}
	public void setLai(float Lai) {
		Lai = Lai;
	}
	
	 public quanlydoanhso() {
			
		}

	
}
