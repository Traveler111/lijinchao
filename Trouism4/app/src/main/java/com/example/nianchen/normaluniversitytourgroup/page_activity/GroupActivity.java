package com.example.nianchen.normaluniversitytourgroup.page_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nianchen.normaluniversitytourgroup.BaseClass.FriendTwo;
import com.example.nianchen.normaluniversitytourgroup.MainActivity3;
import com.example.nianchen.normaluniversitytourgroup.R;
import com.example.nianchen.normaluniversitytourgroup.adapter.GroupAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nianchen on 2016/11/22.
 */
public class GroupActivity extends Activity {
    private List<FriendTwo> friends = new ArrayList<FriendTwo>();
    private ListView list;
    private GroupAdapter myadpter;
    private ImageView jia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiu_group);
        getdata();
        getid();
        setlistener();
        myadpter = new GroupAdapter(this,friends);
        list.setAdapter(myadpter);
    }

    private void setlistener() {
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.setClass(GroupActivity.this, MainActivity3.class);
                startActivity(i);
//                View v2= LayoutInflater.from(GroupActivity.this).inflate(R.layout.layout_fabu,null);
//                new AlertDialog.Builder(GroupActivity.this)
//                        .setTitle("发布你的队伍信息")
//                        .setView(v2)
//                        .setPositiveButton("发布", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                Toast.makeText(GroupActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setNegativeButton("取消",null)
//                        .create()
//                        .show();
            }
        });
    }

    private void getid() {
        list = (ListView)findViewById(R.id.group_list);
        jia =(ImageView)findViewById(R.id.img_jia);
    }

    private void getdata() {
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
        friends.add(new FriendTwo(R.drawable.a1,"抱犊寨","详情......",R.drawable.b1));
    }
}
