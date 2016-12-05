package pszczolkowskisebastian.simplequiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import pszczolkowskisebastian.simplequiz.R;
import pszczolkowskisebastian.simplequiz.controller.RetrofitManager;
import pszczolkowskisebastian.simplequiz.model.adapter.QuizAdapter;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.MainQuizBranch;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.QuizTitleBranch;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;
import pszczolkowskisebastian.simplequiz.model.helper.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements QuizAdapter.QuizClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;

    private RetrofitManager manager;
    private QuizAdapter quizAdapter;
    private int resultInPercent = -1;
    private long lastDoneQuizId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGetExtras();
        configViews();

        manager = new RetrofitManager();

        if (Utils.isNetworkAvilable(getApplicationContext())) {

            getQuizInfo();
        } else {

            Toast.makeText(this, "Connect to internet", Toast.LENGTH_SHORT).show();
            /*TODO*/ // getQuizInfoFromDataBase();

        }
    }

    private void initGetExtras() {
        final Bundle extras = getIntent().getExtras();
        if (extras == null) return;
        resultInPercent = extras.getInt(FinalActivity.RESULT_PERCENT, -1);
        lastDoneQuizId = getIntent().getExtras().getLong(FinalActivity.QUIZ_ID, -1);
    }

    private void getQuizInfo() {

        Call<MainQuizBranch> listCall = manager.getRetrofitService().getAllQuiz();

        listCall.enqueue(new Callback<MainQuizBranch>() {
            @Override
            public void onResponse(Call<MainQuizBranch> call, Response<MainQuizBranch> response) {

                if (response.isSuccessful()) {

                    MainQuizBranch mainQuizBranch = response.body();

                    for (int i = 0; i < mainQuizBranch.items.size(); i++) {

                        QuizTitleBranch quiz = mainQuizBranch.items.get(i);
                        quizAdapter.addQuiz(quiz);
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

        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        quizAdapter = new QuizAdapter(this, lastDoneQuizId, resultInPercent);
        recyclerView.setAdapter(quizAdapter);
    }

    @Override
    public void onClick(int position) {

        QuizTitleBranch selectedVeryMainItem = quizAdapter.getSelectedQuiz(position);
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra(Constants.REFERENCE.QUIZ, selectedVeryMainItem);
        startActivity(intent);
    }
}
