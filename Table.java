package sproject2;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Table {
    public InsertData IConn;
    Table(String tableName, int i){
        IConn = new InsertData();
        Statement MyStatement = IConn.getStatement();
        String query = "drop table "+tableName;
        
         try {
            MyStatement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Table(String TableName) {
        String plsql = "declare v_sql LONG; begin v_sql:='create table "+TableName+" ( DATEE DATE , OPEN NUMBER , HIGH NUMBER , LOW NUMBER , CLOSE NUMBER , ADJCLOSE NUMBER , VOLUME NUMBER)'; execute immediate v_sql; EXCEPTION WHEN OTHERS THEN IF SQLCODE = -955 THEN NULL;  ELSE RAISE; END IF; END; ";
        IConn = new InsertData();
        Statement MyStatement = IConn.getStatement();
 
        try {
            MyStatement.execute(plsql);
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
