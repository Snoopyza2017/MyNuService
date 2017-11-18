package com.u.panu.mynuservice;

import android.os.AsyncTask;
import android.os.TokenWatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.u.panu.mynuservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment To Actvity
        if (savedInstanceState ==null){
//            Status True
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentfragmentmain, new MainFragment()).commit();
        }
    }//Main Method

}//Main Class
