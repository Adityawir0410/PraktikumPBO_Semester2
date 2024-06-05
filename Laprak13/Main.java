package Laprak13;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("DaftarTransaksi.txt");

            System.out.println("Kode\tJenis\tHarga");
            System.out.println("=======================");
            System.out.println("D\tDada\tRp. 2500");
            System.out.println("P\tPaha\tRp. 2000");
            System.out.println("S\tSayap\tRp. 1500\n");

            writer.write("Kode\tJenis\tHarga\n");
            writer.write("=======================\n");
            writer.write("D\tDada\tRp. 2500\n");
            writer.write("P\tPaha\tRp. 2000\n");
            writer.write("S\tSayap\tRp. 1500\n\n");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Banyak Jenis: ");
            int banyakJenis = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline yang tersisa

            String[] jenisPotong = new String[banyakJenis];
            int[] hargaSatuan = new int[banyakJenis];
            int[] banyakPotong = new int[banyakJenis];
            int[] jumlahHarga = new int[banyakJenis];
            int totalBayar = 0;

            for (int i = 0; i < banyakJenis; i++) {
                System.out.println("Jenis Ke-" + (i + 1));
                System.out.print("Jenis Potong [D/P/S]: ");
                jenisPotong[i] = scanner.nextLine();
                switch (jenisPotong[i].toUpperCase()) {
                    case "D":
                        hargaSatuan[i] = 2500;
                        break;
                    case "P":
                        hargaSatuan[i] = 2000;
                        break;
                    case "S":
                        hargaSatuan[i] = 1500;
                        break;
                    default:
                        hargaSatuan[i] = 0;
                        System.out.println("Jenis potong tidak valid.");
                        continue;
                }
                System.out.print("Banyak Potong: ");
                banyakPotong[i] = scanner.nextInt();
                scanner.nextLine();
                jumlahHarga[i] = banyakPotong[i] * hargaSatuan[i];
                totalBayar += jumlahHarga[i];
            }

            System.out.printf("%-22s %s%n", "", "Gerobak Fried Chicken");
            System.out.println("====================================================================");
            System.out.printf("%-5s %-15s %-15s %-15s %-18s%n", "No.", "Jenis Potong", "Harga Satuan", "Banyak Beli", "Jumlah Harga");
            System.out.println("====================================================================");
            for (int i = 0; i < banyakJenis; i++) {
                if (hargaSatuan[i] > 0) {
                    System.out.printf("%-5d %-15s %-15d %-15d Rp. %-15d%n", (i + 1), jenisPotong[i], hargaSatuan[i], banyakPotong[i], jumlahHarga[i]);
                }
            }
            System.out.println("====================================================================");
            System.out.printf("%57s %-2d%n", "Jumlah Bayar    Rp.", totalBayar);
            double pajak = totalBayar * 0.1;
            System.out.printf("%57s %-2.0f%n", "Pajak 10%       Rp.", pajak);
            double totalBayarPajak = totalBayar + pajak;
            System.out.printf("%57s %-2.0f%n", "Total Bayar     Rp.", totalBayarPajak);
            System.out.println("====================================================================");

            writer.write(String.format("%-22s %s%n", "", "Gerobak Fried Chicken"));
            writer.write("====================================================================\n");
            writer.write(String.format("%-5s %-15s %-15s %-15s %-18s%n", "No.", "Jenis Potong", "Harga Satuan", "Banyak Beli", "Jumlah Harga"));
            writer.write("====================================================================\n");
            for (int i = 0; i < banyakJenis; i++) {
                if (hargaSatuan[i] > 0) {
                    writer.write(String.format("%-5d %-15s %-15d %-15d Rp. %-15d%n", (i + 1), jenisPotong[i], hargaSatuan[i], banyakPotong[i], jumlahHarga[i]));
                }
            }
            writer.write("====================================================================\n");
            writer.write(String.format("%57s %-2d%n", "Jumlah Bayar    Rp.", totalBayar));
            writer.write(String.format("%57s %-2.0f%n", "Pajak 10%       Rp.", pajak));
            writer.write(String.format("%57s %-2.0f%n", "Total Bayar     Rp.", totalBayarPajak));
            writer.write("====================================================================\n");

            writer.close();
            System.out.println("Hasil output berhasil disimpan dalam file DaftarTransaksi.txt.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan dalam menulis file: " + e.getMessage());
        }
    }
}