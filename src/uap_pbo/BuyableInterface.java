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
public interface BuyableInterface {
    public String getName();
    public double getPricePerUnit();
    public void addResource(int add);
}
