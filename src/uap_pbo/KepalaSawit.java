/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uap_pbo;

/**
 *
 * @author tuffa
 */
public class KepalaSawit extends Tanaman implements TreatmentInterface {
    private double oilInLitrePerDay;
    private double oilPrice;
    private Medicine medicine;

    public KepalaSawit(){

    }

    public KepalaSawit(double area, double expensePerDay, double oilInLitrePerDay, double oilPrice, double pricePerUnit){
        super("Kepala Sawit", area, expensePerDay, pricePerUnit);
        setOilInLitrePerDay(oilInLitrePerDay);
        setOilPrice(oilPrice);
    }

    public void setOilInLitrePerDay(double oilInLitrePerDay){
        this.oilInLitrePerDay = oilInLitrePerDay;
    }

    public void setOilPrice(double oilPrice){
        this.oilPrice = oilPrice;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public double getOilInLitrePerDay(){
        return isFertilized()? 1.25 * oilInLitrePerDay : oilInLitrePerDay;
    }

    public double getOilPrice(){
        return oilPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

    // Method to return if "Kepala Sawit" instance in drug effect (booster)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean isFertilized(){
        // Code here
        return medicine != null;
    }

    // Method to return string if it fertilized
    // In this case, if this instance is fertilized, return "Fertilized"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        if(isFertilized()==false){
            return "Normal";
        }
        else return "Fertilized";
    }

    // Method to return total of daily sell
    // For "Kepala Sawit" instance, it can be written as following:
    // the total of palm oil (of all hectare) * palm oil price
    public double dailySell(){
        // Code here
        return getOilPrice()*getOilInLitrePerDay();
    }

    // Method to return total of profit for "Cengkeh" instance
    // It can be written as following:
    // total of cengkeh per day (of all hectare) * cengkeh price
    @Override
    public double dailyProfit(){
        // Code here
        return dailySell() - getTotalExpense();
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (isFertilized()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of hewan consisted of
    // Its name, quantitiy, and expese per day
    // Ex:
    //  Nama         : Kepala Sawit
    //  Luas         : 40 hektar
    //  Pengeluaran  : Rp. 8.000.000 (per hari)
    //  Minyak/hari  : 25 liter (per hektar)
    //  Harga pasar  : Rp. 25,000 (per kg)
    //  Penjualan    : Rp. 25,000,000 (per hari)
    //  Profit       : Rp. 17,000,000 (per hari)
    //  Status       : Fertilized / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        // Code here
        return String.format("Nama\t: %s \nLuas\t\t: Rp. %d hektar \nPengeluaran\t: Rp. %,.2f (per hari) \nMinyak/hari\t: %d liter (per hektar) \nHarga pasar\t: Rp. %,.2f (per kg) \nPenjualan\t: Rp. %,.2f (per hari) \nProfit\t: Rp. %,.2f (per hari) \nStatus\t: %s)", 
        getName(), getArea(), getExpensePerDay(), getOilInLitrePerDay(), getOilPrice(), dailySell(), dailyProfit(), getStatus());
    }
}