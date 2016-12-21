package com.example.lishuxing.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView content;
    String url="http://v.juhe.cn/weather/index";
    String key="b0e551c641bdba2364ee4ccf30783f00";
    private EditText et;
    String str="";

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            content.setText((String)msg.obj);

        }
    };
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.et);
        btn=(Button)findViewById(R.id.btn);
        content=(TextView)findViewById(R.id.content);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main3Activity.class));
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client=new AsyncHttpClient();
                RequestParams rp=new RequestParams();
                rp.put("cityname",et.getText().toString());
                rp.put("key",key);
                client.get(url,rp,new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, org.apache.http.Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        Toast.makeText(MainActivity.this, "请求成功了", Toast.LENGTH_SHORT).show();
//                        for (int i=0;i<response.length();i++){
//
//                        }
                        try {
                            JSONObject j1=response.getJSONObject("result");
                            JSONObject j2=j1.getJSONObject("sk");
                            String s1="当前温度: "+j2.getString("temp")+"\n"+"当前风向: "+j2.getString("wind_direction")+"\n"+"当前风力: "+j2.getString("wind_strength")+"\n"+"当前湿度: "+j2.getString("humidity")+"\n"+"更新时间: "+j2.getString("time")+"\n";
                            JSONObject j3=j1.getJSONObject("today");
                            String s2="城市: "+j3.getString("city")+"\n"+"日期: "+j3.getString("date_y")+j3.getString("week")+"\n"+"今日温度: "+j3.getString("temperature")+"\n"+"今日天气: "+j3.getString("weather")+"\n"+"风向: "+j3.getString("wind")+"\n"+"穿衣指数: "+j3.getString("dressing_index")+"\n"+"穿衣建议: "+j3.getString("dressing_advice")+"\n"+"紫外线强度: "+j3.getString("uv_index")+"\n"+"舒适度指数: "+j3.getString("comfort_index")+"\n"+"洗车指数: "+j3.getString("wash_index")+"\n"+"旅游指数: "+j3.getString("travel_index")+"\n"+"晨练指数: "+j3.getString("exercise_index")+"\n"+"干燥指数: "+j3.getString("drying_index")+"\n";
                            str=str+s1+s2;
                            Message msg=h.obtainMessage();
                            msg.obj=str;
                            h.sendMessage(msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
