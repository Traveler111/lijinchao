package com.example.nianchen.normaluniversitytourgroup.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nianchen.normaluniversitytourgroup.MyteamActivity;
import com.example.nianchen.normaluniversitytourgroup.R;

/**
 * Created by nianchen on 2016/11/21.
 */
public class MyFragment extends Fragment{
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_my, container, false);
        btn=(Button)v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(getActivity(), MyteamActivity.class);
                startActivity(i);
            }
        });
        return v;
    }
}
