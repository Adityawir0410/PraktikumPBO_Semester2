package Laprak3;
public class Customer {
    private String customerNumber;
    private String name;
    private double balance;
    private String pin;
    private int failedAttempts;

    public Customer(String customerNumber, String name, double balance, String pin) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.failedAttempts = 0;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean authenticate(String pin) {
        if (this.pin.equals(pin)) {
            this.failedAttempts = 0;
            return true;
        } else {
            this.failedAttempts++;
            if (this.failedAttempts >= 3) {
                // Block the account
                System.out.println("Akun diblokir karena 3x kesalahan dalam autentifikasi");
            }
            return false;
        }
    }

    public void topUp(double amount) {
        this.balance += amount;
    }

    public boolean purchase(double amount) {
        if (this.balance - amount < 10000) {
            System.out.println("Transaksi gagal. Saldo minimal Rp10.000");
            return false;
        }

        double cashback = 0;
        if (amount > 1000000) {
            switch (customerNumber.substring(0, 2)) {
                case "38":
                    cashback = amount * 0.05;
                    break;
                case "56":
                    cashback = amount * 0.07;
                    break;
                case "74":
                    cashback = amount * 0.10;
                    break;
            }
        }

        this.balance = this.balance - amount + cashback;
        return true;
    }
}
