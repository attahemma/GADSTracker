package com.pyropy.gadstracker.FragmentSwitch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pyropy.gadstracker.R;

public class LearningLeaders extends Fragment {



    public LearningLeaders() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.learning_leaders_fragment, container, false);
    }
}