package pszczolkowskisebastian.simplequiz.model.callback;

import pszczolkowskisebastian.simplequiz.model.gsonQuestion.QuestionObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sebastian on 02.12.2016.
 */

public interface RetrofitServiceQuestion {

  @GET("/api/v1/quiz/{id}/0/") Call<QuestionObject> getAllQuestions(@Path("id") Long id);
}
