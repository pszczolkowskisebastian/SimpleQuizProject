package pszczolkowskisebastian.simplequiz.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pszczolkowskisebastian.simplequiz.R;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.MainQuizBranch;
import pszczolkowskisebastian.simplequiz.model.gsonTitle.QuizTitleBranch;

/**
 * Created by Sebastian on 01.12.2016.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.Holder> {

    //private static final String TAG = QuizAdapter.class.getSimpleName();
    private static final String TAG = "Cyrek";
    private final QuizClickListener myListener;

    private MainQuizBranch myMainQuizBranch;

    public QuizAdapter(QuizClickListener listener) {
        myMainQuizBranch = new MainQuizBranch();
        myListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) { //row in recyclerview

        View view_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        return new Holder(view_row);


    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        QuizTitleBranch quiz = myMainQuizBranch.items.get(position);

        Picasso.with(holder.itemView.getContext()).load(quiz.mainPhoto.url).into(holder.myPicture);

        holder.myTitle.setText(quiz.title);
        /*TODO*/ // string for display - progress
        //holder.myProgress.setText(quiz.)

    }

    @Override
    public int getItemCount() {
        return myMainQuizBranch.items.size();
    }


    /*TODO*/ //del 2x //notifyDataSetChanged
    public void addQuiz(QuizTitleBranch quiz) {
        myMainQuizBranch.items.add(quiz);
        notifyDataSetChanged();
    }

    public QuizTitleBranch getSelectedQuiz(int position) {
        return myMainQuizBranch.items.get(position);
    }


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView myPicture;
        private TextView myTitle, myProgress;

        public Holder(View itemView) {
            super(itemView);

            myPicture = (ImageView) itemView.findViewById(R.id.quizPicture);
            myTitle = (TextView) itemView.findViewById(R.id.quizTitle);
            myProgress = (TextView) itemView.findViewById(R.id.quizProgress);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            myListener.onClick(getLayoutPosition());
        }
    }

    public interface QuizClickListener {

        void onClick(int position);

    }

}
