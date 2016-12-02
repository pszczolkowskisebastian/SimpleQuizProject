package pszczolkowskisebastian.simplequiz.model.callback;

import java.util.List;

import pszczolkowskisebastian.simplequiz.model.gsonQuestion.Question;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sebastian on 02.12.2016.
 */

public interface RetrofitServiceQuestion {

    @GET("/api/v1/quiz/6064546637603969/0/")
    Call<List<Question>> getAllQuestions();
}
