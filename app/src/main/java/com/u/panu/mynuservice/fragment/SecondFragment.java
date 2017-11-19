package com.u.panu.mynuservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.u.panu.mynuservice.R;
import com.u.panu.mynuservice.utility.GetJSON;
import com.u.panu.mynuservice.utility.MyConstant;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

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

// Show Rate
        showRate();

// Calculate Controller
        Button button = getView().findViewById(R.id.btnexchange);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = getView().findViewById(R.id.edtUSD);
                usdString = editText.getText().toString().trim();

                if (usdString.isEmpty()) {
                    // Have Space
                    Toast.makeText(getActivity(),"Please Fill Thai Bath",
                    Toast.LENGTH_SHORT).show();

                } else {
                    // No Space
                    double usdAdouble = Double.parseDouble(usdString);
                    double answerAdouble = usdAdouble * rateADouble;

                    TextView textView = getView().findViewById(R.id.txtAnswer);
                    textView.setText(Double.toString(answerAdouble) + "THB");
                    }



                }



        });



    }   //Main Method

    private void showRate() {
        TextView textView = getView().findViewById(R.id.txtShowRate);
        try {

            JSONArray jsonArray = new JSONArray(jasonrateString);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            rateADouble = jsonObject.getDouble("THB");
            Log.d("19novV1", "rateAdou ==>" + rateADouble);

            textView.setText(getString(R.string.rate) + Double.toString(rateADouble));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
