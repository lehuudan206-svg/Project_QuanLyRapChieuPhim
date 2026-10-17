package com.mycompany.project9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class Ticket {
    private String maVe;
    private ThoigianChieu suatChieu; 
    private List<String> danhSachGheDaChon; 
    private double giaVe;
    private String trangThaiVe; 
    private boolean isIdSet = false;

    public Ticket() {
        this.maVe = "";
        this.danhSachGheDaChon = new ArrayList<>();
        this.trangThaiVe = "Pending";
    }

    public Ticket(String maVe, ThoigianChieu suatChieu, List<String> danhSachGheDaChon, String trangThaiVe) {
        if (maVe == null || maVe.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma ve khong duoc de trong!");
        }
        this.maVe = maVe.trim();
        this.suatChieu = suatChieu;
        this.danhSachGheDaChon = danhSachGheDaChon != null ? danhSachGheDaChon : new ArrayList<>();
        this.giaVe = suatChieu != null ? (suatChieu.getGiaVe() * this.danhSachGheDaChon.size()) : 0; 
        this.trangThaiVe = trangThaiVe;
        this.isIdSet = true;
    }

    public String getMaVe() {
        return maVe; 
    }
    
    public ThoigianChieu getSuatChieu() {
        return suatChieu; 
    }

    public List<String> getDanhSachGheDaChon() {
        return danhSachGheDaChon;
    }

    public double getGiaVe() {
        if (suatChieu != null) {
            return suatChieu.getGiaVe() * danhSachGheDaChon.size();
        }
        return giaVe;
    }

    public String getTrangThaiVe() {
        return trangThaiVe;
    }
    
    public void setMaVe(String maVe) {
        if (!isIdSet) {
            this.maVe = maVe;
            this.isIdSet = true;
        } else {
            System.out.println("Loi: Khong duoc sua ma ve!");
        }
    }

    public void setSuatChieu(ThoigianChieu suatChieu) {
        this.suatChieu = suatChieu;
    }

    public void setTrangThaiVe(String trangThaiVe) { 
        this.trangThaiVe = trangThaiVe; 
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        
        if (!isIdSet) {
            do {
                System.out.print("Nhap ma ve: ");
                maVe = sc.nextLine().trim();
                if (maVe.isEmpty()) {
                    System.out.println("Loi: Ma ve khong duoc de trong!");
                }
            } while (maVe.isEmpty());
            isIdSet = true;
        }

        if (this.suatChieu == null) {
            System.out.println("Loi: Ve nay chua duoc lien ket voi Suat chieu nao!");
            return;
        }

        this.suatChieu.hienThiSoDoGhe();
        this.trangThaiVe = "Pending"; 
        this.danhSachGheDaChon.clear();

        System.out.println("Ban co the chon nhieu ghe cung luc, phan cach bang dau phay (VD: A1,A2,B5)");
        
        while (true) {
            System.out.print("Nhap cac ma ghe ban muon dat: ");
            String inputGhe = sc.nextLine().trim();
            
            if (inputGhe.isEmpty()) {
                System.out.println("Loi (BR17): Khong duoc de trong ma ghe!");
                continue;
            }

            String[] mangGheNhap = inputGhe.split(",");
            List<String> danhSachTam = new ArrayList<>();
            boolean tatCaHopLe = true;

            for (String ghe : mangGheNhap) {
                String gheChuanHoa = ghe.trim().toUpperCase();
                if (gheChuanHoa.isEmpty()) continue;

                boolean datThanhCong = this.suatChieu.datGhe(gheChuanHoa);
                if (datThanhCong) {
                    danhSachTam.add(gheChuanHoa);
                } else {
                    System.out.println("Loi: Ghe [" + gheChuanHoa + "] khong ton tai hoac da co nguoi dat!");
                    tatCaHopLe = false;
                    break; 
                }
            }

            if (tatCaHopLe && !danhSachTam.isEmpty()) {
                this.danhSachGheDaChon.addAll(danhSachTam);
                System.out.println("-> Ban da chon cac ghe " + danhSachGheDaChon + " thanh cong!");
                break; 
            } else {
                if (danhSachTam.isEmpty() && tatCaHopLe) {
                    System.out.println("Loi (BR11): So luong ve/ghe dat phai lon hon 0! Vui long nhap lai.");
                } else {
                    System.out.println("Vui long kiem tra so do va nhap lai toan bo cac ghe muon dat.");
                }
            }
        }
    }

    public void hienThiThongTin() {
        System.out.println("===== THONG TIN VE XEM PHIM =====");
        System.out.println("Ma ve: " + this.maVe);
        
        if (this.suatChieu != null) {
            System.out.println("Ten phim: " + this.suatChieu.getPhim().getTenPhim());
            System.out.println("Phong chieu: " + this.suatChieu.getPhong().getMaPhong() 
                    + " (" + this.suatChieu.getPhong().getLoaiPhong() + ")");
            System.out.printf("Gia ve don chiec: %,.0f VND%n", this.suatChieu.getGiaVe());
            System.out.println("So luong ghe dat: " + this.danhSachGheDaChon.size());
            System.out.printf("Tong tien thanh toan: %,.0f VND%n", this.getGiaVe());
        }
        
        System.out.println("Danh sach ghe ngoi: " + (this.danhSachGheDaChon.isEmpty() ? "Chua chon" : this.danhSachGheDaChon));
        System.out.println("Trang thai ve: " + this.trangThaiVe); 
        System.out.println("=================================");
    }
}