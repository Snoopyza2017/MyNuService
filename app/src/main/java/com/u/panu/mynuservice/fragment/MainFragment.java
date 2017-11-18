package com.u.panu.mynuservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.u.panu.mynuservice.R;

/**
 * Created by New on 18/11/60.
 */

public class MainFragment extends Fragment{

//    Create Main Method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Button Controller
        buttonController();


    }   //Main Medthod

    private void buttonController() {
        Button button = getView().findViewById(R.id.btnGoToSecond);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentfragmentmain, new SecondFragment())
                        .addToBackStack(null).commit();
            }
        });
    }

    //    Create View
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,container,false);


        return view;
    }

}//Main Class

