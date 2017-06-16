package com.example.realsoc.firerace.model;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by realsoc on 14/06/17.
 */
// Class object for Driver
@IgnoreExtraProperties
public class Driver {
    @SerializedName("driverId")
    private String driverId;
    @SerializedName("dateOfBirth")
    private Date dateOfBirth;
    public Driver(){

    }
    public Driver(String driverId, Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        this.driverId = driverId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String toString(){
        return driverId+" - "+dateOfBirth;
    }
}
