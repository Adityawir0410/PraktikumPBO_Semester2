package Laprak8;

import java.util.Scanner;

interface Payable {
   int getPayableAmount();
}

class Invoice implements Payable {
   private String productName;
   private int quantity;
   private int pricePerItem;

   public Invoice(String productName, int quantity, int pricePerItem) {
       this.productName = productName;
       this.quantity = quantity;
       this.pricePerItem = pricePerItem;
   }

   public String getProductName() {
       return productName;
   }

   public int getQuantity() {
       return quantity;
   }

   public int getPricePerItem() {
       return pricePerItem;
   }

   @Override
   public int getPayableAmount() {
       return quantity * pricePerItem;
   }
}

class Employee implements Payable {
   private int registrationNumber;
   private String name;
   private int salaryPerMonth;
   private Invoice[] invoices;

   public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
       this.registrationNumber = registrationNumber;
       this.name = name;
       this.salaryPerMonth = salaryPerMonth;
       this.invoices = invoices;
   }

   public int getRegistrationNumber() {
       return registrationNumber;
   }

   public String getName() {
       return name;
   }

   public int getSalaryPerMonth() {
       return salaryPerMonth;
   }

   public Invoice[] getInvoices() {
       return invoices;
   }

   public void setInvoices(Invoice[] invoices) {
       this.invoices = invoices;
   }

   @Override
   public int getPayableAmount() {
       int totalInvoiceAmount = 0;
       for (Invoice invoice : invoices) {
           totalInvoiceAmount += invoice.getPayableAmount();
       }
       return salaryPerMonth - totalInvoiceAmount;
   }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Masukkan nama karyawan: ");
       String name = scanner.nextLine();

       System.out.print("Masukkan nomor registrasi: ");
       int registrationNumber = scanner.nextInt();

       System.out.print("Masukkan gaji per bulan: ");
       int salaryPerMonth = scanner.nextInt();

       System.out.print("Banyak jenis produk yang ingin dibeli: ");
       int numInvoices = scanner.nextInt();
       scanner.nextLine();

       Invoice[] invoices = new Invoice[numInvoices];
       for (int i = 0; i < numInvoices; i++) {
           System.out.println("Produk ke-" + (i + 1));
           System.out.print("Masukkan nama produk: ");
           String productName = scanner.nextLine();

           System.out.print("Banyak produk yang ingin dibeli: ");
           int quantity = scanner.nextInt();

           System.out.print("Harga per item: ");
           int pricePerItem = scanner.nextInt();
           scanner.nextLine();

           Invoice invoice = new Invoice(productName, quantity, pricePerItem);
           invoices[i] = invoice;
       }

       Employee employee = new Employee(registrationNumber, name, salaryPerMonth, invoices);

       System.out.println("===== KOPERASI NV. MENEER =====");
       System.out.printf("%-20s: %s\n", "Nama", employee.getName());
       System.out.printf("%-20s: %d\n", "Nomor Registrasi", employee.getRegistrationNumber());
       System.out.printf("%-20s: %d\n", "Gaji per Bulan", employee.getSalaryPerMonth());
       System.out.println();

       for (int i = 0; i < employee.getInvoices().length; i++) {
           Invoice invoice = employee.getInvoices()[i];
           System.out.println("Produk ke-" + (i + 1) + " : " + invoice.getProductName());
           System.out.printf("%-30s: %d\n", "Banyak Produk yang Ingin Dibeli", invoice.getQuantity());
           System.out.printf("%-30s: %d\n", "Harga per Item", invoice.getPricePerItem());
       }

       System.out.println("=====================================================");
       System.out.printf("%-20s: %s\n", "Nama", employee.getName());
       System.out.printf("%-20s: %d\n", "Nomor Registrasi", employee.getRegistrationNumber());
       System.out.printf("%-20s: %d\n", "Gaji per Bulan", employee.getSalaryPerMonth());
       System.out.println("=====================================================");
       System.out.println("                   PRODUK YANG DIBELI                ");
       System.out.println("=====================================================");
       System.out.printf("%-20s%-20s%-20s\n", "Nama Produk", "Harga per Item", "Jumlah Produk");

       for (Invoice invoice : employee.getInvoices()) {
           System.out.printf("%-20s%-20d%-20d\n", invoice.getProductName(), invoice.getPricePerItem(), invoice.getQuantity());
       }

       System.out.println("=====================================================");
       System.out.printf("%-30s: %d\n", "Pembelian Produk Koperasi", calculateTotalInvoiceAmount(employee.getInvoices()));
       System.out.printf("%-30s: %d\n", "Gaji Setelah Dipotong", employee.getPayableAmount());
       System.out.println("=====================================================");

       scanner.close();
   }

   private static int calculateTotalInvoiceAmount(Invoice[] invoices) {
       int totalInvoiceAmount = 0;
       for (Invoice invoice : invoices) {
           totalInvoiceAmount += invoice.getPayableAmount();
       }
       return totalInvoiceAmount;
   }
}