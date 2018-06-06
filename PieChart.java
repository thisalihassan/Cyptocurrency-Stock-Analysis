package sproject2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author MrLucifer
 */
public class PieChart extends JFrame{
    private static final long serialVersionUID = 6294689542092367723L;
     private sqlConnect sql;
     

  public PieChart(String title) {
    super(title);
    sql = new sqlConnect();

    PieDataset dataset = createDataset();

    JFreeChart chart = ChartFactory.createPieChart(
        "CryptoCurrency",
        dataset,
        true, 
        true,
        false);

    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
        "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
    
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private PieDataset createDataset() {
      ArrayList<String> names = new ArrayList<>();
      String query = "Select company from Stockmarket";
        try {
            Statement st = (Statement) sql.getConnection().createStatement();
            ResultSet myRs = st.executeQuery(query);
            while (myRs.next()) {
              names.add(myRs.getString("Company"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         DefaultPieDataset dataset=new DefaultPieDataset();
  
      for(int i=0;i<names.size();i++){
          String query2 = "SELECT * FROM ( SELECT * FROM "+names.get(i)+" ORDER BY Datee DESC ) WHERE ROWNUM = 1";
           try {
            Statement st = (Statement) sql.getConnection().createStatement();
               ResultSet myRs = st.executeQuery(query2);
            while (myRs.next()) {
               dataset.setValue(names.get(i), new Integer(myRs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
    return dataset;
  }

}
