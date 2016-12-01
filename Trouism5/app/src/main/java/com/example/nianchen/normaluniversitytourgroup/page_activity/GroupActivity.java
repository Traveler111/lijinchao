package com.example.nianchen.normaluniversitytourgroup.page_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nianchen.normaluniversitytourgroup.BaseClass.FriendTwo;
import com.example.nianchen.normaluniversitytourgroup.MainActivity;
import com.example.nianchen.normaluniversitytourgroup.MainActivity3;
import com.example.nianchen.normaluniversitytourgroup.R;
import com.example.nianchen.normaluniversitytourgroup.adapter.GroupAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by nianchen on 2016/11/22.
 */
public class GroupActivity extends Activity {
    private List<FriendTwo> friends = new ArrayList<FriendTwo>();
    private ListView list;
    private GroupAdapter myadpter;
    private ImageView jia;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiu_group);
        String url="http://123.207.228.232:8080/blog/Xianshifabu";
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(getApplicationContext(),url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject json=response.getJSONObject(i);
                        String scontent=json.getString("Content");
                        String stitle=json.getString("Title");
                        System.out.println("Title:"+stitle);
                        System.out.println("Content:"+scontent);
                        friends.add(new FriendTwo(R.drawable.a1,stitle,scontent,R.drawable.b1));
                        myadpter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        getid();
        setlistener();
        myadpter = new GroupAdapter(this,friends);
        list.setAdapter(myadpter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v1=getLayoutInflater().inflate(R.layout.layout_item,null);
                tv1=(TextView)v1.findViewById(R.id.tv1);
                tv2=(TextView)v1.findViewById(R.id.tv2);
                AlertDialog.Builder adb=new AlertDialog.Builder(GroupActivity.this);
                adb.setView(v1);
                adb.setTitle("队伍信息");
                adb.setPositiveButton("",);
                adb.setNegativeButton("",);
                adb.create().show();
            }
        });
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
