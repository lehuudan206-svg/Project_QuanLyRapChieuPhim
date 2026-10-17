package com.mycompany.project9;

import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */
public class PhongVip extends PhongChieu{
      private double giaVeVip = 90000;

    public PhongVip() {
    }

    public PhongVip(String maPhong, int soLuongGhe, String trangThaiPhong) {
        super(maPhong, soLuongGhe, trangThaiPhong);
    }

    @Override
    public String getLoaiPhong() {
        return "VIP";
    }

    @Override
    public double tinhGiaVe() {
        return giaVeVip;
    }
}