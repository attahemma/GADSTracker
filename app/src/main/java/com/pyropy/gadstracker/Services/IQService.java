package com.pyropy.gadstracker.Services;

import com.pyropy.gadstracker.Models.IQLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IQService {
    @GET("/api/skilliq")
    Call<List<IQLeaders>> getSkillLearners();
}
