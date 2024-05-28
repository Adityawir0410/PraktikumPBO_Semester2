package Laprak9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private int orderId;
    private String customerName;
    private String shippingAddress;
    private String billingAddress;
    private List<Item> items;

    public Order(int orderId, String customerName, String shippingAddress, String billingAddress, List<Item> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.items = items;
    }

    public void printOrder() {
        System.out.println("------------------------------");
        System.out.println("Nomor Pesanan: " + orderId);
        System.out.println("Nama Pelanggan: " + customerName);
        System.out.println("Alamat Pengirim: " + shippingAddress);
        System.out.println("Alamat Penerima: " + billingAddress);
        System.out.println("Barang: ");
        for (Item item : items) {
            System.out.println("- " + item.getName() + " (Jumlah: " + item.getQuantity() + ")");
        }
        System.out.println("Jumlah Barang: " + getTotalItems());
        System.out.println("------------------------------");
    }

    private int getTotalItems() {
        int total = 0;
        for (Item item : items) {
            total += item.getQuantity();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.println("Selamat datang di aplikasi pemesanan!");

        while (true) {
            System.out.println("------------------------------");
            System.out.println("\nPilih opsi:");
            System.out.println("1. Tambah pesanan baru");
            System.out.println("2. Tampilkan daftar pesanan");
            System.out.println("3. Hapus Nomor Pesanan");
            System.out.println("4. Keluar");
            System.out.println("------------------------------");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nomor pesanan: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan nama pelanggan: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Masukkan alamat pengirim: ");
                    String shippingAddress = scanner.nextLine();

                    System.out.print("Masukkan alamat penerima: ");
                    String billingAddress = scanner.nextLine();

                    List<Item> items = new ArrayList<>();
                    while (true) {
                        System.out.print("Masukkan nama barang (atau 'selesai' untuk menghentikan): ");
                        String itemName = scanner.nextLine();

                        if (itemName.equalsIgnoreCase("selesai")) {
                            break;
                        }

                        System.out.print("Masukkan jumlah: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        items.add(new Item(itemName, quantity));
                    }

                    Order order = new Order(orderId, customerName, shippingAddress, billingAddress, items);
                    orders.add(order);
                    System.out.println("Pesanan berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.println("Daftar Pesanan:");
                    for (Order ord : orders) {
                        ord.printOrder();
                    }
                    break;
                case 3:
                    System.out.println("Masukkan nomor pesanan yang ingin dihapus:");
                    int orderIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Order ord : orders) {
                        if (ord.getOrderId() == orderIdToDelete) {
                            System.out.println("Pesanan dengan nomor " + orderIdToDelete + " atas nama "
                                    + ord.getCustomerName() + " berhasil dihapus.");
                            orders.remove(ord);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Nomor pesanan tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}