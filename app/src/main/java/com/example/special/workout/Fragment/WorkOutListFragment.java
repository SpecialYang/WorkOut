package com.example.special.workout.Fragment;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.special.workout.R;
import com.example.special.workout.model.WorkOut;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkOutListFragment extends ListFragment {
    private WorkOutListOnClickListener listener;

    public interface WorkOutListOnClickListener{
        void itemClicked(long id);
    }

    public WorkOutListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (WorkOutListOnClickListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int length = WorkOut.workOuts.length;
        String[] listName = new String[length];
        for(int i = 0; i < length; i++)
            listName[i] = WorkOut.workOuts[i].getName();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,listName);
        setListAdapter(arrayAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listener.itemClicked(id);
    }
}
