package com.github.affandes.kuliah.pm;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private Stack<String> history = new Stack<>();

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
        } else {
            System.out.println("Riwayat browser (terbaru ke terlama):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((history.size() - i) + ". " + history.get(i));
            }
        }
    }

    public void browse(String website) {
        history.push(website);
        System.out.println("Membuka website: " + website);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak ada history untuk kembali.");
        } else {
            String lastVisited = history.pop();
            System.out.println("Kembali dari: " + lastVisited);
            if (!history.isEmpty()) {
                System.out.println("Kembali ke website: " + history.peek());
            } else {
                System.out.println("History kosong setelah kembali.");
            }
        }
    }

    public static void main(String[] args) {
        Main browserHistory = new Main();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Menu Browser History ===");
            System.out.println("1. Browse Website");
            System.out.println("2. View History");
            System.out.println("3. Back");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama website (URL): ");
                    String website = scanner.nextLine();
                    browserHistory.browse(website);
                    break;
                case 2:
                    browserHistory.view();
                    break;
                case 3:
                    browserHistory.back();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
