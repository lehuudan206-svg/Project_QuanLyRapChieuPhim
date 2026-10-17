package com.mycompany.project9;

import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class PhongThuong extends PhongChieu {
    
    private double giaVeThuong = 60000;

    public PhongThuong() {
    }

    public PhongThuong(String maPhong, int soLuongGhe, String trangThaiPhong) {
        super(maPhong, soLuongGhe, trangThaiPhong);
    }

    @Override
    public String getLoaiPhong() {
        return "Standard";
    }

    @Override
    public double tinhGiaVe() {
        return giaVeThuong;
    }
}