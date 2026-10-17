package com.mycompany.project9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class BoPhanHauDai {
    private List<Movie> danhSachPhim;
    private List<ThoigianChieu> danhSachSuatChieu;
    private List<PhongChieu> danhSachPhong; 
    private List<Ticket> danhSachVeDaBan; 

    public BoPhanHauDai(List<Movie> danhSachPhim, List<ThoigianChieu> danhSachSuatChieu, List<PhongChieu> danhSachPhong, List<Ticket> danhSachVeDaBan) {
        this.danhSachPhim = danhSachPhim;
        this.danhSachSuatChieu = danhSachSuatChieu;
        this.danhSachPhong = danhSachPhong;
        this.danhSachVeDaBan = danhSachVeDaBan;
    }

    public void hienThiMenuQuanLy(Scanner sc) {
        while (true) {
            System.out.println("\n================ KHOA QUAN LY - BO PHAN HAU DAI ================");
            System.out.println("1. Them bo phim moi (Tich hop tao suat chieu)");
            System.out.println("2. Them suat chieu moi cho phim co san");
            System.out.println("3. Xoa suat chieu (Xoa han hoac xoa rieng le)");
            System.out.println("4. Xem bao cao doanh thu & Xep hang phim ban chay");
            System.out.println("5. Thoat che do quan ly");
            System.out.print("Nhap lua chon cua ban (1-5): ");
            
            String luaChon = sc.nextLine().trim();
            switch (luaChon) {
                case "1":
                    themPhimMoi(sc);
                    break;
                case "2":
                    themSuatChieuMoi(sc); 
                    break;
                case "3":
                    xoaSuatChieu(sc);
                    break;
                case "4":
                    hienThiBaoCaoDoanhThuVaXepHangPhim();
                    break;
                case "5":
                    System.out.println("-> Dang dang xuat khoi phan he quan ly hau dai...");
                    return;
                default:
                    System.out.println("Loi: Lua chon khong hop le! Vui long chon tu 1 den 5.");
            }
        }
    }

    private void hienThiPhimCoSanTrongHeThong() {
        System.out.println("\n=========================================================================================");
        System.out.println("------------------------- DANH SACH PHIM HIEN CO SAN TRONG RAP --------------------------");
        System.out.println("=========================================================================================");
        System.out.printf("| %-10s | %-40s | %-15s | %-12s |%n", "Ma Phim", "Ten Bo Phim", "The Loai", "Do Tuoi");
        System.out.println("-----------------------------------------------------------------------------------------");
        if (danhSachPhim.isEmpty()) {
            System.out.println("|                           He thong hien tai chua co phim nao!                         |");
        } else {
            for (Movie m : danhSachPhim) {
                System.out.printf("| %-10s | %-40s | %-15s | %-12s |%n", 
                        m.getMaPhim().toUpperCase(), 
                        DatVe.chuanHoaDinhDangChu(m.getTenPhim()), 
                        m.getTheLoai(), 
                        m.getDoTuoiGioiHan());
            }
        }
        System.out.println("=========================================================================================");
    }

    public void themSuatChieuMoi(Scanner sc) {
        hienThiPhimCoSanTrongHeThong();
        
        System.out.println("\n--- THEM SUAT CHIEU MOI CHO PHIM CO SAN ---");
        if (danhSachPhim.isEmpty()) {
            System.out.println("Loi: He thong chua co phim nao de tao suat chieu!");
            return;
        }

        Movie phimDuocChon = null;
        while (true) {
            System.out.print("Nhap Ma phim muon tao suat chieu hoac go 'EXIT' de thoat: ");
            String maPhim = sc.nextLine().trim().toUpperCase();
            if (maPhim.equalsIgnoreCase("EXIT")) {
                System.out.println("-> Da thoat chuc nang.");
                return;
            }
            for (Movie m : danhSachPhim) {
                if (m.getMaPhim().equalsIgnoreCase(maPhim)) {
                    phimDuocChon = m;
                    break;
                }
            }
            if (phimDuocChon != null) {
                break;
            }
            System.out.println("Loi: Khong tim thay bo phim co ma vua nhap! Vui long kiem tra bang danh sach phia tren.");
        }

        hienThiSuatChieuCUAPhim(phimDuocChon.getMaPhim());

        PhongChieu phongDuocChon = null;
        while (true) {
            System.out.print("Nhap Ma phong chieu hoac go 'EXIT' de thoat: ");
            String maPhong = sc.nextLine().trim().toUpperCase();
            if (maPhong.equalsIgnoreCase("EXIT")) {
                System.out.println("-> Da thoat chuc nang.");
                return;
            }
            for (PhongChieu p : danhSachPhong) {
                if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                    phongDuocChon = p;
                    break;
                }
            }
            
            if (phongDuocChon != null) {
                if (phongDuocChon.getTrangThaiPhong().equalsIgnoreCase("Active")) {
                    break; 
                } else {
                    System.out.println("Loi (BR6): Phong chieu [" + maPhong + "] hien dang khoa hoac bao tri (Inactive)! Khong the xep lich.");
                    phongDuocChon = null; 
                }
            } else {
                System.out.println("Loi: Ma phong chieu khong hop le hoac khong ton tai!");
            }
        }

        String maSC = "";
        while (true) {
            System.out.print("Nhap Ma suat chieu moi hoac go 'EXIT' de thoat: ");
            maSC = sc.nextLine().trim().toUpperCase();
            if (maSC.equalsIgnoreCase("EXIT")) {
                System.out.println("-> Da thoat chuc nang.");
                return;
            }
            boolean trungMa = false;
            for (ThoigianChieu tc : danhSachSuatChieu) {
                if (tc.getMaSuatChieu().equalsIgnoreCase(maSC)) {
                    trungMa = true;
                    break;
                }
            }
            if (!trungMa) {
                break;
            }
            System.out.println("Loi: Ma suat chieu nay da duoc su dung!");
        }

        while (true) {
            try {
                System.out.println("-> Nhap thoi gian chieu (Hoac nhap nam = 0 de thoat):");
                System.out.print("   Nhap Ngay chieu (1-31): ");
                int ngay = Integer.parseInt(sc.nextLine().trim());
                System.out.print("   Nhap Thang chieu (1-12): ");
                int thang = Integer.parseInt(sc.nextLine().trim());
                System.out.print("   Nhap Nam chieu: ");
                int nam = Integer.parseInt(sc.nextLine().trim());

                if (nam == 0) {
                    System.out.println("-> Da thoat chuc nang.");
                    return;
                }

                if (!kiemTraNgayThangHopLe(ngay, thang, nam)) {
                    System.out.println("Vui long kiem tra va nhap lai dung moc thoi gian!");
                    continue;
                }

                System.out.print("   Nhap Gio bat dau (0-23): ");
                int gio = Integer.parseInt(sc.nextLine().trim());
                System.out.print("   Nhap Phut bat dau (0-59): ");
                int phut = Integer.parseInt(sc.nextLine().trim());

                if (gio < 0 || gio > 23 || phut < 0 || phut > 59) {
                    System.out.println("Loi: Gio hoac phut khong hop le! Vui long nhap lai.");
                    continue;
                }

                if (kiemTraTrungLichChieu(phongDuocChon, ngay, thang, nam, gio, phut, phimDuocChon)) {
                    System.out.println("Vui long thiet la lai thoi gian hoac phong khac!");
                    continue;
                }

                ThoigianChieu tcMoi = new ThoigianChieu(phimDuocChon, phongDuocChon, maSC, ngay, thang, nam, gio, phut, 0.0, "Scheduled");
                tcMoi.tinhGiaVe(); 
                danhSachSuatChieu.add(tcMoi);
                System.out.println("-> Da them suat chieu moi len he thong lich chieu thanh cong!");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Loi: Cac truong ngay/thang/nam/gio/phut phai nhap bang so nguyen.");
            }
        }
    }

    private void hienThiBaoCaoDoanhThuVaXepHangPhim() {
        System.out.println("\n=========================================================================================================");
        System.out.println("================== BAO CAO DOANH THU & THONG KE XEP HANG DOANH SO PHIM BHD STAR ========================");
        System.out.println("=========================================================================================================");

        double tongTienGiaLapHeThong = 0;
        double tongTienThucTeHeThong = 0;

        Map<String, Integer> thongKeVePhim = new HashMap<>();
        Map<String, Double> thongKeTienGiaLap = new HashMap<>();
        Map<String, Double> thongKeTienThucTe = new HashMap<>();

        for (Movie m : danhSachPhim) {
            String tenChuan = DatVe.chuanHoaDinhDangChu(m.getTenPhim());
            thongKeVePhim.put(tenChuan, 0);
            thongKeTienGiaLap.put(tenChuan, 0.0);
            thongKeTienThucTe.put(tenChuan, 0.0);
        }

        for (ThoigianChieu tc : danhSachSuatChieu) {
            if (tc.getPhim() != null) {
                String tenPhim = DatVe.chuanHoaDinhDangChu(tc.getPhim().getTenPhim());
                int soGheGiaLap = tc.getSoGheGiaLapDaBan();
                double tienGiaLap = tc.tinhDoanhThuGheGiaLap();
                
                tongTienGiaLapHeThong += tienGiaLap;
                thongKeVePhim.put(tenPhim, thongKeVePhim.getOrDefault(tenPhim, 0) + soGheGiaLap);
                thongKeTienGiaLap.put(tenPhim, thongKeTienGiaLap.getOrDefault(tenPhim, 0.0) + tienGiaLap);
            }
        }

        for (Ticket ve : danhSachVeDaBan) {
            if (ve.getTrangThaiVe().equalsIgnoreCase("Booked") || ve.getTrangThaiVe().equalsIgnoreCase("Paid")) {
                double soTienThucTe = ve.getGiaVe();
                tongTienThucTeHeThong += soTienThucTe;

                if (ve.getSuatChieu() != null && ve.getSuatChieu().getPhim() != null) {
                    String tenPhim = DatVe.chuanHoaDinhDangChu(ve.getSuatChieu().getPhim().getTenPhim());
                    int soVeDat = ve.getDanhSachGheDaChon().size();
                    
                    thongKeVePhim.put(tenPhim, thongKeVePhim.getOrDefault(tenPhim, 0) + soVeDat);
                    thongKeTienThucTe.put(tenPhim, thongKeTienThucTe.getOrDefault(tenPhim, 0.0) + soTienThucTe);
                }
            }
        }

        System.out.println("BANG XEP HANG CHI TIET DOANH SO & DOANH THU PHAN TACH (Giam dan theo so luong ve):");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-40s | %-11s | %-20s | %-20s |%n", "Ten Bo Phim", "So Ve Da Ban", "Thanh Tien Ghe Cu", "Thanh Tien Hom Nay");
        System.out.println("---------------------------------------------------------------------------------------------------------");

        List<Map.Entry<String, Integer>> danhSachXepHang = new ArrayList<>(thongKeVePhim.entrySet());
        danhSachXepHang.sort((p1, p2) -> p2.getValue().compareTo(p1.getValue()));

        int tongSoVeToanRap = 0;
        for (Map.Entry<String, Integer> entry : danhSachXepHang) {
            String tenPhim = entry.getKey();
            int veBan = entry.getValue();
            double tienGiaLapPhim = thongKeTienGiaLap.getOrDefault(tenPhim, 0.0);
            double tienThucTePhim = thongKeTienThucTe.getOrDefault(tenPhim, 0.0);
            
            tongSoVeToanRap += veBan;

            System.out.printf("| %-40s | %-8s ve | %-16s VND | %-16s VND |%n", 
                    tenPhim, veBan, String.format("%,.0f", tienGiaLapPhim), String.format("%,.0f", tienThucTePhim));
        }
        
        double tongDoanhThuChung = tongTienGiaLapHeThong + tongTienThucTeHeThong;

        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-40s | %-8s ve | %-16s VND | %-16s VND |%n", 
                "TONG CONG TUNG COT", tongSoVeToanRap, String.format("%,.0f", tongTienGiaLapHeThong), String.format("%,.0f", tongTienThucTeHeThong));
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("=> TONG DOANH THU THU HOACH CHUNG TOAN HE THONG: %,.0f VND%n", tongDoanhThuChung);
        System.out.println("=========================================================================================================");
    }

    private void hienThiDanhSachPhimHienTai() {
        System.out.println("\n--------------------------- DANH SACH PHIM DANG CO LICH CHIEU ---------------------------");
        if (danhSachPhim.isEmpty()) {
            System.out.println("[He thong trong]: Chua co bo phim nao!");
            System.out.println("-----------------------------------------------------------------------------------------");
            return;
        }
        for (Movie m : danhSachPhim) {
            System.out.printf("[%s] - %-40s | The loai: %-25s | Tuoi: %s%n", 
                    m.getMaPhim().toUpperCase(), DatVe.chuanHoaDinhDangChu(m.getTenPhim()), m.getTheLoai(), m.getDoTuoiGioiHan());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private void hienThiToanBoSuatChieuHeThong() {
        System.out.println("\n---------------------------- LICHTRINH CHIEU TOAN BO HE THONG ----------------------------");
        System.out.println("=====================================================================================================================");
        System.out.printf("| %-8s | %-35s | %-20s | %-12s | %-8s | %-15s |%n", "Ma SC", "Ten Phim", "Phong Chieu", "Ngay Chieu", "Gio", "Gia Ve");
        System.out.println("=====================================================================================================================");
        
        if (danhSachSuatChieu.isEmpty()) {
            System.out.println("|                               He thong hien tai trong suat chieu!                                                 |");
        } else {
            for (ThoigianChieu tc : danhSachSuatChieu) {
                tc.hienThiThongTin();
            }
        }
        System.out.println("=====================================================================================================================");
    }

    private void hienThiSuatChieuCUAPhim(String maPhim) {
        System.out.println("\n--- DANH SACH SUAT CHIEU HIEN CO CUA MA PHIM [" + maPhim.toUpperCase() + "] ---");
        System.out.println("=====================================================================================================================");
        System.out.printf("| %-8s | %-35s | %-20s | %-12s | %-8s | %-15s |%n", "Ma SC", "Ten Phim", "Phong Chieu", "Ngay Chieu", "Gio", "Gia Ve");
        System.out.println("=====================================================================================================================");
        
        int count = 0;
        for (ThoigianChieu tc : danhSachSuatChieu) {
            if (tc.getPhim().getMaPhim().equalsIgnoreCase(maPhim)) {
                tc.hienThiThongTin();
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("|                      Phim nay hien tai chua co suat chieu nao duoc len lich!                                       |");
        }
        System.out.println("=====================================================================================================================");
    }

    private boolean kiemTraNgayThangHopLe(int ngay, int thang, int nam) {
        if (nam < 2000 || nam > 2100) return false;
        if (thang < 1 || thang > 12) return false;
        if (ngay < 1 || ngay > 31) return false;
        try {
            java.time.LocalDate ngayNhap = java.time.LocalDate.of(nam, thang, ngay);
            java.time.LocalDate ngayHienTai = java.time.LocalDate.now();
            java.time.LocalDate mocToiThieu = ngayHienTai.plusMonths(1);
            
            if (ngayNhap.isBefore(mocToiThieu)) {
                System.out.printf("Loi: Suat chieu phai duoc tao truoc it nhat 1 thang! Ngay hien tai: %s. Ngay nhap toi thieu phai tu: %s%n", 
                        ngayHienTai.toString(), mocToiThieu.toString());
                return false;
            }
            return true;
        } catch (java.time.DateTimeException e) {
            System.out.println("Loi: Ngay thang khong ton tai tren lich thuc te!");
            return false;
        }
    }

    private boolean kiemTraTrungLichChieu(PhongChieu phong, int ngay, int thang, int nam, int gio, int phut, Movie phimMoi) {
        int thoiGianBatDauMoi = gio * 60 + phut;
        int thoiGianKetThucMoi = thoiGianBatDauMoi + phimMoi.getThoiLuong();

        for (ThoigianChieu tc : danhSachSuatChieu) {
            if (tc.getPhong().getMaPhong().equalsIgnoreCase(phong.getMaPhong()) 
                && tc.getNgayChieu() == ngay 
                && tc.getThangChieu() == thang 
                && tc.getNamChieu() == nam) {
                
                int thoiGianBatDauCu = tc.getGioBatDau() * 60 + tc.getPhutBatDau();
                int thoiGianKetThucCu = thoiGianBatDauCu + tc.getPhim().getThoiLuong();

                if (thoiGianBatDauMoi < thoiGianKetThucCu && thoiGianKetThucMoi > thoiGianBatDauCu) {
                    System.out.println("\nLoi: Trung lich chieu (BR7)!");
                    System.out.printf("-> Phong [%s] vao ngay %02d/%02d/%d da co phim '%s' chieu tu %02d:%02d den %02d:%02d.%n",
                            phong.getMaPhong().toUpperCase(), ngay, thang, nam, DatVe.chuanHoaDinhDangChu(tc.getPhim().getTenPhim()),
                            tc.getGioBatDau(), tc.getPhutBatDau(), (thoiGianKetThucCu / 60), (thoiGianKetThucCu % 60));
                    return true; 
                }
            }
        }
        return false; 
    }

    public void themPhimMoi(Scanner sc) {
        hienThiDanhSachPhimHienTai();
        System.out.println("\n--- THEM BO PHIM MOI ---");
        
        String maPhim = "";
        while (true) {
            System.out.print("Nhap Ma phim moi (VD: P013): ");
            maPhim = sc.nextLine().trim().toUpperCase(); 
            if (maPhim.isEmpty()) {
                System.out.println("Loi: Ma phim khong duoc de trong!");
                continue;
            }
            
            boolean trungMa = false;
            for (Movie m : danhSachPhim) {
                if (m.getMaPhim().equalsIgnoreCase(maPhim)) {
                    trungMa = true;
                    break;
                }
            }
            
            if (trungMa) {
                System.out.println("Loi: Ma phim nay da ton tai tren he thong! Vui long nhap lai.");
            } else {
                break;
            }
        }
        
        System.out.print("Nhap Ten phim: ");
        String fontTenPhim = sc.nextLine().trim();
        fontTenPhim = DatVe.chuanHoaDinhDangChu(fontTenPhim); 

        List<String> danhSachTheLoaiHopLe = new ArrayList<>();
        for (Movie m : danhSachPhim) {
            boolean daTonTai = false;
            for (String tl : danhSachTheLoaiHopLe) {
                if (tl.equalsIgnoreCase(m.getTheLoai())) {
                    daTonTai = true;
                    break;
                }
            }
            if (!daTonTai && m.getTheLoai() != null && !m.getTheLoai().isEmpty()) {
                danhSachTheLoaiHopLe.add(m.getTheLoai());
            }
        }

        String theLoai = "";
        while (true) {
            System.out.print("Nhap The loai: ");
            theLoai = sc.nextLine().trim();
            theLoai = DatVe.chuanHoaDinhDangChu(theLoai);
            
            String theLoaiKhopGoc = null;
            for (String tl : danhSachTheLoaiHopLe) {
                if (tl.equalsIgnoreCase(theLoai)) {
                    theLoaiKhopGoc = tl;
                    break;
                }
            }
            
            if (theLoaiKhopGoc != null) {
                theLoai = theLoaiKhopGoc;
                break;
            } else {
                System.out.println("Loi: The loai phim khong hop le hoac chua co tren he thong rap!");
                System.out.print("Cac the loai hien tai hop le gom: ");
                for (int i = 0; i < danhSachTheLoaiHopLe.size(); i++) {
                    System.out.print(danhSachTheLoaiHopLe.get(i));
                    if (i < danhSachTheLoaiHopLe.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\nVui long kiem tra ky tu va nhap lai.");
            }
        }
        
        int thoiLuong = 0;
        while (true) {
            System.out.print("Nhap thoi luong phim (phut): ");
            try {
                thoiLuong = Integer.parseInt(sc.nextLine().trim());
                if (thoiLuong > 0 && thoiLuong < 300) break;
                System.out.println("Loi: Thoi luong phai > 0 va < 300 phut!");
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen hop le!");
            }
        }

        String doTuoiGioiHan = "Moi lua tuoi";
        String theLoaiChuanHoa = theLoai.toLowerCase();

        if (theLoaiChuanHoa.contains("manga") || theLoaiChuanHoa.contains("tam ly")) {
            doTuoiGioiHan = "13+";
        } else if (theLoaiChuanHoa.contains("hoat hinh")) {
            doTuoiGioiHan = "Moi lua tuoi";
        } else if (theLoaiChuanHoa.contains("trinh tham") || theLoaiChuanHoa.contains("kinh di")) {
            doTuoiGioiHan = "18+";
        } else if (theLoaiChuanHoa.contains("hanh dong")) {
            doTuoiGioiHan = "16+";
        }

        System.out.println("-> He thong tu dong nhan dien do tuoi gioi han cho phim: " + doTuoiGioiHan);

        Movie phimMoi = new Movie(maPhim, fontTenPhim, theLoai, thoiLuong, doTuoiGioiHan, "Coming Soon");
        danhSachPhim.add(phimMoi);
        System.out.println("-> Them phim moi vao danh sach thanh cong!");

        System.out.print("\nBan co muon tao luon suat chieu cho bo phim moi nay khong? (Y/N): ");
        String xacNhan = sc.nextLine().trim();
        if (!xacNhan.equalsIgnoreCase("Y")) {
            System.out.println("-> Bo qua buoc tao suat chieu.");
            return;
        }

        PhongChieu phongDuocChon = null;
        while (true) {
            System.out.print("Nhap Ma phong chieu (VD: ROOM01, ROOM02...) hoac go 'EXIT' de thoat: ");
            String maPhong = sc.nextLine().trim().toUpperCase(); 
            if (maPhong.equalsIgnoreCase("EXIT")) {
                System.out.println("-> Da thoat luong tao suat chieu.");
                return;
            }
            for (PhongChieu p : danhSachPhong) {
                if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                    phongDuocChon = p;
                    break;
                }
            }
            
            if (phongDuocChon != null) {
                if (phongDuocChon.getTrangThaiPhong().equalsIgnoreCase("Active")) {
                    break; 
                } else {
                    System.out.println("Loi (BR6): Phong chieu [" + maPhong + "] hien dang khoa hoac bao tri (Inactive)! Khong the xep lich.");
                    phongDuocChon = null; 
                }
            } else {
                System.out.println("Loi: Ma phong chieu khong dung hoac khong ton tai!");
            }
        }

        String maSC = "";
        while (true) {
            System.out.print("Nhap Ma suat chieu moi (VD: DRM06, CN03...) hoac go 'EXIT' de thoat: ");
            maSC = sc.nextLine().trim().toUpperCase(); 
            if (maSC.equalsIgnoreCase("EXIT")) {
                System.out.println("-> Da thoat luong tao suat chieu.");
                return;
            }
            boolean trungMa = false;
            for (ThoigianChieu tc : danhSachSuatChieu) {
                if (tc.getMaSuatChieu().equalsIgnoreCase(maSC)) {
                    trungMa = true;
                    break;
                }
            }
            if (!trungMa) {
                break;
            }
            System.out.println("Loi: Ma suat chieu nay da ton tai tren he thong!");
        }

        while (true) {
            try {
                System.out.println("-> Nhap thoi gian chieu (Hoac nhap nam = 0 de huy thoat):");
                System.out.print("   Nhap Ngay chieu (1-31): ");
                int ngay = Integer.parseInt(sc.nextLine().trim());
                System.out.print("   Nhap Thang chieu (1-12): ");
                int thang = Integer.parseInt(sc.nextLine().trim());
                System.out.print("   Nhap Nam chieu: ");
                int nam = Integer.parseInt(sc.nextLine().trim());

                if (nam == 0) {
                    System.out.println("-> Da thoat luong tao suat chieu.");
                    return;
                }

                if (!kiemTraNgayThangHopLe(ngay, thang, nam)) {
                    System.out.println("Vui long kiem tra va nhap lai dung moc thoi gian!");
                    continue;
                }

                System.out.print("   Nhap Gio bat dau (0-23): ");
                int gio = Integer.parseInt(sc.nextLine().trim());
                System.out.print("   Nhap Phut bat dau (0-59): ");
                int phut = Integer.parseInt(sc.nextLine().trim());
                
                if (gio < 0 || gio > 23 || phut < 0 || phut > 59) {
                    System.out.println("Loi: Khung gio hoac phut khong hop le! Vui long nhap lai.");
                    continue;
                }

                if (kiemTraTrungLichChieu(phongDuocChon, ngay, thang, nam, gio, phut, phimMoi)) {
                    System.out.println("Vui long chon khung gio khac hoac phong chieu khac!");
                    continue; 
                }

                ThoigianChieu tcMoi = new ThoigianChieu(phimMoi, phongDuocChon, maSC, ngay, thang, nam, gio, phut, 0.0, "Scheduled");
                tcMoi.tinhGiaVe(); 
                danhSachSuatChieu.add(tcMoi);
                System.out.println("-> Da tao thanh cung bo phim va suat chieu di kem!");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Loi: Cac truong ngay/thang/nam/gio/phut bat buoc phai nhap bang so nguyen!");
            }
        }
    }

    private void xoaSuatChieu(Scanner sc) {
        while (true) {
            System.out.println("\n--- PHAN HE XOA SUAT CHIEU ---");
            System.out.println("1. Quet va xoa toan bo cac suat chieu truoc moc ngay tu chon");
            System.out.println("2. Xoa rieng le tung suat chieu theo Ma");
            System.out.println("3. Quay lai menu quan ly");
            System.out.print("Nhap lua chon cua ban (1-3): ");
            
            String luaChonXoa = sc.nextLine().trim();
            if (luaXoaChon(luaChonXoa, sc)) {
                return;
            }
        }
    }

    private boolean luaXoaChon(String luaChonXoa, Scanner sc) {
        if (luaChonXoa.equals("1")) {
            int ngay = 0, thang = 0, nam = 0;
            java.time.LocalDate ngayMoc = null;
            
            while (true) {
                try {
                    System.out.println("-> Nhap moc thoi gian ban muon quet xoa (Suat chieu TRUOC ngay nay se bi xoa):");
                    System.out.print("   Nhap Ngay: ");
                    ngay = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("   Nhap Thang: ");
                    thang = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("   Nhap Nam: ");
                    nam = Integer.parseInt(sc.nextLine().trim());
                    
                    ngayMoc = java.time.LocalDate.of(nam, thang, ngay);
                    break;
                } catch (Exception e) {
                    System.out.println("Loi: Ngay thang nhap vao khong hop le hoac sai dinh dang so! Vui long nhap lai.");
                }
            }

            List<ThoigianChieu> danhSachXoa = new ArrayList<>();
            for (ThoigianChieu tc : danhSachSuatChieu) {
                java.time.LocalDate ngaySuatChieu = java.time.LocalDate.of(tc.getNamChieu(), tc.getThangChieu(), tc.getNgayChieu());
                if (ngaySuatChieu.isBefore(ngayMoc)) {
                    danhSachXoa.add(tc);
                }
            }
            
            if (danhSachXoa.isEmpty()) {
                System.out.printf("-> Thong bao: Khong co suat chieu nao dien ra truoc ngay %02d/%02d/%d de xoa.%n", ngay, thang, nam);
            } else {
                danhSachSuatChieu.removeAll(danhSachXoa);
                System.out.printf("-> Thanh cong! Da quet va giai phong %d suat chieu dien ra truoc ngay %02d/%02d/%d khoi he thong.%n", 
                        danhSachXoa.size(), ngay, thang, nam);
            }
            return false;
        } else if (luaChonXoa.equals("2")) {
            hienThiToanBoSuatChieuHeThong();
            System.out.print("Nhap Ma suat chieu ban muon xoa khoi danh sach tren hoac go 'EXIT' de quay lai: ");
            String maSC = sc.nextLine().trim().toUpperCase();
            if (maSC.equalsIgnoreCase("EXIT")) {
                return false;
            }
            ThoigianChieu canXoa = null;
            for (ThoigianChieu tc : danhSachSuatChieu) {
                if (tc.getMaSuatChieu().equalsIgnoreCase(maSC)) {
                    canXoa = tc;
                    break;
                }
            }
            if (canXoa != null) {
                danhSachSuatChieu.remove(canXoa);
                System.out.println("-> Da xoa thanh cong suat chieu [" + maSC + "] khoi kho du lieu rap.");
            } else {
                System.out.println("Loi: Khong tim thay ma suat chieu phu hop de xoa!");
            }
            return false;
        } else if (luaChonXoa.equals("3")) {
            return true;
        }
        System.out.println("Loi: Lua chon phan he xoa khong hop le!");
        return false;
    }
}