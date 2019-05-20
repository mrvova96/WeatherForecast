package com.example.mrvova96.weatherforecast.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrvova96.weatherforecast.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneDayFragment extends Fragment {


    public OneDayFragment() {
        // Required empty public constructor
    }

    public static OneDayFragment newInstance(String temp) {
        Bundle args = new Bundle();
        OneDayFragment fragment = new OneDayFragment();
        args.putString("temp", temp);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_day, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String temp = getArguments().getString("temp");
        TextView tempTv = getActivity().findViewById(R.id.temp);
        tempTv.setText(temp);
    }
}
