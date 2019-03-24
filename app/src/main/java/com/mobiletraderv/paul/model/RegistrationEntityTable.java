package com.mobiletraderv.paul.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Generated;

@Entity
public class RegistrationEntityTable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public int user_id;
    public String name;
    public String ecode;
    public String custno;
    public String dbroute;
    public String sellingunit;
    public double depotlat;
    public double depotlng;
    public String vehiclename;
    public String vehicleid;
    public String depot_waiver;
    public String clokin;
    public String clokout;


    public RegistrationEntityTable(int user_id, String name, String ecode, String custno, String dbroute,
                                   String sellingunit, double depotlat, double depotlng, String vehiclename,
                                   String vehicleid, String depot_waiver, String clokin, String clokout) {
        this.user_id = user_id;
        this.name = name;
        this.ecode = ecode;
        this.custno = custno;
        this.dbroute = dbroute;
        this.sellingunit = sellingunit;
        this.depotlat = depotlat;
        this.depotlng = depotlng;
        this.vehiclename = vehiclename;
        this.vehicleid = vehicleid;
        this.depot_waiver = depot_waiver;
        this.clokin = clokin;
        this.clokout = clokout;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getEcode() {
        return ecode;
    }

    public String getCustno() {
        return custno;
    }

    public String getDbroute() {
        return dbroute;
    }

    public String getSellingunit() {
        return sellingunit;
    }

    public double getDepotlat() {
        return depotlat;
    }

    public double getDepotlng() {
        return depotlng;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public String getDepot_waiver() {
        return depot_waiver;
    }

    public String getClokin() {
        return clokin;
    }

    public String getClokout() {
        return clokout;
    }

    public void setId(int id) {
        this.id = id;
    }
}
