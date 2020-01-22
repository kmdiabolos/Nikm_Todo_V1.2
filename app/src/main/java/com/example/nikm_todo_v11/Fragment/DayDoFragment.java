package com.example.nikm_todo_v11.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nikm_todo_v11.MainAdapter;
import com.example.nikm_todo_v11.MainData;
import com.example.nikm_todo_v11.R;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DayDoFragment extends Fragment {
    private  View view;

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    RecyclerView recyclerView;
    Button btn_add;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daydo,container,false);

        btn_add = view.findViewById(R.id.btn_add);
        recyclerView = view.findViewById(R.id.rv_day);
        recyclerView.setLayoutManager(new LinearLayoutManager(DayDoFragment.this.getContext()));
        recyclerView.setAdapter(mainAdapter);




        return view;
    }


    public void showItemList(ArrayList<MainData> data){
        mainAdapter = new MainAdapter(data);
        mainAdapter.notifyDataSetChanged();
    }
}
