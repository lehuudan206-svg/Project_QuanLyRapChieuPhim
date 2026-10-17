package com.mycompany.project9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */

public class DatVe {
    private List<Movie> danhSachPhim;
    private List<PhongChieu> danhSachPhong;
    private List<ThoigianChieu> danhSachSuatChieu;
    private List<Ticket> danhSachVeDaBan;
    private ThanhToan boPhanThanhToan;

    public DatVe() {
        this.danhSachPhim = new ArrayList<>();
        this.danhSachPhong = new ArrayList<>();
        this.danhSachSuatChieu = new ArrayList<>();
        this.danhSachVeDaBan = new ArrayList<>();
        this.boPhanThanhToan = new ThanhToan();
        
        khoiTaoDuLieu();
    }

    public static String chuanHoaDinhDangChu(String str) {
        if (str == null || str.trim().isEmpty()) return "";
        String[] words = str.trim().replaceAll("\\s+", " ").split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    private void khoiTaoDuLieu() {
        Movie m1 = new Movie("P001", chuanHoaDinhDangChu("Doraemon: Ban Giao Huong Dia Cau"), "Hoat hinh", 115, "Moi lua tuoi", "Now Showing");
        Movie m2 = new Movie("P002", chuanHoaDinhDangChu("Tam Biet Gohan"), "Tam ly", 120, "13+", "Now Showing");
        Movie m3 = new Movie("P003", chuanHoaDinhDangChu("Ngoi Den Ky Quai 4"), "Kinh di", 110, "16+", "Now Showing");
        Movie m4 = new Movie("P004", chuanHoaDinhDangChu("Conan Movie 27: Ngoi Sao Nam Canh"), "Manga", 110, "13+", "Coming Soon");
        Movie m5 = new Movie("P005", chuanHoaDinhDangChu("Lat Mat 7: Mot Dieu Uoc"), "Gia dinh", 138, "Moi lua tuoi", "Coming Soon");
        Movie m6 = new Movie("P006", chuanHoaDinhDangChu("Haikyu!!: Tran Chien Bai Phe Lieu"), "The thao", 85, "Moi lua tuoi", "Coming Soon");
        Movie m7 = new Movie("P007", chuanHoaDinhDangChu("Deadpool & Wolverine"), "Hanh dong", 127, "18+", "Coming Soon");
        Movie m8 = new Movie("P008", chuanHoaDinhDangChu("Inside Out 2"), "Hoat hinh", 100, "Moi lua tuoi", "Coming Soon");
        Movie m9 = new Movie("P009", chuanHoaDinhDangChu("Despicable Me 4"), "Hai huoc", 95, "Moi lua tuoi", "Coming Soon");
        Movie m10 = new Movie("P010", chuanHoaDinhDangChu("Furiosa: Chien Binh Sa Mac"), "Hanh dong", 148, "16+", "Coming Soon");
        Movie m11 = new Movie("P011", chuanHoaDinhDangChu("Vung Dat Cam Lang: Ngay Mot"), "Kinh di", 100, "16+", "Coming Soon");
        Movie m12 = new Movie("P012", chuanHoaDinhDangChu("Hanh Tinh Khi: Vuong Quoc Moi"), "Vien tuong", 145, "13+", "Coming Soon");

        danhSachPhim.add(m1); danhSachPhim.add(m2); danhSachPhim.add(m3);
        danhSachPhim.add(m4); danhSachPhim.add(m5); danhSachPhim.add(m6);
        danhSachPhim.add(m7); danhSachPhim.add(m8); danhSachPhim.add(m9);
        danhSachPhim.add(m10); danhSachPhim.add(m11); danhSachPhim.add(m12);

        PhongChieu r1 = new PhongThuong("ROOM01", 60, "Active");
        PhongChieu r2 = new PhongVip("ROOM02", 30, "Active");
        PhongChieu r3 = new PhongThuong("ROOM03", 60, "Active");
        PhongChieu r4 = new PhongVip("ROOM04", 30, "Active");
        PhongChieu r5 = new PhongThuong("ROOM05", 60, "Active");
        PhongChieu r6 = new PhongVip("ROOM06", 30, "Active");
        
        danhSachPhong.add(r1); danhSachPhong.add(r2); danhSachPhong.add(r3);
        danhSachPhong.add(r4); danhSachPhong.add(r5); danhSachPhong.add(r6);

        danhSachSuatChieu.add(new ThoigianChieu(m1, r1, "DRM01", 13, 5, 2026, 8, 30, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m1, r1, "DRM02", 17, 6, 2026, 11, 45, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m1, r2, "DRM03", 17, 4, 2026, 14, 0, 0.0, "Scheduled")); 
        danhSachSuatChieu.add(new ThoigianChieu(m1, r3, "DRM04", 19, 6, 2026, 17, 15, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m1, r4, "DRM05", 21, 6, 2026, 20, 30, 0.0, "Scheduled"));

        danhSachSuatChieu.add(new ThoigianChieu(m2, r2, "GH01", 14, 3, 2026, 9, 0, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m2, r5, "GH02", 18, 6, 2026, 13, 30, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m2, r6, "GH03", 20, 5, 2026, 16, 0, 0.0, "Scheduled")); 
        danhSachSuatChieu.add(new ThoigianChieu(m2, r1, "GH04", 23, 6, 2026, 19, 45, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m2, r2, "GH05", 26, 6, 2026, 21, 0, 0.0, "Scheduled"));

        danhSachSuatChieu.add(new ThoigianChieu(m3, r3, "NDKQ01", 13, 2, 2026, 10, 15, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m3, r3, "NDKQ02", 17, 6, 2026, 14, 30, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m3, r4, "NDKQ03", 19, 6, 2026, 18, 0, 0.0, "Scheduled")); 
        danhSachSuatChieu.add(new ThoigianChieu(m3, r5, "NDKQ04", 24, 6, 2026, 20, 15, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m3, r6, "NDKQ05", 27, 6, 2026, 22, 0, 0.0, "Scheduled"));

        danhSachSuatChieu.add(new ThoigianChieu(m4, r4, "CCN01", 13, 4, 2026, 11, 0, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m4, r1, "CCN02", 18, 6, 2026, 15, 0, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m4, r2, "CCN03", 21, 3, 2026, 17, 30, 0.0, "Scheduled")); 
        danhSachSuatChieu.add(new ThoigianChieu(m4, r3, "CCN04", 25, 6, 2026, 19, 0, 0.0, "Scheduled"));
        danhSachSuatChieu.add(new ThoigianChieu(m4, r4, "CCN05", 28, 6, 2026, 21, 30, 0.0, "Scheduled"));

        Movie[] phimConLai = {m5, m6, m7, m8, m9, m10, m11, m12};
        String[] tienTo = {"LM", "HQ", "DW", "IO", "DM", "FR", "VDC", "HTK"};
        int indexTienTo = 0;
        int ngayDem = 17;
        
        for (Movie p : phimConLai) {
            String prefix = tienTo[indexTienTo++];
            danhSachSuatChieu.add(new ThoigianChieu(p, r5, prefix + "01", 13, 6, 2026, 12, 0, 0.0, "Scheduled"));
            danhSachSuatChieu.add(new ThoigianChieu(p, r6, prefix + "02", ngayDem, 6, 2026, 14, 15, 0.0, "Scheduled"));
            danhSachSuatChieu.add(new ThoigianChieu(p, r1, prefix + "03", ngayDem + 2, 6, 2026, 16, 45, 0.0, "Scheduled")); 
            danhSachSuatChieu.add(new ThoigianChieu(p, r2, prefix + "04", ngayDem + 4, 6, 2026, 19, 0, 0.0, "Scheduled"));
            danhSachSuatChieu.add(new ThoigianChieu(p, r3, prefix + "05", ngayDem + 6, 6, 2026, 21, 15, 0.0, "Scheduled"));
            ngayDem = (ngayDem >= 23) ? 17 : ngayDem + 1;
        }

        for (ThoigianChieu tc : danhSachSuatChieu) {
            tc.tinhGiaVe();
        }
    }

    public void thucHienDatVe(Scanner sc) {
        while (true) { 
            System.out.println("============================ CHAO MUNG BAN DEN VOI RAP CHIEU PHIM ============================");
            
            System.out.println("\n------------------------------ DANH SACH PHIM SAP CHIEU ---------------------------------");
            for (Movie m : danhSachPhim) {
                System.out.printf("[%s] - %-40s | The loai: %-15s | Tuoi: %s%n", 
                        m.getMaPhim().toUpperCase(), chuanHoaDinhDangChu(m.getTenPhim()), m.getTheLoai(), m.getDoTuoiGioiHan());
            }

            Movie phimChon = null;
            List<ThoigianChieu> lichTrinhLoc = new ArrayList<>();

            while (true) {
                phimChon = null;
                do {
                    System.out.print("\nNhap Ma phim ban muon xem: ");
                    String maPhim = sc.nextLine().trim().toUpperCase(); 
                    for (Movie m : danhSachPhim) {
                        if (m.getMaPhim().equalsIgnoreCase(maPhim)) {
                            phimChon = m;
                            break;
                        }
                    }
                    if (phimChon == null) {
                        System.out.println("Loi: Ma phim khong hop le! Vui long nhap lai.");
                    }
                } while (phimChon == null);

                lichTrinhLoc.clear();
                for (ThoigianChieu tc : danhSachSuatChieu) {
                    if (tc.getPhim().getMaPhim().equalsIgnoreCase(phimChon.getMaPhim())) {
                        lichTrinhLoc.add(tc);
                    }
                }

                if (lichTrinhLoc.isEmpty()) {
                    System.out.println("Thong bao: Bo phim '" + chuanHoaDinhDangChu(phimChon.getTenPhim()) + "' hien tai chua co lich chieu! Vui long chon phim khac.");
                    System.out.println("------------------------------------------------------------------------------------------------------");
                } else {
                    java.util.Collections.sort(lichTrinhLoc, new java.util.Comparator<ThoigianChieu>() {
                        @Override
                        public int compare(ThoigianChieu tc1, ThoigianChieu tc2) {
                            if (tc1.getNamChieu() != tc2.getNamChieu()) return Integer.compare(tc1.getNamChieu(), tc2.getNamChieu());
                            if (tc1.getThangChieu() != tc2.getThangChieu()) return Integer.compare(tc1.getThangChieu(), tc2.getThangChieu());
                            if (tc1.getNgayChieu() != tc2.getNgayChieu()) return Integer.compare(tc1.getNgayChieu(), tc2.getNgayChieu());
                            if (tc1.getGioBatDau() != tc2.getGioBatDau()) return Integer.compare(tc1.getGioBatDau(), tc2.getGioBatDau());
                            return Integer.compare(tc1.getPhutBatDau(), tc2.getPhutBatDau());
                        }
                    });
                    break; 
                }
            }

            ThoigianChieu suatChon = null;
            String thongBaoLoi = ""; 

            do {
                if (!thongBaoLoi.isEmpty()) {
                    System.out.println("=====================================================================================================================");
                    System.out.println(thongBaoLoi);
                    System.out.println("=====================================================================================================================");
                    thongBaoLoi = ""; 
                }

                System.out.println("\n--- LICH CHIEU CUA PHIM: " + phimChon.getTenPhim().toUpperCase() + " ---");
                System.out.println("=====================================================================================================================");
                System.out.printf("| %-8s | %-35s | %-20s | %-12s | %-8s | %-15s |%n", "Ma SC", "Ten Phim", "Phong Chieu", "Ngay Chieu", "Gio", "Gia Ve");
                System.out.println("=====================================================================================================================");
                
                for (ThoigianChieu tc : lichTrinhLoc) {
                    tc.hienThiThongTin();
                }
                System.out.println("=====================================================================================================================");

                System.out.print("\nNhap Ma suat chieu ban chon: ");
                String maSC = sc.nextLine().trim().toUpperCase(); 
                
                ThoigianChieu timSuat = null;
                for (ThoigianChieu tc : lichTrinhLoc) {
                    if (tc.getMaSuatChieu().equalsIgnoreCase(maSC)) {
                        timSuat = tc;
                        break;
                    }
                }
                
                if (timSuat == null) {
                    thongBaoLoi = "LOI: Ma suat chieu [" + maSC + "] khong ton tai trong he thong! Vui long chon lai.";
                    continue;
                }

                java.time.LocalDateTime thoiGianHienTai = java.time.LocalDateTime.now();
                java.time.LocalDateTime thoiGianSuatChieu = java.time.LocalDateTime.of(
                        timSuat.getNamChieu(), timSuat.getThangChieu(), timSuat.getNgayChieu(),
                        timSuat.getGioBatDau(), timSuat.getPhutBatDau()
                );

                if (thoiGianSuatChieu.isBefore(thoiGianHienTai) || thoiGianSuatChieu.isEqual(thoiGianHienTai)) {
                    thongBaoLoi = String.format("LOI: Suat chieu [%s] da qua gio chieu hoac dang dien ra (%02d:%02d ngay %02d/%02d/%d)! Khong the dat ve.", 
                            maSC, timSuat.getGioBatDau(), timSuat.getPhutBatDau(), 
                            timSuat.getNgayChieu(), timSuat.getThangChieu(), timSuat.getNamChieu());
                    suatChon = null;
                    continue; 
                }

                if (timSuat.getMaSuatChieu().endsWith("03")) {
                    thongBaoLoi = "LOI: Suat chieu [" + maSC + "] hien tai da het ve! (Da xoa vinh vien)";
                    danhSachSuatChieu.remove(timSuat); 
                    lichTrinhLoc.remove(timSuat);      
                    suatChon = null;
                    continue;
                }

                if (timSuat.isQuaGioChieu()) {
                    thongBaoLoi = "LOI: Suat chieu nay da qua gio phat song!";
                    danhSachSuatChieu.remove(timSuat); 
                    lichTrinhLoc.remove(timSuat);
                    suatChon = null;
                } else if (timSuat.isHetGhe()) {
                    thongBaoLoi = "LOI: Suat chieu nay hien tai da het ghe ngoi!";
                    danhSachSuatChieu.remove(timSuat); 
                    lichTrinhLoc.remove(timSuat);
                    suatChon = null;
                } else {
                    suatChon = timSuat; 
                }
                
            } while (suatChon == null);

            System.out.println("\n--- TIEN HANH CHON GHE ---");
            Ticket veMoi = new Ticket();
            veMoi.setMaVe("TICK" + (danhSachVeDaBan.size() + 1)); 
            
            veMoi.setSuatChieu(suatChon);
            veMoi.setTrangThaiVe("Pending"); 
            veMoi.input(); 

            System.out.println("\n--- THONG TIN VE TAM TINH ---");
            veMoi.hienThiThongTin();

            System.out.print("\nBan co chac chan muon thanh toan chiec ve nay khong? (Y/N): ");
            String xacNhan = sc.nextLine().trim();
            
            if (xacNhan.equalsIgnoreCase("Y")) {
                System.out.println("\n--- CO QUAN THANH TOAN: NHAP THONG TIN TUNG KHACH HANG ---");
                
                int soLuongGhe = veMoi.getDanhSachGheDaChon().size();
                List<String> danhSachHoTen = new ArrayList<>();
                List<Integer> danhSachTuoi = new ArrayList<>();
                
                boolean phatHienChuaDuTuoi = false;

                for (int idx = 0; idx < soLuongGhe; idx++) {
                    String gheHienTai = veMoi.getDanhSachGheDaChon().get(idx);
                    System.out.println("\n>> Nhap thong tin cho nguoi ngoi ghe [" + gheHienTai + "]:");
                    
                    String hoTen = "";
                    while (hoTen.isEmpty()) {
                        System.out.print("   Nhap ho va ten: ");
                        hoTen = sc.nextLine().trim();
                        if (hoTen.isEmpty()) {
                            System.out.println("   Loi: Ho ten khong duoc de trong!");
                        }
                    }
                    hoTen = chuanHoaDinhDangChu(hoTen);
                    
                    int tuoi = 0;
                    while (true) {
                        System.out.print("   Nhap tuoi: ");
                        try {
                            tuoi = Integer.parseInt(sc.nextLine().trim());
                            if (tuoi <= 0) {
                                System.out.println("   Loi: Tuoi phai la so nguyen duong!");
                                continue;
                            }
                            
                            String gioiHanTuoi = phimChon.getDoTuoiGioiHan(); 
                            if ((gioiHanTuoi.contains("13") && tuoi < 13) ||
                                (gioiHanTuoi.contains("16") && tuoi < 16) ||
                                (gioiHanTuoi.contains("18") && tuoi < 18)) {
                                
                                System.out.println("   Loi: Phim gioi han [" + gioiHanTuoi + "]. Nguoi xem ghe " + gheHienTai + " chua du tuoi!");
                                phatHienChuaDuTuoi = true;
                            }
                            break; 
                            
                        } catch (NumberFormatException ex) {
                            System.out.println("   Loi: Vui long nhap tuoi bang ky tu so!");
                        }
                    }
                    
                    if (phatHienChuaDuTuoi) {
                        break; 
                    }

                    danhSachHoTen.add(hoTen);
                    danhSachTuoi.add(tuoi);
                }
                
                if (phatHienChuaDuTuoi) {
                    System.out.println("\n========================================================");
                    System.out.print("Giao dich bi gian doan do co thanh vien chua du tuoi! Ban co muon doi sang phim khac hop le hon khong? (Y/N): ");
                    String doiPhim = sc.nextLine().trim();
                    
                    if (doiPhim.equalsIgnoreCase("Y")) {
                        System.out.println("-> He thong dang chuyen huong ve danh sach phim...");
                        veMoi.setTrangThaiVe("Cancelled");
                        continue; 
                    } else {
                        System.out.println("-> Giao dich dat ve da bi huy bo vinh vien.");
                        veMoi.setTrangThaiVe("Cancelled");
                        return; 
                    }
                }

                System.out.println("\n--------------------------------------------------------");
                String hinhThucTT = "";
                while (true) {
                    System.out.print("Chon hinh thuc thanh toan (1. Tien mat / 2. Chuyen khoan): ");
                    hinhThucTT = sc.nextLine().trim();
                    if (hinhThucTT.equals("1") || hinhThucTT.equals("2")) {
                        break;
                    }
                    System.out.println("Loi: Vui long chon dung hinh thuc 1 hoac 2!");
                }

                String thongTinTaiKhoanInPhoi = "";

                if (hinhThucTT.equals("2")) {
                    String soThe = "";
                    while (true) {
                        System.out.print("Nhap so the ngan hang cua ban: ");
                        soThe = sc.nextLine().trim();
                        if (soThe.isEmpty()) {
                            System.out.println("Loi: So the khong duoc de trong!");
                        } else if (!soThe.matches("\\d+")) { 
                            System.out.println("Loi: So the ngan hang chi duoc phep chua ky tu so (0-9)!");
                        } else {
                            break;
                        }
                    }
                    thongTinTaiKhoanInPhoi = "Tai khoan thanh toan: ****" + (soThe.length() > 4 ? soThe.substring(soThe.length() - 4) : soThe);
                } else {
                    System.out.println("-> Ban da chon thanh toan bang Tien mat.");
                    double tongTienCanThu = veMoi.getGiaVe();
                    
                    while (true) {
                        System.out.printf("Vui long nhap dung so tien can thanh toan (%.0f) de xac nhan: ", tongTienCanThu);
                        try {
                            double soTienNhap = Double.parseDouble(sc.nextLine().trim());
                            if (Double.compare(soTienNhap, tongTienCanThu) == 0) {
                                System.out.println("-> Xac nhan thanh toan tien mat thanh cong!");
                                break;
                            } else {
                                System.out.println("Loi: So tien nhap vao khong khop voi hoa don! Vui long nhap lai.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Loi: Vui long nhap dung dinh dang so!");
                        }
                    }
                    thongTinTaiKhoanInPhoi = "Hinh thuc: Tien mat (Da thanh toan tai quay)";
                }
                
                veMoi.setTrangThaiVe("Booked"); 
                boPhanThanhToan.thanhToan(veMoi);
                danhSachVeDaBan.add(veMoi); 
                
                System.out.println("\n========================================================");
                System.out.println("THONG BAO: BAN DA DAT CUM VE THANH CONG!");
                for (int i = 0; i < soLuongGhe; i++) {
                    System.out.println(" - Ghe [" + veMoi.getDanhSachGheDaChon().get(i) + "] Khach hang: " + danhSachHoTen.get(i) + " | Tuoi: " + danhSachTuoi.get(i));
                }
                System.out.println(thongTinTaiKhoanInPhoi);
                System.out.println("========================================================");
                
                System.out.println("\n--- IN PHOI VE CHINH THUC GIAO CHO KHACH ---");
                veMoi.hienThiThongTin(); 
                break; 
                
            } else {
                veMoi.setTrangThaiVe("Cancelled");
                System.out.println("Giao dich da bi huy! Ghe ngoi cua ban da duoc giai phong.");
                break;
            }
        }
    }

    public List<Movie> getDanhSachPhim() { return this.danhSachPhim; }
    public List<ThoigianChieu> getDanhSachSuatChieu() { return this.danhSachSuatChieu; }
    public List<PhongChieu> getDanhSachPhong() { return this.danhSachPhong; }
    public List<Ticket> getDanhSachVeDaBan() { return this.danhSachVeDaBan; }
}