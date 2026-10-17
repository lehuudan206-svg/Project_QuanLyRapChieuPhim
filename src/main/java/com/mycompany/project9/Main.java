package com.mycompany.project9;

import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        DatVe heThongDatVe = new DatVe();

        while (true) {
            System.out.println("\n========================================================");
            System.out.println("========= HE THONG QUAN LY RAP CHIEU PHIM BHD =========");
            System.out.println("========================================================");
            System.out.println("1. Xem danh sach phim hien co tai rap");
            System.out.println("2. Tien hanh mua ve xem phim (Danh cho Khach hang)");
            System.out.println("3. Dang nhap Bo phan Hau dai (Danh cho Quan ly rap)");
            System.out.println("4. Thoat chuong trinh");
            System.out.println("========================================================");
            System.out.print("Chon chuc nang he thong (1-4): ");
            
            String luaChon = sc.nextLine().trim();
            
            switch (luaChon) {
                case "1":
                    System.out.println("\n=========================================================================================");
                    System.out.println("------------------------- DANH SACH PHIM HIEN CO SAN TRONG RAP --------------------------");
                    System.out.println("=========================================================================================");
                    System.out.printf("| %-10s | %-40s | %-15s | %-12s |%n", "Ma Phim", "Ten Bo Phim", "The Loai", "Do Tuoi");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    if (heThongDatVe.getDanhSachPhim().isEmpty()) {
                        System.out.println("|                           He thong hien tai chua co phim nao!                         |");
                    } else {
                        for (Movie m : heThongDatVe.getDanhSachPhim()) {
                            System.out.printf("| %-10s | %-40s | %-15s | %-12s |%n", 
                                    m.getMaPhim().toUpperCase(), 
                                    DatVe.chuanHoaDinhDangChu(m.getTenPhim()), 
                                    m.getTheLoai(), 
                                    m.getDoTuoiGioiHan());
                        }
                    }
                    System.out.println("=========================================================================================");
                    break;
                    
                case "2":
                    heThongDatVe.thucHienDatVe(sc);
                    break;
                    
                case "3":
                    BoPhanHauDai hauDai = new BoPhanHauDai(
                            heThongDatVe.getDanhSachPhim(), 
                            heThongDatVe.getDanhSachSuatChieu(), 
                            heThongDatVe.getDanhSachPhong(),
                            heThongDatVe.getDanhSachVeDaBan()
                    );
                    hauDai.hienThiMenuQuanLy(sc);
                    break;
                    
                case "4":
                    System.out.println("\n-> Dang dong ket noi co so du lieu... Giai phong bo nho.");
                    System.out.println("Cam on ban da su dung phan mem quan ly rap phim BHD! Hen gap lai.");
                    sc.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Loi: Chuc nang khong hop le! Vui long nhap dung ky tu so tu 1 den 4.");
            }
        }
    }
}