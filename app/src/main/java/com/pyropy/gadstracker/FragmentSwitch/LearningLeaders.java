package com.pyropy.gadstracker.FragmentSwitch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pyropy.gadstracker.Adapters.HourRecyclerViewAdapter;
import com.pyropy.gadstracker.Models.HourLeaders;
import com.pyropy.gadstracker.R;
import com.pyropy.gadstracker.Services.LearnerService;
import com.pyropy.gadstracker.Services.ServiceBuilder;

import java.util.List;

public class LearningLeaders extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private HourRecyclerViewAdapter mHourRecyclerViewAdapter;

    public LearningLeaders() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.learning_leaders_fragment, container, false);
        recyclerView = view.findViewById(R.id.hours_recyclerview);

        LearnerService uLearnerService = ServiceBuilder.buildService(LearnerService.class);
        Call<List<HourLeaders>> uLearningLeadersRequest = uLearnerService.getLearningLeaders();

        uLearningLeadersRequest.enqueue(new Callback<List<HourLeaders>>() {
            @Override
            public void onResponse(Call<List<HourLeaders>> call, Response<List<HourLeaders>> response) {
                //set up and display recyclerview with response objects
                displayResults(response.body());
            }

            @Override
            public void onFailure(Call<List<HourLeaders>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to perform Request",Toast.LENGTH_SHORT).show();
                Log.d("LearningLeadersRequest:",t.toString());
            }
        });
        return view;
    }

    private void displayResults(List<HourLeaders> body) {
        mHourRecyclerViewAdapter = new HourRecyclerViewAdapter(getContext(), body);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mHourRecyclerViewAdapter);
    }
}