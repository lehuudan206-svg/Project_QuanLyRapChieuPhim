package com.mycompany.project9;

import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class ThoigianChieu {
    private Movie phim;
    private PhongChieu phong;
    private String maSuatChieu;
    private int ngayChieu;
    private int thangChieu;
    private int namChieu;
    private int gioBatDau;
    private int phutBatDau;
    private double giaVe;
    private String trangThai; 
    protected boolean isIdSet = false;

    private String[][] soDoGhe; 
    private final String[] cacHang = {"A", "B", "C", "D", "E", "F", "G", "H"};
  
    private boolean daBanHetVe = false;
    private boolean daQuaGioChieu = false; 

    public ThoigianChieu() {
        khoiTaoSoDoGhe();
    }

    public ThoigianChieu(Movie phim, PhongChieu phong, String maSuatChieu, 
                        int ngayChieu, int thangChieu, int namChieu, 
                        int gioBatDau, int phutBatDau, double giaVe, String trangThai) {
        this.phim = phim;
        this.phong = phong;
        this.maSuatChieu = maSuatChieu != null ? maSuatChieu.trim().toUpperCase() : "";
        this.ngayChieu = ngayChieu;
        this.thangChieu = thangChieu;
        this.namChieu = namChieu;
        this.gioBatDau = gioBatDau;
        this.phutBatDau = phutBatDau;
        this.giaVe = giaVe;
        
        if (trangThai != null && (trangThai.equalsIgnoreCase("Scheduled") 
                || trangThai.equalsIgnoreCase("Cancelled") 
                || trangThai.equalsIgnoreCase("Completed"))) {
            this.trangThai = trangThai.substring(0, 1).toUpperCase() + trangThai.substring(1).toLowerCase();
        } else {
            this.trangThai = "Scheduled"; 
        }
        
        this.isIdSet = true;
        khoiTaoSoDoGhe();
    }

    private String chuanHoaDinhDangTen(String str) {
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

    public void lamDayGheGiaLap() {
        this.daBanHetVe = true;
    }

    public void setQuaGioGiaLap() {
        this.daQuaGioChieu = true;
    }

    public boolean isQuaGioChieu() {
        return this.daQuaGioChieu;
    }

    public boolean isHetGhe() {
        if (this.daBanHetVe) {
            return true; 
        }
        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            for (int j = 0; j < soCot; j++) {
                if (soDoGhe[i][j] != null && !soDoGhe[i][j].equals("X")) {
                    return false; 
                }
            }
        }
        return true; 
    }

    private void khoiTaoSoDoGhe() {
        soDoGhe = new String[8][13];
        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            for (int j = 0; j < soCot; j++) {
                soDoGhe[i][j] = cacHang[i] + (j + 1); 
            }
        }
  
        if (!this.daBanHetVe) {
            java.util.Random rand = new java.util.Random();
            for (int i = 0; i < 8; i++) {
                int soCot = (cacHang[i].equals("H")) ? 10 : 13;
                for (int j = 0; j < soCot; j++) {
                    if (rand.nextInt(7) == 0) {
                        soDoGhe[i][j] = "X";
                    }
                }
            }
        }
    }

    public void hienThiSoDoGhe() {
        System.out.println("\n----------------- SO DO GHE NGOI PHONG CHIEU -----------------");
        System.out.println("                 =========================                    ");
        System.out.println("                 ||       MAN HINH      ||                    ");
        System.out.println("                 =========================                    \n");

        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            if (cacHang[i].equals("H")) {
                System.out.print("      "); 
            }
            for (int j = 0; j < soCot; j++) {
                String ghe = soDoGhe[i][j];
                if (ghe.equals("X")) {
                    System.out.print("[ X ] ");
                } else {
                    System.out.printf("[%2s] ", ghe); 
                }
            }
            System.out.println();
            if (cacHang[i].equals("C") || cacHang[i].equals("G")) {
                System.out.println(); 
            }
        }
        System.out.println("\n(Ghi chu: [ X ] la ghe da co nguoi dat, [Ma Ghe] la ghe con trong)");
        System.out.println("--------------------------------------------------------------");
    }

    public boolean datGhe(String maGheYeuCau) {
        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            for (int j = 0; j < soCot; j++) {
                if (soDoGhe[i][j] != null && soDoGhe[i][j].equalsIgnoreCase(maGheYeuCau)) {
                    soDoGhe[i][j] = "X";
                    return true;
                }
            }
        }
        return false;
    }

    public boolean datGheHienTaiGiaLap(String maGheGiaoDien) {
        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            for (int j = 0; j < soCot; j++) {
                if (soDoGhe[i][j] != null && soDoGhe[i][j].equalsIgnoreCase(maGheGiaoDien)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Movie getPhim() {
        return phim;
    }

    public PhongChieu getPhong() {
        return phong;
    }

    public String getMaSuatChieu() {
        return maSuatChieu != null ? maSuatChieu.toUpperCase() : "";
    }

    public int getNgayChieu() {
        return ngayChieu;
    }

    public int getThangChieu() {
        return thangChieu;
    }

    public int getNamChieu() {
        return namChieu;
    }

    public int getGioBatDau() {
        return gioBatDau;
    }

    public int getPhutBatDau() {
        return phutBatDau;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setTrangThai(String trangThai) { 
        if (trangThai != null && (trangThai.equalsIgnoreCase("Scheduled") 
                || trangThai.equalsIgnoreCase("Cancelled") 
                || trangThai.equalsIgnoreCase("Completed"))) {
            this.trangThai = trangThai.substring(0, 1).toUpperCase() + trangThai.substring(1).toLowerCase();
        } else {
            System.out.println("Loi: Trang thai suat chieu khong hop le!");
        }
    }

    public String getTrangThai() {
        return this.trangThai;
    }
    
    public double tinhGiaVe() {
        if (phong == null) return 0;
        
        double giaThucTe = phong.tinhGiaVe();
        int thoiGianBatDauPhut = gioBatDau * 60 + phutBatDau;
        
        int mocBatDauPhuThu = 19 * 60;
        int mocKetThucPhuThu = 23 * 60;
        
        if (thoiGianBatDauPhut >= mocBatDauPhuThu && thoiGianBatDauPhut <= mocKetThucPhuThu) {
            giaThucTe += 20000;
        }
        
        this.giaVe = giaThucTe;
        return giaThucTe;
    }

    public double tinhDoanhThuGheGiaLap() {
        int soGheDaBanGiaLap = 0;
        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            for (int j = 0; j < soCot; j++) {
                if (soDoGhe[i][j] != null && soDoGhe[i][j].equals("X")) {
                    soGheDaBanGiaLap++;
                }
            }
        }
        return soGheDaBanGiaLap * this.giaVe;
    }

    public int getSoGheGiaLapDaBan() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int soCot = (cacHang[i].equals("H")) ? 10 : 13;
            for (int j = 0; j < soCot; j++) {
                if (soDoGhe[i][j] != null && soDoGhe[i][j].equals("X")) {
                    count++;
                }
            }
        }
        return count;
    }

    public void hienThiThongTin() {
        String ngay = String.format("%02d/%02d/%d", ngayChieu, thangChieu, namChieu);
        String gio = String.format("%02d:%02d", gioBatDau, phutBatDau);
        
        String maSCIn = getMaSuatChieu(); 
        String tenPhimIn = phim != null ? chuanHoaDinhDangTen(phim.getTenPhim()) : ""; 
        String maPhongIn = phong != null ? phong.getMaPhong().toUpperCase() : ""; 
        String loaiPhongIn = phong != null ? phong.getLoaiPhong() : "";

        System.out.printf("| %-8s | %-35s | %-20s | %-12s | %-8s | %-15s |%n",
                maSCIn, tenPhimIn, maPhongIn + " (" + loaiPhongIn + ")", ngay, gio, String.format("%,.0f VND", giaVe));
    }
}