package com.example.special.workout.Fragment;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.special.workout.R;
import com.example.special.workout.model.WorkOut;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkDetailFragment extends Fragment {
    private long workOutId;

    public WorkDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null)
            workOutId = savedInstanceState.getLong("workOutId");
        else {
            StopWatchFragment swf = new StopWatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.stopwatch_container, swf);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
        return inflater.inflate(R.layout.fragment_work_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null){
            TextView titleText = view.findViewById(R.id.workout_title);
            TextView contentText = view.findViewById(R.id.workout_content);
            WorkOut workOut = WorkOut.workOuts[(int) workOutId];
            titleText.setText(workOut.getName());
            contentText.setText(workOut.getDescripition());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("workOutId",workOutId);
    }

    public void setWorkOutId(long workOutId){
        this.workOutId = workOutId;
    }
}
