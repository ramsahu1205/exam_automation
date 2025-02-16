package com.examtest.logicknots;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class QuestionDetail {
    private String question;
    private String optionA;
    public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	private String optionB;
    private String optionC;
    private String optionD;
    private String keyword;
    private String correctAnswer;
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
	public double getCOrrectAns(String Q,String O1,String O2,String O3,String O4) {
		String ca1="";
		String ca2="";
		if(this.correctAnswer.toLowerCase().equals("a")) {
		  	ca1=this.optionA;
		  	ca2=O1;
		}
		else if(this.correctAnswer.toLowerCase().equals("b")) {
			ca1=this.optionB;
		  	ca2=O2;
		}
		else if(this.correctAnswer.toLowerCase().equals("c")) {
			ca1=this.optionC;
		  	ca2=O3;
		}
		else if(this.correctAnswer.toLowerCase().equals("d")) {
			ca1=this.optionD;
		  	ca2=O4;
		}
		if(Q.toLowerCase().contains(this.keyword.toLowerCase())) {
			return 100;
		}
		else if(this.question.toLowerCase().equals(Q.toLowerCase()) && ca1.toLowerCase().equals(ca2.toLowerCase())) {
			return 100;
		}
		else if(this.question.toLowerCase().equals(Q.toLowerCase()) || ca1.toLowerCase().equals(ca2.toLowerCase())) {
			return 99.99;
		}
		else {
		    int n=Util.longestCommonSubstr(ca1, ca2);
		    return Math.max((n/ca1.length())*100, (n/ca2.length())*100)-1;
		}		
	}
	
	public int getCorrectAns() {
		if(this.correctAnswer.toLowerCase().equals("a")) {
		  	return 0;
		}
		else if(this.correctAnswer.toLowerCase().equals("b")) {
			return 1;
		}
		else if(this.correctAnswer.toLowerCase().equals("c")) {
			return 2;
		}
		else if(this.correctAnswer.toLowerCase().equals("d")) {
			return 3;
		}
		return 0;
	}
    
    
}
