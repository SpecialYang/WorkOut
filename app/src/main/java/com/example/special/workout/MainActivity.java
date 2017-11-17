package com.example.special.workout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.special.workout.Fragment.WorkDetailFragment;
import com.example.special.workout.Fragment.WorkOutListFragment;

public class MainActivity extends AppCompatActivity implements WorkOutListFragment.WorkOutListOnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.detail_fragment_container);
        if(fragmentContainer != null) {
            WorkDetailFragment wf = new WorkDetailFragment();
            FragmentTransaction fgt = getFragmentManager().beginTransaction();
            wf.setWorkOutId(id);
            fgt.replace(R.id.detail_fragment_container, wf);
            fgt.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fgt.addToBackStack(null);
            fgt.commit();
        }
        else{
            Intent intent = new Intent(this,WorkOutDetailActivity.class);
            intent.putExtra(WorkOutDetailActivity.EXTRA_WORKOUT_ID,id);
            startActivity(intent);
        }
    }
}
