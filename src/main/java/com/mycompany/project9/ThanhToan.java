package com.mycompany.project9;

import java.util.Scanner;

/**
 *
 * @author Dnlh1
 */

public class ThanhToan {
    
   public void thanhToan(Ticket ticket) {
        if (ticket == null) {
            System.out.println("Loi: Thong tin ve khong hop le!");
            return;
        }

        String trangThaiVe = ticket.getTrangThaiVe();

        if (trangThaiVe.equalsIgnoreCase("Cancelled")) {
            System.out.println("Khong the thanh toan vi ve da huy!");
            return;
        }

        if (trangThaiVe.equalsIgnoreCase("Paid")) {
            System.out.println("Ve nay da duoc thanh toan!");
            return;
        }

        ticket.setTrangThaiVe("Paid");
        System.out.println("Thanh toan thanh cong cho ma ve: " + ticket.getMaVe());
        System.out.printf("So tien: %,.0f VND%n", ticket.getGiaVe());
    }
}