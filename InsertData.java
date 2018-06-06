/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject2;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MR. Lucifer
 */
class InsertData extends sqlConnect {

    private String Company;
    private String Symbol;
    private int ClosePrice;
    private Statement mystatement;

    public InsertData(){
          try {
            mystatement = (Statement) getConnection().createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public InsertData(String table,String open,String High, String low, String close,String Volume) {
        super();
        String query = "insert into "+table+" values(sysdate,"+open+","+High+","+low+","+close+","+close+","+Volume+")";
        try {
            mystatement = (Statement) getConnection().createStatement();
            mystatement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public InsertData(String Company, String Symbol) {
        super();
        this.Company = Company;
        this.Symbol = Symbol;
        try {
            mystatement = (Statement) getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void InsertData() {
        try {
            Table table = new Table(Company);

            String query = "insert into StockMarket values ('"+ Company+"','"+Symbol+"')";
            mystatement.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(InsertData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Statement getStatement() {
        return mystatement;
    }

    public String getCompany() {
        return Company;
    }

    public String getSymbol() {
        return Symbol;
    }

}
