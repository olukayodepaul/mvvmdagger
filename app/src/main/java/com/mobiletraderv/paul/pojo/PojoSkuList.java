package com.mobiletraderv.paul.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoSkuList {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("separator")
    @Expose
    public String separator;

    @SerializedName("separatorname")
    @Expose
    public String separatorname;

    @SerializedName("productcode")
    @Expose
    public String productcode;

    @SerializedName("productname")
    @Expose
    public String productname;

    @SerializedName("qty")
    @Expose
    public String qty;

    @SerializedName("soq")
    @Expose
    public String soq;

    @SerializedName("rollprice")
    @Expose
    public double rollprice;

    @SerializedName("packprice")
    @Expose
    public double packprice;

}
