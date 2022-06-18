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
public class Helper {
    // Helper function to initialize variable that used in runtime environment
    static void initialize(){

        // Code Here
        // P.S: I think something is wrong with Initialize function

        // Initilaize Admin Instances
        UAP_PBO.admins[0] = new Admin("Joko", "ini_password_joko");
        UAP_PBO.admins[1] = new Admin("Dengklek", "ini_password_dengklek");

        // Initialize Hewan Instances
        UAP_PBO.ayam =  new Ayam(500,500_000,3, 3000, 20_000);
        UAP_PBO.domba = new Domba();
        UAP_PBO.sapi = new Sapi();

        // Initialize Tanaman Instances
        UAP_PBO.cengkeh =  new Cengkeh(50.00, 100_000, 10.0, 30_000, 15_000_000);
        UAP_PBO.kepalaSawit = new KepalaSawit(40.00, 200_000, 25.0, 25_000, 20_000_000);

        // Initialize Medicine instances
        UAP_PBO.boosterAyam = new Medicine("Booster Ayam", 3000, 7);
        UAP_PBO.boosterSapi = new Medicine("Booster Sapi", 50_000, 5);
        UAP_PBO.pesticideCengkeh = new Medicine("Pestisida Cengkeh", 500_000, 14);
        UAP_PBO.boosterKepalaSawit = new Medicine("Booster Kelapa Sawit", 1_000_000, 10);

        // Uang Kas 100000000
        UAP_PBO.cash = 0;
    }

    // Helper function to authentication
    // PS: Doing an iteration to check one by one admin instances
    static boolean authentication(String username, String password) {
        UAP_PBO.admins[0].setName("joko");
        
        UAP_PBO.admins[1].setName("dengklek");
        
        UAP_PBO.admins[0].setPassword("ini_password_joko");
        
        UAP_PBO.admins[1].setPassword("ini_password_dengklek");
        
        if(username.equals(UAP_PBO.admins[0].getName()) && password.equals(UAP_PBO.admins[0].getPassword())){
            return true;
        }      
        return username.equals(UAP_PBO.admins[1].getName()) && password.equals(UAP_PBO.admins[1].getPassword());
    }

    // PS: You can add new helper function below this comment if you want
}
