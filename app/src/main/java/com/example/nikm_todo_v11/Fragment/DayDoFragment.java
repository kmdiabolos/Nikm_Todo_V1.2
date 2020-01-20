package com.example.nikm_todo_v11.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nikm_todo_v11.MainAdapter;
import com.example.nikm_todo_v11.MainData;
import com.example.nikm_todo_v11.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DayDoFragment extends Fragment implements View.OnClickListener{
    private  View view,drawerView;
    public DrawerLayout drawerLayout;
    public Button btn_open,btn_day,btn_every,btn_month,btn_finish,btn_add;
    public TextView tv_title;
    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daydo,container,false);
        btn_open = view.findViewById(R.id.btn_nav_open);
        btn_add = view.findViewById(R.id.btn_add);
        drawerLayout = view.findViewById(R.id.layout_main);
        drawerView = view.findViewById(R.id.layout_drawer);
        tv_title = view.findViewById(R.id.tv_set_Day);


        recyclerView = view.findViewById(R.id.rv_day);

        recyclerView.setLayoutManager(new LinearLayoutManager(DayDoFragment.this.getContext()));
        arrayList = new ArrayList<>();
        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        tv_title.append(dateFormat.format(new Date()));
        btn_open.setOnClickListener(this);
        btn_add.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn_nav_open :
                drawerLayout.openDrawer(drawerView);
                MainData subData = new MainData("122","3234235","234234");
                arrayList.add(subData);
                mainAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_add:
                break;
        }
    }
}
