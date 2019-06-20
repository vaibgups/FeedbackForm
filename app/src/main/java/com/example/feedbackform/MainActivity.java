package com.example.feedbackform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<QuestionBeam> questionBeamList;
    private RecyclerView recycler;
    private FeedbackQuestionAdapter feedbackQuestionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.main_recycler);

        questionBeamList = new ArrayList<>();
        QuestionBeam questionBeam = new QuestionBeam("Optional","1","1","Overall view of the Training Program.",
                "Very Useful", "Useful", "Useful to some extent");

        QuestionBeam questionBeam2 = new QuestionBeam("Optional","2","2","Your impression about lectures delivered" +
                " in the training program.","Very Useful", "Useful", "Useful to some extent");

        QuestionBeam questionBeam3 = new QuestionBeam("Optional","3","3","How do you find the arrangements for the training course",
                "Excellent", "Very good", "Satisfactory");

        QuestionBeam questionBeam4 = new QuestionBeam("Optional","4","4","What do your feel about the duration of the course",
                "Too Long", "Sufficient", "Too Short");

        QuestionBeam questionBeam5 = new QuestionBeam("Optional","5","5","Specific comments about particular lecture and its relevance to the training programme",
                "Too Long", "Sufficient", "Too Short");

        QuestionBeam questionBeam6 = new QuestionBeam("Optional","6","6","How much beneficial this training is, in handling court cases more effectively?",
                "Very Useful", "Useful", "Useful to some extent");

        QuestionBeam questionBeam7 = new QuestionBeam("Optional","7","7","How do you see this training will help you in your present job?  Any suggestion about the structure of the training, which could be more beneficial with respect to your area of work in the Ministry.",
                "Very Useful", "Useful", "Useful to some extent");

        QuestionBeam questionBeam8 = new QuestionBeam("Optional","8","8","Coverage of contents",
                "Excellent", "Very good", "Satisfactory");

        QuestionBeam questionBeam9 = new QuestionBeam("Optional","9","9","Opportunity of Contents",
                "Excellent", "Very good", "Satisfactory");

        QuestionBeam questionBeam10 = new QuestionBeam("NonOptional","10","10","Any other suggestion etc",
                "", "", "");


        questionBeamList.add(questionBeam);
        questionBeamList.add(questionBeam2);
        questionBeamList.add(questionBeam3);
        questionBeamList.add(questionBeam4);
        questionBeamList.add(questionBeam5);
        questionBeamList.add(questionBeam6);
        questionBeamList.add(questionBeam7);
        questionBeamList.add(questionBeam8);
        questionBeamList.add(questionBeam9);
        questionBeamList.add(questionBeam10);


        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        feedbackQuestionAdapter = new FeedbackQuestionAdapter(questionBeamList,MainActivity.this);
        recycler.setAdapter(feedbackQuestionAdapter);

    }
}
