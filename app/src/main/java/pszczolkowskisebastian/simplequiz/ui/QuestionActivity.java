package pszczolkowskisebastian.simplequiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pszczolkowskisebastian.simplequiz.R;
import pszczolkowskisebastian.simplequiz.controller.RetrofitManager;
import pszczolkowskisebastian.simplequiz.model.gsonQuestion.Answer;
import pszczolkowskisebastian.simplequiz.model.gsonQuestion.Question;
import pszczolkowskisebastian.simplequiz.model.gsonQuestion.QuestionObject;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.QuizTitleBranch;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sebastian on 01.12.2016.
 */

public class QuestionActivity extends AppCompatActivity {

    private ImageView questionPicture;

    private static final String TAG = QuestionActivity.class.getSimpleName();
    private TextView questionTextView;
    private RadioButton answer1, answer2, answer3, answer4;

    private RetrofitManager myQuestionManager;

    private List<RadioButton> answerRadioButtonList = new ArrayList<>();
    private List<Question> questionsList = new ArrayList<>();
    private int questionCurrentIndex = 0;
    private RadioGroup answersRadioGroup;
    private QuizTitleBranch quizTitleBranch; //quiz title from first activity
    private TextView quizTitle; //quiz title to view in this activity
    private int correctAnswers = 0;

    private ProgressBar progressBar;
    private TextView progressStatusValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        initGettingExtras();
        initViews();
        initRetrofit();
    }

    private void initGettingExtras() {

        quizTitleBranch = getIntent().getExtras().getParcelable(Constants.REFERENCE.QUIZ);
    }

    private void initViews() {

        questionPicture = (ImageView) findViewById(R.id.questionPicture);

        questionTextView = (TextView) findViewById(R.id.textViewQuestion);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressStatusValue = (TextView) findViewById(R.id.progressBarInfo);
        quizTitle = (TextView) findViewById(R.id.quizTitle);

        quizTitle.setText(quizTitleBranch.title);

        answer1 = (RadioButton) findViewById(R.id.radioButtonAnswer1);
        answer2 = (RadioButton) findViewById(R.id.radioButtonAnswer2);
        answer3 = (RadioButton) findViewById(R.id.radioButtonAnswer3);
        answer4 = (RadioButton) findViewById(R.id.radioButtonAnswer4);

        answersRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        answerRadioButtonList.add(answer1);
        answerRadioButtonList.add(answer2);
        answerRadioButtonList.add(answer3);
        answerRadioButtonList.add(answer4);

        answersRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
                checkIfAnswerIsCorrect(checkedRadioButton);

                initNextQuestionUI();

            }
        });
    }

    private void checkIfAnswerIsCorrect(RadioButton checkedRadioButton) { /*TODO*/

        final Question currentQuestion = questionsList.get(questionCurrentIndex);
        final String checkedAnswerText = (String) checkedRadioButton.getText();

        for (Answer answer : currentQuestion.getAnswers()) {

            final Integer isCorrect = answer.getIsCorrect();
            final boolean isTheAnswerCorrect = isCorrect != null && isCorrect == 1;

            if (isTheAnswerCorrect) {
                if (checkedAnswerText.equals(answer.getText())) {

                    correctAnswers++;

                }
            }
        }
    }

    private void initRetrofit() {
        myQuestionManager = new RetrofitManager();

        final Call<QuestionObject> questionObject = myQuestionManager.getRetrofitServiceQuestion()
                .getAllQuestions(quizTitleBranch.id);

        questionObject.enqueue(new Callback<QuestionObject>() {
            @Override
            public void onResponse(Call<QuestionObject> call, Response<QuestionObject> response) {

                questionsList = response.body().getQuestions();

                int questionsListSize = questionsList.size() - 1;
                progressStatusValue.setText(questionCurrentIndex + "/" + questionsListSize);

                initQuestionUI(questionsList.get(0));
                questionCurrentIndex++;

            }

            @Override
            public void onFailure(Call<QuestionObject> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });
    }

    private void initNextQuestionUI() {

        if (questionCurrentIndex >= questionsList.size() - 1) {

            finishQuiz();
            return;

        }

        initQuestionUI(questionsList.get(questionCurrentIndex));

        countForProgressBar();

        questionCurrentIndex++;

        // clear check:
        for (RadioButton radioButton : answerRadioButtonList) {
            radioButton.setChecked(false);
        }

        // add to DB Realm
    }

    private void countForProgressBar() {

        int questionListSize = questionsList.size() - 1;
        progressStatusValue.setText(questionCurrentIndex + " / " + questionListSize);

        progressBar.setMax(questionsList.size() - 1);
        progressBar.setProgress(questionCurrentIndex);

    }

    private void finishQuiz() {
        Log.d(TAG, "finishQuiz: result = " + correctAnswers);

        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra("result", correctAnswers);

        Intent intentId = new Intent(QuestionActivity.this, FinalActivity.class);
        intentId.putExtra(Constants.REFERENCE.QUIZ, quizTitleBranch);
        startActivity(intent);

    }

    private void initQuestionUI(Question question) {

        //QuestionObject image = new QuestionObject();
        questionTextView.setText(question.getText());

        //Context context = getApplicationContext();
        //Picasso.with(context).load(image.getMainPhoto().getUrl()).into(questionPicture); /*TODO*/
        // init answers:
        for (int i = 0; i < question.getAnswers().size(); i++) {

            Answer answer = question.getAnswers().get(i);
            RadioButton radioButton = answerRadioButtonList.get(i);
            radioButton.setText(answer.getText());
        }
    }
}