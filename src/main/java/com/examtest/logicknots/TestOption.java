package com.examtest.logicknots;

import java.io.FileNotFoundException;

public class TestOption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try {
			QuestionBank bank=new QuestionBank();
//    		QuestionDetail d=bank.questionList.get(73);
//			int actual=bank.getCorrectAnswer(d.getQuestion(),d.getOptionA(),d.getOptionB(),d.getOptionC(),d.getOptionD());
//			System.out.println(actual);
	    	for(int i=0;i<bank.questionList.size();i++) {
	    		QuestionDetail d=bank.questionList.get(i);
				int actual=bank.getCorrectAnswer(d.getQuestion(),d.getOptionA(),d.getOptionB(),d.getOptionC(),d.getOptionD());
	    	    int expected = d.getCorrectAns();
	    	    if(actual!=expected) {
	    	    	System.out.println("No Match Answer ==>"+(i+1));
	    	    	System.out.println(d.getQuestion());
	    	    	System.out.println(actual);


	    	    }
	    	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
               
	}

}
