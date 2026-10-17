package com.mycompany.project9;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public abstract class PhongChieu {
    protected String maPhong;
    protected int soLuongGhe;
    protected String trangThaiPhong;
    protected boolean isIdSet = false;

    public PhongChieu() {}

    public PhongChieu(String maPhong, int soLuongGhe, String trangThaiPhong) {
        if (maPhong == null || maPhong.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma phong khong duoc de trong!");
        }
        if (soLuongGhe <= 0) {
            throw new IllegalArgumentException("So luong ghe phai lon hon 0!");
        }
        if (trangThaiPhong == null || (!trangThaiPhong.equalsIgnoreCase("Active") 
                && !trangThaiPhong.equalsIgnoreCase("Inactive"))) {
            throw new IllegalArgumentException("Trang thai phong khong hop le (Active/Inactive)!");
        }

        this.maPhong = maPhong.trim();
        this.soLuongGhe = soLuongGhe;
        this.trangThaiPhong = trangThaiPhong.trim();
        this.isIdSet = true;
    }

    public String getMaPhong() { return maPhong; }
    public int getSoLuongGhe() { return soLuongGhe; }
    public String getTrangThaiPhong() { return trangThaiPhong; }
    
    public void setMaPhong(String maPhong) {
        if (!isIdSet) {
            this.maPhong = maPhong;
            this.isIdSet = true;
        } else {
            System.out.println("Loi: Khong duoc phep sua ma phong chieu!");
        }
    }

    public void setSoLuongGhe(int soLuongGhe) {
        if (soLuongGhe > 0) this.soLuongGhe = soLuongGhe;
    }

    public void setTrangThaiPhong(String trangThaiPhong) {
        if (trangThaiPhong != null && (trangThaiPhong.equalsIgnoreCase("Active") 
                || trangThaiPhong.equalsIgnoreCase("Inactive"))) {
            this.trangThaiPhong = trangThaiPhong.trim();
        }
    }

    public abstract String getLoaiPhong();
    public abstract double tinhGiaVe();

    public void input(List<PhongChieu> danhSachTong) {
        Scanner sc = new Scanner(System.in);
       
        if (!isIdSet) {
            while (true) {
                System.out.print("Nhap ma phong: ");
                String maNhap = sc.nextLine().trim();
                if (maNhap.isEmpty()) {
                    System.out.println("Loi: Ma phong khong duoc de trong!");
                    continue;
                }
                
                boolean trungMa = false;
                if (danhSachTong != null) {
                    for (PhongChieu p : danhSachTong) {
                        if (p.getMaPhong().equalsIgnoreCase(maNhap)) {
                            trungMa = true;
                            break;
                        }
                    }
                }
                
                if (trungMa) {
                    System.out.println("Loi: Ma phong [" + maNhap + "] da ton tai! Vui long dung ma khac.");
                } else {
                    this.maPhong = maNhap;
                    this.isIdSet = true;
                    break;
                }
            }
        } else {
            System.out.println("Ma phong hien tai: " + maPhong);
            System.out.println("Khong duoc sua ma phong!");
        }

        while (true) {
            try {
                System.out.print("Nhap so luong ghe: ");
                soLuongGhe = Integer.parseInt(sc.nextLine());
                if (soLuongGhe <= 0) {
                    System.out.println("Loi: So ghe phai > 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen!");
            }
        }

        while (true) {
            System.out.print("Nhap trang thai phong (Active / Inactive): ");
            trangThaiPhong = sc.nextLine().trim();
            if (trangThaiPhong.equalsIgnoreCase("Active") || trangThaiPhong.equalsIgnoreCase("Inactive")) {
                break;
            }
            System.out.println("Loi: Trang thai khong hop le!");
        }
    }

    public void hienThiThongTin() {
        System.out.println("===== THONG TIN PHONG =====");
        System.out.println("Ma phong: " + maPhong);
        System.out.println("Loai phong: " + getLoaiPhong());
        System.out.println("So luong ghe: " + soLuongGhe);
        System.out.println("Trang thai phong: " + trangThaiPhong);
        System.out.printf("Gia ve co ban: %,.0f VND%n", tinhGiaVe());
        System.out.println("===========================");
    }
}