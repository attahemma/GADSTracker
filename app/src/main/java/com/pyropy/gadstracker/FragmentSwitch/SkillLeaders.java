package com.pyropy.gadstracker.FragmentSwitch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pyropy.gadstracker.R;


public class SkillLeaders extends Fragment {


    public SkillLeaders() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.skill_leaders_fragment, container, false);
    }
}