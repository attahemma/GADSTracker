package com.pyropy.gadstracker.Services;

import com.pyropy.gadstracker.Models.HourLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnerService {
    @GET("/api/hours")
    Call<List<HourLeaders>> getLearningLeaders();
}
