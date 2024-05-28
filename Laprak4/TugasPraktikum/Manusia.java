package Laprak4.TugasPraktikum;

public class Manusia {
    public String nama, nik;
    public boolean jenisKelamin, menikah;
    public double pendapatan, tunjangan;

    public Manusia(String nama, String nik, boolean gender, boolean menikah) {
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = gender;
        this.menikah = menikah;
    }
    public double hitungTunjangan() {
        double jumlahTunjangan = 0;
        if (menikah == true && jenisKelamin == true) {
            jumlahTunjangan += 25;
        }
        if (menikah == true && jenisKelamin == false) {
            jumlahTunjangan += 20;
        }
        if (menikah == false) {
            jumlahTunjangan += 15;
        }
        return jumlahTunjangan;
    }

    public double getTunjangan() {
        tunjangan = hitungTunjangan();
        return tunjangan;
    }

    public double hitungPendapatan() {
        return pendapatan + getTunjangan();
    }

    public double getPendapatan() {
        pendapatan = hitungPendapatan();
        return pendapatan;
    }

    @Override
    public String toString() {
        printNama();
        printNIK();
        printJenisKelamin();
        printPendapatan();
        String dummy = "\n";
        return dummy;
    }

    public void printNama() {
        System.out.println("Nama          : " + nama);
    }

    public void printNIK() {
        System.out.println("NIK           : " + nik);
    }

    public void printJenisKelamin() {
        System.out.print("Jenis Kelamin : ");
        if (jenisKelamin == true) {
            System.out.println("Laki-laki");
        } else {
            System.out.println("Perempuan");
        }
    }

    public void printPendapatan() {
        System.out.println("Pendapatan    : " + getPendapatan());
    }
}