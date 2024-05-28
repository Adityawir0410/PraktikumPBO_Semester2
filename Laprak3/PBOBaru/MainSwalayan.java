package Laprak3.PBOBaru;

import java.util.Scanner;

public class MainSwalayan {
    static int total, pilihan, nominal, pilih, banyak, totaltotal = 0, pin;
    static String pelanggan, simpanpelanggan = "";

    public static void main(String[] args) {
        SwalayanTiny dataplgn = null;
        String[][] Harga_barang = new String[][]{
                {"Barang", "Harga"},
                {"Beras", "Rp 45000"},
                {"Gula", "Rp 20000"},
                {"Kopi", "Rp 15000"},
                {"Minyak", "Rp 40000"},
                {"Sabun", "Rp 25000"}
        };
        int harga[] = new int[]{45000, 20000, 15000, 40000, 25000};
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1. Daftar harga barang");
            System.out.println("2. Transaksi Pembelian");
            System.out.println("3. Pembayaran Barang");
            System.out.println("4. Top Up");
            System.out.println("5. Exit");
            System.out.print("pilihan : ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("================ D A F T A R H A R G A ===================");
                    for (int i = 0; i < Harga_barang.length; i++) {
                        for (int j = 0; j < Harga_barang[i].length; j++) {
                            System.out.printf("%-20s ", Harga_barang[i][j]);
                        }
                        System.out.println("");
                    }
                    System.out.println("=============================================================\n");
                    break;
                case 2:
                    System.out.println("=================== P E M B E L I A N =====================");
                    do {
                        System.out.println("Menu");
                        System.out.println("1. Beras");
                        System.out.println("2. Gula");
                        System.out.println("3. Kopi");
                        System.out.println("4. Minyak");
                        System.out.println("5. Sabun");
                        System.out.println("6. Exit");
                        System.out.print("Pilih : ");
                        pilih = input.nextInt();

                        switch (pilih) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                System.out.print("Berapa : ");
                                banyak = input.nextInt();
                                total = harga[pilih - 1] * banyak;
                                System.out.println("Harga : " + total + "\n");
                                break;
                            default:
                                break;
                        }

                        if (pilih != 6) {
                            totaltotal += total;
                        }
                    } while (pilih != 6);

                    System.out.println("Total Pembelian : " + totaltotal);
                    System.out.println("=============================================================\n");
                    break;
                case 3:
                    System.out.println("================== P E M B A Y A R A N ====================");
                    System.out.print("Masukkan Nomor Pelanggan anda : ");
                    pelanggan = input.next();
                    System.out.print("Masukkan Pin anda : ");
                    pin = input.nextInt();
                    System.out.println("=============================================================");

                    if (simpanpelanggan.equals(pelanggan)) {
                        dataplgn.Login(pin);
                    } else {
                        dataplgn = new SwalayanTiny(pin, pelanggan);
                        dataplgn.Login(pin);
                    }

                    simpanpelanggan = pelanggan;
                    dataplgn.totalPembelian(totaltotal);
                    dataplgn.getCashBack(totaltotal);
                    System.out.println("=============================================================\n");
                    break;
                case 4:
                    System.out.println("==================== T O P U P ========================");
                    System.out.print("Masukkan nominal uang : Rp ");
                    nominal = input.nextInt();
                    dataplgn.getTopUp(nominal);
                    System.out.println("=============================================================\n");
                    break;
            }
        } while (pilihan != 5);

        System.out.println("===============================================");
    }
}
