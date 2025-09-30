/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class RegularService extends ServiceBase {

    public RegularService(int id, String owner, String vehicleType, String date, String serviceType) {
        super(id, owner, vehicleType, date, serviceType);
    }

    @Override
    public String getInfo() {
        return owner + " | " + vehicleType + " | " + date + " | " + serviceType + " [Regular]";
    }
}
