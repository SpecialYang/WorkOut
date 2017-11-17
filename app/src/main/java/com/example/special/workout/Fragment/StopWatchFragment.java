package com.example.special.workout.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.special.workout.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatchFragment extends Fragment implements View.OnClickListener{
    private int seconds;
    private boolean isRunning;

    public StopWatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stop_watch, container, false);
        runnerTimer(view);
        Button startButton = view.findViewById(R.id.fra_watch_start);
        Button pauseButton = view.findViewById(R.id.fra_watch_pause);
        Button stopButton = view.findViewById(R.id.fra_watch_stop);
        startButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds",seconds);
        outState.putBoolean("isRunning",isRunning);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.fra_watch_start:
                onClickStart();break;
            case R.id.fra_watch_pause:
                onClickPause();break;
            case R.id.fra_watch_stop:
                onClickStop();break;
        }
    }

    public void onClickStart(){
        isRunning = true;
    }

    public void onClickPause(){
        isRunning = false;
    }

    public void onClickStop(){
        isRunning = false;
        seconds = 0;
    }

    public void runnerTimer(View view){
        final TextView timeText = view.findViewById(R.id.frag_watch_time);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = seconds % 3600 / 60;
                int sec = seconds % 60;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,sec);
                timeText.setText(time);
                if(isRunning)
                    seconds++;
                handler.postDelayed(this,1000);
            }
        });
    }

}
