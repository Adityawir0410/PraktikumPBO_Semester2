package Laprak6;

import java.util.Scanner;

public class SablonJaket {
    private static final int HARGA_JAKET_A = 100000;
    private static final int HARGA_JAKET_B = 125000;
    private static final int HARGA_JAKET_C = 175000;
    private static final int BATAS_DISKON = 100;
    private static final double DISKON = 0.05;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Selamat datang di Sablon Jaket ===");
        System.out.println("Tipe jaket yang tersedia:");
        System.out.println("1. Jaket A @ Rp" + String.format("%,.2f", (double) HARGA_JAKET_A));
        System.out.println("2. Jaket B @ Rp" + String.format("%,.2f", (double) HARGA_JAKET_B));
        System.out.println("3. Jaket C @ Rp" + String.format("%,.2f", (double) HARGA_JAKET_C));
        System.out.println("Setiap pembelian > 100 Jaket akan mendapat diskon 5%!");

        System.out.print("Tipe jaket yang ingin dipesan (1/2/3): ");
        int tipeJaket = scanner.nextInt();

        System.out.print("Jumlah pesanan: ");
        int jumlahPesanan = scanner.nextInt();

        double totalHarga = hitungTotalHarga(tipeJaket, jumlahPesanan);
        System.out.println("Total harga jaket yang harus dibayar: Rp" + String.format("%,.2f", totalHarga));
    }

    private static double hitungTotalHarga(int tipeJaket, int jumlahPesanan) {
        double hargaSatuan;

        switch (tipeJaket) {
            case 1:
                hargaSatuan = (jumlahPesanan > BATAS_DISKON) ? HARGA_JAKET_A * (1 - DISKON) : HARGA_JAKET_A;
                break;
            case 2:
                hargaSatuan = (jumlahPesanan > BATAS_DISKON) ? HARGA_JAKET_B * (1 - DISKON) : HARGA_JAKET_B;
                break;
            case 3:
                hargaSatuan = (jumlahPesanan > BATAS_DISKON) ? HARGA_JAKET_C * (1 - DISKON) : HARGA_JAKET_C;
                break;
            default:
                throw new IllegalArgumentException("Tipe jaket tidak valid");
        }

        return hargaSatuan * jumlahPesanan;
    }
}