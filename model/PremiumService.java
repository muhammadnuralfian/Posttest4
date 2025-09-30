/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class PremiumService extends ServiceBase implements Bonusable {
    private String bonus;

    public PremiumService(int id, String owner, String vehicleType, String date, String serviceType, String bonus) {
        super(id, owner, vehicleType, date, serviceType);
        this.bonus = bonus;
    }

    @Override
    public String getInfo() {
        return owner + " | " + vehicleType + " | " + date + " | " + serviceType + " [Premium] + Bonus: " + bonus;
    }

    @Override
    public String getBonus() {
        return bonus;
    }
}
