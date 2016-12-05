package pszczolkowskisebastian.simplequiz.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pszczolkowskisebastian.simplequiz.R;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.QuizTitleBranch;
import pszczolkowskisebastian.simplequiz.model.helper.Constants;

public class FinalActivity extends AppCompatActivity {

    public static final String QUIZ_ID = "quizId";
    public static final String RESULT_PERCENT = "result";
    private Button buttonQuizList;
    private Button buttonTryAgain;
    private TextView textViewProcent;
    private QuizTitleBranch quizTitleBranch;
    private int correctAnswerPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        initViews();
        getInitExtras();
    }

    private void initViews() {

        buttonQuizList = (Button) findViewById(R.id.buttonQuizList);
        buttonTryAgain = (Button) findViewById(R.id.buttonTryAgain);
        textViewProcent = (TextView) findViewById(R.id.textViewProcent);

        buttonQuizList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FinalActivity.this, MainActivity.class);
                intent.putExtra(RESULT_PERCENT, correctAnswerPercent);
                intent.putExtra(QUIZ_ID, quizTitleBranch.id);

                startActivity(intent);
            }
        });

        buttonTryAgain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FinalActivity.this, QuestionActivity.class);
                intent.putExtra(Constants.REFERENCE.QUIZ, quizTitleBranch);
                startActivity(intent);
            }
        });
    }

    public void getInitExtras() {
        quizTitleBranch = getIntent().getExtras().getParcelable(Constants.REFERENCE.QUIZ);
        correctAnswerPercent = getIntent().getExtras().getInt("result");
        textViewProcent.setText(correctAnswerPercent + " %");
    }
}
