package pszczolkowskisebastian.simplequiz.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import pszczolkowskisebastian.simplequiz.R;
import pszczolkowskisebastian.simplequiz.controller.RetrofitManager;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.MainQuizBranch;
import pszczolkowskisebastian.simplequiz.model.adapter.QuizAdapter;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.QuizTitleBranch;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;
import pszczolkowskisebastian.simplequiz.model.helper.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements QuizAdapter.QuizClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView myRecyclerView;

    private RetrofitManager myManager;
    private QuizAdapter myQuizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();

        myManager = new RetrofitManager();

        if (Utils.isNetworkAvilable(getApplicationContext())) {

            getQuizInfo();

        } else {

            /*TODO*/ // getQuizInfoFromDataBase();

        }
    }

    private void getQuizInfo() {

        Call<MainQuizBranch> listCall = myManager.getRetrofitService().getAllQuiz();

        listCall.enqueue(new Callback<MainQuizBranch>() {
            @Override
            public void onResponse(Call<MainQuizBranch> call, Response<MainQuizBranch> response) {

                if (response.isSuccessful()) {

                    MainQuizBranch mainQuizBranch = response.body();

                    for (int i = 0; i < mainQuizBranch.items.size(); i++) {

                        QuizTitleBranch quiz = mainQuizBranch.items.get(i);
                        myQuizAdapter.addQuiz(quiz);

                    }

                } else {

                    int status = response.code();
                    switch (status) {

                    }
                }
            }

            @Override
            public void onFailure(Call<MainQuizBranch> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    private void configViews() {

        myRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        myQuizAdapter = new QuizAdapter(this);
        myRecyclerView.setAdapter(myQuizAdapter);

    }

    @Override
    public void onClick(int position) {

        QuizTitleBranch selectedVeryMainItem = myQuizAdapter.getSelectedQuiz(position);
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra(Constants.REFERENCE.QUIZ, selectedVeryMainItem);
        startActivity(intent);

    }
}
