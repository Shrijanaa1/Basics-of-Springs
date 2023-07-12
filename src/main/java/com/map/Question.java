package com.map;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    private String question;

    //For one-to-one relationship
//    @OneToOne
//    @JoinColumn(name = "ans_id")
//    private Answer answer;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Question(){}

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(int questionId, String question, List<Answer> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    //for one-to-one
//    public Answer getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(Answer answer) {
//        this.answer = answer;
//    }
}
