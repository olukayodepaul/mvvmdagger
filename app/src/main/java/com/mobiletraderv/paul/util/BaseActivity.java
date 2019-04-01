package com.mobiletraderv.paul.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int frameid,
                                             String tag){

        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        transaction.replace(frameid, fragment, tag );
        transaction.commit();
    }

}
