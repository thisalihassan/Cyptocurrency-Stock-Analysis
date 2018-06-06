/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject2;

/**
 *
 * @author MrLucifer
 */
public class StockMarket {
    private String Company;
    private String Symbol;
    
    StockMarket(String Company, String Symbol){
         this.Company = Company;
         this.Symbol = Symbol;
    }

    public String getCompany() {
        return Company;
    }

    public String getSymbol() {
        return Symbol;
    }
    
}
