package com.licona.loginandregister2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class WelcomeActivity extends FragmentActivity implements OnClickListener{

    //定义4个Fragment的对象
    private Fragment1 fg1;
    private TaskActivity fg2;
    private Fragment3 fg3;
    private Fragment4 fg4;
    //帧布局对象,就是用来存放Fragment的容器
    private FrameLayout flayout;
    //定义底部导航栏的四个布局
    private RelativeLayout home_page_layout;
    private RelativeLayout task_layout;
    private RelativeLayout clock_layout;
    private RelativeLayout settings_layout;

    //定义底部导航栏中的ImageView与TextView
    private ImageView home_page_image;
    private ImageView task_image;
    private ImageView clock_image;
    private ImageView settings_image;

    private TextView home_page_text;
    private TextView task_text;
    private TextView clock_text;
    private TextView settings_text;

    //定义要用的颜色值
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int blue =0xFF0AB2FB;
    //定义FragmentManager对象
    FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        fManager = getSupportFragmentManager();
        initViews();
    }


    //完成组件的初始化
    public void initViews()
    {
        home_page_layout = findViewById(R.id.home_page_layout);
        task_layout = findViewById(R.id.task_layout);
        clock_layout = findViewById(R.id.clock_layout);
        settings_layout = findViewById(R.id.setting_layout);


        home_page_image=findViewById(R.id.home_page_image);
        task_image = findViewById(R.id.task_image);
        clock_image = findViewById(R.id.clock_image);
        settings_image = findViewById(R.id.setting_image);

        home_page_text=findViewById(R.id.home_page_text);
        task_text = findViewById(R.id.task_text);
        clock_text = findViewById(R.id.clock_text);
        settings_text = findViewById(R.id.setting_text);


        home_page_layout.setOnClickListener(this);
        task_layout.setOnClickListener(this);
        clock_layout.setOnClickListener(this);
        settings_layout.setOnClickListener(this);

    }

    //重写onClick事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_page_layout:
                setChioceItem(1);
                break;
            case R.id.task_layout:
                setChioceItem(2);
                break;
            case R.id.clock_layout:
                setChioceItem(3);
                break;
            case R.id.setting_layout:
                setChioceItem(4);
                break;
            default:
                break;
        }

    }


    //定义一个选中一个item后的处理
    public void setChioceItem(int index)
    {
        //重置选项+隐藏所有Fragment
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChoice();
        hideFragments(transaction);
        switch (index) {
            case 1:
                home_page_image.setImageResource(R.drawable.ic_tabbar_home_pressed);
                home_page_text.setTextColor(blue);
                home_page_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg1 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg1 = new Fragment1();
                    transaction.add(R.id.content, fg1);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg1);
                }
                break;

            case 2:
                task_image.setImageResource(R.drawable.ic_tabbar_task_pressed);
                task_text.setTextColor(blue);
                task_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg2 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg2 = new TaskActivity();
                    transaction.add(R.id.content, fg2);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg2);
                }
                break;

            case 3:
                clock_image.setImageResource(R.drawable.ic_tabbar_clock_pressed);
                clock_text.setTextColor(blue);
                clock_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg3 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg3 = new Fragment3();
                    transaction.add(R.id.content, fg3);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg3);
                }
                break;
            case 4:
                settings_image.setImageResource(R.drawable.ic_tabbar_settings_pressed);
                settings_text.setTextColor(blue);
                settings_layout.setBackgroundResource(R.drawable.ic_tabbar_bg_click);
                if (fg4 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg4 = new Fragment4();
                    transaction.add(R.id.content, fg4);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (fg1 != null) {
            transaction.hide(fg1);
        }
        if (fg2 != null) {
            transaction.hide(fg2);
        }
        if (fg3 != null) {
            transaction.hide(fg3);
        }
        if (fg4 != null) {
            transaction.hide(fg4);
        }

    }


    //定义一个重置所有选项的方法
    public void clearChoice()
    {
        home_page_image.setImageResource(R.drawable.ic_tabbar_home_normal);
        home_page_layout.setBackgroundColor(whirt);
        home_page_text.setTextColor(gray);
        task_image.setImageResource(R.drawable.ic_tabbar_task_normal);
        task_layout.setBackgroundColor(whirt);
        task_text.setTextColor(gray);
        clock_image.setImageResource(R.drawable.ic_tabbar_clock_normal);
        clock_layout.setBackgroundColor(whirt);
        clock_text.setTextColor(gray);
        settings_image.setImageResource(R.drawable.ic_tabbar_settings_normal);
        settings_layout.setBackgroundColor(whirt);
        settings_text.setTextColor(gray);

    }

}

