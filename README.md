# Posttest4

## DESKRIPSI PROGRAM
 🚗 Sistem Manajemen Jadwal Service Kendaraan

Program ini merupakan aplikasi berbasis Java yang dibuat untuk mengelola data jadwal service kendaraan menggunakan konsep **Object-Oriented Programming (OOP)**.  
Pengguna dapat menambahkan, melihat, mengubah, menghapus, dan mencari data jadwal service kendaraan berdasarkan nama pemilik.  
Selain itu, program juga telah dikembangkan hingga tahap **Posttest 4**, di mana sudah menerapkan fitur **Abstraction, Interface, Polymorphism (Overloading & Overriding)**, serta **Encapsulation** secara penuh.

Tujuan dari program ini adalah membantu bengkel atau penyedia jasa service dalam mencatat dan mengelola data jadwal pelanggan secara efisien.

## 🆕 Pembaruan pada Posttest 4

Berikut perubahan yang telah dilakukan dari versi sebelumnya:

### 🔹 1. Abstraction
- Dibuat **abstract class `ServiceBase`** sebagai superclass dari seluruh jenis service.
- Di dalam `ServiceBase` didefinisikan atribut dan method umum seperti `id`, `owner`, `vehicleType`, `date`, dan `serviceType`.
- Method `displayInfo()` bersifat **abstract** dan dioverride oleh subclass.

### 🔹 2. Interface
- Ditambahkan **interface `Bonusable`** yang mendefinisikan method `getBonusInfo()`.
- Interface ini diimplementasikan oleh `PremiumService` untuk memberikan fitur bonus khusus pelanggan premium.

### 🔹 3. Inheritance
- `RegularService` dan `PremiumService` dibuat sebagai **subclass** dari `ServiceBase`.
- Kedua subclass mewarisi atribut dan method dari superclass, namun memiliki implementasi berbeda pada `displayInfo()`.

### 🔹 4. Polymorphism
- **Overriding:** Method `toString()` dan `displayInfo()` di-override di setiap subclass agar menampilkan informasi sesuai tipe service.
- **Overloading:** Method `add()` di `Service.java` memiliki beberapa versi (dengan parameter berbeda) untuk menambahkan data service.

### 🔹 5. Encapsulation
- Semua atribut diberi access modifier `private` dan diakses melalui **getter** dan **setter**.
- Hal ini menjaga keamanan data dan mengikuti prinsip OOP.

### 🔹 6. Update Menu CRUD
- Di menu **Tambah Jadwal (case 2)** kini pengguna dapat memilih tipe service:
  - `1. Regular Service`
  - `2. Premium Service` (dengan bonus tambahan)
- Data yang ditambahkan akan disimpan sebagai objek dari subclass yang sesuai.

## PENJELASAN KODE 

## 🧱Abstraction – ServiceBase.java

Kelas ServiceBase merupakan kelas abstrak yang berisi atribut dasar dan method displayInfo() tanpa implementasi. Kelas ini tidak bisa dibuat objeknya secara langsung, namun menjadi kerangka untuk kelas turunannya.

<img width="1068" height="528" alt="image" src="https://github.com/user-attachments/assets/748c01c6-744f-4835-867e-dd715a38e33d" />

## 🧬 Inheritance – RegularService.java

Kelas RegularService merupakan turunan dari ServiceBase yang mewarisi atribut dan constructor dari superclass. Kelas ini mengimplementasikan method displayInfo() sesuai kebutuhan untuk menampilkan data service standar.

<img width="1193" height="467" alt="image" src="https://github.com/user-attachments/assets/1a1b6c5e-2867-4b0c-9a85-41a8b2f6665b" />

## 💎 Inheritance + Interface – PremiumService.java

Kelas PremiumService adalah turunan dari ServiceBase sekaligus mengimplementasikan interface Bonusable. Kelas ini menambahkan atribut bonus serta meng-override displayInfo() untuk menampilkan informasi tambahan bonus.

<img width="1309" height="504" alt="image" src="https://github.com/user-attachments/assets/a672d40b-9c60-43ad-89ce-a553546bb078" />

## 🔗 Interface – Bonusable.java

Bonusable adalah interface yang mendefinisikan kontrak method getBonusInfo() untuk kelas yang ingin menyediakan fitur bonus. Kelas PremiumService wajib mengimplementasikan method ini.

<img width="1126" height="131" alt="image" src="https://github.com/user-attachments/assets/bdfe3064-716a-4240-9693-207360c3e34a" />

## 🔄 Polymorphism – Overloading (Service.java)

Method add() menerapkan polymorphism overloading dengan dua versi berbeda: satu menerima objek ServiceBase, dan satu lagi menerima parameter langsung untuk membuat objek baru.

<img width="1179" height="815" alt="image" src="https://github.com/user-attachments/assets/ee0ae3f3-422a-44df-8b81-e47db18d6a6f" />

## 🔁 Polymorphism – Overriding (displayInfo())

Method displayInfo() di-override di subclass (RegularService dan PremiumService) untuk memberikan perilaku yang berbeda saat menampilkan data, menunjukkan penerapan polymorphism dinamis.

<img width="1173" height="208" alt="image" src="https://github.com/user-attachments/assets/d9189e17-f54f-42f1-b648-54644ae7cc01" />

## 📥 Update CRUD – Posttest3.java (Tambah Data)

Kode ini menambahkan fitur pilihan jenis service saat input data baru. Pengguna dapat memilih antara Regular atau Premium, lalu sistem akan membuat objek yang sesuai berdasarkan pilihan tersebut.

<img width="1271" height="500" alt="image" src="https://github.com/user-attachments/assets/9e9460a8-6ace-41d0-b3f4-9f282a6371cf" />









