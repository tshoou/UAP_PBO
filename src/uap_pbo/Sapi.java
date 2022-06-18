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
public class Sapi extends Hewan implements TreatmentInterface {
    private double milkInLiterPerDay;
    private double milkPrice;
    private Medicine medicine;

    public Sapi(){

    }

    public Sapi(int quantitiy, double expensePerDay, double milkInLiterPerDay, double milkPrice, double pricePerUnit){
        super("Sapi", quantitiy, expensePerDay, pricePerUnit);
        this.milkInLiterPerDay = milkInLiterPerDay;
        this.milkPrice = milkPrice;
    }

    public void setMilkInLiterPerDay(double milkInLiterPerDay){
        this.milkInLiterPerDay = milkInLiterPerDay;
    }

    public void setMedicine(Medicine medicine){
        // Roundabout way to clone
        Medicine newMedicine = medicine;
        this.medicine = newMedicine;
    }

    public void setMilkPrice(double milkPrice){
        this.milkPrice = milkPrice;
    }

    public double getMilkInLitrePerDay(){
        return isBoosted()? 1.5 * milkInLiterPerDay : milkInLiterPerDay;
    }

    public double getMilkPrice(){
        return milkPrice;
    }

    public Medicine getMedicine(){
        return medicine;
    }

    // Method to return if "Sapi" instance in drug effect (booster)
    // PS: If medicine is null, return false. If it exist, return the status from medicine instances
    public boolean isBoosted(){
        // Code here
        return medicine != null;
    }

    // Method to return string if it boosted
    // In this case, if this instance is boosted return "Booster"
    // If not, return "Normal"
    public String getStatus(){
        // Code here
        if(isBoosted()==false){
            return "Normal";
        }
        else return "Booster";
    }

    // Method to return total of daily sell
    // For "Sapi" instance, it can be written as following:
    // the total milk in litre in day (of all cows) * milkPrice
    public double dailySell(){
        return getMilkInLitrePerDay()*getMilkPrice();
    }

    // Method to return total of profit for "Sapi" instance
    // It can be written as following:
    // the total of daily sell - the total of expense
    public double dailyProfit(){
        return dailySell()-getTotalExpense();
    }

    // Method to apply drug to this instance
    public void treatment(Medicine medicine){
        setMedicine(medicine);
    }

    // Method to apply reduce duration
    public void reduceDrugDuration(){
        if (isBoosted()) {
            this.medicine.reduceDuration();
        }
    }

    // To String return a formatted string of Sapi consisted of
    // Its name, quantitiy, and expese per day (you can get this with "super")
    // Ex:
    //  Nama        : Sapi
    //  Jumlah      : 50 ekor
    //  Pengeluaran : Rp. 4,000,000 (per hari)
    //  Susu/hari   : 7.5 liter (per ekor)
    //  Harga susu  : Rp. 25,000 (per liter)
    //  Penjualan   : Rp. 9,375,000  (per hari)
    //  Profit      : Rp. 5,375,000 (per hari)
    //  Status      : Boosted / Normal
    //  (Status depends whether the instance got medicine or not)
    @Override public String toString(){
        // Code Here
        return super.toString()
                +"Susu/hari  : "+getMilkInLitrePerDay()+"\n" +
                "Harga susu : "+getMilkPrice()+"\n" +
                "Penjualan   : "+dailySell()+"\n" +
                "Profit      : "+dailyProfit()+"\n" +
                "Status      : "+getStatus();
    }
}
