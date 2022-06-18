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
public class Admin {
    private String name;
    private String password;

    public Admin(){
        
    }

    // Constructor
    public Admin(String name, String password){
        setName(name);
        setPassword(password);
    }

    // Basic Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Basic Getters

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // To String return a formattet string of admin
    @Override
    public String toString() {
        return String.format("Name\t\t: %s \n", getName());
    }

    // Is match with Name and Password
    // Method to check whether the name and password is match with the attribut from the instances
    public boolean isMatch(String name, String password){
        return false;
    }
}
