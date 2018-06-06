/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineClass extends JFrame {

    private sqlConnect sql;
    private static final long serialVersionUID = 1L;
    
    public LineClass(String table, int timeskip){
        super();
        sql = new sqlConnect();
        
        switch (timeskip) {
            case 7:
                oneLineGraph(table, timeskip);
                break;
            
            case 30:
                oneLineGraph(table, timeskip);
                break;

            case 90:
                oneLineGraph(table, timeskip);
                break;
            
            case 360:
                oneLineGraph(table, timeskip);
                break;
            
            default :
               oneLineGraph(table, 0);
                break; 
        }
    }
    
    public LineClass(String table, String table2, int timeskip) {
        super();
        sql = new sqlConnect();
        switch (timeskip) {
            case 7:
                twoLineGraph(table, table2, timeskip);
                break;
            
            case 30:
                twoLineGraph(table, table2, timeskip);
                break;

            case 90:
                twoLineGraph(table, table2, timeskip);
                break;
            
            case 360:
                twoLineGraph(table, table2, timeskip);
                break;
            
            default :
                twoLineGraph(table, table2, 0);
                break; 
        }
    }

    public void oneLineGraph(String table, int timeskip) {
        DefaultCategoryDataset dataset = null;
        JFreeChart chart = null;
        dataset = singleLine(table, timeskip);
        chart = ChartFactory.createLineChart(
                table + "-USD Price", // Chart title
                "Date", // X-Axis Label
                "Company", // Y-Axis Label
                dataset
        );

       ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);

    }

    public void twoLineGraph(String table, String table2, int timeskip) {
        DefaultCategoryDataset dataset = null;
        JFreeChart chart = null;
        dataset = doubleLine(table, table2, timeskip);
        chart = ChartFactory.createLineChart(
                table + "-USD " + "To " + table2 + "-USD Price of Last " + timeskip, // Chart title
                "Date", // X-Axis Label
                "Company", // Y-Axis Label
                dataset
        );
       ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
    }

    private DefaultCategoryDataset singleLine(String table, int timeskip) {
        String series1 = table;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<String> close = tableList("close", table, timeskip);
        ArrayList<String> Date = tableList("Date", table, timeskip);
        for (int i = 0; i < close.size(); i++) {
            dataset.addValue(new Double(close.get(i)), series1, Date.get(i));
        }

        return dataset;
    }

    private DefaultCategoryDataset doubleLine(String table, String table2, int timeskip) {
        String series1 = table;
        String series2 = table2;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<String> close = tableList("close", table, timeskip);
        ArrayList<String> Date = tableList("Date", table, timeskip);
        for (int i = 0; i < close.size(); i++) {
            dataset.addValue(new Double(close.get(i)), series1, Date.get(i));
        }

        ArrayList<String> close2 = tableList("close", table2, timeskip);
        ArrayList<String> Date2 = tableList("Date", table2, timeskip);
        for (int i = 0; i < close.size(); i++) {
            dataset.addValue(new Double(close2.get(i)), series2, Date2.get(i));
        }

        return dataset;
    }

    public ArrayList<String> tableList(String choice, String table, int timeskip) {
        ArrayList<String> tableList = new ArrayList<>();
        ArrayList<String> tableList2 = new ArrayList<>();
        try {
             String query = null;
            if(timeskip==0)
                    query = "Select Datee,Close from " + table;
            else
                 query = "Select Datee,Close from " + table + " where DATEE  between trunc(sysdate) - " + timeskip + "  and trunc(sysdate)";
              
            
            Statement st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            while (myRs.next()) {
                tableList.add(myRs.getString("Datee"));
                tableList2.add(myRs.getString("Close"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(theForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (choice.equalsIgnoreCase("Close")) {
            return tableList2;
        } else {
            return tableList;
        }
    }
    

}
