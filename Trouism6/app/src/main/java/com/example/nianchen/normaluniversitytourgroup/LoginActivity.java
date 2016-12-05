package com.example.nianchen.normaluniversitytourgroup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button Btlogin;
    private EditText EtUname;
    private EditText EtPwd;
    private ProgressDialog pb;
    private boolean ischecked=false;
    private CheckBox cb;
    SharedPreferences spf;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.e("log","onCreate");
//        ischecked=spf.getBoolean("click",);
        spf=getPreferences(MODE_PRIVATE);
        edit=spf.edit();
        Boolean bl=spf.getBoolean("click",false);
        findView();
        setListener();
        if(bl==true){
            settext();
        }
    }

    private void settext() {
        EtUname.setText(spf.getString("Name",""));
        EtPwd.setText(spf.getString("Pwd",""));
        cb.setChecked(true);
    }

    private void findView() {
        Btlogin = (Button)findViewById(R.id.btlogin);
        EtUname = (EditText) findViewById(R.id.Etu);
        EtPwd = (EditText) findViewById(R.id.Pw);
        cb=(CheckBox)findViewById(R.id.cb);

    }
    View.OnClickListener mylistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btlogin:
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra("NAME", EtUname.getText().toString());
                    i.putExtra("PWD", EtPwd.getText().toString());
                    startActivityForResult(i,1);
                    SharedPreferences spf=getSharedPreferences("User",MODE_PRIVATE);
                    SharedPreferences.Editor editor=spf.edit();
                    editor.putString("uname",EtUname.getText().toString());
                    editor.clear();
                    editor.commit();
                    if(cb.isChecked()){
                        ischecked=true;
                        edit.putBoolean("click",true);
                        edit.putString("Name",EtUname.getText().toString());
                        edit.putString("Pwd",EtPwd.getText().toString());
                        edit.commit();
                    }
                    break;
            }
        }
    };
    private void setListener() {
        Btlogin.setOnClickListener(mylistener);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            Toast.makeText(LoginActivity.this, "用户名密码正确", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(LoginActivity.this, "用户名密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("log","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("log","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("log","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("log","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("log","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("log","onRestart");
    }


}
