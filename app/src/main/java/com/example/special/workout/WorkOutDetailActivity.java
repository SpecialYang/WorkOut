package com.example.special.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.special.workout.Fragment.WorkDetailFragment;

public class WorkOutDetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "workOutId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out_detail);
        WorkDetailFragment frag = (WorkDetailFragment)
                getFragmentManager().findFragmentById(R.id.workout_fra);
        long workoutId = getIntent().getLongExtra(EXTRA_WORKOUT_ID,0);
        frag.setWorkOutId(workoutId);
    }
}
