/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public abstract class ServiceBase {
    protected int id;
    protected String owner;
    protected String vehicleType;
    protected String date;
    protected String serviceType;

    public ServiceBase(int id, String owner, String vehicleType, String date, String serviceType) {
        this.id = id;
        this.owner = owner;
        this.vehicleType = vehicleType;
        this.date = date;
        this.serviceType = serviceType;
    }

    // Abstract method untuk overriding
    public abstract String getInfo();

    // Overloading contoh (Polymorphism)
    public void showDetail() {
        System.out.println(getInfo());
    }

    public void showDetail(boolean includeId) {
        if (includeId) {
            System.out.println("ID: " + id + " | " + getInfo());
        } else {
            showDetail();
        }
    }

    // Getter
    public int getId() { return id; }
    public String getOwner() { return owner; }
    public String getVehicleType() { return vehicleType; }
    public String getDate() { return date; }
    public String getServiceType() { return serviceType; }

    // Setter
    public void setOwner(String owner) { this.owner = owner; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public void setDate(String date) { this.date = date; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
}
