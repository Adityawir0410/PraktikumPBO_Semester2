package Laprak4.TugasPraktikum;

public class MahasiswaFILKOM extends Manusia {
    public String nim, status;
    public double ipk, beasiswa;

    public MahasiswaFILKOM(String nim, double ipk, String nama, String nik, boolean kelamin, boolean menikah) {
        super(nama, nik, kelamin, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public String getJurusan() {
        String jurusan = "null";
        String kode = nim.substring(6, 7);

        switch (kode) {
            case "2":
                jurusan = "Teknik Informatika";
                break;
            case "4":
                jurusan = "Teknik Komputer";
                break;
            case "5":
                jurusan = "Sistem Informasi";
                break;
            case "7":
                jurusan = "Pendidikan Teknologi Informasi";
                break;
            case "8":
                jurusan = "Teknologi Informasi";
                break;
        }

        return jurusan;
    }

    public String getTahun() {
        String tahun = nim.substring(0, 2);
        return "20" + tahun;
    }

    public String getStatus() {
        status = getJurusan() + ", " + getTahun();
        return status;
    }

    public double hitungBantuan() {
        double bantuan = 0;
        if (ipk >= 3.0 && ipk <= 3.5) {
            bantuan += 50;
        }
        if (ipk > 3.5) {
            bantuan += 75;
        }
        return bantuan;
    }

    public double getBantuan() {
        beasiswa = hitungBantuan();
        return beasiswa;
    }

    @Override
    public double getPendapatan() {
        pendapatan += getTunjangan() + getBantuan();
        return pendapatan;
    }

    public void cetakNIM() {
        System.out.println("NIM           : " + nim);
    }

    public void cetakIPK() {
        System.out.println("IPK           : " + ipk);
    }

    public void cetakStatus() {
        System.out.println("Status        : " + getStatus());
    }

    public String toString() {
        super.toString();
        cetakNIM();
        cetakIPK();
        cetakStatus();
        String dummy = "\n";
        return dummy;
    }
}
