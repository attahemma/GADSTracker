package com.pyropy.gadstracker.FragmentSwitch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pyropy.gadstracker.Adapters.HourRecyclerViewAdapter;
import com.pyropy.gadstracker.Adapters.SkillRecyclerViewAdapter;
import com.pyropy.gadstracker.Models.IQLeaders;
import com.pyropy.gadstracker.R;
import com.pyropy.gadstracker.Services.IQService;
import com.pyropy.gadstracker.Services.ServiceBuilder;

import java.security.SecureRandom;
import java.util.List;


public class SkillLeaders extends Fragment {

    View view;
    private RecyclerView skillRecyclerView;
    private SkillRecyclerViewAdapter mSkillRecyclerViewAdapter;

    public SkillLeaders() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.skill_leaders_fragment, container, false);
        skillRecyclerView = view.findViewById(R.id.skill_recyclerview);

        IQService uIQService = ServiceBuilder.buildService(IQService.class);
        Call<List<IQLeaders>> IQRequest = uIQService.getSkillLearners();

        IQRequest.enqueue(new Callback<List<IQLeaders>>() {
            @Override
            public void onResponse(Call<List<IQLeaders>> call, Response<List<IQLeaders>> response) {
                displayResults(response.body());
            }

            @Override
            public void onFailure(Call<List<IQLeaders>> call, Throwable t) {

            }
        });
        return view;
    }

    private void displayResults(List<IQLeaders> body) {
        mSkillRecyclerViewAdapter = new SkillRecyclerViewAdapter(getContext(), body);
        skillRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        skillRecyclerView.setAdapter(mSkillRecyclerViewAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}