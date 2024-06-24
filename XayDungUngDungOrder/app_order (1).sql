-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2024 lúc 02:53 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `app_order`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhsach`
--

CREATE TABLE `danhsach` (
  `masanpham` varchar(50) NOT NULL,
  `tenmon` varchar(50) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` float NOT NULL,
  `thanhtien` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `doanhthu`
--

CREATE TABLE `doanhthu` (
  `ngay` date NOT NULL,
  `doanhthu` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `doanhthu`
--

INSERT INTO `doanhthu` (`ngay`, `doanhthu`) VALUES
('2024-05-15', 200000),
('2024-05-16', 105000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `stt` int(11) NOT NULL,
  `soban` int(11) NOT NULL,
  `tongtien` float NOT NULL,
  `thoigian` datetime NOT NULL,
  `manhanvien` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`stt`, `soban`, `tongtien`, `thoigian`, `manhanvien`) VALUES
(1, 1, 74000, '2024-05-15 23:50:06', 'tuyenpvMot'),
(2, 1, 79000, '2024-05-15 23:50:45', 'tuyenpvMot'),
(3, 1, 47000, '2024-05-15 23:54:06', 'tuyenpv1Mot'),
(4, 1, 105000, '2024-05-16 00:48:38', 'nhuypvMot'),
(5, 1, 247000, '2024-06-05 13:18:22', 'tuyenpv1Mot'),
(6, 1, 104000, '2024-06-14 16:33:20', 'NV1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `machang`
--

CREATE TABLE `machang` (
  `masanpham` varchar(50) NOT NULL,
  `tenmon` varchar(50) NOT NULL,
  `dongia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `machang`
--

INSERT INTO `machang` (`masanpham`, `tenmon`, `dongia`) VALUES
('CDN', 'Chè dưỡng nhan loại 1', 30000),
('CF01', 'Cà phê sữa phin/ máy', 18000),
('CF02', 'Cà phê đen phin/ máy', 160000),
('CF03', 'Cà phê Sữa SG', 22000),
('CF04', 'Cà phê Đen SG ', 23000),
('NE02', 'Ép Chanh Dây ', 29000),
('T01', 'Trà gừng thảo mộc', 25000),
('T02', 'Trà mãn cầu', 29000),
('T03', 'Trà sữa Phúc Long', 20000),
('T05', 'Trà sữa trân châu đường đen', 29000),
('T06', 'Trà Tắc', 15000),
('T07', 'Trà Xanh', 15000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manhanvien` varchar(50) NOT NULL,
  `macuahang` varchar(50) NOT NULL,
  `tennhanvien` varchar(50) NOT NULL,
  `matkhau` char(10) NOT NULL,
  `sdt` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manhanvien`, `macuahang`, `tennhanvien`, `matkhau`, `sdt`) VALUES
('hoa123', 'SN3Mot', 'hoa', 'hoa', '0849588992'),
('NV1', 'HD10', 'Nguyễn Bảo ', '11111', '0849588992');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanli`
--

CREATE TABLE `quanli` (
  `tenquanli` varchar(50) NOT NULL,
  `tencuahang` varchar(50) NOT NULL,
  `macuahang` varchar(50) NOT NULL,
  `matkhau` varchar(50) NOT NULL,
  `sdt` int(11) NOT NULL,
  `diachi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `quanli`
--

INSERT INTO `quanli` (`tenquanli`, `tencuahang`, `macuahang`, `matkhau`, `sdt`, `diachi`) VALUES
('Nguyễn An', 'Handy', 'HD10', '12345', 123456789, 'Hòa Quý');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danhsach`
--
ALTER TABLE `danhsach`
  ADD PRIMARY KEY (`masanpham`);

--
-- Chỉ mục cho bảng `doanhthu`
--
ALTER TABLE `doanhthu`
  ADD PRIMARY KEY (`ngay`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `machang`
--
ALTER TABLE `machang`
  ADD PRIMARY KEY (`masanpham`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manhanvien`);

--
-- Chỉ mục cho bảng `quanli`
--
ALTER TABLE `quanli`
  ADD PRIMARY KEY (`macuahang`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
