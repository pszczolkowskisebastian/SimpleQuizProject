package pszczolkowskisebastian.simplequiz.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

import static android.view.View.GONE;

/**
 * Created by Sebastian on 01.12.2016.
 */

public class QuestionActivity extends AppCompatActivity {

    private ImageView questionPicture;

    private static final String TAG = QuestionActivity.class.getSimpleName();
    private TextView questionTextView;
    private RadioButton answer1, answer2, answer3, answer4, answer5, answer6;

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
    private QuestionObject myQuestionObject;
    private List<Integer> answerRadioButtonIdsList = new ArrayList<>();

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
        answer5 = (RadioButton) findViewById(R.id.radioButtonAnswer5);
        answer6 = (RadioButton) findViewById(R.id.radioButtonAnswer6);

        answersRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        answerRadioButtonList.add(answer1);
        answerRadioButtonList.add(answer2);
        answerRadioButtonList.add(answer3);
        answerRadioButtonList.add(answer4);
        answerRadioButtonList.add(answer5);
        answerRadioButtonList.add(answer6);

        // answer IDs list:
        answerRadioButtonIdsList.add(R.id.radioButtonAnswer1);
        answerRadioButtonIdsList.add(R.id.radioButtonAnswer2);
        answerRadioButtonIdsList.add(R.id.radioButtonAnswer3);
        answerRadioButtonIdsList.add(R.id.radioButtonAnswer4);
        answerRadioButtonIdsList.add(R.id.radioButtonAnswer5);
        answerRadioButtonIdsList.add(R.id.radioButtonAnswer6);

        answersRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(checkedId);
                checkIfAnswerIsCorrect(checkedRadioButton);

                initNextQuestionUI();
            }
        });
    }

    private void checkIfAnswerIsCorrect(RadioButton checkedRadioButton) {

        final Question currentQuestion = getCurrentQuestion();
        final String checkedAnswerText = (String) checkedRadioButton.getText();

        int correctAnswerIndex = getCorrectAnswerIndex(currentQuestion.getAnswers());
        int checkedRadioButtonIndex = getCheckedRadioButtonIndex(checkedRadioButton);

        if (correctAnswerIndex == checkedRadioButtonIndex) { // CORRECT ANSWER:
            correctAnswers++;
        } else { // INCORRECT:

        }

    }

    private int getCheckedRadioButtonIndex(RadioButton checkedRadioButton) {
        for (int i = 0; i < answerRadioButtonIdsList.size(); i++) {
            final Integer radioId = answerRadioButtonIdsList.get(i);
            if (checkedRadioButton.getId() == radioId) {
                return i;
            }
        }
        return -1;
    }

    private int getCorrectAnswerIndex(List<Answer> answers) {
        for (int i = 0; i < answers.size(); i++) {
            final Answer answer = answers.get(i);
            final boolean isAnswerCorrect = answer.getIsCorrect() != null && answer.getIsCorrect() == 1;
            if (isAnswerCorrect) {
                return i;
            }
        }
        return -1;
    }

    private void initRetrofit() {
        myQuestionManager = new RetrofitManager();

        final Call<QuestionObject> questionObject =
                myQuestionManager.getRetrofitServiceQuestion().getAllQuestions(quizTitleBranch.id);

        questionObject.enqueue(new Callback<QuestionObject>() {
            @Override
            public void onResponse(Call<QuestionObject> call, Response<QuestionObject> response) {
                if (response.body() == null) return;

                myQuestionObject = response.body();
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

        initQuestionUI(getCurrentQuestion());

        countForProgressBar();

        questionCurrentIndex++;

        // clear check:
        for (RadioButton radioButton : answerRadioButtonList) {
            radioButton.setChecked(false);
        }

        // add to DB Realm
    }

    private Question getCurrentQuestion() {
        return questionsList.get(questionCurrentIndex);
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
        final int questionsCount = myQuestionObject.getQuestions().size();

        int percentOfCorrectAnswers = (correctAnswers * 100) / questionsCount;
        intent.putExtra("result", percentOfCorrectAnswers);
        intent.putExtra(Constants.REFERENCE.QUIZ, quizTitleBranch);
        startActivity(intent);
    }

    private void initQuestionUI(Question question) {

        questionTextView.setText(question.getText());

        Context context = getApplicationContext();
        if (question == null) return;

        initImage(question, context);
        // init answers:
        for (int i = 0; i < question.getAnswers().size(); i++) {

            Answer answer = question.getAnswers().get(i);
            RadioButton radioButton = answerRadioButtonList.get(i);
            radioButton.setText(answer.getText());
        }

        hideUnusedRadioButtons(question);
    }

    private void initImage(Question question, Context context) {
        if (question.getImage() != null || question.getImage().getUrl() != null) {
            String imageUrl = question.getImage().getUrl();
            if (imageUrl != null && !TextUtils.isEmpty(imageUrl)) {
                Picasso.with(context).load(imageUrl).into(questionPicture);
            }
        }
    }

    private void hideUnusedRadioButtons(Question question) {
        for (int i = question.getAnswers().size(); i < answerRadioButtonList.size(); i++) {
            RadioButton radioButton = answerRadioButtonList.get(i);
            radioButton.setVisibility(GONE);
        }
    }
}