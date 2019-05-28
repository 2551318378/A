package com.licona.loginandregister2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.TextView;
import android.widget.Toast;

public class NewTaskAcitivity extends AppCompatActivity{
    private TextView tv_back;
    private EditText et_title;
    private EditText et_detail;
    private EditText et_time_from;
    private EditText et_time_to;
    private String title,detail,timefrom,timeto;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tv_back=findViewById(R.id.tv_back);
        TextView tv_create=findViewById(R.id.tv_create);
        TextView tv_title=findViewById(R.id.tv_title);
        TextView tv_detail=findViewById(R.id.tv_detail);
        TextView tv_time=findViewById(R.id.tv_time);
        Button btn_yes=findViewById(R.id.btn_yes);
        et_title=findViewById(R.id.et_title);
        et_detail=findViewById(R.id.et_detail);
        et_time_from=findViewById(R.id.et_time_from);
        et_time_to=findViewById(R.id.et_time_to);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTaskAcitivity.this.finish();
            }
        });
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTaskAcitivity.this.finish();
            }
        });
    }
    private void savedNewTaskStatus(boolean status,String userName){
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",status);
        editor.putString("loginUserName",userName);
        editor.apply();
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data!=null){
            String title=data.getStringExtra("title");
            if(!TextUtils.isEmpty(title)){
                et_title.setText(title);
                et_title.setSelection(title.length());
            }
        }
    }
}
