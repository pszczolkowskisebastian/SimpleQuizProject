package pszczolkowskisebastian.simplequiz.model.callback;

import pszczolkowskisebastian.simplequiz.model.gsonQuestion.Question;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.MainQuizBranch;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sebastian on 01.12.2016.
 */

public interface RetrofitService {

    @GET("/api/v1/quizzes/0/100/")
    Call<MainQuizBranch> getAllQuiz();
}
