package pszczolkowskisebastian.simplequiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pszczolkowskisebastian.simplequiz.R;
import pszczolkowskisebastian.simplequiz.controller.RetrofitManager;
import pszczolkowskisebastian.simplequiz.model.callback.RetrofitServiceQuestion;
import pszczolkowskisebastian.simplequiz.model.gsonQuestion.Answer;
import pszczolkowskisebastian.simplequiz.model.gsonQuestion.Question;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.MainQuizBranch;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sebastian on 01.12.2016.
 */

public class QuestionActivity extends AppCompatActivity {

    private static final String TAG = QuestionActivity.class.getSimpleName();
    private TextView questionTextView;
    private RadioButton answer1, answer2, answer3, answer4, answer5, answer6;
    //
    private ProgressBar progressBar;
    private TextView progressStatus;
    private Button button;
    private int progresStatus = 0;
    Handler handler = new Handler();
    //
    private RetrofitManager myQuestionManager;
    private RetrofitServiceQuestion myRetrofitServiceQuestion;

    private List<RadioButton> answerRadioButtonList = new ArrayList<>();
    private int questionCurrentIndex = 0;
    private RadioGroup answersRadioGroup;
    private List<Question> questionsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        MainQuizBranch mainQuizBranch = (MainQuizBranch) intent.getSerializableExtra(Constants.REFERENCE.QUIZ);



//        initRetrofit(); /*TODO*/

        initViews();
        initRetrofit();
    }

    private void initViews() {
        questionTextView = (TextView) findViewById(R.id.textViewQuestion);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressStatus = (TextView) findViewById(R.id.progressBarInfo);
        button = (Button) findViewById(R.id.Button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setProgress(2);
                progressStatus.setText("2/6");
            }
        });

        //radiobuttons
        answer1 = (RadioButton) findViewById(R.id.radioButtonAnswer1);
        answer2 = (RadioButton) findViewById(R.id.radioButtonAnswer2);
        answer3 = (RadioButton) findViewById(R.id.radioButtonAnswer3);
        answer4 = (RadioButton) findViewById(R.id.radioButtonAnswer4);
        answer5 = (RadioButton) findViewById(R.id.radioButtonAnswer5);
        answer6 = (RadioButton) findViewById(R.id.radioButtonAnswer6);
        answersRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        answerRadioButtonList.add(answer1);
        answerRadioButtonList.add(answer2);
        answerRadioButtonList.add(answer3);
        answerRadioButtonList.add(answer4);
        answerRadioButtonList.add(answer5);
        answerRadioButtonList.add(answer6);

        answersRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);

                initNextQuestionUI();
            }
        });
    }


    private void initRetrofit() {
        myQuestionManager = new RetrofitManager();

        final Call<List<Question>> allQuestions = myQuestionManager.getMyRetrofitServiceQuestion().getAllQuestions();//tu krzyczy
        allQuestions.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                questionsList = response.body();

                initNextQuestionUI();

            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }

    private void initNextQuestionUI() {
        initQuestionUI(questionsList.get(questionCurrentIndex));
        questionCurrentIndex++;
    }

    private void initQuestionUI(Question question) {
        questionTextView.setText(question.getText());

        // init answers:
        for (int i = 0; i < question.getAnswers().size(); i++) {
            Answer answer = question.getAnswers().get(i);
            RadioButton radioButton = answerRadioButtonList.get(i);
            radioButton.setText(answer.getText());
        }
    }
}