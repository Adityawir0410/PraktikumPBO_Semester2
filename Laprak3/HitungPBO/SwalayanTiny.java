package Laprak3.HitungPBO;

import java.util.Scanner;

interface LayananPelanggan {
    String Login();
    int totalPembelian();
    int getCashBack();
    int getTopUp();
}

public class SwalayanTiny implements LayananPelanggan {
    Scanner input = new Scanner(System.in);
    private String nama;
    private String nomorpelanggan;
    private String nomor[];
    private int pembelian;
    private int pem;
    private int total;
    private int saldo;
    private int topsaldo;
    private int pin;
    private int ulang;
    private int nopel;
    private int totalsaldo;
    int[] saldoAtm = new int[]{1500000, 2000000, 2500000};

    public SwalayanTiny() {
    }

    public SwalayanTiny(String pelanggan) {
        nomorpelanggan = pelanggan;
    }

    public SwalayanTiny(int pn, String pelanggan) {
        nomorpelanggan = pelanggan;
        pin = pn;
    }

    public int getnopel() {
        nomor = nomorpelanggan.split("");
        nopel = Integer.parseInt(nomor[0] + "" + nomor[1]);
        return nopel;
    }

    public int getsaldo() {
        getnopel();
        int index = (nopel / 18) - 2;
        if (index >= 0 && index < saldoAtm.length) {
            saldo = saldoAtm[index];
        }
        return saldo;
    }
    
    public String Login() {
        System.out.print("Masukkan PIN Anda: ");
        pin = input.nextInt();
        return Login(pin);
    }

    public String Login(int pn) {
        getnopel();
        if (nopel == 11 && pn == 1234) {
            printInfo("Anak", "Silver");
        } else if (nopel == 22 && pn == 5678) {
            printInfo("Agung", "Gold");
        } else if (nopel == 33 && pn == 9009) {
            printInfo("Agung", "Platinum");
        } else {
            handleInvalidLogin();
        }
        return nomorpelanggan;
    }

    private void printInfo(String nama, String jenisKartu) {
        System.out.println("Nama: " + nama);
        System.out.println("Nomer pelanggan: " + nomorpelanggan);
        System.out.println("Jenis Kartu: Pelanggan kartu " + jenisKartu);
    }

    private void handleInvalidLogin() {
        int i = 0;
        while (!(pin == pin) && i < 2 || pin == pin) {
            System.out.print("Maaf, PIN Anda salah.\nSilahkan ulangi: ");
            ulang = input.nextInt();
            if (nopel == 11 && ulang == 1234) {
                printInfo("Anak", "Silver");
                saldo = saldoAtm[0];
                break;
            } else if (nopel == 22 && ulang == 5678) {
                printInfo("Agung", "Gold");
                saldo = saldoAtm[1];
                break;
            } else if (nopel == 33 && ulang == 9009) {
                printInfo("Ngurah", "Platinum");
                saldo = saldoAtm[2];
                break;
            }
            if (i == 1 && pin != pin) {
                System.out.println("User ID Anda diblok");
                System.out.println("==============================");
                System.exit(0);
            }
            i++;
        }
    }

    public int totalPembelian(int pembelian) {
        System.out.println("Total Pembelian: Rp " + pembelian);
        return pembelian;
    }

    public int totalPembelian() {
        System.out.print("Masukkan Total Pembelian: ");
        pembelian = input.nextInt();
        return totalPembelian(pembelian);
    }

    public int getCashBack(int pembelian) {
        getnopel();
        getsaldo();
        if (saldo >= pembelian) {
            int index = (nopel / 18) - 2;
            if (index >= 0 && index < 3) {
                int[] cashBackRates = {5, 7, 10};
                int[] defaultRates = {0, 2, 5};
                pem = (pembelian >= 1000000) ? pembelian * cashBackRates[index] / 100 : pembelian * defaultRates[index] / 100;
                saldo -= pembelian;
                total = saldo + pem;
                System.out.println("Uang kembalian ke saldo: Rp " + pem);
            }
        } else {
            System.out.println("Maaf transaksi Anda dibatalkan");
            System.out.println("Silahkan Top Up terlebih dahulu");
        }
        return total;
    }
    

    public int getCashBack() {
        System.out.print("Masukkan Total Pembelian: ");
        pembelian = input.nextInt();
        return getCashBack(pembelian);
    }

    public int getTopUp(int nominal) {
        getnopel();
        getsaldo();
        int index = (nopel / 18) - 2;
        if (index >= 0 && index < saldoAtm.length) {
            topsaldo = saldo + nominal;
            saldoAtm[index] = topsaldo;
        }
        System.out.println("Total saldo: Rp " + topsaldo);
        return topsaldo;
    }
    

    public int getTopUp() {
        System.out.print("Masukkan Nominal Top Up: ");
        int nominal = input.nextInt();
        return getTopUp(nominal);
    }
}

