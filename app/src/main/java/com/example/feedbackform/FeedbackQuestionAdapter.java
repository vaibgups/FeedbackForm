package com.example.feedbackform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class FeedbackQuestionAdapter extends RecyclerView.Adapter<FeedbackQuestionAdapter.ViewHolder> {

    private static final String TAG = FeedbackQuestionAdapter.class.getSimpleName();
    private List<QuestionBeam> questionBeamList;
    private Context context;
    private QuestionBeam questionBeam;
    boolean temp = false;

    public FeedbackQuestionAdapter(List<QuestionBeam> questionBeamList, Context context) {
        Log.i(TAG, "FeedbackQuestionAdapter: Constructor call");
        this.questionBeamList = questionBeamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.feedback_form, viewGroup, false);
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


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView feedbackSNoTV, feedbackQuestionTV;
        private LinearLayout feedbackQuestionLL, feedbackAnswerLL,feedbackOtherAnswerLL;
        private CheckBox feedbackOtherOptionCB;
        private EditText feedbackOtherAnswerEditText;
        private Button feedbackAnswerBtn1, feedbackAnswerBtn2, feedbackAnswerBtn3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feedbackSNoTV = itemView.findViewById(R.id.feedbackSNoTV);
            feedbackQuestionTV = itemView.findViewById(R.id.feedbackQuestionTV);

            feedbackOtherAnswerEditText = itemView.findViewById(R.id.feedbackOtherAnswerEditText);

            feedbackQuestionLL = itemView.findViewById(R.id.feedbackQuestionLL);
            feedbackAnswerLL = itemView.findViewById(R.id.feedbackAnswerLL);
            feedbackOtherAnswerLL = itemView.findViewById(R.id.feedbackOtherAnswerLL);

            feedbackOtherOptionCB = itemView.findViewById(R.id.feedbackOtherOptionCB);

            feedbackAnswerBtn1 = itemView.findViewById(R.id.feedbackAnswerBtn1);
            feedbackAnswerBtn2 = itemView.findViewById(R.id.feedbackAnswerBtn2);
            feedbackAnswerBtn3 = itemView.findViewById(R.id.feedbackAnswerBtn3);

            feedbackAnswerBtn1.setOnClickListener(this);
            feedbackAnswerBtn2.setOnClickListener(this);
            feedbackAnswerBtn3.setOnClickListener(this);

        }

        public void setWidgetValue(QuestionBeam questionBeam) {
            feedbackSNoTV.setText("Q" + questionBeam.getQuestionS_No() + ".");
            feedbackQuestionTV.setText(questionBeam.getQuestion());

            if (questionBeam.getQuestionType().equals("Optional")) {
                feedbackOtherAnswerLL.setVisibility(View.GONE);
                feedbackAnswerLL.setVisibility(View.VISIBLE);
                feedbackAnswerBtn1.setText(questionBeam.getAnswer1());
                feedbackAnswerBtn2.setText(questionBeam.getAnswer2());
                feedbackAnswerBtn3.setText(questionBeam.getAnswer3());
                setSelectedOptionValue(questionBeam);
            }else if (questionBeam.getQuestionType().equals("NonOptional")){
                feedbackOtherAnswerLL.setVisibility(View.VISIBLE);
                feedbackAnswerLL.setVisibility(View.GONE);
            }

        }

        @Override
        public void onClick(View v) {
            questionBeam = questionBeamList.get(getAdapterPosition());

            switch (v.getId()) {

                case R.id.feedbackAnswerBtn1: {
//                    questionBeam.setOptionSelected( questionBeam.isOptionSelected() ? false : true);
//                    questionBeam.setButtonId(R.id.feedbackAnswerBtn1);
                    checkSelectedOptionCondition(questionBeam, R.id.feedbackAnswerBtn1);
                    break;
                }
                case R.id.feedbackAnswerBtn2: {

//                    questionBeam.setOptionSelected( questionBeam.isOptionSelected() ? false : true);
//                    questionBeam.setButtonId(R.id.feedbackAnswerBtn2);
                    checkSelectedOptionCondition(questionBeam, R.id.feedbackAnswerBtn2);
                    break;
                }
                case R.id.feedbackAnswerBtn3: {
//                    questionBeam.setOptionSelected( questionBeam.isOptionSelected() ? false : true);
//                    questionBeam.setButtonId(R.id.feedbackAnswerBtn3);
                    checkSelectedOptionCondition(questionBeam, R.id.feedbackAnswerBtn3);
                    break;
                }
            }
        }

        private void checkSelectedOptionCondition(QuestionBeam questionBeam, int id) {
            Log.i(TAG, "checkSelectedOptionCondition button id is : ");
            if (questionBeam.getButtonId() != id){

                if (!questionBeam.isOptionSelected()){

                    questionBeam.setButtonId(id);
                    questionBeam.setOptionSelected(true);
                    setSelectedOptionValue(questionBeam);
                }else {
                    questionBeam.setOptionSelected(true);
                    questionBeam.setButtonId(id);
                    setSelectedOptionValue(questionBeam);
                }
            }else {

                questionBeam.setOptionSelected(false);
                questionBeam.setButtonId(0);
                setSelectedOptionValue(questionBeam);
            }
        }

        private void setSelectedOptionValue(QuestionBeam questionBeam) {
            if (questionBeam.getButtonId() != -1) {
                switch (questionBeam.getButtonId()) {

                    case R.id.feedbackAnswerBtn1: {

                        feedbackAnswerBtn1.setBackgroundResource(R.drawable.my_button_selected_bg);
                        feedbackAnswerBtn2.setBackgroundResource(R.drawable.my_button_bg);
                        feedbackAnswerBtn3.setBackgroundResource(R.drawable.my_button_bg);
                        questionBeam.setButtonId(R.id.feedbackAnswerBtn1);
                        break;
                    }
                    case R.id.feedbackAnswerBtn2: {
                        feedbackAnswerBtn2.setBackgroundResource(R.drawable.my_button_selected_bg);
                        feedbackAnswerBtn1.setBackgroundResource(R.drawable.my_button_bg);
                        feedbackAnswerBtn3.setBackgroundResource(R.drawable.my_button_bg);
                        questionBeam.setButtonId(R.id.feedbackAnswerBtn2);
                        break;
                    }
                    case R.id.feedbackAnswerBtn3: {
                        feedbackAnswerBtn3.setBackgroundResource(R.drawable.my_button_selected_bg);
                        feedbackAnswerBtn1.setBackgroundResource(R.drawable.my_button_bg);
                        feedbackAnswerBtn2.setBackgroundResource(R.drawable.my_button_bg);
                        questionBeam.setButtonId(R.id.feedbackAnswerBtn3);
                        break;
                    }
                    default:
                    {

                        feedbackAnswerBtn3.setBackgroundResource(R.drawable.my_button_bg);
                        feedbackAnswerBtn1.setBackgroundResource(R.drawable.my_button_bg);
                        feedbackAnswerBtn2.setBackgroundResource(R.drawable.my_button_bg);
                        break;
                    }
                }
            }/*else {
                feedbackAnswerBtn3.setBackgroundResource(R.drawable.my_button_bg);
                feedbackAnswerBtn1.setBackgroundResource(R.drawable.my_button_bg);
                feedbackAnswerBtn2.setBackgroundResource(R.drawable.my_button_bg);
            }*/
        }


    }


}
