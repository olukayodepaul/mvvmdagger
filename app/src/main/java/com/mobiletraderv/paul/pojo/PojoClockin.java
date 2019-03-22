package com.mobiletraderv.paul.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoClockin {

    @SerializedName("clockindate")
    @Expose
    public String clockindate;

    @SerializedName("clockintime")
    @Expose
    public String clockintime;

}
