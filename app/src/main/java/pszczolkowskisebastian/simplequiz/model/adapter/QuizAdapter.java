package pszczolkowskisebastian.simplequiz.model.adapter;

import android.support.v7.widget.RecyclerView;
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

    private final QuizClickListener listener;

    private MainQuizBranch mainQuizBranch;

    public QuizAdapter(QuizClickListener listener) {
        mainQuizBranch = new MainQuizBranch();
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) { //row in recyclerwiev

        View view_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        return new Holder(view_row);

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        QuizTitleBranch quiz = mainQuizBranch.items.get(position);

        Picasso.with(holder.itemView.getContext()).load(quiz.mainPhoto.url).into(holder.picture);

        holder.title.setText(quiz.title);

    }

    @Override
    public int getItemCount() {
        return mainQuizBranch.items.size();
    }

    public void addQuiz(QuizTitleBranch quiz) {

        mainQuizBranch.items.add(quiz);
        notifyDataSetChanged();

    }

    public QuizTitleBranch getSelectedQuiz(int position) {

        return mainQuizBranch.items.get(position);

    }


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView picture;
        private TextView title, score;

        public Holder(View itemView) {
            super(itemView);

            picture = (ImageView) itemView.findViewById(R.id.quizPicture);
            title = (TextView) itemView.findViewById(R.id.quizTitle);
            score = (TextView) itemView.findViewById(R.id.yourScore);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onClick(getLayoutPosition());
        }

    }

    public interface QuizClickListener {

        void onClick(int position);

    }
}
