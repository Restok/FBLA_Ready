package profoundmasteryinidiocy.gmail.com.schedulermaybe.Adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import profoundmasteryinidiocy.gmail.com.schedulermaybe.Model.Question;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private List<Question> questions;
    private List<String> chosenAnswers;
    private Context context;

    public MyRecyclerAdapter(List<Question> questions, List<String> chosenAnswers, Context context) {
        this.questions = questions;
        this.chosenAnswers = chosenAnswers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_box, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder viewHolder, int i) {
        Question question = questions.get(i);
        String selected = chosenAnswers.get(i);
        boolean questionCorrect = (selected.equals(question.getAnswer()));

        viewHolder.correctCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.cChoiceGreen));
        viewHolder.question.setText("Q: " + question.getQuestion());
        viewHolder.subcategory.setText("SUBCATEGORY: " + question.getSubcategory());
        if(questionCorrect){
            int color = ContextCompat.getColor(context, R.color.correctGreen);
            viewHolder.incorrectCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.LightBlue));
            viewHolder.bgCard.setCardBackgroundColor(color);
            viewHolder.correctChoice.setText(question.getAnswer());
            viewHolder.incorrectChoice.setText(question.getChoice());
            viewHolder.otherChoice.setText(question.getChoice2());
            viewHolder.otherChoice2.setText(question.getChoice3());
        }
        else{
            viewHolder.bgCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.CrimsonSky));
            viewHolder.incorrectCard.setCardBackgroundColor(ContextCompat.getColor(context, R.color.incorrectRed));
            viewHolder.correctChoice.setText(question.getAnswer());
            viewHolder.incorrectChoice.setText(selected);
            if(selected.equals(question.getChoice())){
                viewHolder.otherChoice.setText(question.getChoice2());
                viewHolder.otherChoice2.setText(question.getChoice3());
            }
            else if(selected.equals(question.getChoice2())){
                viewHolder.otherChoice.setText(question.getChoice());
                viewHolder.otherChoice2.setText(question.getChoice3());
            }
            else{
                viewHolder.otherChoice.setText(question.getChoice());
                viewHolder.otherChoice2.setText(question.getChoice2());
            }
        }



    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView question;
        public TextView correctChoice;
        public TextView incorrectChoice;
        public TextView otherChoice;
        public TextView otherChoice2;
        public TextView subcategory;
        public CardView bgCard;
        public CardView correctCard;
        public CardView incorrectCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.qCard_text);
            correctChoice = itemView.findViewById(R.id.aCard_text);
            incorrectChoice = itemView.findViewById(R.id.bCard_text);
            otherChoice = itemView.findViewById(R.id.cCard_text);
            otherChoice2 =itemView.findViewById(R.id.dCard_text);
            subcategory = itemView.findViewById(R.id.subcategorysec);
            bgCard =itemView.findViewById(R.id.backgroundCard);
            correctCard=itemView.findViewById(R.id.aCard);
            incorrectCard=itemView.findViewById(R.id.bCard);

        }
    }
}
