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
public class TheTable {

    private String Datee;
    private String Open;
    private String High;
    private String Low;
    private String Close;
    private String AdjClose;
    private String Volume;

    TheTable(String Datee, String Open, String High, String Low, String Close, String AdjClose, String Volume) {
        this.Datee = Datee;
        this.Open = Open;
        this.High = High;
        this.Low = Low;
        this.Close = Close;
        this.AdjClose = AdjClose;
        this.Volume = Volume;
    }

    public String getDatee() {
        return Datee;
    }

    public String getOpen() {
        return Open;
    }

    public String getHigh() {
        return High;
    }

    public String getLow() {
        return Low;
    }

    public String getClose() {
        return Close;
    }

    public String getAdjClose() {
        return AdjClose;
    }

    public String getVolume() {
        return Volume;
    }

}
