package com.example.feedbackform;

public class QuestionBeam {

    private String questionType;
    private String questionId;
    private String questionS_No;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private boolean isOtherReason;
    private String otherReason;
    private boolean isOptionSelected;
    private int buttonId;

    public QuestionBeam(String questionType, String questionId, String questionS_No, String question, String answer1, String answer2, String answer3) {
        this.questionType = questionType;
        this.questionId = questionId;
        this.questionS_No = questionS_No;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getQuestionS_No() {
        return questionS_No;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }


    public boolean isOtherReason() {
        return isOtherReason;
    }

    public void setOtherReason(boolean otherReason) {
        isOtherReason = otherReason;
    }

    public String getOtherReason() {
        return otherReason;
    }

    public void setOtherReason(String otherReason) {
        this.otherReason = otherReason;
    }

    public boolean isOptionSelected() {
        return isOptionSelected;
    }

    public void setOptionSelected(boolean optionSelected) {
        isOptionSelected = optionSelected;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }
}
