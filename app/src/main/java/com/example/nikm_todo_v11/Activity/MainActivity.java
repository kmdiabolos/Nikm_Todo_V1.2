package com.example.nikm_todo_v11.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nikm_todo_v11.Fragment.DayDoFragment;
import com.example.nikm_todo_v11.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Fragment dayDo,monthDo,everyDo,finishDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            DayDoFragment dayDo = new DayDoFragment();
                transaction.replace(R.id.frame_container, dayDo);
                transaction.commit();
    }

    @Override
    public void onClick(View v) {

    }
}
