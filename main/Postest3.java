/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import model.*;
import service.Service;
import java.util.ArrayList;
import java.util.Scanner;

public class Postest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service manager = new Service();

        

        while (true) {
            System.out.println("\n=== Sistem Manajemen Jadwal Service Kendaraan ===");
            System.out.println("1. Lihat Semua Jadwal");
            System.out.println("2. Tambah Jadwal");
            System.out.println("3. Ubah Jadwal (berdasarkan ID)");
            System.out.println("4. Hapus Jadwal (berdasarkan ID)");
            System.out.println("5. Cari berdasarkan Nama Pemilik");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka menu.");
                continue;
            }

            switch (pilihan) {
                // 1. Lihat Semua Jadwal
                case 1:
                    ArrayList<ServiceBase> all = manager.getAll();
                    if (all.isEmpty()) {
                        System.out.println("Belum ada data service.");
                    } else {
                        System.out.println("\n=== Daftar Jadwal Service ===");
                        for (ServiceBase s : all) {
                            System.out.println(s.toString());
                        }
                    }
                    break;

                // 2. Tambah Jadwal
                case 2:
                    System.out.println("1. Regular Service");
                    System.out.println("2. Premium Service");
                    System.out.print("Pilih jenis service: ");
                    int jenis;
                    try {
                        jenis = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Pilihan jenis tidak valid.");
                        break;
                    }

                    System.out.print("Nama Pemilik: ");
                    String owner = sc.nextLine();
                    System.out.print("Jenis Kendaraan: ");
                    String vehicle = sc.nextLine();
                    System.out.print("Tanggal Service (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Jenis Service: ");
                    String serviceType = sc.nextLine();

                    int newId = manager.getAll().size() + 1; 

                    if (jenis == 1) {
                        manager.add(new RegularService(newId, owner, vehicle, date, serviceType));
                        System.out.println("Jadwal Regular berhasil ditambahkan.");
                    } else if (jenis == 2) {
                        System.out.print("Bonus: ");
                        String bonus = sc.nextLine();
                        manager.add(new PremiumService(newId, owner, vehicle, date, serviceType, bonus));
                        System.out.println("Jadwal Premium berhasil ditambahkan.");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                // 3. Ubah Jadwal
                case 3:
                    System.out.print("Masukkan ID yang ingin diubah: ");
                    int idU;
                    try {
                        idU = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID tidak valid.");
                        break;
                    }
                    manager.updateData(sc, idU);
                    break;

                // 4. Hapus Jadwal
                case 4:
                    System.out.print("Masukkan ID yang ingin dihapus: ");
                    int idD;
                    try {
                        idD = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("ID tidak valid.");
                        break;
                    }
                    boolean removed = manager.delete(idD);
                    if (removed) System.out.println("Data berhasil dihapus.");
                    else System.out.println("Data tidak ditemukan.");
                    break;

                // 5. Cari Jadwal berdasarkan nama pemilik
                case 5:
                    System.out.print("Masukkan keyword nama pemilik: ");
                    String kw = sc.nextLine();
                    ArrayList<ServiceBase> hasil = manager.searchByOwner(kw);
                    if (hasil.isEmpty()) {
                        System.out.println("Tidak ditemukan data.");
                    } else {
                        System.out.println("Hasil pencarian:");
                        for (ServiceBase s : hasil) {
                            System.out.println(s.toString());
                        }
                    }
                    break;

                // 6. Keluar
                case 6:
                    System.out.println("Terima kasih.");
                    sc.close();
                    return;

                // default
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            } // end switch
        } // end while
    } // end main
} // end class
