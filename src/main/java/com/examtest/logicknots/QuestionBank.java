package com.examtest.logicknots;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class QuestionBank {
	List<QuestionDetail> questionList=new ArrayList<>();
    public QuestionBank() throws FileNotFoundException {
    	URL filename  = getClass().getClassLoader().getResource("tableConvert.com_m6jubi.json");
		Gson gson=new Gson();
		JsonReader reader = new JsonReader(new FileReader(filename.getPath()));
	    Map<String,String>[] list= gson.fromJson(reader, HashMap[].class);
	    for(int i=0;i<list.length;i++) {
		    QuestionDetail qd=new QuestionDetail();
	    	qd.setQuestion(list[i].get("Question "));
	    	qd.setOptionA(list[i].get("Option A").replace("a. ", ""));
	    	qd.setOptionB(list[i].get("Option B").replace("b. ", ""));
	    	qd.setOptionC(list[i].get("Option C").replace("c. ", ""));
	    	qd.setOptionD(list[i].get("Option D").replace("d. ", ""));
	    	qd.setCorrectAnswer(list[i].get("Answers "));
	    	qd.setKeyword(list[i].get("Keywords"));
	    	questionList.add(qd);
	    	System.out.println(i+" "+ qd.getQuestion());
	    	System.out.println(qd.getOptionA());
	    	System.out.println(qd.getOptionB());
	    	System.out.println(qd.getOptionC());
	    	System.out.println(qd.getOptionD());
	    }

    }
    public int getCorrectAnswer(String Q,String O1,String O2,String O3,String O4) {
    	double maxWeight=-1;
    	int questionPointer=-1;
    	
    	for(int i=0;i<questionList.size();i++) {
    		double weight=questionList.get(i).getCOrrectAns(Q, O1, O2, O3, O4);
    		if(weight>maxWeight) {
    			maxWeight=weight;
    			questionPointer=i;
    		}
    		if(weight==100) {
    			break;
    		}
    	}
    	if(questionPointer>=0) {
    		return questionList.get(questionPointer).getCorrectAns();
    	}
    	return 1;
    }
}
