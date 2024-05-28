package Laprak1;

import java.util.*;
public class MainMahasiswa {
    public static void main(String[] args) {
        Scanner tots = new Scanner(System.in);

        System.out.println("Masukkan Jumlah Mahasiswa :");
        int jumlahMahasiswa = tots.nextInt();
        tots.nextLine();

        ArrayList<Mahasiswa> daftarMahasiswa = tambahMahasiswa(jumlahMahasiswa, tots);
        tampilkanDaftarMahasiswa(daftarMahasiswa);
    }

    public static void tampilkanMahasiswa(Mahasiswa mahasiswaTotal){
        System.out.printf("%-15s: %s\n", "Nama Mahasiswa", mahasiswaTotal.nama);
        System.out.printf("%-15s: %d\n", "Nim", mahasiswaTotal.nim);
        System.out.printf("%-15s: %.2f\n", "Nilai", mahasiswaTotal.nilai);
    } 

    public static void tampilkanDaftarMahasiswa(ArrayList<Mahasiswa> daftarMahasiswa){
        int i = 0;
        while (i < daftarMahasiswa.size()) {
            Mahasiswa mahasiswaTotal = daftarMahasiswa.get(i);
            tampilkanMahasiswa(mahasiswaTotal);
            System.out.println();
            i++;
        }
    }

    public static ArrayList<Mahasiswa> tambahMahasiswa(int jumlahMahasiswa, Scanner sc){
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        int i = 0;
        while (i < jumlahMahasiswa) {
            System.out.println("Masukkan Nama :");
            String namaMahasiswa = sc.nextLine();
            System.out.println("Masukkan Nim :");
            long nimMahasiswa = sc.nextLong();
            sc.nextLine();
            System.out.println("Masukkan Nilai :");
            double nilaiMahasiswa = sc.nextDouble();
            sc.nextLine();

            Mahasiswa mahasiswaTotal = new Mahasiswa(namaMahasiswa, nimMahasiswa, nilaiMahasiswa);
            daftarMahasiswa.add(mahasiswaTotal);
            i++;
        }
        return daftarMahasiswa;
    }
}