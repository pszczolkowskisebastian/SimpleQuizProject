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

    private RetrofitService myRetrofitService;
    private RetrofitServiceQuestion myRetrofitServiceQuestion;

    public RetrofitService getMyRetrofitService() {

        if (myRetrofitService == null) {

            Retrofit retrofit = getRetrofit();

            myRetrofitService = retrofit.create(RetrofitService.class);
        }
        return myRetrofitService;
    }

    public RetrofitServiceQuestion getMyRetrofitServiceQuestion() {

        if (myRetrofitServiceQuestion == null) {

            Retrofit retrofit = getRetrofit();

            myRetrofitServiceQuestion = retrofit.create(RetrofitServiceQuestion.class);
        }
        return myRetrofitServiceQuestion;
    }

    @NonNull
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.HTTP.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
