package com.example.nikm_todo_v11.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nikm_todo_v11.Fragment.DayDoFragment;
import com.example.nikm_todo_v11.Fragment.EveryDoFragment;
import com.example.nikm_todo_v11.Fragment.FinishDoFragment;
import com.example.nikm_todo_v11.Fragment.MonthDoFragment;
import com.example.nikm_todo_v11.MainData;
import com.example.nikm_todo_v11.R;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , Serializable {

    DayDoFragment dayDo;
    EveryDoFragment everyDo;
    FinishDoFragment finishDo;
    MonthDoFragment monthDo;

Button btn_add,btn_nav_open,btn_nav_d,btn_nav_m,btn_nav_e,btn_nav_f;
DrawerLayout drawerLayout;
View drawerView;
String nowPage = "day";

    ArrayList<MainData> dayList = new ArrayList<MainData>();
    ArrayList<MainData> monthList= new ArrayList<MainData>();
    ArrayList<MainData> everyList= new ArrayList<MainData>();
    ArrayList<MainData> finishList= new ArrayList<MainData>();
    MainData mainData;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            mainData = (MainData)data.getSerializableExtra("data");
            if(nowPage=="day"){
                dayList.add(mainData);
                changedFragments("day",dayList);
            }
            else if(nowPage=="every"){
                everyList.add(mainData);
                changedFragments("every",everyList);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changedFragments("day",dayList);
        btn_add=findViewById(R.id.btn_add);
        btn_nav_open=findViewById(R.id.btn_nav_open);
        btn_nav_d=findViewById(R.id.btn_nav_d);
        btn_nav_e=findViewById(R.id.btn_nav_e);
        btn_nav_m=findViewById(R.id.btn_nav_m);
        btn_nav_f=findViewById(R.id.btn_nav_f);

        btn_add.setOnClickListener(this);
        btn_nav_open.setOnClickListener(this);
        btn_nav_d.setOnClickListener(this);
        btn_nav_e.setOnClickListener(this);
        btn_nav_m.setOnClickListener(this);
        btn_nav_f.setOnClickListener(this);


        drawerLayout = (DrawerLayout)findViewById(R.id.layout_main);
        drawerView = (View)findViewById(R.id.layout_drawer);

    }

    @Override
    public void onClick(View v) {

    switch(v.getId()){
        case R.id.btn_add :
            switch (nowPage) {
                case "day": case "every":
                startActivityForResult(new Intent(this, DoActivity.class), 101);
                    break;
                case "month":
                    break;
            }
            break;

        case R.id.btn_nav_open :
            drawerLayout.openDrawer(drawerView);
            break;

        case R.id.btn_nav_d :
            changedFragments("day",dayList);
            nowPage = "day";
            drawerLayout.closeDrawer(drawerView);
            break;

        case R.id.btn_nav_e :
            changedFragments("every",everyList);
            nowPage = "every";
            drawerLayout.closeDrawer(drawerView);
        break;

        case R.id.btn_nav_m :
            changedFragments("month",monthList);
            nowPage = "month";
            drawerLayout.closeDrawer(drawerView);
            break;

        case R.id.btn_nav_f :
            changedFragments("finish",finishList);
            nowPage = "finish";
            drawerLayout.closeDrawer(drawerView);
            break;

}
    }

    private void changedFragments (String fragmentsName,ArrayList<MainData> datalist){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch(fragmentsName){

            case "day":
                dayDo = new DayDoFragment();
                transaction.replace(R.id.frame_container, dayDo);
                dayDo.showItemList(datalist);
                transaction.commit();
                break;

            case"every":
                everyDo = new EveryDoFragment();
                transaction.replace(R.id.frame_container, everyDo);
                everyDo.showItemList(datalist);
                transaction.commit();
                break;

            case"month":
                monthDo = new MonthDoFragment();
                transaction.replace(R.id.frame_container, monthDo);
                monthDo.showItemList();
                transaction.commit();
                break;


            case"finish":
                finishDo = new FinishDoFragment();
                transaction.replace(R.id.frame_container, finishDo);
                finishDo.showItemList();
                transaction.commit();
                break;

        }
    }

}
