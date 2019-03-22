package com.mobiletraderv.paul.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoClockOut {

    @SerializedName("clockoutdate")
    @Expose
    public String clockoutdate;

    @SerializedName("clockouttime")
    @Expose
    public String clockouttime;
    
}
