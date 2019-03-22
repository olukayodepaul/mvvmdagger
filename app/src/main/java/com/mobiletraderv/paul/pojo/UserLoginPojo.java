package com.mobiletraderv.paul.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UserLoginPojo {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("ecode")
    @Expose
    public String ecode;

    @SerializedName("custno")
    @Expose
    public String custno;

    @SerializedName("dbroute")
    @Expose
    public String dbroute;

    @SerializedName("msg")
    @Expose
    public String msg;

    @SerializedName("sellingunit")
    @Expose
    public String sellingunit;

    @SerializedName("lat")
    @Expose
    public double lat;

    @SerializedName("lng")
    @Expose
    public double lng;

    @SerializedName("vehiclename")
    @Expose
    public String vehiclename;

    @SerializedName("vehicleid")
    @Expose
    public String vehicleid;

    @SerializedName("depot_waiver")
    @Expose
    public String depot_waiver;

    @SerializedName("clockinroster")
    @Expose
    public PojoClockin clockinroster;

    @SerializedName("clockoutroster")
    @Expose
    public PojoClockOut clockoutroster;

    @SerializedName("modules")
    @Expose
    public List<PojoUserModules> modules;

    @SerializedName("salesmodules")
    @Expose
    public List<PojoCustomersList> salesmodules;

    @SerializedName("basket")
    @Expose
    public List<PojoRepBasketList> basket;

    @SerializedName("product")
    @Expose
    public List<PojoSkuList> product;

}
