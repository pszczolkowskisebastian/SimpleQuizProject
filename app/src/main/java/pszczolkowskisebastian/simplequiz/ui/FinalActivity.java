package pszczolkowskisebastian.simplequiz.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import pszczolkowskisebastian.simplequiz.R;

public class FinalActivity extends AppCompatActivity {

    private Button buttonQuizList;
    private Button buttonTryAgain;
    private TextView textViewProcent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        buttonQuizList = (Button) findViewById(R.id.buttonQuizList);
        buttonTryAgain = (Button) findViewById(R.id.buttonTryAgain);
        textViewProcent = (TextView) findViewById(R.id.texViewProcent);
    }
}
