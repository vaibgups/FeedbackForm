package com.example.feedbackform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class FeedbackQuestionAdapter extends RecyclerView.Adapter<FeedbackQuestionAdapter.ViewHolder>  {

    private List<QuestionBeam> questionBeamList;
    private Context context;
    private QuestionBeam questionBeam;

    public FeedbackQuestionAdapter(List<QuestionBeam> questionBeamList, Context context) {
        this.questionBeamList = questionBeamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.feedback_form, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        questionBeam = questionBeamList.get(i);
        viewHolder.setWidgetValue(questionBeam);
    }

    @Override
    public int getItemCount() {
        return questionBeamList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView feedbackSNoTV, feedbackQuestionTV;
        private LinearLayout feedbackQuestionLL, feedbackAnswerLL;
        private Button feedbackAnswerBtn1, feedbackAnswerBtn2, feedbackAnswerBtn3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feedbackSNoTV = itemView.findViewById(R.id.feedbackSNoTV);
            feedbackQuestionTV = itemView.findViewById(R.id.feedbackQuestionTV);

            feedbackQuestionLL = itemView.findViewById(R.id.feedbackQuestionLL);
            feedbackAnswerLL = itemView.findViewById(R.id.feedbackAnswerLL);

            feedbackAnswerBtn1 = itemView.findViewById(R.id.feedbackAnswerBtn1);
            feedbackAnswerBtn2 = itemView.findViewById(R.id.feedbackAnswerBtn2);
            feedbackAnswerBtn3 = itemView.findViewById(R.id.feedbackAnswerBtn3);

        }

        public void setWidgetValue(QuestionBeam questionBeam){
            feedbackSNoTV.setText("Q"+questionBeam.getQuestionS_No()+".");
            feedbackQuestionTV.setText(questionBeam.getQuestion());

            feedbackAnswerBtn1.setText(questionBeam.getAnswer1());
            feedbackAnswerBtn2.setText(questionBeam.getAnswer2());
            feedbackAnswerBtn3.setText(questionBeam.getAnswer3());

        }
    }
}
