package com.u.panu.mynuservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.u.panu.mynuservice.R;
import com.u.panu.mynuservice.utility.GetJSON;
import com.u.panu.mynuservice.utility.MyConstant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by New on 18/11/60.
 */

public class SecondFragment extends Fragment{

    // Explicit
    private String jsonString, dateString, rateString, usdString, answerString;

    private String jasonrateString;
    private double rateADouble;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Read All JSONArrayto class
        readJSON();

//  Show Date
        showDate();


    }   //Main Method

    private void showDate() {
        TextView textView = getView().findViewById(R.id.txtshowdate);

        try {

            JSONArray jsonArray = new JSONArray("[" + jsonString+ "]");
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            dateString = jsonObject.getString("date");
                    Log.d("19novV1","Date ==> " + dateString);

                    textView.setText(getText(R.string.date) + dateString);

                    jasonrateString = "[" + jsonObject.getString("rates") + "]";
                    Log.d("19novV1", "jsonRate ==> " + jasonrateString);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void readJSON() {
        String tag = "19novV1";
        MyConstant myConstant = new MyConstant();

        try {

            GetJSON getJSON = new GetJSON(getActivity());
            getJSON.execute(myConstant.getUrlJSON());
            jsonString = getJSON.get();
            Log.d(tag, "JSON ==> " + jsonString);

        } catch (Exception e) {
            Log.d(tag, "e==>"+ e.toString());

        }

    }


    // Create View คือการสร้างหน้ากาก
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_second,container,false);
        return view;
    }
}//Main Class
