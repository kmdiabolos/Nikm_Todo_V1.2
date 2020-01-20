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

public class DayDoFragment extends Fragment {
    private  View view;

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    RecyclerView recyclerView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showItemList();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daydo,container,false);

        recyclerView = view.findViewById(R.id.rv_day);
        recyclerView.setLayoutManager(new LinearLayoutManager(DayDoFragment.this.getContext()));
        recyclerView.setAdapter(mainAdapter);



        return view;
    }

    public void showItemList(){
        arrayList = new ArrayList<MainData>();
        mainAdapter = new MainAdapter(arrayList);

        MainData subData = new MainData("122","3234235","234234");

        arrayList.add(subData);
        mainAdapter.notifyDataSetChanged();

    }

    public void showItemList(String tv_time, String tv_do, String tv_value){
        arrayList = new ArrayList<MainData>();
        mainAdapter = new MainAdapter(arrayList);

        MainData subData = new MainData(tv_time,tv_do,tv_value);
        arrayList.add(subData);
        mainAdapter.notifyDataSetChanged();

    }
}
