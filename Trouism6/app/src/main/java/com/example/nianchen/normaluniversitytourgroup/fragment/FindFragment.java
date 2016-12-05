package com.example.nianchen.normaluniversitytourgroup.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.nianchen.normaluniversitytourgroup.BaseClass.FriendOne;
import com.example.nianchen.normaluniversitytourgroup.MainActivityDitu;
import com.example.nianchen.normaluniversitytourgroup.R;
import com.example.nianchen.normaluniversitytourgroup.adapter.FindFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nianchen on 2016/11/22.
 */
public class FindFragment extends Fragment {
    private List<FriendOne> friends=new ArrayList<FriendOne>();
    private View view;
    private ListView lv;
    private FindFragmentAdapter myadapter;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, container, false);
        getdata();
        findview();
        myadapter=new FindFragmentAdapter(getActivity(),friends);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(getActivity(), MainActivityDitu.class);
                startActivity(i);
            }
        });
        lv.setAdapter(myadapter);
        return view;
    }
    public void findview(){
        lv=(ListView)view.findViewById(R.id.findlist);
        btn=(Button)view.findViewById(R.id.btn);
        Log.e("find","run");
    }
    public void getdata(){
        friends.add(new FriendOne(R.drawable.a1,"面对面加群","与身边的朋友进入同一个群聊"));
        friends.add(new FriendOne(R.drawable.a1,"扫一扫","扫描二维码名片"));
        friends.add(new FriendOne(R.drawable.a1,"手机联系人","邀请通讯录中的好友"));
        friends.add(new FriendOne(R.drawable.a2,"李佳航","人是个神马东西"));
        Log.e("getdata","run");
    }
}
