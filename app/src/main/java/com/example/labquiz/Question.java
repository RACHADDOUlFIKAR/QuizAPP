package com.example.labquiz;

public class Question {
    private int id;
    private String text;
    private String correctAnswer;
    private String opt1;
    private String opt2;


    public Question(String text, String correctAnswer, String opt1,String opt2) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.opt1 = opt1;
        this.opt2 = opt2;
    }
    public Question(){

        this.id=0;
        this.text="";
        this.correctAnswer="";
        this.opt1="";
        this.opt2="";

    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }


    // getters and setters omitted for brevity
}

