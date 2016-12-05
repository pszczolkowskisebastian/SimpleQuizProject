package pszczolkowskisebastian.simplequiz.controller;

import android.support.annotation.NonNull;

import pszczolkowskisebastian.simplequiz.model.callback.RetrofitService;
import pszczolkowskisebastian.simplequiz.model.callback.RetrofitServiceQuestion;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sebastian on 01.12.2016.
 */

public class RetrofitManager {

    private RetrofitService retrofitService;
    private RetrofitServiceQuestion retrofitServiceQuestion;

    public RetrofitService getRetrofitService() {

        if (retrofitService == null) {

            Retrofit retrofit = getRetrofit();

            retrofitService = retrofit.create(RetrofitService.class);
        }
        return retrofitService;
    }

    public RetrofitServiceQuestion getRetrofitServiceQuestion() {

        if (retrofitServiceQuestion == null) {

            Retrofit retrofit = getRetrofit();

            retrofitServiceQuestion = retrofit.create(RetrofitServiceQuestion.class);
        }
        return retrofitServiceQuestion;
    }

    @NonNull
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.HTTP.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
