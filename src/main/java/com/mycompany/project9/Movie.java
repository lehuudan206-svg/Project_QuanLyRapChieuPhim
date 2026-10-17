package com.mycompany.project9;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class Movie {
    private String maPhim;
    private String tenPhim;
    private String theLoai;
    private int thoiLuong;
    private String doTuoiGioiHan;
    private String trangThai; 
    private boolean isIdSet = false;

    public Movie() {
        this.maPhim = "";
    }
    

    public Movie(String maPhim, String tenPhim, String theLoai, int thoiLuong, String doTuoiGioiHan, String trangThai) {
        if(maPhim == null || maPhim.trim().isEmpty()){
            throw new IllegalArgumentException("Ma phim khong duoc de trong!");
        }
        if(tenPhim == null || tenPhim.trim().isEmpty()){
            throw new IllegalArgumentException("Ten phim khong duoc de trong!");
        }
        if(theLoai == null || theLoai.trim().isEmpty()){
            throw new IllegalArgumentException("The loai phim khong duoc de trong!");
        }
        if(trangThai == null || (!trangThai.equalsIgnoreCase("Coming Soon")
                && !trangThai.equalsIgnoreCase("Now Showing")
                && !trangThai.equalsIgnoreCase("Stopped"))) {
            throw new IllegalArgumentException("Trang thai phim khong hop le!");
        }
        
        this.maPhim = maPhim.trim();
        this.tenPhim = tenPhim.trim();
        this.theLoai = theLoai.trim();
        this.thoiLuong = thoiLuong;
        this.doTuoiGioiHan = doTuoiGioiHan;
        this.trangThai = trangThai.trim();
        this.isIdSet = true;
    }

    public String getMaPhim() { return maPhim; }
    public String getTenPhim() { return tenPhim; }
    public String getTheLoai() { return theLoai; }
    public int getThoiLuong() { return thoiLuong; }
    public String getDoTuoiGioiHan() { return doTuoiGioiHan; }
    public String getTrangThai() { return trangThai; }

    public void setMaPhim(String maPhim) {
        if (!isIdSet) {
            this.maPhim = maPhim;
            this.isIdSet = true;
        } else {
            System.out.println("Loi: Khong duoc phep thay doi ma phim sau khi da tao!");
        }
    }

    public void setTenPhim(String tenPhim) {
        if (tenPhim != null && !tenPhim.trim().isEmpty()) this.tenPhim = tenPhim.trim();
    }
    public void setTheLoai(String theLoai) {
        if (theLoai != null && !theLoai.trim().isEmpty()) this.theLoai = theLoai.trim();
    }
    public void setThoiLuong(int thoiLuong) {
        if (thoiLuong > 0 && thoiLuong < 300) this.thoiLuong = thoiLuong;
    }
    public void setDoTuoiGioiHan(String doTuoiGioiHan) {
        if(doTuoiGioiHan == null || doTuoiGioiHan.trim().isEmpty()){
            throw new IllegalArgumentException("Loi: khong duoc de trong");
        }
        this.doTuoiGioiHan = doTuoiGioiHan;
    }
    public void setTrangThai(String trangThai) {
        if (trangThai != null && (trangThai.equalsIgnoreCase("Coming Soon")
                || trangThai.equalsIgnoreCase("Now Showing")
                || trangThai.equalsIgnoreCase("Stopped"))) {
            this.trangThai = trangThai.trim();
        }
    }

    public void input(List<Movie> danhSachTong) {
        Scanner sc = new Scanner(System.in);
        
        if (!isIdSet) {
            while (true) {
                System.out.print("Nhap ma phim: ");
                String maNhap = sc.nextLine().trim();
                if (maNhap.isEmpty()) {
                    System.out.println("Loi: Ma phim khong duoc de trong!");
                    continue;
                }
                
                boolean trungMa = false;
                if (danhSachTong != null) {
                    for (Movie m : danhSachTong) {
                        if (m.getMaPhim().equalsIgnoreCase(maNhap)) {
                            trungMa = true;
                            break;
                        }
                    }
                }
                
                if (trungMa) {
                    System.out.println("Loi: Ma phim [" + maNhap + "] da ton tai trong he thong! Vui long nhap ma khac.");
                } else {
                    this.maPhim = maNhap;
                    this.isIdSet = true;
                    break;
                }
            }
        } else {
            System.out.println("Dang cap nhat thong tin cho ma phim: " + maPhim);
            System.out.println("Khong duoc phep sua ma phim!");
        }

        do {
            System.out.print("Nhap ten phim: ");
            tenPhim = sc.nextLine().trim();
            if (tenPhim.isEmpty()) System.out.println("Loi: Ten phim khong duoc de trong!");
        } while (tenPhim.isEmpty());

        do {
            System.out.print("Nhap the loai: ");
            theLoai = sc.nextLine().trim();
            if (theLoai.isEmpty()) System.out.println("Loi: The loai khong duoc de trong!");
        } while (theLoai.isEmpty());

        do {
            try {
                System.out.print("Nhap thoi luong phim (VD: 180): ");
                thoiLuong = Integer.parseInt(sc.nextLine());
                if (thoiLuong <= 0 || thoiLuong >= 300) {
                    System.out.println("Loi: Thoi luong phai > 0 va < 300 phut!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap mot so nguyen hop le!");
                thoiLuong = 0; 
            }
        } while (thoiLuong <= 0 || thoiLuong >= 300);

        System.out.print("Nhap do tuoi gioi han (VD: 18+): ");
        doTuoiGioiHan = sc.nextLine().trim();

        do {
            System.out.print("Nhap trang thai (Coming Soon / Now Showing / Stopped): ");
            trangThai = sc.nextLine().trim();
            if (!trangThai.equalsIgnoreCase("Coming Soon")
                && !trangThai.equalsIgnoreCase("Now Showing")
                && !trangThai.equalsIgnoreCase("Stopped")) {
                System.out.println("Loi: Trang thai khong hop le!");
            } else {
                break;
            }
        } while (true);
    }

    public void hienThiThongTin() {
        System.out.println("----------------------------------------");
        System.out.println("Ma phim: " + maPhim);
        System.out.println("Ten phim: " + tenPhim);
        System.out.println("The loai: " + theLoai);
        System.out.println("Thoi luong: " + thoiLuong + " phut");
        System.out.println("Do tuoi han che: " + doTuoiGioiHan);
        System.out.println("Trang thai: " + trangThai);
    }   
}