package com.mobiletraderv.paul.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoCustomersList {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("notice")
    @Expose
    public String notice;

    @SerializedName("urno")
    @Expose
    public String urno;

    @SerializedName("customerno")
    @Expose
    public String customerno;

    @SerializedName("outletclasname")
    @Expose
    public String outletclasname;

    @SerializedName("outletlagname")
    @Expose
    public String outletlagname;

    @SerializedName("outlettypename")
    @Expose
    public String outlettypename;

    @SerializedName("outletname")
    @Expose
    public String outletname;

    @SerializedName("lat")
    @Expose
    public String lat;

    @SerializedName("lng")
    @Expose
    public String lng;

    @SerializedName("sort")
    @Expose
    public int sort;

    @SerializedName("keys")
    @Expose
    public String keys;

}
