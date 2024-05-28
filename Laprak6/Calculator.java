package Laprak6;

import java.util.Scanner;

public class Calculator {
    private double numerator;
    private double denominator;

    public Calculator(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static String add(double a, double b) {
        double result = a + b;
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    public static String subtract(double a, double b) {
        double result = a - b;
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    public String multiply(double a) {
        double result = this.numerator * a;
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    public String divide(double a) {
        if (a != 0) {
            double result = this.numerator / a;
            result = Math.round(result * 100.0) / 100.0;
            if (result == (int) result) {
                return String.valueOf((int) result);
            } else {
                return String.format("%.2f", result);
            }
        } else {
            throw new IllegalArgumentException("Pembagian dengan nol tidak diperbolehkan!");
        }
    }

    public void simplify() {
        double gcd = findGCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private double findGCD(double a, double b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public void display() {
        if (this.denominator == 1) {
            System.out.println((int) this.numerator);
        } else {
            System.out.println((int) this.numerator + "/" + (int) this.denominator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        System.out.print("Masukkan bilangan pertama: ");
        num1 = scanner.nextDouble();
        System.out.print("Masukkan bilangan kedua: ");
        num2 = scanner.nextDouble();

        while (true) {
            System.out.println("\n==== Selamat datang di kode kalkulator ====");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Penyederhanaan Pecahan");
            System.out.println("6. Keluar");
            System.out.println("7. Ganti Bilangan");
            System.out.print("Pilih operasi (1-7): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String resultAdd = Calculator.add(num1, num2);
                    System.out.println("Hasil penjumlahan: " + resultAdd);
                    break;
                case 2:
                    String resultSubtract = Calculator.subtract(num1, num2);
                    System.out.println("Hasil pengurangan: " + resultSubtract);
                    break;
                case 3:
                    Calculator calc = new Calculator(num1, num2);
                    String resultMultiply = calc.multiply(num2);
                    System.out.println("Hasil perkalian: " + resultMultiply);
                    break;
                case 4:
                    calc = new Calculator(num1, num2);
                    try {
                        String resultDivide = calc.divide(num2);
                        System.out.println("Hasil pembagian: " + resultDivide);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    calc = new Calculator(num1, num2);
                    System.out.print("Pecahan sebelum disederhanakan: ");
                    calc.display();
                    calc.simplify();
                    System.out.print("Pecahan setelah disederhanakan: ");
                    calc.display();
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan kalkulator!");
                    System.exit(0);
                case 7:
                    System.out.println("Pilih bilangan yang ingin diganti:");
                    System.out.println("1. Bilangan pertama");
                    System.out.println("2. Bilangan kedua");
                    System.out.print("Pilih (1-2): ");
                    int changeChoice = scanner.nextInt();
                    if (changeChoice == 1) {
                        System.out.print("Masukkan bilangan pertama yang baru: ");
                        num1 = scanner.nextDouble();
                    } else if (changeChoice == 2) {
                        System.out.print("Masukkan bilangan kedua yang baru: ");
                        num2 = scanner.nextDouble();
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
