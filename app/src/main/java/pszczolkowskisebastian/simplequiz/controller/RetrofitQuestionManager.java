package pszczolkowskisebastian.simplequiz.controller;

import pszczolkowskisebastian.simplequiz.model.callback.RetrofitServiceQuestion;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sebastian on 02.12.2016.
 */

public class RetrofitQuestionManager {

    private RetrofitServiceQuestion myRetrofitSerivceQuestion;

    public RetrofitServiceQuestion getMyRetrifitQuestionService() {

        if (myRetrofitSerivceQuestion == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            myRetrofitSerivceQuestion = retrofit.create(RetrofitServiceQuestion.class);
        }
        return myRetrofitSerivceQuestion;
    }

}

