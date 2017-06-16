package com.example.realsoc.firerace.model;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by realsoc on 14/06/17.
 */
// Class object for DriverTable
@IgnoreExtraProperties
public class DriverTable {
    @SerializedName("Drivers")
    private List<Driver> drivers;
    @SerializedName("season")
    private int season;
    @SerializedName("round")
    private int round;
    public DriverTable(){

    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
    public void print(){
        System.out.println("Drivers");
        for(int i =0;i<drivers.size();i++){
            System.out.println(drivers.get(i).toString());
        }
    }

    @Override
    public String toString() {
        String size = "null";
        if(drivers != null)
            size = String.valueOf(drivers.size());
        return "Year : "+season+" round : "+round+" players : "+size;
    }
}
