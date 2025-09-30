/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class Service {
    private ArrayList<ServiceBase> daftarService = new ArrayList<>();

    // Tambahkan data default
    public void seedDefault() {
        daftarService.add(new RegularService(1, "Budi", "Motor", "2025-09-20", "Service Ringan"));
        daftarService.add(new PremiumService(2, "Ani", "Mobil", "2025-09-21", "Ganti Oli", "Cuci Gratis"));
    }

    // Tambah data baru
    public void add(ServiceBase s) {
        daftarService.add(s);
    }

    // Ambil semua data
    public ArrayList<ServiceBase> getAll() {
        return daftarService;
    }

    // Hapus data berdasarkan ID
    public boolean delete(int id) {
        return daftarService.removeIf(s -> s.getId() == id);
    }

    // Cari data berdasarkan ID
    public ServiceBase findById(int id) {
        for (ServiceBase s : daftarService) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    //Cari data berdasarkan nama pemilik
    public ArrayList<ServiceBase> searchByOwner(String keyword) {
        ArrayList<ServiceBase> hasil = new ArrayList<>();
        for (ServiceBase s : daftarService) {
            if (s.getOwner().toLowerCase().contains(keyword.toLowerCase())) {
                hasil.add(s);
            }
        }
        return hasil;
    }

    // ==============================
    // 🔄 BAGIAN UPDATE (POLYMORPHISM)
    // ==============================

    // Overloading #1 – update semua field
    public boolean update(int id, String owner, String vehicle, String date, String serviceType) {
        ServiceBase s = findById(id);
        if (s != null) {
            if (!owner.isEmpty()) s.setOwner(owner);
            if (!vehicle.isEmpty()) s.setVehicleType(vehicle);
            if (!date.isEmpty()) s.setDate(date);
            if (!serviceType.isEmpty()) s.setServiceType(serviceType);
            return true;
        }
        return false;
    }

    // Overloading #2 – hanya update serviceType saja (PARAMETER BERBEDA)
    public boolean update(int id, String serviceType) {
        ServiceBase s = findById(id);
        if (s != null) {
            s.setServiceType(serviceType);
            return true;
        }
        return false;
    }

    //Method interaktif update data
    public void updateData(Scanner sc, int id) {
        ServiceBase s = findById(id);
        if (s == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        System.out.print("Nama Pemilik baru (" + s.getOwner() + "): ");
        String newOwner = sc.nextLine();
        System.out.print("Jenis Kendaraan baru (" + s.getVehicleType() + "): ");
        String newVehicle = sc.nextLine();
        System.out.print("Tanggal Service baru (" + s.getDate() + "): ");
        String newDate = sc.nextLine();
        System.out.print("Jenis Service baru (" + s.getServiceType() + "): ");
        String newService = sc.nextLine();

        // Panggil versi overloading pertama
        boolean updated = update(id, newOwner, newVehicle, newDate, newService);

        if (updated) {
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah data.");
        }
    }
}
